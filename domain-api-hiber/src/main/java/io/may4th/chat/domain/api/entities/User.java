package io.may4th.chat.domain.api.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @Length(min = 4, max = 64)
    @NotBlank
    private String username;

    @NotNull
    private String hash;

    @NotNull
    @ElementCollection(targetClass=UUID.class)
    private List<UUID> rooms;
}
