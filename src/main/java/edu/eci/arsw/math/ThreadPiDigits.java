/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

/**
 *
 * @author 2101770
 */
public class ThreadPiDigits extends Thread{
    private final int A;
    private final int B;
    private final int N;
    private Thread t;
    private final String threadName;

    public ThreadPiDigits(String name, int in, int out, int hilos) {
        this.threadName = name;
        this.A = in;
        this.B = out;
        this.N = hilos;
    }

    @Override
    public void run() {
        byte[] digits;
        String res;
        digits = PiDigits.getDigits(A, B, N);
        res = Main.bytesToHex(digits);
        System.out.println("threadName: "+threadName+ "res: "+res+"\n");

    }
}
