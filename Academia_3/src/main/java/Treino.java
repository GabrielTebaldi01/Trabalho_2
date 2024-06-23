public class Treino {
    private String nome;
    private int duracaoMinutos;
    private String tipoDeTreino;
    private String exercicios;

    public Treino(String nome, int duracaoMinutos, String tipoDeTreino, String exercicios) {
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
        this.tipoDeTreino = tipoDeTreino;
        this.exercicios = exercicios;
    }

    public String toString() {
        return "Nome do treino: " + nome + "\n" +
               "Duração do treino: " + duracaoMinutos + " minutos\n" +
               "Tipo de treino: " + tipoDeTreino + "\n" +
               "Exercícios: " + exercicios;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getTipoTreino() {
        return tipoDeTreino;
    }

    public void setTipoTreino(String tipoDeTreino) {
        this.tipoDeTreino = tipoDeTreino;
    }

    public String getExercicios() {
        return exercicios;
    }

    public void setExercicios(String exercicios) {
        this.exercicios = exercicios;
    }
}
