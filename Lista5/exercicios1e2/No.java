package exercicios1e2;
public class No {

    public int data;
    public No esq;
    public No dir;
    public int alt; 

    public No(int data){
        this.data = data;
        this.esq  = null;
        this.dir  = null;
        this.alt = 1;
    }
}