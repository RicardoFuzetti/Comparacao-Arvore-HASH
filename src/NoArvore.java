public class NoArvore {

    public NoArvore esquerda;
    public int dado;
    public NoArvore direita;

    public NoArvore(int valor) {
        this.dado = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
