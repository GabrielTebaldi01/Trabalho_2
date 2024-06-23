public class Pessoa {
    private String nome;
    private int idade;
    private char genero;

    public Pessoa(String nome, int idade, char genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
