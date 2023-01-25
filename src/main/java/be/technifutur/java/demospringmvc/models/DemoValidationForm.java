package be.technifutur.java.demospringmvc.models;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class DemoValidationForm {

    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    private int entier;

    @NotBlank
    @NotNull
    @NotEmpty
    @Size(min = 0, max = 10)
    @Pattern(regexp = "kek")
    private String chaine;

    @NotNull
    @Null
    private Object objet;

    @NotNull
    @Null
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent
    private LocalDateTime dateTime;

    @NotNull
    @Null
    @NotEmpty
    @Size(min = 8, max = 10)
    private List<Object> list;

}
