import java.util.function.Function;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 01  -  Escreva  dois  métodos  em  Java:  o  primeiro  deve  ser  utilizado  para  preencher  um  vetor  de  6  números  inteiros  a 
 * partir  da  entrada  do  usuário.  O  segundo  deve  inverter  as  posições  dos  números  do  vetor.  Por  exemplo,  se  o  vetor 
 * original  era  4-8-15-16-23-42,  deve  ficar  42-23-16-15-8-4  após  a  execução  do  segundo  método.  Escreva  um 
 * programa que execute e teste os dois métodos. 
 */
public class EX01 {

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
    static int[] createArray(){
        int[] arr = new int[6];
        Scanner key = new Scanner(System.in);
        System.out.println("Informe 6 números para compor o seu vetor: ");

        for (int i=0; i<6; i++) {
            System.out.print(( i + 1 ) + "º ");
            arr[i] = key.nextInt();
        }

        return arr;
    }
    /**
     * Recebe como parâmetro um vetor e inverte ele retornando em formato de pilha
     * @param array
     * @return
     */
    static Stack invertArray(int[] array) {
        Stack pilha = new Stack(); 

        for (int i : array) {
            pilha.push(i);
        }

        return pilha; 
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
     * Recebe como parametro uma pilha e exibe
     * ela desempilhando-a
     * @param pilha
     */
     static void viewer(Stack pilha){
        for (int i=0; i<6; i++) {
            if(i == 5)
                System.out.println(pilha.pop());
            else
                System.out.print(pilha.pop() + ", ");
        }
    }
    /**
     * 01 - Escreva dois métodos em Java: o primeiro deve ser utilizado para preencher um vetor de 6 números inteiros a partir da entrada do usuário. O segundo deve inverter as posições dos números do vetor. Por exemplo, se o vetor original era 4-8-15-16-23-42, deve ficar 43-23-16-15-8-4 após a execução do segundo método. Escreva um
     *  programa que execute e teste os dois métodos.
     *  
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        clear();
        String path = "./arquivo.txt";
        int[] arry = createArray();

        //Entrada pelo Usuário
        System.out.println("Entrada pelo Usuário -> Vetor invertido: ");
        viewer(invertArray(arry));

        System.out.println();

        System.out.println("Entrada por arquivo -> Vetor invertido: ");
        //Entrada por arquivo
        viewer(invertArray(readFile(path)));
    }
}
