package Ejercicio2021;

import java.util.Random;
import java.util.Scanner;

public class Main{

    public static Scanner scanner;
    
    public static void main(String[] args){
        
        char[] listaChars = new char[52];
        char[] listaInt = {'0','1','2','3','4','5','6','7','8','9'};
        char[] listaCharEspecial = {'!','@','#','$','%','&','*','+','-', '¡'};

        scanner = new Scanner(System.in);

        rellenarListaChar(listaChars);

        int opcion;
        
        while((opcion = menu()) != 4)
        {
            switch(opcion)
            {
                case 1:
                    imprimirCadena(listaChars);
                    imprimirCadena(listaCharEspecial);
                    imprimirCadena(listaInt);
                    break;
                case 2:
                    generarContraseña(listaChars, listaCharEspecial, listaInt, 5,0,3);
                    break;

                case 3:
                    generarContraseñaDificil(listaChars, listaCharEspecial, listaInt, 6,3,4);
                    break;
                default:
                    break;

            }
        }

    }

    public static void rellenarListaChar(char[] lista)
    {
        int index = 0;
        for(char i = 'a'; i <= 'z'; i++)
        {
            lista[index] = i;
            index++;
        }
        for(char i = 'A'; i <= 'Z'; i++)
        {
            lista[index] = i;
            index++;
        }
    }

    public static void imprimirCadena(char[] lista)
    {
        for(int i = 0; i < lista.length; i++)
        {
            System.out.print(lista[i]);
            if(i < lista.length - 1)
            {
                System.out.print(", ");
            }
            
        }

            System.out.print('.');
            System.out.print('\n');
    }

    public static void generarContraseña(char[] caracteres, char[] especiales, char[] numeros, int numCaracteres, int numeroEspeciales, int numNumeros)
    {
        int num = 0, car = 0, esp = 0;
        int end = numCaracteres + numNumeros + numeroEspeciales;

        char[] contrasena = new char[end];

        Random rnd = new Random();
        
        int index = 0;
        while(index < end)
        {
            int aleatorio = rnd.nextInt(3);
            if((aleatorio==0)&&(car<numCaracteres))
            {
                contrasena[index] = caracteres[rnd.nextInt(52)];
                car++;
                index++;                
            }
            if((aleatorio == 1) && (esp < numeroEspeciales))
            {
                contrasena[index] = especiales[rnd.nextInt(10)];
                esp++;
                index++;  
            }
            if((aleatorio == 2) && (num < numNumeros))
            {
                contrasena[index] = numeros[rnd.nextInt(10)];
                num++;
                index++;
            }
        }

        imprimirCadena(contrasena);
    }

        public static void generarContraseñaDificil(char[] caracteres, char[] especiales, char[] numeros, int numCaracteres, int numeroEspeciales, int numNumeros)
    {
        int num = 0, car = 0, esp = 1;
        int end = numCaracteres + numNumeros + numeroEspeciales;
        char valorAIntroducir;

        char[] contrasena = new char[end];

        Random rnd = new Random();
        
        int index = 1;

        contrasena[0] = especiales[rnd.nextInt(10)];

        while(index < end)
        {
            int aleatorio = rnd.nextInt(3);
            if((aleatorio==0)&&(car<numCaracteres))
            {
                

                if(car == 0)
                {
                    contrasena[index] = caracteres[rnd.nextInt(26)+26];
                }
                else
                {
                    valorAIntroducir = caracteres[rnd.nextInt(26)];

                    while(contains(contrasena,valorAIntroducir))
                    {
                        valorAIntroducir = caracteres[rnd.nextInt(26)];
                    }

                    contrasena[index] = valorAIntroducir;
                }

                car++;
                index++; 
               
            }
            if((aleatorio == 1)&&(esp < numeroEspeciales))
            {

                valorAIntroducir = especiales[rnd.nextInt(10)];

                while(contains(contrasena, valorAIntroducir))
                {
                    valorAIntroducir = especiales[rnd.nextInt(10)];
                }
                contrasena[index] = valorAIntroducir;
                esp++;
                index++;  
            }
            if((aleatorio==2) &&(num < numNumeros))
            {
                valorAIntroducir = numeros[rnd.nextInt(10)];

                while(contains(contrasena, valorAIntroducir))
                {
                    valorAIntroducir = numeros[rnd.nextInt(10)];
                }
                
                contrasena[index] = valorAIntroducir;
                num++;
                index++;
            }
        }

        imprimirCadena(contrasena);
    }

    public static boolean contains(char[] lista, char valor)
    {
        boolean to_return = false;
        int index = 0;
        while((!to_return)&&(index<lista.length))
        {
            if(lista[index]==valor)
            {
                to_return = true;
            }
            index++;
        }
        return to_return;
    }

    public static int menu(){

        System.out.println("1 Mostrar cadenas");
        System.out.println("2 Contrasena debil");
        System.out.println("3 Contrasena Fuerte");
        System.out.println("4 salir");

        return scanner.nextInt();
    }
}