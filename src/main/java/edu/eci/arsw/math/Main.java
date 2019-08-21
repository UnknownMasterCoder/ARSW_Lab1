/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import java.util.Arrays;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws InterruptedException {
        
        System.out.println("Case 1:");
        ParallelCalculation T0 = new ParallelCalculation(1000000,500);
        T0.calculate();
        /*
        System.out.println("Case 2:\n");
        ParallelCalculation T1 = new ParallelCalculation(30,3);
        T1.calculate();
        */
        /*
        
        ThreadPi T0 = new ThreadPi("origy",0,10,2);
        T0.run();
        ThreadPi T1 = new ThreadPi("1",0,10,2);
        T1.run();
        */
        
        
        
        //System.out.println(bytesToHex(PiDigits.getDigits(0, 10)));
        
        
        
        //System.out.println(bytesToHex(PiDigits.getDigits(1, 100)));
        //System.out.println(bytesToHex(PiDigits.getDigits(1, 1000000)));
    }

    

}
