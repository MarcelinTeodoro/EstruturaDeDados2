package exercicios1e2;



public class Main {
    public static void main(String[] args) {
        // {1, 64, 12, 18, 66, 38, 95, 58, 59, 70, 68, 39, 62, 7, 60, 43, 16, 67, 34, 35}
        BSTAVL a  = new BSTAVL();

        
        a.inserir(50);
        a.printTree();
        a.inserir(1);
        a.printTree();
        a.inserir(64);
        a.printTree();
        a.inserir(12);
        a.printTree();
        a.inserir(18);
        a.printTree();
        a.inserir(66);
        a.printTree();
        a.inserir(38);
        a.printTree();
        a.inserir(95);
        a.printTree();
        a.inserir(58);
        a.printTree();
        a.inserir(59);
        a.printTree();
        a.inserir(70);
        a.printTree();
        a.inserir(68);
        a.printTree();
        a.inserir(39);
        a.printTree();
        a.inserir(62);
        a.printTree();
        a.inserir(7);
        a.printTree();
        a.inserir(60);
        a.printTree();
        a.inserir(43);
        a.printTree();
        a.inserir(16);
        a.printTree();
        a.inserir(67);
        a.printTree();
        a.inserir(34);
        a.printTree();
        a.inserir(35);
        a.printTree();
        // 50 , 95, 70 , 60 , 35
        a.remover(50);
        a.printTree();
        a.remover(95);
        a.printTree();
        a.remover(70);
        a.printTree();
        a.remover(60);
        a.printTree();
        a.remover(35);
        a.printTree();
    }
}
