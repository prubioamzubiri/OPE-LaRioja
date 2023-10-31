import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static List<Integer> positivos;
    private static List<Integer> negativos;

    public static void main(String args[])
    {
        

        do{
            scanner = new Scanner(System.in);
            positivos = new ArrayList<Integer>();
            negativos = new ArrayList<Integer>();
            int ceros = 0;
            try{
            while(true)
            {              
                Integer opcion = scanner.nextInt();
                System.out.println("Opcion: " + opcion);
                if(opcion==0)
                {
                    ceros++;
                }
                else if(opcion>0)
                {
                    positivos.add(opcion);
                }
                else
                {
                    negativos.add(opcion);
                }
            }
        }
        catch(Exception e){
            //Limpiar Buffer
            scanner.nextLine();
        }

        System.out.println("Positivos: " + imprimirArray(positivos) + " Ceros:" + ceros + " Negativos: " + imprimirArray(negativos));
        }while(seguir().equals("si"));
    }

    public static String imprimirArray(List<Integer> lista)
    {
        String to_return = "(";

        for(int i=0; i< lista.size(); i++)
        {
            to_return += " " + lista.get(i);
            if(i != lista.size()-1)
            {
                to_return += ",";
            }
        }

        to_return += " )";

        return to_return;
    }

    public static String seguir()
    {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("¿Desea continuar? (si/no)");
        String respuesta = scanner2.nextLine().toLowerCase();
        //scanner2.close();
        return respuesta;

    }
}
