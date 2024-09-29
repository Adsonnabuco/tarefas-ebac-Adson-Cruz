package br.com.acruz;

public class Demo {

    public static void main(String[] args) {
            Customer cliente = new Customer("A", false);
            Factory factory = getFactory(cliente);
            Car car = factory.create(cliente.getGradeRequest());
            car.startEngine();
    }
    public static Factory getFactory(Customer cliente){
        if (cliente.hasCompanyContract()) {
            return new Contratosfactory();
        } else  {
            return new semContratosfactory();
        }
    }

}
