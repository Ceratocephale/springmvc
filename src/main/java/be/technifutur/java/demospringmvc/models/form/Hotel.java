package be.technifutur.java.demospringmvc.models.form;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Hotel {
    private int id;
    private String address;
    private int starNumber;
    private String receptionName;
    private String name;

}
