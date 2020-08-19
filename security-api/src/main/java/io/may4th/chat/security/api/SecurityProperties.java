package io.may4th.chat.security.api;

public interface SecurityProperties {

    String getTokenSecret();

    Long getTokenLifetime();
}
