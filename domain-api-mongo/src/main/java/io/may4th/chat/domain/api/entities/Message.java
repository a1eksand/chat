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
import java.time.ZonedDateTime;
import java.util.UUID;

@Accessors(chain = true)
@Document
@Getter
@Setter
public class Message {

    @Id
    @NotNull
    private UUID id;

    @NotNull
    private UUID userId;

    @NotNull
    private UUID roomId;

    @NotNull
    private ZonedDateTime timestamp;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 4096)
    @Pattern(regexp= CommonValidation.TRIMMED_MULTI_LINE)
    private String body;
}
