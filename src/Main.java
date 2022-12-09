import java.lang.*;
import java.lang.reflect.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Exercice 1
//        int targetNumber = 100;
//        int startNumber = 0;
//        boolean targetReached = false;
//
//        enumerateWhile(targetReached, startNumber, targetNumber);
//        enumerateFor();
//        enumerateEven();
//        //Exercice 2.1
//        int number = 30;
//        int smallerSuperiorSquare = getSmallerSquaredNum(number);
//        System.out.println("The smaller superior square of "+ number + " is: " + smallerSuperiorSquare);
//        //Exercice 2.2
//        int biggestInferiorSquare = getBiggestInferiorNum(number);
//        System.out.println("The biggest inferior square of "+ number + " is: " + biggestInferiorSquare);

        //Exercice 3
        //Exercice 3.1
        //ArrayList test = fibo(5);
        //System.out.println(test);
        //Exercice 3.2
        double epsilon = 0.00001;
        int[] aproxFibo = approximationFiboRevision(epsilon);
        System.out.println(Arrays.toString(aproxFibo));

//        //Exercice 4
//        //Exercice 4.1
//        printNames();
//        //Exercice 4.2
//        printNamesForEachLoop();
//        //Exercice 4.3
//        describe();
//        //Exercice 4.4
//        toUpperCase(); */
//
//        /* Exercice 5 */
//        decryptWeirdMessage();




    }

    public static void enumerateWhile(boolean targetReached, int startNumber, int targetNumber){
        whileLoop(targetReached, startNumber, targetNumber);
        isTargetReached(targetReached, startNumber, targetNumber);
    }

    public static void enumerateFor(){
        for(int i = 0; i <= 100; i++){
            System.out.println(i);
        }
    }

    public static void enumerateEven(){
        for (int i = 0; i <= 100; i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
    public static void whileLoop(boolean targetReached, int startNumber, int targetNumber){
        while(!targetReached){
            System.out.println(startNumber);
            startNumber++;
            if (startNumber == targetNumber){
                System.out.println(startNumber);
                targetReached = true;
            }
        }
    }
    public static void isTargetReached(boolean targetReached, int startNumber, int targetNumber){
        if (startNumber == targetNumber){
            System.out.println(startNumber);
            targetReached = true;
        }
    }
    public static int getSmallerSquaredNum(int n){
        boolean squareFound = false;
        while (!squareFound){
            double squareValOfn = Math.sqrt(n);
            if(Math.floor(squareValOfn) == squareValOfn){
                return n;
            } else {
                n++;
            }
        }
        return 0;
    }

    public static int getSmallerSquaredNum_fixed(int n){
        boolean squareFound = false;
        while (!squareFound){
            double squareValOfn = Math.sqrt(n);
            if(Math.floor(squareValOfn) == squareValOfn){
                squareFound = true;
            } else {
                n++;
            }
        }
        return n;
    }

    public static int getSmallerSquaredNum_demo(int n){
        boolean squareFound;
        do {
            double squareValOfn = Math.sqrt(n);
            if(Math.floor(squareValOfn) == squareValOfn){
                squareFound = true;
            } else {
                squareFound = false;
                n++;
            }
        } while (!squareFound);
        return 0;
    }


    public static int getBiggestInferiorNum(int n){
        boolean squareFound = false;
        while (!squareFound){
            double squareValOfn = Math.sqrt(n);
            if(Math.floor(squareValOfn) == squareValOfn){
                return n;
            } else {
                n--;
            }
        }
        return 0;
    }

    public static ArrayList<Integer> fibo(int listLength){
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);
        int n0;
        int n1;
        int addNum;
        for (int i = 1; i <= listLength; i++){
            n0 = fibonacciList.get(i - 1);
            n1 = fibonacciList.get(i);
            addNum = n0 + n1;
            fibonacciList.add(addNum);
        }
        return (fibonacciList);
    }

    public static ArrayList<Integer> fibo_demo(int listLength){
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);
        for (int i = 1; i <= listLength; i++){
            int num = fibonacciList.get(i - 1) + fibonacciList.get(i);
            fibonacciList.add( num );
        }
        return fibonacciList;
    }

    public static int[] approximationFibo(double epsilon){
        ArrayList fibonacciSuite = fibo(10);
        int lengthFibo = fibonacciSuite.size();
        System.out.println(lengthFibo);
        for (int i = 1; i < lengthFibo; i++){
            int a = (int) fibonacciSuite.get(i);
            for(int j = 2; j < lengthFibo; j++){
                int b = (int) fibonacciSuite.get(j);
                double delta = Math.abs((float)a/(float)b - (1+Math.sqrt(5)) / 2);
                if(delta  <= epsilon){
                    return new int[] {a, b};
                }
            }

        }
        return new int[0];
    }

    public static int[] approximationFiboRevision(double epsilon){
        //Building fibonacci suite

        ArrayList<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);
        fibonacciList.add(1);

        fibonacciList.addAll( Arrays.asList(0, 1, 1) );

        double error = 1;
        int a = 1;
        int b = 1;

        //Check if epsilon is reached and continue the fibonacci suite if not
        while (error > epsilon){
           a = fibonacciList.get( fibonacciList.size() - 1 );
           b = fibonacciList.get( fibonacciList.size() - 2 );
            error = Math.abs((float)b/(float)a - (1+Math.sqrt(5)) / 2);
            if(error  > epsilon){
                fibonacciList.add(a+b);
            }
        }
        return new int[] {a, b};
    }

    public static void printNames(){
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Jean");
        namesList.add("Ahmed");
        namesList.add("Lea");
        namesList.add("Blanca");
        for(int i = 0; i < namesList.size(); i++){
            String nameExtracted = namesList.get(i);
            System.out.println(namesList.get(i) + ": " +  nameExtracted.length());
        }
    }

    public static void printNamesForEachLoop(){
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Jean");
        namesList.add("Ahmed");
        namesList.add("Lea");
        namesList.add("Blanca");
        for(String name : namesList){
            System.out.println(name + ": " + name.length());
        }

    }

    public static void describe(){
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Jean");
        namesList.add("Ahmed");
        namesList.add("Lea");
        namesList.add("Blanca");
        for(String name : namesList){
            int nameLength = name.length();
            if (nameLength >= 4){
            System.out.println(name + ": " + nameLength);}
        }
    }

    public static void toUpperCase(){
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Jean");
        namesList.add("Ahmed");
        namesList.add("Lea");
        namesList.add("Blanca");
        for (String name : namesList){
            String nameUpperCase =  name.toUpperCase();
            System.out.println(nameUpperCase);
        }
    }
    public static void decryptWeirdMessage(){
        String encryptedMessage = "000T000000000000000000000000000000o0000u00000000000j0o0000000u0000000000r00s0000 c00o0000d00000e000000000000r000000000000000000 00000c0000000000o000m00000000000000m0e000 000000000s00i0000000000 0l000e00000000 g000000000000a00000000000000000r0s0000 000000000000000000000000000q00000u0000000000000000000000000i00000000 000f000i0ni00000r0000000a 000p00000a00000r0000000000000000000000000000000 m00000000000000a000in0t000000e00n000000000i00r0000000000000000 00000000000v00000000000o0000000t00r0000000e000000000 0c000o00d000000000e000000000 00e0000000000000000000000000000000000s0t0000000000000000000 0000000000000u0n00000 0000000000000000000000000000000ps00000000y000000000000000000c0h0000000op00000a0t0000h0e0 000000000000000v00000000000i00000000000000000000000000000000000000o0000l0000en00t 0000000q0u000000000i 00000000sa00000it00000 000où0000000000 000000v0000000o0000000000u000000000000000s000000000000000000 00000v00000000000000i00000000v0000000000000000000000000000e0000000000z0000000 00(000000c0i0000000000000000000ta0ti0o00000000n 000000d000000000000000000e00 00J000o00000000000000h0n00 0W00o000000000000o00000000000d0000000s0000000000)0";
        int lengthEncryptedMessage = encryptedMessage.length();
        String decryptedMessage = "";
        for (int i = 0; i < lengthEncryptedMessage; i++ ){
            char letter = encryptedMessage.charAt(i);
            if(letter != '0') {
                decryptedMessage += letter;
            }
        }
        System.out.println(decryptedMessage);
    }
}
