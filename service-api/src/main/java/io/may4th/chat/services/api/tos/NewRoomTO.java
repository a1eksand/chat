package io.may4th.chat.services.api.tos;

import io.may4th.chat.services.api.CommonValidation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Accessors(chain = true)
@ApiModel
@Getter
@Setter
public class NewRoomTO {

    @ApiModelProperty(required = true, example = "00000000-0000-0000-C000-000000000146")
    @NotNull
    private UUID id;

    @ApiModelProperty(required = true, example = "00000000-0000-0000-C000-000000000147")
    @NotNull
    private UUID ownerId;

    @ApiModelProperty(required = true, example = "NY2020")
    @NotNull
    @NotBlank
    @Size(min = 1, max = 4096)
    @Pattern(regexp= CommonValidation.TRIMMED_SINGLE_LINE)
    private String title;
}
