package Exercicios1a7;
public class No {

    public int data;
    public No esq;
    public No dir;

    public No(int data){
        this.data = data;
        this.esq  = null;
        this.dir  = null;
    }
}