// args[0] = "1,2,3,4" ceva de genul

public class ExercitiuVectori {

    static void afisare(String mesaj, int[] vector) {
        System.out.print(mesaj + ": ");

        for(int numar: vector){
            System.out.print(numar + ", ");
        }
        System.out.println();
    }

    static int[] adaugareInceput(int[] vector, int numar) {
        int[] vectorNou = new int[vector.length + 1];
        //var vectorNou = ....  functioneaza si asa

        vectorNou[0] = numar;
//        for(int i = 0; i < vector.length; i++) {
//            vectorNou[i + 1] = vector[i];
//        }  ori asa ori asa:
        System.arraycopy(vector, 0, vectorNou, 1, vector.length); //ba ce doamne iarta-ma

        return vectorNou;
    }

    public static void main(String[] args) {//asta e entry pointul pt proiect ca sa poata fi rulat individual

        String[] valoriString = args[0].split(",");

        int[] valoriInt = new int[valoriString.length];

        for(int i = 0; i < valoriInt.length; i++)
            valoriInt[i] = Integer.parseInt(valoriString[i].trim());

        afisare("Vector", valoriInt);

        valoriInt = adaugareInceput(valoriInt, 67);

        afisare("Vector nou", valoriInt);
    }
}
