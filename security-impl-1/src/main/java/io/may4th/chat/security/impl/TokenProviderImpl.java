package io.may4th.chat.security.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.may4th.chat.security.api.TokenProvider;
import io.may4th.chat.security.api.UserDetails;
import io.may4th.chat.security.api.exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.Random;

@Component
public class TokenProviderImpl extends BaseCoder implements TokenProvider {

    private static final String ALGORITHM = "SHA-1";

    private static final long LIFETIME_MILLIS = 3600000;

    private static final int SECRET_LENGTH = 128;

    private final ObjectMapper objectMapper;

    private final byte[] secret;



    @Autowired
    TokenProviderImpl(ObjectMapper objectMapper) {
        super(ALGORITHM);
        this.secret = new byte[SECRET_LENGTH];
        new Random().nextBytes(this.secret);
        this.objectMapper = objectMapper;
    }

    @Override
    public String generateToken(UserDetails userDetails, long now) {
        var authToken = new AuthToken()
            .setUserId(userDetails.getId())
            .setIssuedAt(now)
            .setExpireAt(now + LIFETIME_MILLIS)
            .setSeed(new Random().nextLong());

        authToken.setSing(sing(authToken));

        try {
            return encode(objectMapper.writeValueAsString(authToken).getBytes());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    AuthToken extractToken(String token) {
        try {
            return objectMapper.readValue(decode(token), AuthToken.class);
        } catch (Exception e) {
            throw new AuthenticationException(e);
        }
    }

    boolean isValid(AuthToken authToken) {
        return Objects.equals(authToken.getSing(), sing(authToken)) && System.currentTimeMillis() < authToken.getExpireAt();
    }

    private byte[] toBytes(long... longs) {
        var buffer = ByteBuffer.allocate(Long.SIZE * longs.length / Byte.SIZE);
        for (var value : longs) {
            buffer.putLong(value);
        }
        return buffer.array();
    }

    private String sing(AuthToken authToken) {
        return encode(hash(
            authToken.getUserId().getBytes(),
            toBytes(authToken.getIssuedAt(), authToken.getExpireAt(), authToken.getSeed()),
            secret
        ));
    }
}
