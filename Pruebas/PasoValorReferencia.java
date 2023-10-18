package Pruebas;

public class PasoValorReferencia {

    public static void main(String[] args)
    {
        //paso valor
        int j = 0;
        paso(j); // j++
        System.out.println(j); // muestra 0

        //paso referencia
        int[] k = {1,4};
        pasoArray(k); // k[0]++
        System.out.println(k[0]); //muestra 2

        //paso referencia (atributo)
        Algo algo = new Algo(); //empieza en 2
        pasoObjeto(algo); //suma 1 al atributo mediante un método del objeto
        System.out.println(algo.getNumero()); // devuelve 3

        //Paso valor
        pasoTodoObjeto(algo); //new Algo
        System.out.println(algo.getNumero()); //devuelve 3 (el viejo algo)



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

    public static void pasoTodoObjeto(Algo al)
    {
        al = new Algo();
    }
    
}
