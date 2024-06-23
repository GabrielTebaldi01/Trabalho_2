public class Professor extends Pessoa {
    private String especializacao;
    private double salario;

    public Professor(String nome, int idade, char genero, String especializacao, double salario) {
        super(nome, idade, genero);
        this.especializacao = especializacao;
        this.salario = salario;
    }

    // Getters e setters
    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
