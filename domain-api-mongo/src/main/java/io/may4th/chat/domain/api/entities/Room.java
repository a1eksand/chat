package io.may4th.chat.domain.api.entities;

import io.may4th.chat.domain.api.CommonValidation;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

@Accessors(chain = true)
@Document
@Getter
@Setter
public class Room {

    @Id
    @NotNull
    private UUID id;

    @NotNull
    private UUID ownerId;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 128)
    @Pattern(regexp= CommonValidation.TRIMMED_SINGLE_LINE)
    private String title;
}
