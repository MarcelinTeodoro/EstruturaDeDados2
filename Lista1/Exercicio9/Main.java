package Lista1.Exercicio9;

public class Main {
    public static void main(String[] args) {
        TabelaHashEncadeada tab = new TabelaHashEncadeada(8);
        Aluno a  = new Aluno(52,"Chorao");
        Aluno b  = new Aluno(45,"Sabotagem");
        Aluno c  = new Aluno(64,"CPM22");
        Aluno d  = new Aluno(34,"Pity");
        Aluno e  = new Aluno(69,"Engenhiros");
        Aluno f  = new Aluno(11,"Raimundos");
        Aluno g  = new Aluno(10,"Ventania");
        Aluno h  = new Aluno(3 ,"Sepultura");
        Aluno i  = new Aluno(6 ,"Capital");
        Aluno j  = new Aluno(02,"Rappa");
        tab.put(52, a);
        tab.put(45, b);
        tab.put(64, c);
        tab.put(34, d);
        tab.put(69, e);
        tab.put(11, f);
        tab.put(10, g);
        tab.put(3, h );
        tab.put(6, i );
        tab.put(02, j);
        tab.get(45);
        tab.get(75);
        System.out.println("Atualizando a tabela...");
        System.out.println("Aluno retirado: " + tab.remove(11));

        
        
    }
}
