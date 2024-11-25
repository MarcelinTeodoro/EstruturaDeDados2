package Exercicios1a7;



public class Main {
    public static void main(String[] args) {
        BST a  = new BST();
        BST d  = new BST();
        BST c  = new BST();
        a.inserir(5);
        a.inserir(0);
        a.inserir(3);
        a.inserir(8);
        a.inserir(1);
        //Ex4
        a.inserirSemRecursividade(4);
        a.inserir(2);
        a.inserir(7);
        a.inserir(6);
        a.inserir(9);
        System.out.println(a.buscar(4));
        //Ex3
        a.inverterOrdem();
        a.inverterOrdem();
        
        
        System.out.println("quantidade de nos = "+a.contarNo());
        System.out.println(" quantidade de nos folhas = "+a.contarNoFolhas());

        BST b  = new BST();
        b.inserir(5);
        b.inserir(0);
        b.inserir(3);
        b.inserir(8);
        b.inserir(1);
        b.inserir(4);
        b.inserir(2);
        b.inserir(7);
        b.inserir(6);
        b.inserir(9);
        System.out.println(b.buscar(4));
        
        b.imprimirPreOrdem();
        System.out.println("em ordem ");
        b.imprimirEmOrdem();
        System.out.println("pos ordem");
        b.imprimirPosOrdem();
        System.out.println();
        //Ex1
        System.out.println("quantidade de nos = "+b.contarNo());
        //Ex2
        System.out.println(" quantidade de nos folhas = "+b.contarNoFolhas());
        //Ex5
        System.out.println(" sao semelhantes? " +a.verificarSemelhamte(b.getRaiz()));
        // Ex6
        System.out.println(a.verificarIgual(a, b));
        // Ex 7
        System.out.println(a.IsBinary());
        System.out.println(c.verificarSemelhamte(d.getRaiz()));
        
        

    }
}
