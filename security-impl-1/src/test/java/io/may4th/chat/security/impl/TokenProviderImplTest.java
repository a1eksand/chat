package io.may4th.chat.security.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.may4th.chat.security.api.UserDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TokenProviderImplTest {

    @Test
    void testTokenProvider() {
        var tokenProvider = new TokenProviderImpl(new ObjectMapper());
        var userDetails = mock(UserDetails.class);
        when(userDetails.getId()).thenReturn("1");
        assertTrue(tokenProvider.isSingValid(tokenProvider.extractAuthTokenTO(tokenProvider.generateToken(userDetails, 0))));
    }
}
