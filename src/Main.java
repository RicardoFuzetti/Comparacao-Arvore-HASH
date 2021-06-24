import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main (String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o tamanho: ");
        int tamanhoUsuario = entrada.nextInt();

        Random value = new Random();

        Arvore arvore = new Arvore();
        TabelaHash tabelaHash = new TabelaHash(tamanhoUsuario);



        // Arvore Binaria
        //Cálculo de tempo de inserção
        long inicioExecucaoArvore = System.nanoTime();
        for (int i = 0; i < tamanhoUsuario; i++){
            int valor = value.nextInt(999999999);
            arvore.insere(valor);
        }
        long fimExecucaoArvore = System.nanoTime();
        long tempoExecucaoArvore = fimExecucaoArvore - inicioExecucaoArvore;
        double secondsExecucaoArvore = (double) tempoExecucaoArvore / 1000000000;
        System.out.println("O tempo de execução das inserções da árvore binária foi de: " + secondsExecucaoArvore + " segundos");


        //Cálculo de tempo de impressão
        long inicioTempoExecucaoImpressaoArvore = System.nanoTime();
        arvore.inOrdem(arvore.raiz);
        long fimTempoExecucaoImpressaoArvore = System.nanoTime();
        long tempoExecucaoImpressaoArvore = fimTempoExecucaoImpressaoArvore - inicioTempoExecucaoImpressaoArvore;
        double secondsImpressaoArvore = (double) tempoExecucaoImpressaoArvore / 1000000000;
        System.out.println("O tempo de execução da indexação da árvore binária foi de: " + secondsImpressaoArvore + " segundos");


        System.out.println("----------------------------------------------------------------------------");


        // Tabela Hash
        //Cálculo de tempo de inserção
        long inicioExecucaoHash = System.nanoTime();
        for (int i = 0; i < tamanhoUsuario; i++){
            int valor = value.nextInt(999999999);
            tabelaHash.insere(valor, tamanhoUsuario);
        }
        long fimExecucaoHash = System.nanoTime();
        long tempoExecucaoHash = fimExecucaoHash - inicioExecucaoHash;
        double secondsExecucaoHash = (double) tempoExecucaoHash / 1000000000;
        System.out.println("O tempo de execução das inserções da tabela hash foi de: " + secondsExecucaoHash + " segundos");


        //Cálculo de tempo de impressão
        long inicioTempoExecucaoImpressaoTabela = System.nanoTime();
        tabelaHash.imprime();
        long fimTempoExecucaoImpressaoTabela = System.nanoTime();
        long tempoExecucaoImpressaoTabela = fimTempoExecucaoImpressaoTabela - inicioTempoExecucaoImpressaoTabela;
        double secondsImpressaoHash = (double) tempoExecucaoImpressaoTabela / 1000000000;
        System.out.println("O tempo de execução da indexação da tabela foi de: " + secondsImpressaoHash + " nanosegundos");


        entrada.close();

    }

    //Escreva uma função que solicita do usuário o tamanho do conjunto de dados utilizado nos experimentos;
    //Gere aleatoriamente um grande número de chaves (números inteiros grandes, ex: 462594038) e insira cada chave em
    //uma Árvore Binária de Busca (ABB) e em uma Tabela Hash (TH);
    //Calcule o tempo em segundos gasto por cada estrutura (ABB e TH) para armazenar todas as chaves;
    //Gere aleatoriamente um grande número de chaves e procure cada uma delas nas estruturas de Árvore Binária
    //de Busca (ABB) e Tabela Hash (TH) geradas anteriormente;
    //Calcule o tempo em segundos gasto por cada estrutura estruturas (ABB e TH) para recuperar todas as chaves;
    //Apresente para o usuário os tempos de indexação e recuperação de cada estrutura (TH) e (ABB) e a soma dos seus respectivos tempos.
    //A estratégia de armazenamento externo deve ser utilizada para tratamento de colisões. Não é permitido uso de TADs prontos do JAVA como HashMaps

}
