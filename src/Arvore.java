public class Arvore {
    NoArvore raiz;

    public Arvore(){
        raiz = null;
    }

    public void insere(int valor){
        NoArvore novo = new NoArvore(valor);

        if (raiz == null){
            raiz = novo;
        } else {
            NoArvore p = raiz;
            NoArvore q = null;
            while (p != null){
                q = p;
                if (valor < p.dado){
                    p = p.esquerda;
                } else {
                    p = p.direita;
                }
            }
            if (valor < q.dado){
                q.esquerda = novo;
            } else {
                q.direita = novo;
            }
        }
    }

    public void preOrdem(NoArvore raiz){
        if (raiz != null){
            System.out.println(raiz.dado);
            preOrdem(raiz.esquerda);
            preOrdem(raiz.direita);
        }
    }

    public void inOrdem(NoArvore raiz){
        if (raiz != null){
            inOrdem(raiz.esquerda);
            System.out.println(raiz.dado);
            inOrdem(raiz.direita);
        }
    }

    public void posOrdem(NoArvore raiz){
        if (raiz != null){
            posOrdem(raiz.esquerda);
            posOrdem(raiz.direita);
            System.out.println(raiz.dado);
        }
    }

    public void maior(){
        if (raiz != null){
            NoArvore no = null;
            while (raiz != null){
                no = raiz;
                raiz = raiz.direita;
            }
            System.out.println(no.dado);
        } else {
            System.out.println("Raiz vazia");
        }
    }

    public void menor(){
        if (raiz != null){
            NoArvore no = null;
            while (raiz != null){
                no = raiz;
                raiz = raiz.esquerda;
            }
            System.out.println(no.dado);
        } else {
            System.out.println("Raiz vazia");
        }
    }

    public void existe(int elemento, NoArvore no){
        if (no != null){
            if (no.dado == elemento){
                System.out.println("O elemento " + elemento + " existe na arvore");
            } else {
                existe(elemento, no.esquerda);
                existe(elemento, no.direita);
            }
        }
    }
}
