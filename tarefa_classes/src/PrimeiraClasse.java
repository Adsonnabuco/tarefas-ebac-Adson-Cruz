public class PrimeiraClasse {
    public static void main(String args[]) {

        Cachorro cachorro = new Cachorro();

        cachorro.setCor("Preto");
        cachorro.setRaca("Pastor Alemão");
        cachorro.setTamanho("Grande");
        cachorro.setIdade(9);
        System.out.println(cachorro.getRaca());
        System.out.println(cachorro.getTamanho());
        System.out.println(cachorro.getIdade());
        System.out.println(cachorro.getCor());
    }
}
