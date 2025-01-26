package Implementacao;

class No {
    int valor;
    Cor cor;
    No esquerdo;
    No direito;
    No pai;

    // Construtor
    public No(int valor) {
        this.valor = valor;
        this.cor = Cor.VERMELHO; // Todo novo nó começa como vermelho
        this.esquerdo = null;
        this.direito = null;
        this.pai = null;
    }
}
