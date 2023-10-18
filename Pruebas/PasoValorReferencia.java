package Pruebas;

public class PasoValorReferencia {

    public static void main(String[] args)
    {
        //paso valor
        int j = 0;
        paso(j); // j++
        System.out.println(j); // muestra 0

        //paso referencia
        int[] k = {1,2};
        pasoArray(k); // k[0]++
        System.out.println(k[0]); //muestra 2

        //paso referencia
        Algo algo = new Algo(); //empieza en 2
        pasoObjeto(algo); //suma 1 al atributo
        System.out.println(algo.getNumero()); // devuelve 3

    }

    public static void paso(int a)
    {
        a++;
    }

    public static void pasoArray(int[] b)
    {
        b[0]++;
    }

    public static void pasoObjeto(Algo al)
    {
        al.sumar();
    }
    
}
