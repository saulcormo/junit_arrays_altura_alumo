package org.iesvdm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;



public class AlturaAlumnoTest {
     @Test
void verdader(){
    assertTrue( 1==1);

}


@Test
void aniadenombreTest1(){
         final String[] array = new String [2];

     array[0] = "Jose";
    array[1] = "Paco";
    String nombre="Maria";

    String[] ArrayActual = AlturaAlumno.aniadeNombre(array, nombre);
    assertTrue(nombre != null && ArrayActual[ArrayActual.length-1].equals(nombre));
     for (int i = 1; i > ArrayActual.length; i++)
         assertEquals(array[i], ArrayActual[i]);



     }


    @Test
    void aniadenombreTest2(){
        final String[] array = new String [10];

        int longInicial = array.length;

        String nombre="Maria";
        String[] ArrayActual = AlturaAlumno.aniadeNombre(array, nombre);
        assertEquals(longInicial+1, ArrayActual.length);
        assertEquals( nombre, ArrayActual[ArrayActual.length-1]);


    }

    @Test
    void modificaAltura(){

    //when (cuando)
        double[] array = {1.6, 1.7, 1.8};
        double[] array2 = Arrays.copyOf(array, array.length);
        int posicion = 1;
        double altura = 1.9;

        //Do (hacer)
        AlturaAlumno.modificaAltura(array,posicion,altura);


            //Then (Entonces)
            assertTrue(altura==array[posicion]);;

            //Todos los demas elementos del array no cambian
            for (int i=0; i< array.length;i++)
                if(i!=posicion){
                    assertEquals(array[i], array2[i]);
                }
    }
    @Test
    public void buscaNombreTestEncontrado() {

         //When (cuando)
        String[] array = {"Juan", "Ana", "Luis"};
        String nombre= "Ana";

            //Do (hacer
            //Then (entonces)
                assertEquals(1,AlturaAlumno.buscaNombre(array,nombre));

    }
    @Test
    public void buscaNombreTestNoEncontrado() {

        //When (cuando)
        String[] array = {"Juan", "Ana", "Luis"};
        String nombre= "Saul";

        //Do (hacer
        //Then (entonces)
        assertEquals(-1,AlturaAlumno.buscaNombre(array,nombre));

    }
    @Test
    public void buscaNombreTestArrayvacio() {

        //When (cuando)
        String[] array = {"Juan", "Ana", "Luis"};
        String nombre= "";

        //Do (hacer
        //Then (entonces)
        assertEquals(-1,AlturaAlumno.buscaNombre(array,nombre));
        assertEquals(-11,AlturaAlumno.buscaNombre(array,nombre));

    }
    @Test
    public void motrarCorrecto(){

        //When (Cuando)
        String[] array= {"Ana", "Juan", "Saul"};
        double[] altura={1.9,1.5,1.3};

        //Do(hacer) Then(Entonces
       assertDoesNotThrow(() ->{
           AlturaAlumno.mostrar(array,altura);
       });
    }

    @Test
    public void motrarFallo(){

         //When (Cuando)
         String[] array= {"Ana", "Juan", "Saul"};
         double[] altura={1.9,1.5,1.3};

            //Do(hacer) Then(Entonces
            assertThrows(ArrayIndexOutOfBoundsException.class,()->
            {AlturaAlumno.mostrar(array, altura);
            }
            );

    }

    @Test
    public void calculaMAX(){

         //WHEN(cuando)
        double[] array = {19.5,18.5,20.5};
        double  ResultadoMax = 20.5;

        //Do(hacer)
        double[] resultado=AlturaAlumno.calculaMaximo(array);

        //THEN(entonces)
         assertEquals(2,resultado[0]);
         assertEquals(20.5,resultado[1]);
    }

    @Test
    public void calcularMAXVacio(){
        double[] array = {0.0, -1, -5};
        double resultadoMax=0;

        double[] resultado=AlturaAlumno.calculaMaximo(array);

        assertEquals(0.0, resultado[0]);
        assertEquals(0.0, resultado[1]);

    }


    @Test
    public void calculaMedia(){
         double[] array= {1,2,3};
         double mediat=2;

         double mediaactual= AlturaAlumno.calculaMedia(array);

         assertEquals(2,mediaactual);
    }

    

}
