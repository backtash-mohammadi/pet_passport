package pet_passport.pet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "owners", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    // Optional; validate only if present. E.164 (e.g., +491234567890).
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Use E.164 format, e.g. +491234567890")
    private String phoneNumber;

}
