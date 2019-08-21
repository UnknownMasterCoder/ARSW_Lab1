/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;
/**
 *
 * @author 2099190
 */
public class ParallelCalculation {
    
    private final int digitsNumber;
    private final int threadsNumber;
    private double width;
    private final int[] array;
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public ParallelCalculation(int digits, int N) {
        this.digitsNumber = digits;
        this.threadsNumber = N;
        this.array = new int[N];
        //calcular tamaño cada hilo
        int div = digits / N;
        int mod = digits % N;
        int suma = div;
        for(int i = 0; i < N ; i++){
            if(i+1 == N){
                this.array[i]=suma+mod;
            }else{
                this.array[i]=suma;
            }
        }
    }
    
    public String calculate() throws InterruptedException{
        
        ThreadPi threads[] = new ThreadPi[threadsNumber];
        width = 1.0 / (double) digitsNumber;
        int[] intArray = new int[] {3,3,4};
        for (int i=0; i < threadsNumber; i++){
            long start =  i * digitsNumber/threadsNumber;
            long count =   digitsNumber/threadsNumber;
            //int end = (i+1) * (digitsNumber/threadsNumber);
            threads[i] = new ThreadPi(Integer.toString(i), (int)start, (int)this.array[i]);
            threads[i].start();
        }
        
        //Join all the threads
       
        String res = "";
        for (int i = 0; i < threadsNumber; i++) {
            threads[i].join();
            res += threads[i].getValue();
        }
       
        System.out.println("\nRes: "+res+"\n");
        return res;
    }
    
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            //sb.append(hexChars[i]);
            sb.append(hexChars[i+1]);            
        }
        return sb.toString();
    }
}
