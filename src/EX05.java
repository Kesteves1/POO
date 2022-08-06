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
    static int[] readFile(String path) throws Exception {
        String valor;
        int cont = 0;
        Scanner arq = new Scanner(new FileReader(path));
        while (arq.hasNext()){
            cont++;
        }

        while (arq.hasNext()){
            
        }
        return [];
    }
    public static void main(String[] args) throws Exception {
        readFile("arquivo05.txt");
    }
    
}
