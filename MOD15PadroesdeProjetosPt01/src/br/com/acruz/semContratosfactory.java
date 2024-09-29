package br.com.acruz;

public class semContratosfactory extends Factory {

    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)){
            return new Brasilia(150, "cheio", "Amarela");
        } else {
            return null;
        }

    }
}
