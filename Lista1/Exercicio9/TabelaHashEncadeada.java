package Lista1.Exercicio9;
import java.util.ArrayList;

public class TabelaHashEncadeada  {
    private ArrayList<Aluno>[] tabela;


    public TabelaHashEncadeada(int tamanho) {
        this.tabela = new ArrayList[tamanho];

    }

    public  int hash(int chave){ //funcao has
        return chave % this.tabela.length;
        
    }     
    public Aluno get (int chave){
        int hash = this.hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        if (alunos == null) {
            return null;
        }
        for(Aluno aluno:alunos){
            if (aluno.getMatricula()== chave) {
                return aluno;
            }
        }
        return null;
    }
    public void put(int chave, Aluno valor){
        int hash = this.hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela[hash] = alunos;
        }else{
            for(int i = 0; i < alunos.size();i++){
                if (alunos.get(i).getMatricula()==chave) {
                    alunos.set(i, valor);
                    return;
                }
            }
            alunos.add(valor);
        }
        imprimirTabela(alunos);
    }
    public void imprimirTabela(ArrayList<Aluno> alunos){
        System.out.println("------------Tabela Hash------------");
        for(int i = 0; i < tabela.length; i++){
            System.out.print(i+"-");
            System.out.println(   (alunos =   this.tabela[i]) );
        
        }
        System.out.println("------------------------");
    }

    public Aluno remove(int chave){
        int hash = this.hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        for(Aluno atual : alunos){
            if (atual.getMatricula()==chave) {
                alunos.remove(atual);
                
                imprimirTabela(alunos);
                return atual;
            }
        }
        return null;
    }
}
