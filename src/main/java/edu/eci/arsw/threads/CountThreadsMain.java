/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThreadsMain {
    
    public static void main(String a[]) {
        CountThread T1 = new CountThread("1",0,99);
        T1.start();
        //T1.run();

        CountThread T2 = new CountThread("2",100,199);
        T2.start();
        //T2.run();
        
        CountThread T3 = new CountThread("3",200,299);
        T3.start();
        //T3.run();

    }
    
}
