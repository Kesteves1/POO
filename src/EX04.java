import java.time.Year;
import java.util.Scanner;

/**
 * 04 - Sabendo que 1º de janeiro de 2022 foi um sábado, escreva um método que receba uma data e diga em qual dia 
 * da semana esta data acontecerá em 2022. Escreva um programa principal para testar seu método. 
 */
public class EX04 {
    /**
     * Limpa a tela
     */
    public static void clear() { 

        System.out.print("\033[H\033[2J"); 
        System.out.flush(); 
    } 
    /**
     * Checa se o ano é bissexto
     * @param year
     * @return
     */
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
                return "Sábado";
                    
                case 2: 
                return "Domingo";

                case 3:
                return "Segunda-feira";

                case 4:
                return "Terça-feira";

                case 5:
                return "Quarta-feira";

                case 6:
                return "Quinta-feira";

                case 7: 
                return "Sexta-feira";
            }
        }

        days -= 7;
        return discoverDay(days);

    }
    static int calculateDays(int day, int month, boolean bissexto) {
        int days = -1;
        if(month == 1)
            return day;
        if(month == 2)
            return day + 31; // janeiro + dias
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
        if(bissexto)
            days++;
        
        return days;
    }
    public static void main(String[] args) throws Exception {
        Scanner key = new Scanner(System.in);
        boolean bissexto;
        int days;
        clear();

        System.out.print("Informe o número do dia: ");
        int day = key.nextInt();
        
        System.out.print("Informe o número do mês: ");
        int month = key.nextInt();

        System.out.print("Informe o número do ano com 4 dígitos: ");
        int year = key.nextInt();

        bissexto = checkYear(year);
        days = calculateDays(day, month, bissexto);

        System.out.println();
        System.out.println("O dia " + day + "/" + month + "/" + year + " é " + discoverDay(days)); 
    }
    
}
