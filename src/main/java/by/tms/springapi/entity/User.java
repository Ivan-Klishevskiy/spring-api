package by.tms.springapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    @NotNull
    private String username;

    @NotBlank
    @NotEmpty
    @NotNull
    private String firstName;

    @NotBlank
    @NotEmpty
    @NotNull
    private String lastName;

    @NotBlank
    @NotEmpty
    @NotNull
    private String email;

    @NotBlank
    @NotEmpty
    @NotNull
    private String password;

    @NotBlank
    @NotEmpty
    @NotNull
    private String phone;

    private int userStatus;
}
