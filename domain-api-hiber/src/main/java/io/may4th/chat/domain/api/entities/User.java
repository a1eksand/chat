package io.may4th.chat.domain.api.entities;

import io.may4th.chat.domain.api.CommonValidation;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Accessors(chain = true)
@Entity
@Getter
@Setter
@Table(name = "user_")
public class User {

    @Id
    @NotNull
    private UUID id;

    @Column(unique = true)
    @NotNull
    @NotBlank
    @Size(min = 4, max = 64)
    @Pattern(regexp= CommonValidation.WITHOUT_WHITESPACE)
    private String username;

    @NotNull
    private String hash;

    @NotNull
    @ElementCollection(targetClass=UUID.class)
    private List<UUID> rooms;
}
