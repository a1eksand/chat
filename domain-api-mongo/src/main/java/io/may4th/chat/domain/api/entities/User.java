package io.may4th.chat.domain.api.entities;

import io.may4th.chat.domain.api.CommonValidation;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Document
@Getter
@Setter
public class User {

    @Id
    @NotNull
    private UUID id;

    @Indexed(unique = true)
    @NotNull
    @NotBlank
    @Size(min = 4, max = 64)
    @Pattern(regexp= CommonValidation.WITHOUT_WHITESPACE)
    private String username;

    @NotNull
    private String hash;

    @NotNull
    private List<UUID> rooms;
}
