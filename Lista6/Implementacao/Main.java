package Implementacao;

public class Main {
    public static void main(String[] args) {
        RedBlack arvore = new RedBlack();

        // Inserir valores na árvore
        int[] valoresInseridos = {50, 30, 20, 70, 40, 35, 37, 38, 10, 32, 45,
            42, 25, 47, 36, 49};
        for (int valor : valoresInseridos) {
            arvore.inserir(valor);
            
        }
        System.out.println("Árvore Rubro-Negra em ordem:");
        arvore.exibirArvore();
        int[] valoresRemovidos = {37, 70,45, 36, 32, 42, 40} ;
        for (int valor : valoresRemovidos) {
            arvore.remover(valor);
            
        }
        System.out.println("Árvore Rubro-Negra em ordem:");
        arvore.exibirArvore();
        

        
    }
}
