package Lista1.Exercicio9;

public class Aluno {
    String nome;
    int matricula;

    public Aluno(int matricula, String nome) {
        this.nome = nome;
        this.matricula = matricula;
    }
    

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        
        return nome;
    }
}
