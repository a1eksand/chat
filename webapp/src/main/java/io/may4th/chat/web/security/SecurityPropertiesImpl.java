package io.may4th.chat.web.security;

import io.may4th.chat.security.api.SecurityProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties("security")
@EnableConfigurationProperties(SecurityPropertiesImpl.class)
@Getter
@Setter
public class SecurityPropertiesImpl implements SecurityProperties {

    @NotBlank
    @Min(16)
    private String tokenSecret;

    @NotNull
    @Min(60)
    private Long tokenLifetime;
}
