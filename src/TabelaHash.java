public class TabelaHash {

    protected ListaSE[] tabelaHash;
    protected int tamanho;
    int contagemColisoes;

    public TabelaHash(int total) {
        tamanho = 0;
        contagemColisoes = 0;
        tabelaHash = new ListaSE[total];
        for(int i=0; i<total; i++) {
            tabelaHash[i] = new ListaSE();
        }
    }

    public void setTamanho(int t) {
        tamanho = t;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int funcaoHash(int elemento, int tamanho) {
        return elemento % tamanho;
    }

    public ListaSE retornaPrimeiro() {
        ListaSE lista = new ListaSE();
        return lista;
    }

    public void insere(int elemento, int tamanho) {
        int posicao = funcaoHash(elemento, tamanho);
        if (tabelaHash [posicao] != null){
            if (tabelaHash[posicao].buscaLista(elemento) && retornaPrimeiro().getP() == null) { //REFERENCIA ESTATICA?
                NoSE no = new NoSE(elemento);
                tabelaHash[posicao].insereUltimo(elemento);
                // Não estamos conseguindo alocar o primeiro elemento da ListaSE na posição da tabelaHash
            } else if (tabelaHash[posicao].buscaLista(elemento)) {
                System.out.println("Chave: [" + posicao + "] esta ocupada. Inserindo na proxima chave.");
                contagemColisoes++;
                tabelaHash[posicao++].insereUltimo(elemento);

            } else {
                tabelaHash [posicao].insereUltimo(elemento);
            }
        }
    }


    // Busca o elemento dentro da tabela
    // Busca independente


    public int buscaElemento(int elemento) {
        int i = funcaoHash(elemento, tamanho);
        if (tabelaHash[i].buscaLista(elemento)) {
            return elemento;
        }else {
            return -1;
        }
    }

    public void imprime() {
        for (int i=0; i<tamanho; i++) {
            String imprime = "\n HASH[";
            if(i<10) {
                System.out.print(imprime + "0" + i + "] -> ");
            }else {
                System.out.print(imprime + i + "] -> ");
            }if (tabelaHash[i].primeiro != null) {
                tabelaHash[i].imprime();
            }
            else {
                System.out.print("null");
            }
        }
    }


    // Busca a Posição do elemento dentro da tabela
    // Busca atrelada ao apagar()


    public int buscaPosicao(int posicao) {
        for (int i=0; i<tamanho; i++)
            if ( tabelaHash[i]!=null ) {
                if (tabelaHash[i].buscaLista(posicao)) {
                    return i;
                }
            }
        return -1;
    }

    public void apaga(int elemento) {
        int pos = buscaPosicao((int)elemento);
        if (pos != -1) {
            tabelaHash[pos].remove(elemento);
        }
        else System.out.println("\n ---- " + elemento + " nao encontrado na Tabela ----");
    }

    public void mostrar() {
        int t = getTamanho();
        System.out.println("Tamanho da Tabela Hash: " + t);
    }

    public void colisoes() {
        System.out.println("Quantidade de colisoes: " + contagemColisoes);
    }
}
