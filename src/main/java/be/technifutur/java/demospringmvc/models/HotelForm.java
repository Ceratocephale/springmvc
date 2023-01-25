package be.technifutur.java.demospringmvc.models;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelForm {
    @PositiveOrZero
    private int id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 200)
    private String address;
    @PositiveOrZero
    @Max(5)
    private int starNumber;


    @NotBlank
    @Size(max = 100)
    private String receptionName;
}
