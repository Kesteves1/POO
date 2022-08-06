import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 02  -  Escreva  um  método  que  receba  como  parâmetro  um  vetor  de  inteiros  e  crie  outro  vetor,  contendo  a  soma  de 
 * cada par de vizinhos do vetor original. Por exemplo, se o vetor original era 4-8-15-16-23-42, o retorno deve ser um 
 * vetor 12-31-65 (ou seja, 4+8, 15+16 e 23+42). Caso o vetor tenha tamanho ímpar, o último número deve ser somado 
 * consigo mesmo. Para ler o vetor, pode aproveitar o método do exercício 02. Escreva um programa que execute e teste 
 * os métodos. 
 */
public class EX02 {
    /**
     * Limpa a tela
     */
    public static void clear() { 

        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    } 
    /**
     * Cria o vetor a partir dos valores inseridos pelo usuário
     * @return
     */
    static int[] createArray() {
        Scanner key = new Scanner(System.in);
        System.out.print("Informe o tamanho do seu vetor: ");
        int tamanho = key.nextInt();

        int[] arr = new int[tamanho];
        
        System.out.println("Informe os números para compor o seu vetor: ");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(( i + 1 ) + "º ");
            arr[i] = key.nextInt();
        }

        return arr;
    }
      /**
     * Recebe um Vetor e soma ele com os seus vizinhos 
     * @param array
     * @return
     */
    static int[] sumNeighbors(int[] array){
        int j = 0, tamanhoArr = array.length;

        if  (array.length % 2 == 0) { // <- É Par
            int[] soma = new int[tamanhoArr / 2];
            for (int i = 0; i < array.length; i += 2 ) {
                soma[j] = array[i] + array[i + 1];
                j++;
            }
            return soma;
        } else { // <- É Ímpar
            int[] soma = new int[(tamanhoArr / 2) + 1];
            for (int i = 0; i < tamanhoArr; i += 2) {
                if(i == tamanhoArr - 1) {
                    soma[j] = array[tamanhoArr - 1] * 2;
                    return soma;
                } else {
                    soma[j] = array[i] + array[i + 1];
                }
                    
                j++;
            }

            return soma;
        }
        
    }
    /**
     * Recebe como parametro o caminho do arquivo txt,
     * lê os valores do arquivo, passa para um vetor e 
     * retorna ele
     * @param path
     * @return
     * @throws Exception
     */
    static int[] readFile(String path) throws Exception {
        
        Scanner arq = new Scanner(new FileReader(path));
        String valor, aux;
        int[] val = new int[6];
        int i = 0;

        while (arq.hasNext()){
            valor = arq.next();
            StringTokenizer t = new StringTokenizer(valor, ";");
            aux = t.nextToken();
            val[i] = Integer.parseInt(aux);
            i++;
        }
        return val;
    }
    /**
     * Recebe como parametro um vetor de inteiro e 
     * exibe ele na tela
     * @param array
     */
    static void viewer(int[] array) {
        System.out.println();
        System.out.println("Vetor Pronto:");
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
    
    static void tester() throws Exception {
        System.out.println("Entrada pelo arquivo");
        viewer(sumNeighbors(readFile("./arquivo.txt")));
    }

    public static void main(String[] args) throws Exception {
        int[] soma;
        clear();

        int[] array = createArray();

        soma = sumNeighbors(array);

        tester();

        viewer(soma);
    }
}
