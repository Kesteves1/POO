import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Uso de arquivos 
 * 05 - Refaça o exercício 02, sendo que os dados serão lidos de um arquivo texto. O arquivo texto pode ter várias linhas 
 * e cada linha representa um vetor a ser utilizado pelo método. O separador usado é ponto e vírgula. Por exemplo: 
 * 
 *    4;8;15;4;15;16;23;42 
 *    7;11;13;17;29;23;29;31 
 *    6;5;4;3;2;1 
 */
public class EX05 {

      /**
     * Recebe um Vetor e soma ele com os seus vizinhos 
     * @param array
     * @return
     */
    static int[] sumNeighbors(int[] array) {
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
    static int[] changeInt(String[] array) {
        int[] arr = new int[array.length];
        for ( int i=0; i < array.length; i++) {
            arr[i] = Integer.parseInt(array[i]);
        }
        return arr;
    }
    static void viewer(int [] array) {
        System.out.print("A soma dos vizinhos são: ");
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println();
    }
    static void readFile(String path) throws Exception {
        
        Scanner arq = new Scanner(new FileReader(path));
        String valor, aux;
        int[] aux1;

        while (arq.hasNext()){
            valor = arq.next();
            String [] val = valor.split(";");
            aux1 = changeInt(val);
            viewer(sumNeighbors(aux1));
        }
    }
    public static void main(String[] args) throws Exception {
        readFile("arquivo05.txt");
    }
    
}
