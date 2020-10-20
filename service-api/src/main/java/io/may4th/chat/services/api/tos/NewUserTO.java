package io.may4th.chat.services.api.tos;

import io.may4th.chat.services.api.CommonValidation;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Accessors(chain = true)
@Getter
@Setter
public class NewUserTO {

    @NotNull
    @NotBlank
    @Size(min = 4, max = 64)
    @Pattern(regexp= CommonValidation.WITHOUT_WHITESPACE)
    private String username;

    @NotNull
    private String hash;
}
