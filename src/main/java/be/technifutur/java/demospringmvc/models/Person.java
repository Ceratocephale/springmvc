package be.technifutur.java.demospringmvc.models;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Person {
    @Size(min = 5, max = 10)
    @NotBlank
    private String firstName, lastName;

    @Past
    private LocalDate birthdate;
}
