package ru.itis.semestrproject.models;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.itis.semestrproject.constraints.AccountAgeConstraint;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "account")
public abstract class Account  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please fill the name")
    @Size(min=2, max=50, message = "Name should be >2 and <50")
    protected String name;

    @NotBlank(message = "Please fill the surname")
    @Size(min=2, message = "Surname too short")
    protected String surname;

    protected String patronymic;

    @NotBlank(message = "Password cannot be empty")
    @Length(min = 6, message = "Too short, must be > 6")
    protected String password;

    @Digits(integer=3, fraction=0, message = "Не более 3-х знаков")
    @AccountAgeConstraint
    protected Integer age;

    protected boolean isActive;
    protected String activationCode;

    @Enumerated(EnumType.STRING)
    protected Gender gender;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(unique=true)
    protected String email;

    protected String avatarFilename;

    @Enumerated(EnumType.STRING)
    protected Role role;


    abstract String getType();
}
