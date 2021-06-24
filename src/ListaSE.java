public class ListaSE {
    public NoSE primeiro;
    public NoSE ultimo;
    public int tamanho;
    NoSE p = this.primeiro;

    public ListaSE(){
        this.primeiro = null;
        this.ultimo = null;
        p = this.primeiro;
    }

    public boolean vazia(){
        return (this.primeiro == null);
    }

    public NoSE getP(){
        NoSE p = this.primeiro;
        return p;
    }

    public void setP(NoSE n){
        p = n;
    }

    public void inserePrimeiro(int elemento){
        NoSE p = new NoSE(elemento);

        if (vazia()){
            this.primeiro = p;
            this.ultimo = p;
        }else{
            p.proximo = this.primeiro;
            this.primeiro = p;
        }
        tamanho++;
    }

    public void insereUltimo(int elemento){
        NoSE p = new NoSE(elemento);
        if (vazia()){
            this.primeiro = p;
            this.ultimo = p;
        }else{
            this.ultimo.proximo = p;
            this.ultimo = p;
        }
        tamanho++;
    }

    public void insereOrdenado(int elemento) {
        if(vazia()){
            inserePrimeiro(elemento);
        } else if(elemento < primeiro.dado) {
            inserePrimeiro(elemento);
        } else if(elemento > ultimo.dado) {
            insereUltimo(elemento);
        } else {
            NoSE p = primeiro;
            NoSE q = null;
            while(p.dado < elemento) {
                q = p;
                p = p.proximo;
            }
            insereDepois(elemento,q);
        }
        tamanho++;
    }

    public void insereDepois(int elemento, NoSE p) {
        NoSE novo = new NoSE(elemento);
        novo.proximo = p.proximo;
        p.proximo = novo;
        tamanho++;
    }




    public boolean buscaLista(int elemento){
        if (vazia()) {
            System.out.println("Lista está vazia!!!");
            return false;
        } else {
            while (getP().dado != elemento){
                setP(getP().proximo);
            }
            return true;
        }
    }


    public void imprime(){
        NoSE p = this.primeiro;
        while(p != null){
            System.out.println(p.dado);
            p = p.proximo;
        }
    }

    public int ultimoElemento() {
        if (vazia()){
            System.out.println("Lista está vazia!!!");
        } else {
            System.out.println(ultimo.dado);
            return ultimo.dado;
        }
        return ' ';
    }

    public boolean remove(int elemento) {
        if (vazia()) {
            System.out.println("Lista está vazia!!!");
            return false;
        } else {
            NoSE p = this.primeiro;
            while (p.dado != elemento){
                p = p.proximo;
            }
            p = null;
            System.out.println(elemento + " removido!!!");
            return true;
        }
    }

    public void retiraPrimeiro() {
        if (vazia()){
            System.out.println("Lista está vazia!!!");
        } else {
            primeiro = primeiro.proximo;
            tamanho--;
        }
    }

    public void retiraUltimo() {
        if (vazia()){
            System.out.println("Lista está vazia!!!");
        } else{
            NoSE p = this.primeiro;
            NoSE q = null;
            while(p.dado < this.ultimo.dado) {
                q = p;
                p = p.proximo;
            }
            q.proximo = null;
            this.ultimo = q;
            this.tamanho--;
        }
    }

    public void retiraDepois(NoSE no) {
        if (vazia()){
            System.out.println("Lista está vazia!!!");
        } else {
            no.proximo = no.proximo.proximo;
            tamanho--;
        }
    }

    public void inverte() {
        NoSE p = primeiro, q, r = null;

        while(p != null)
        {
            q = p.proximo;
            p.proximo = r;
            r = p;
            p = q;
        }
        if (primeiro != null)
        {
            p =  ultimo;
            ultimo = primeiro;
            primeiro = p;
        }
    }
}
