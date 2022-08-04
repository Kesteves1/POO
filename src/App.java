import java.util.function.Function;
import java.util.Scanner;

public class App {
    
    public static void clear(){ 

        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    } 

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

    static int[] invertArray(int[] array) {
        int[] aux = new int[array.length];

        for (int i=0; i<array.length; i++) {
            aux[i] = array[i];
        }
        int j = 5;
        for (int i = 0; i < 6; i++) {
            array[i] = aux[j];
            j--;
        }
        return array; 
    }
    /**
        01 - Escreva dois métodos em Java: o primeiro deve ser utilizado para preencher um vetor de 6 números inteiros a partir da entrada do usuário. O segundo deve inverter as posições dos números do vetor. Por exemplo, se o vetor original era 4-8-15-16-23-42, deve ficar 43-23-16-15-8-4 após a execução do segundo método. Escreva um
        programa que execute e teste os dois métodos.
        02 - Escreva um método que receba como parâmetro um vetor de inteiros e crie outro vetor, contendo a soma de cada par de vizinhos do vetor original. Por exemplo, se o vetor original era 4-8-15-16-23-42, o retorno deve ser um vetor 12-31-65 (ou seja, 4+8, 15+16 e 23+42). Caso o vetor tenha tamanho ímpar, o último número deve ser somado consigo mesmo. Para ler o vetor, pode aproveitar o método do exercício 02. Escreva um programa que execute e teste os métodos.
        Aplicados
        03 - Escreva um método que verifique se uma data é válida, a partir de um dado recebido do usuário no formato DD/MM/AAAA. Se a data for inválida, informe ao usuário onde está o erro.
        04 - Sabendo que 1º de janeiro de 2022 foi um sábado, escreva um método que receba uma data e diga em qual dia da semana esta data acontecerá em 2022. Escreva um programa principal para testar seu método.
        Uso de arquivos
        05 - Refaça o exercício 02, sendo que os dados serão lidos de um arquivo texto. O arquivo texto pode ter várias linhas e cada linha representa um vetor a ser utilizado pelo método. O separador usado é ponto e vírgula. Por exemplo:
        4;8;15;4;15;16;23;42
        7;11;13;17;29;23;29;31
        6;5;4;3;2;1
        06 - Refaça os exercícios 03 e 04, adicionando a capacidade de ler várias datas de um arquivo texto. Para cada data, diga se ela é válida e, caso seja, indique o dia da semana para cada uma delas considerando o ano de 2021. O arquivo conterá, em sua primeira linha, o número de datas das linhas seguintes. Por exemplo,
        4
        12/02/2013
        14/11/2019
        31/04/2020
        26/01/2021
        TEÓRICOS
        07 – O que é um método em um código de um sistema de informação?
        08 – Por que é aconselhável dividir sistemas em métodos separados uns dos outros?
        09 – Defina o que é um parâmetro utilizado em um método Java. Depois de definir, explique por que é importante termos parâmetros em métodos.
        10 – O que acontece com um dado passado por parâmetro para um método após a execução deste método?
        11 – Para cada situação abaixo, cite estruturas de dados que você utilizaria em sistemas de informação que precisam destes dados para resolver o problema. Observe o exemplo para dar suas respostas:
        EXEMPLO: Um praticante realiza uma série de exercícios em sua academia a cada dia da semana.
        RESP: Cada entidade praticante pode ter um vetor ou lista estática com os dias da semana (que é um dado conhecido e imutável). Cada dia da semana conterá uma fila de exercícios a serem feitos, assumindo que a ordem deles é importante.
        b) Uma oficina mecânica realiza diversos serviços em automóveis. Cada automóvel pode ter recebido muitos serviços ao longo de sua existência. Um automóvel está sempre associado a um proprietário, que pode ser pessoa física ou jurídica (empresa).
        c) Um candidato possui uma série de habilidades para se candidatar a vagas de emprego. Cada vaga tem suas habilidades específicas exigidas e deve possuir um conjunto de candidatos hábeis, destacando aquele que for mais adequado para a vaga no momento.
        d) Um posto de saúde atende a milhares de pacientes. O posto tem um calendário anual de vacinação e cada paciente possui um prontuário com as vacinas tomadas, incluindo seu nome, lote e data de aplicação.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        clear();
        int[] arry = createArray();

        for(int i=0; i < 6; i++) {
            System.out.println(arry[i]);
        }

        int[]array = invertArray(arry);
        System.out.println("Vetor invertido: ");
        for (int arr : array) {
            System.out.print(arr + ", ");
        }
    }
}
