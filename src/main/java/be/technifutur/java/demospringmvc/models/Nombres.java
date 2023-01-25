package be.technifutur.java.demospringmvc.models;

import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Nombres {

   @Positive
   private int one, two;
   private char operand;

   public void update(int input){
      setOne(input);
   }

}
