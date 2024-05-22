public class Cachorro {


    //Abaixo voce irá encontrar 3 grupos, Seguidos de:
    //1- VARIÁVEL
    //2- GETERS da mesma
    //3- SETTER da mesma
    private String Cor;
    public String getCor() {
        return Cor;
    }
    public void setCor(String cor) {
        Cor = cor;
    }

    /*
        Abaixo voce irá encontrar 3 grupos, Seguidos de:
        1- VARIÁVEL
        2- GETERS da mesma
        3- SETTER da mesma
    */
    private String Raca;
    public String getRaca() {
        return Raca;
    }
    public void setRaca(String raca) {
        Raca = raca;
    }

    /**
     * Abaivo voce irá encontrar as variaveis Tamando e Idade e seus respectivos getters e setters.
     * @param tamanho
     */
    private String Tamanho;

    public String getTamanho() {
        return Tamanho;
    }
    public void setTamanho(String tamanho) {
        Tamanho = tamanho;
    }

    private int Idade;

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }


    //Abaixo se encontra os Metodos.

    public void racaCachorro(String Raca){
        setRaca(Raca);
    }
    public void tamanhoCachorro(String Tamanho){
        setTamanho(Tamanho);
    }
    public void idadeCachorro(int Idade){
        setIdade(Idade);
    }
    public void corCachorro(String Cor){
        setCor(Cor);
    }

}
