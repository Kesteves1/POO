import java.util.Scanner;

/**
 * Aplicados 
 * 03 - Escreva  um  método  que  verifique  se  uma  data  é  válida,  a  partir  de  um  dado  recebido  do  usuário  no  formato 
 * DD/MM/AAAA. Se a data for inválida, informe ao usuário onde está o erro.  
 */
public class EX03 {
    /**
     * Limpa a tela
     */
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

    public static void main(String[] args) throws Exception {
        Scanner key = new Scanner(System.in);
        String result;
        clear();

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
            
    }
}
