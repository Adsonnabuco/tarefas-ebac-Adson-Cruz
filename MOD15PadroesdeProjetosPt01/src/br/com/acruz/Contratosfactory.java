package br.com.acruz;

public class Contratosfactory extends Factory{
    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)){
            return new CorolaCar(100, "cheio", "Azul");
        } else {
            return null;
        }
    }
}
