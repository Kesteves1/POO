import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 06 - Refaça os exercícios 03 e 04, adicionando a capacidade de ler várias datas  de um arquivo texto. Para  cada data, 
 * diga se ela é válida e, caso seja, indique o dia da semana para cada uma delas considerando o ano de 2021. O arquivo 
 * conterá, em sua primeira linha, o número de datas das linhas seguintes. Por exemplo, 
 * 
 * 4 
 * 12/02/2013 
 * 14/11/2019 
 * 31/04/2020 
 * 26/01/2021 
 */
public class EX06 {
    public static void clear() { 

        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    } 
    static String dateCheck(int day, int month, int year){
        boolean bissexto;
        if(day < 1 || day > 31)
            return "dia";
        if(month < 1 || month > 12)
            return "mês";
        if(year < 0)
            return "ano";

        if(year % 4 == 0) 
            bissexto = true;
         else 
            bissexto = false;

        if(month == 2 && bissexto == false && day > 28)
            return "O ano não é bissexto, portanto fevereiro só tem 28 dias";

        else if(month == 2 && bissexto && day <= 29)
            return "ok";

        if(month == 2 || month == 4 || month == 6 || month == 9 || month == 10 )
            if(day > 30)
                return "O dia do mês informado está incorreto";
        
        return "ok";
    }

    static boolean checkYear(int year) {
        if(year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static String discoverDay(int days) {
       
            if (days - 7 < 1) {                 
                switch(days) {
                    case 1:
                    return "Sexta-feira";
                        
                    case 2: 
                    
                    return "Sábado";
    
                    case 3:
                    return "Domingo";
    
                    case 4:
                    return "Segunda-feira";
    
                    case 5:
                    return "Terça-feira";
    
                    case 6:
                    return "Quarta-feira";
    
                    case 7:
                    return "Quinta-feira"; 
                }

            } 
       
        
        days -= 7;
        return discoverDay(days);

    }

    static int calculateDays(int day, int month, int year) {
        int days = -1;
        if(month == 1)
            days = day;
        if(month == 2)
            days = day + 31; // janeiro + dias
        if(month == 3)
            days = day + 59;// fevereiro + dias
        if(month == 4)
            days = day + 90;// março + dias
        if(month == 5)
            days = day + 120;// abriu + dias
        if(month == 6)
            days = day + 151;// maio + dias
        if(month == 7)
            days = day + 181;// junho + dias
        if(month == 8)
            days = day + 212;// julho + dias
        if(month == 9)
            days = day + 243;// agosto + dias
        if(month == 10)
            days = day + 273;// setembro + dias
        if(month == 11)
            days = day + 304;// outubro + dias
        if(month == 12)
            days = day + 334;// novembro + dias
        if(checkYear(year))
            days++;
        if(year == 2021) {
            return days;

        } else if (year > 2021) {
            int aux = year - 2021;
            if(aux > 7) {
                while(aux > 7){
                    if(aux - 4 > 0)
                    days++;
                    aux-= 7;
                }
            }
            days += aux;
            return days;
        } else if (year < 2021) {
            int aux = 2021 - year;
            if(aux > 7){
                while(aux > 7){
                    if(aux - 4 > 0)
                    days++;
                    aux-= 7;
                }
            }
            days -= aux;
            return days;
        }
        
        return days;
    }

    static String readFile() throws Exception {
        Scanner arq = new Scanner(new FileReader("./arquivo06.txt"));
        int numDate = Integer.parseInt(arq.next()), days;
        String aux, result;
        
        for(int i=0; i<numDate; i++) {
            
            aux = arq.next();
            StringTokenizer t = new StringTokenizer(aux, "/");
            int day = Integer.parseInt(t.nextToken());
            int month = Integer.parseInt(t.nextToken());
            int year = Integer.parseInt(t.nextToken());
            result = dateCheck(day, month, year);

            if(result.equals("ok")){
                
                days = calculateDays(day, month, year);
                System.out.println("A data " + day + "/" + month + "/" + year + " é válida e o dia é " + discoverDay(days));
            } else {
                System.out.println("A data " + day + "/" + month + "/" + year + " é inválida. Erro: '" + result + "'");
            }
        }
        return "";
    }
    public static void main(String[] args) throws Exception {
        Scanner key = new Scanner(System.in);
        int option;
        String result;
        clear();

        System.out.println("Escolha uma opção");
        System.out.println("1º Entrada pelo teclado:");
        System.out.println("2º Entrada por arquivo: ");
        option = key.nextInt();

        switch(option) {
            case 1:
            System.out.print("Informe o número do dia: ");
            int day = key.nextInt();
            
            System.out.print("Informe o número do mês: ");
            int month = key.nextInt();

            System.out.print("Informe o número do ano com 4 dígitos: ");
            int year = key.nextInt();

            result = dateCheck(day, month, year);
            if(result.equals("ok")){
                System.out.println("A data " + day + "/" + month + "/" + year + " é válida");
                if(day < 10)
                    System.out.println("A data 0" + day + "/" + month + "/" + year + " é válida");
            } else {
                System.out.println("A data " + day + "/" + month + "/" + year + " é inválida. Erro: '" + result + "'");
            }

            break;
            
            case 2:
                readFile();
            break;
        }
        
    }
}
