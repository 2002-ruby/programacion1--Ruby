import java.util.*;

public class Assigned8 {
    public static void main(String[] args) throws Exception {
       String input = "Según un estudio de una universidad inglesa, no importa el orden en el que las letras están escritas, la única cosa importante es que la primera y última letra estén escritas en la posición correcta. El resto pueden estar totalmente mal y aún podrás leerlo sin problemas. Esto es porque no leemos cada letra por sí misma. sino la palabra como un todo. Personalmente me parece increíble.";

       String temp[] = input.split(" ");
       String output = "";

       for(int i=0; i<temp.length; i++) {
        if(i==0){
            output = changeWord(temp[i]);
        }
        else{
            output += " " + changeWord(temp[i]);
        }
       }
       System.out.println(output);
    }

    public static String changeWord(String palabra){  
        //    '\u0000' caracter vacio sera el valor inicial de puntuatoion
        char aux, puntuation = '\u0000';
        Random random = new Random();
        //cual sera el index para el intercambio
        int index_change = 1;
        //verificamos si la palabra tiene un caracter , o .
        if (palabra.contains(",") || palabra.contains(".")){
            puntuation = palabra.charAt(palabra.length() - 1);
            palabra = palabra.substring(0, palabra.length()-1);
        }
        char [] msj = palabra.toCharArray();
        int max_int = msj.length - 3;
        
        for (int i = 1; i < msj.length -1 ; i++) {
            aux= msj[i];
            index_change = random.nextInt(max_int + 1) + 1;
            msj[i] = msj[index_change];
            msj[index_change] = aux;
        }
        String result = String.valueOf(msj);
        return result + puntuation;
    }
}