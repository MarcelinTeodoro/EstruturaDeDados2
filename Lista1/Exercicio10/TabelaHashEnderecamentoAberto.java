package Lista1.Exercicio10;

import Lista1.Exercicio9.Aluno;

/**
 * TabelaHashEnderecamentoAberto
 */
public class TabelaHashEnderecamentoAberto {
    private Aluno [] tabela;
    private int tamanho ;
    private double	fatorDeCarga;
    private static final Aluno APAGADO = new Aluno(Integer.MAX_VALUE, "Apagado");
    
    public TabelaHashEnderecamentoAberto(){
        this.tabela = new Aluno[8];
        this.tamanho = 0;
        this.fatorDeCarga = 0.75;
    }

    public int hash(int chave){
        return chave % this.tabela.length;
    }

    public Aluno get(int chave){
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {
            hash = (hash(chave)+sondagem)%tabela.length;
            if(tabela[hash] == null){
                return null;
            }else if(tabela[hash].getMatricula()==chave){
                return tabela[hash];
            }else{
                sondagem++;
            }
            
        }
        return null;
    }

    public void put(int chave , Aluno valor){
        if ((double)this.tamanho/this.tabela.length >= this.fatorDeCarga||
        this.tamanho == this.tabela.length ) {
            resize();
        }
        int sondagem = 0;
        int hash;
        while (sondagem < tabela.length) {
            hash = (hash(chave)+ sondagem)%tabela.length;
            if (tabela[hash]==null|| tabela[hash].getMatricula() == chave
            || tabela[hash].equals(APAGADO)) {
                tabela[hash] = valor;
                imprimirTabela(tabela);
                this.tamanho++;
                return;
            }else{
                sondagem++;

            }
        }
        //throw new tabelaCheiaException();
    }
    public void imprimirTabela(Aluno[] tabela){
        System.out.println("------------Tabela Hash------------");
        for(int i = 0; i < tabela.length ; i++){
            System.out.print(i+"-");
            System.out.println(   (tabela[i]) );
        
        }
        System.out.println("------------------------");
    }
    public Aluno remove(int chave){
        int sondagem = 0 ;
        int hash;
        while (sondagem<tabela.length) {
            hash= (hash(chave)+ sondagem)% tabela.length;
            if (tabela[hash]==null) {
                return null;
            }else if (tabela[hash].getMatricula()== chave) {
                Aluno a = tabela[hash];
                tabela[hash]=APAGADO;
                tamanho--;
                imprimirTabela(tabela);
                return a;
            }else{
                sondagem++;
            }        
        }
        return null;
    }

    public void resize(){
        Aluno[] tabelaAntiga = this.tabela;
        this.tabela = new Aluno[this.tabela.length * 2];
        this.tamanho = 0;
        for(Aluno aluno : tabelaAntiga){
            if (aluno != null ) {
                this.put(aluno.getMatricula(), aluno);
            }
            
        }
    }
}