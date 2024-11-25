package Exercicios1a7;

import java.util.ArrayList;


public class BST {
    private No raiz;
    private int qtdNo; 
    public  ArrayList<Integer> lista;

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    
    // Exercicio 1 
    public int contarNo() {
        qtdNo = 0;
        contarNo(raiz);
        
        return qtdNo;
    }
    private void contarNo(No raiz){
        if (raiz == null)return; 
        contarNo(raiz.esq); 
        qtdNo = qtdNo + 1 ;
        contarNo(raiz.dir);
        
    }
    // Exercicio 2 
    public int contarNoFolhas() {
        qtdNo = 0;
        contarNoFolhas(raiz);
        
        return qtdNo;
    }
    private void contarNoFolhas(No raiz){
        if (raiz == null)return; 
        contarNoFolhas(raiz.esq); 
        if (isFolha(raiz)) {
            qtdNo = qtdNo + 1 ;
        }
        contarNoFolhas(raiz.dir);
        
    }
    // Exercicio 3 
    public void inserirSemRecursividade(int data){
        No novNo = new No(data);
        
        if (raiz == null) {
            raiz = novNo;
            return;
        }
        No atual = raiz;
        
        while (atual != null) {

            if (atual.data > novNo.data) {
                if (atual.esq == null) {
                    atual.esq = novNo;
                    return;
                }else{atual = atual.esq;
                    
    
                }
            }else {
                if (atual.dir == null) {
                    atual.dir = novNo;
                    return;
                }else{atual = atual.dir;
    
                }
            }
        }

    }
    // Exercicio 4 
    public void inverterOrdem(){
        inverterOrdem(raiz);
    }
    private void inverterOrdem(No raiz){
        if (raiz != null) {
            inverterOrdem(raiz.esq);
            inverterOrdem(raiz.dir);
            No raizTemp = raiz.esq;
            raiz.esq = raiz.dir;
            raiz.dir =  raizTemp;
        }
    }
    // Exercicio 5
    public boolean verificarSemelhamte(No B){
        
        return verificarSemelhamte(raiz, B);
        
        
    }
    private boolean verificarSemelhamte(No A, No B){
        if (A == null && B == null ) {
            return true;
        }
        if (A== null && B != null || A!= null && B == null) {
            return false;
        }
        return verificarSemelhamte(A.esq, B.esq)&&  verificarSemelhamte(A.dir, B.dir);
        
    }
    // Exercicio 6 sem usar recursao, obs  poderia usar recursao
    public boolean verificarIgual(BST a, BST b){
        if (a.listaEmOrdem().equals(b.listaEmOrdem()) && a.listaPreOrdem().equals(b.listaPreOrdem())) {
            return true;
        }else{return false;}
    }
    
    public ArrayList<Integer> listaPreOrdem(){
        ArrayList<Integer> lista = new ArrayList();
        lista.clear();
        listaPreOrdem(raiz, lista);
        return lista;
    }
    private void listaPreOrdem(No raiz, ArrayList<Integer> lista){
        if (raiz != null){ 
            lista.add(raiz.data);
            listaPreOrdem(raiz.esq, lista); 
            listaPreOrdem(raiz.dir, lista);
        }
        
        
    }
    public ArrayList listaEmOrdem(){
        ArrayList<Integer> lista = new ArrayList();
        lista.clear();
        listaEmOrdem(raiz, lista);
        return lista;
    }
    private void listaEmOrdem(No raiz, ArrayList<Integer> lista){
        if (raiz == null)return; 
        listaEmOrdem(raiz.esq, lista); 
        lista.add(raiz.data);
        listaEmOrdem(raiz.dir, lista);
        
    }
    // Exercicio 7
    public boolean IsBinary() {
        qtdNo = 0;
        isBinary(raiz);
        if (qtdNo == -1) {
            return true;
        }
        
        return false;
    }
    private void isBinary(No raiz){
        if (raiz == null)return; 
        contarNoFolhas(raiz.esq); 
        if (raiz.esq == null&& raiz.dir != null || raiz.esq != null&& raiz.dir == null) {
            qtdNo = -1 ;
        }
        contarNoFolhas(raiz.dir);
        
    }




    public BST(){
        this.raiz = null;
    }

    public No getRaiz(){
        return this.raiz;
    }
    public void inserir(int data){
        No novNo = new No(data);
        raiz = inserir(raiz, novNo);
    }

    private No inserir(No raiz, No novoNO){
        if (raiz ==  null ) {
            raiz =  novoNO;
            return novoNO;
        }
        if (novoNO.data < raiz.data) {
            if (raiz.esq == null) {
                raiz.esq = novoNO;
            }else{
                inserir(raiz.esq, novoNO);
            }
        }else{
            if (raiz.dir == null) {
                raiz.dir = novoNO;

            }else{
                inserir(raiz.dir, novoNO);
            }
        }
        return raiz;
        

    }

    public void apagar(int valor){
        raiz = apagar(raiz, valor);
    }

    private No apagar(No raiz, int valor){
        if (raiz == null) {
            return raiz;
        }
        if (valor < raiz.data)raiz.esq = apagar(raiz.esq, valor);
        else if(valor > raiz.data)raiz.dir = apagar(raiz.dir, valor);
        else{
            if (raiz.esq == null) return raiz.dir;
            if (raiz.dir == null) return raiz.esq;
            
            raiz.data = min(raiz.dir).data; // predecessor(min) ou sucessor(max)
            raiz.dir = apagar(raiz.dir, raiz.data);
            
            
        }
        return raiz;
    }
    private No min(No raiz){
        if (raiz == null) return raiz;
        if (raiz.esq != null) {
            return min(raiz.esq);
        }    
        return raiz;
    }

    public boolean isFolha(No raiz){
        return raiz.esq == null && raiz.dir == null;
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
    public void imprimirPreOrdem(){
        imprimirPreOrdem(raiz);
    }
    public void imprimirEmOrdem(){
        imprimirEmOrdem(raiz);
    }
    public void imprimirPosOrdem(){
        imprimirPosOrdem(raiz);
    }
    

    private void imprimirPreOrdem(No raiz){
        if (raiz != null){ 
        System.out.print(raiz.data+" ");
        imprimirPreOrdem(raiz.esq); 
        
        imprimirPreOrdem(raiz.dir);
        }
    }

    private void imprimirEmOrdem(No raiz){
        if (raiz == null)return; 
        imprimirEmOrdem(raiz.esq); 
        System.out.print(raiz.data+" ");
        imprimirEmOrdem(raiz.dir);
        
    }
    private void imprimirPosOrdem(No raiz){
        if (raiz != null) {
            imprimirPosOrdem(raiz.esq);
            imprimirPosOrdem(raiz.dir);
            System.out.print(raiz.data+" ");
        }
    }
    
    private int altura(No no){
        if (no == null) return 0;
        if (isFolha(no))return 0;
            
        return 1 + Math.max(altura(no.esq), altura(no.dir));
    }

}
