package be.technifutur.java.demospringmvc.models.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int HotelId;
    private int numRoom;
    private int nbrSimpleBed;
    private int nbrDoubleBed;
    private int size;
}
