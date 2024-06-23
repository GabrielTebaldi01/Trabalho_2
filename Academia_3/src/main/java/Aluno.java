public class Aluno extends Pessoa {
    private Treino planoTreino;
    private double mensalidade;

    public Aluno(String nome, int idade, char genero, Treino planoTreino, double mensalidade) {
        super(nome, idade, genero);
        this.planoTreino = planoTreino;
        this.mensalidade = mensalidade;
    }

    // Getters e setters
    public Treino getPlanoTreino() {
        return planoTreino;
    }

    public void setPlanoTreino(Treino planoTreino) {
        this.planoTreino = planoTreino;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }
}
