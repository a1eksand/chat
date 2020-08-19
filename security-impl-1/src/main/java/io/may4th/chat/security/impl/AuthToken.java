package io.may4th.chat.security.impl;

class AuthToken {

    private String userId;
    private long issuedAt;
    private long expireAt;
    private long seed;
    private String sing;

    public String getUserId() {
        return userId;
    }

    public AuthToken setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public long getIssuedAt() {
        return issuedAt;
    }

    public AuthToken setIssuedAt(long issuedAt) {
        this.issuedAt = issuedAt;
        return this;
    }

    public long getExpireAt() {
        return expireAt;
    }

    public AuthToken setExpireAt(long expireAt) {
        this.expireAt = expireAt;
        return this;
    }

    public long getSeed() {
        return seed;
    }

    public AuthToken setSeed(long seed) {
        this.seed = seed;
        return this;
    }

    public String getSing() {
        return sing;
    }

    public AuthToken setSing(String sing) {
        this.sing = sing;
        return this;
    }
}
