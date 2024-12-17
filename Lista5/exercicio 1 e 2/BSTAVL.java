package Exercicios1a7;

import java.util.Stack;

public class BSTAVL {
    private No raiz;

    public int getFatorBalanceamento(No no){
        if (no == null) return 0;
        return altura(no.esq) - altura(no.dir);
        
    }
    

    public void atualizarAltura(No no){
        no.alt = 1+ Math.max(altura(no.esq),(altura(no.dir))); 
    }
    public void inserir(int valor){
        System.out.println("valor inserido: "+ valor);
        raiz = inserir(raiz, valor);
    }
    private No inserir(No noRaiz, int valor){
        if (noRaiz == null) {
            return new No(valor);
        }
        if (valor < noRaiz.data) {
            noRaiz.esq = inserir(noRaiz.esq, valor);
        }else if (valor > noRaiz.data) {
            noRaiz.dir = inserir(noRaiz.dir, valor);
            
        }else {
            return noRaiz;
        }
        atualizarAltura(noRaiz);
        return rebalancear(noRaiz);
    }
    public void remover(int valor){
        System.out.println("removeu o valor: "+ valor);
        remover(raiz, valor);
    }
    private No remover(No noRaiz , int valor){
        if (noRaiz == null) {
            return null;
        }
        if (valor < noRaiz.data) {
            noRaiz.esq = remover(noRaiz.esq, valor);
        }else if (valor > noRaiz.data) {
            noRaiz.dir = remover(noRaiz.dir, valor);
        }else {
            if (noRaiz.esq == null && noRaiz.dir == null) {
                return null;
            }else if (noRaiz.esq == null || noRaiz.dir == null) {
                if (noRaiz.esq != null) {
                    noRaiz = noRaiz.esq;
                }else{
                    noRaiz = noRaiz.dir;
                }
            }else{
                No temp = max(noRaiz.dir);
                noRaiz.data = temp.data;
                noRaiz.dir = remover(noRaiz.dir, temp.data);
            }

        }
        atualizarAltura(noRaiz);
        return rebalancear(noRaiz);
    }

    public No rotacaoDireita(No A){
        System.out.println("fazer rotação a direita do no: "+ A.data);
        No B = A.esq;
        No Bdir = B.dir;
        B.dir=A;
        A.esq = Bdir;
        atualizarAltura(A);
        atualizarAltura(B);
        return B;
    }
    public No rotacaoEsquerda(No A){
        System.out.println("fazer rotação a Esquerda do no: "+ A.data);
        No B = A.dir;
        No Besq = B.esq;

        B.esq=A;
        A.dir = Besq;
        atualizarAltura(A);
        atualizarAltura(B);
        return B;
    }
    private No rebalancear(No no){
        int fatorBalanceamento = getFatorBalanceamento(no);
        int fatorBalanceamentoEsquerda = getFatorBalanceamento(no.esq);
        int fatorBalanceamentoDireita = getFatorBalanceamento(no.dir);
        //rsd
        
        if (fatorBalanceamento> 1 && fatorBalanceamentoEsquerda >= 0) {
            System.out.println("Fator de balanceamento: "+ fatorBalanceamento+" Esquerda: "+fatorBalanceamentoEsquerda+" Direita: "+ fatorBalanceamentoDireita);
            return rotacaoDireita(no);
        }
        //rdd
        if (fatorBalanceamento> 1 && fatorBalanceamentoEsquerda <0) {
            System.out.println("Fator de balanceamento: "+ fatorBalanceamento+" Esquerda: "+fatorBalanceamentoEsquerda+" Direita: "+ fatorBalanceamentoDireita);
            no.esq = rotacaoEsquerda(no.esq);
            return rotacaoDireita(no);
        }
        //rss
        if (fatorBalanceamento< -1 && fatorBalanceamentoDireita <= 0) {
            System.out.println("Fator de balanceamento: "+ fatorBalanceamento+" Esquerda: "+fatorBalanceamentoEsquerda+" Direita: "+ fatorBalanceamentoDireita);
            return rotacaoEsquerda(no);
        }
        //rds
        if (fatorBalanceamento< -1 && fatorBalanceamentoDireita >0) {
            System.out.println("Fator de balanceamento: "+ fatorBalanceamento+" Esquerda: "+fatorBalanceamentoEsquerda+" Direita: "+ fatorBalanceamentoDireita);
            no.dir = rotacaoDireita(no.dir);
            return rotacaoEsquerda(no);
        }
        return no;
    }
    public No max(No raiz){
        if (raiz == null) return raiz;
        if (raiz.esq != null) {
            return max(raiz.esq);
        }    
        return raiz;
    }
    public boolean buscar(int valor){
        return buscar(raiz, valor);
    }

    private boolean buscar(No raiz, int valor){
        if (raiz == null)return false;
        if (raiz.data == valor) return true;
        if (valor < raiz.data)return buscar(raiz.esq, valor);
        else return buscar(raiz.dir, valor);
        
        
    }
    public boolean isFolha(No raiz){
        return raiz.esq == null && raiz.dir == null;
    }

    public int altura(No no){
        if (no == null) return 0;
            
        return no.alt;
    }
    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(raiz);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                No temp = (No) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.esq);
                    localStack.push(temp.dir);
                    if (temp.esq != null ||
                            temp.dir != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}
