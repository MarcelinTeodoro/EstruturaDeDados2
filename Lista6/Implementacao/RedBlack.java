package Implementacao;

public class RedBlack {
        private No raiz;
        private final No NULO; // Nó "sentinela" para folhas nulas
    
        // Construtor
        public RedBlack() {
            NULO = new No(0); // Nó sentinela representando null
            NULO.cor = Cor.PRETO; // Folhas nulas são sempre pretas
            raiz = NULO;
        }
    
        // Inserção de um valor na árvore
        public void inserir(int valor) {
            No novoNo = new No(valor);
            novoNo.esquerdo = NULO;
            novoNo.direito = NULO;
    
            No atual = raiz;
            No pai = null;
    
            // Encontrar a posição para inserir o novo nó
            while (atual != NULO) {
                pai = atual;
                if (valor < atual.valor) {
                    atual = atual.esquerdo;
                } else {
                    atual = atual.direito;
                }
            }
    
            // Configurar o pai do novo nó
            novoNo.pai = pai;
    
            if (pai == null) {
                raiz = novoNo; // Novo nó será a raiz
            } else if (valor < pai.valor) {
                pai.esquerdo = novoNo;
            } else {
                pai.direito = novoNo;
            }
    
            // Ajustar as propriedades rubro-negras
            ajustarInsercao(novoNo);
        }
    
        // Ajustar as propriedades rubro-negras após a inserção
        private void ajustarInsercao(No no) {
            while (no.pai != null && no.pai.cor == Cor.VERMELHO) {
                No avo = no.pai.pai;
    
                if (no.pai == avo.esquerdo) { // Pai é filho esquerdo do avô
                    No tio = avo.direito;
    
                    // Caso 1: O tio é vermelho
                    if (tio.cor == Cor.VERMELHO) {
                        no.pai.cor = Cor.PRETO;
                        tio.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        no = avo;
                    } else {
                        // Caso 2: Nó é filho direito
                        if (no == no.pai.direito) {
                            no = no.pai;
                            rotacaoEsquerda(no);
                        }
    
                        // Caso 3: Nó é filho esquerdo
                        no.pai.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        rotacaoDireita(avo);
                    }
                } else { // Pai é filho direito do avô
                    No tio = avo.esquerdo;
    
                    // Caso 1: O tio é vermelho
                    if (tio.cor == Cor.VERMELHO) {
                        no.pai.cor = Cor.PRETO;
                        tio.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        no = avo;
                    } else {
                        // Caso 2: Nó é filho esquerdo
                        if (no == no.pai.esquerdo) {
                            no = no.pai;
                            rotacaoDireita(no);
                        }
    
                        // Caso 3: Nó é filho direito
                        no.pai.cor = Cor.PRETO;
                        avo.cor = Cor.VERMELHO;
                        rotacaoEsquerda(avo);
                    }
                }
            }
    
            raiz.cor = Cor.PRETO; // A raiz deve sempre ser preta
        }
    
        // Rotação à esquerda
        private void rotacaoEsquerda(No no) {
            No direito = no.direito;
            no.direito = direito.esquerdo;
    
            if (direito.esquerdo != NULO) {
                direito.esquerdo.pai = no;
            }
    
            direito.pai = no.pai;
    
            if (no.pai == null) {
                raiz = direito;
            } else if (no == no.pai.esquerdo) {
                no.pai.esquerdo = direito;
            } else {
                no.pai.direito = direito;
            }
    
            direito.esquerdo = no;
            no.pai = direito;
        }
    
        // Rotação à direita
        private void rotacaoDireita(No no) {
            No esquerdo = no.esquerdo;
            no.esquerdo = esquerdo.direito;
    
            if (esquerdo.direito != NULO) {
                esquerdo.direito.pai = no;
            }
    
            esquerdo.pai = no.pai;
    
            if (no.pai == null) {
                raiz = esquerdo;
            } else if (no == no.pai.direito) {
                no.pai.direito = esquerdo;
            } else {
                no.pai.esquerdo = esquerdo;
            }
    
            esquerdo.direito = no;
            no.pai = esquerdo;
        }
    
        // Exibição em ordem (para testar a árvore)
        public void exibirArvore() {
            exibirEmOrdem(raiz);
            System.out.println();
        }
    
        private void exibirEmOrdem(No no) {
            if (no != NULO) {
                exibirEmOrdem(no.esquerdo);
                System.out.print(no.valor + "(" + no.cor + ") ");
                exibirEmOrdem(no.direito);
            }
        }
        public void remover(int valor) {
            No no = buscarNo(raiz, valor); // Localizar o nó a ser removido
            if (no == NULO) {
                System.out.println("Valor não encontrado na árvore.");
                return;
            }
        
            No noParaRemover = no;
            No substituto;
            Cor corOriginal = noParaRemover.cor;
        
            if (no.esquerdo == NULO) {
                substituto = no.direito;
                transplantar(no, no.direito);
            } else if (no.direito == NULO) {
                substituto = no.esquerdo;
                transplantar(no, no.esquerdo);
            } else {
                No sucessor = minimo(no.direito); // Encontra o sucessor in-ordem
                corOriginal = sucessor.cor;
                substituto = sucessor.direito;
        
                if (sucessor.pai == no) {
                    substituto.pai = sucessor;
                } else {
                    transplantar(sucessor, sucessor.direito);
                    sucessor.direito = no.direito;
                    sucessor.direito.pai = sucessor;
                }
        
                transplantar(no, sucessor);
                sucessor.esquerdo = no.esquerdo;
                sucessor.esquerdo.pai = sucessor;
                sucessor.cor = no.cor;
            }
        
            if (corOriginal == Cor.PRETO) {
                ajustarRemocao(substituto);
            }
        }
        
        // Substitui um nó u por outro nó v na árvore
        private void transplantar(No u, No v) {
            if (u.pai == null) {
                raiz = v;
            } else if (u == u.pai.esquerdo) {
                u.pai.esquerdo = v;
            } else {
                u.pai.direito = v;
            }
            v.pai = u.pai;
        }
        
        // Ajustar as propriedades rubro-negras após a remoção
        private void ajustarRemocao(No no) {
            while (no != raiz && no.cor == Cor.PRETO) {
                if (no == no.pai.esquerdo) {
                    No irmao = no.pai.direito;
        
                    if (irmao.cor == Cor.VERMELHO) { // Caso 1: O irmão é vermelho
                        irmao.cor = Cor.PRETO;
                        no.pai.cor = Cor.VERMELHO;
                        rotacaoEsquerda(no.pai);
                        irmao = no.pai.direito;
                    }
        
                    if (irmao.esquerdo.cor == Cor.PRETO && irmao.direito.cor == Cor.PRETO) { // Caso 2: Ambos os filhos do irmão são pretos
                        irmao.cor = Cor.VERMELHO;
                        no = no.pai;
                    } else {
                        if (irmao.direito.cor == Cor.PRETO) { // Caso 3: O filho direito do irmão é preto
                            irmao.esquerdo.cor = Cor.PRETO;
                            irmao.cor = Cor.VERMELHO;
                            rotacaoDireita(irmao);
                            irmao = no.pai.direito;
                        }
        
                        // Caso 4: O filho direito do irmão é vermelho
                        irmao.cor = no.pai.cor;
                        no.pai.cor = Cor.PRETO;
                        irmao.direito.cor = Cor.PRETO;
                        rotacaoEsquerda(no.pai);
                        no = raiz;
                    }
                } else {
                    No irmao = no.pai.esquerdo;
        
                    if (irmao.cor == Cor.VERMELHO) { // Caso 1: O irmão é vermelho
                        irmao.cor = Cor.PRETO;
                        no.pai.cor = Cor.VERMELHO;
                        rotacaoDireita(no.pai);
                        irmao = no.pai.esquerdo;
                    }
        
                    if (irmao.esquerdo.cor == Cor.PRETO && irmao.direito.cor == Cor.PRETO) { // Caso 2: Ambos os filhos do irmão são pretos
                        irmao.cor = Cor.VERMELHO;
                        no = no.pai;
                    } else {
                        if (irmao.esquerdo.cor == Cor.PRETO) { // Caso 3: O filho esquerdo do irmão é preto
                            irmao.direito.cor = Cor.PRETO;
                            irmao.cor = Cor.VERMELHO;
                            rotacaoEsquerda(irmao);
                            irmao = no.pai.esquerdo;
                        }
        
                        // Caso 4: O filho esquerdo do irmão é vermelho
                        irmao.cor = no.pai.cor;
                        no.pai.cor = Cor.PRETO;
                        irmao.esquerdo.cor = Cor.PRETO;
                        rotacaoDireita(no.pai);
                        no = raiz;
                    }
                }
            }
        
            no.cor = Cor.PRETO;
        }
        
        // Encontrar o nó com o menor valor em uma subárvore
        private No minimo(No no) {
            while (no.esquerdo != NULO) {
                no = no.esquerdo;
            }
            return no;
        }
        
        // Buscar nó por valor
        private No buscarNo(No no, int valor) {
            while (no != NULO && valor != no.valor) {
                if (valor < no.valor) {
                    no = no.esquerdo;
                } else {
                    no = no.direito;
                }
            }
            return no;
        }
        
    }
    
    
    

