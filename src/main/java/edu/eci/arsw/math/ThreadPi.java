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
public class ThreadPi extends Thread{
    private final int A;
    private final int B;
    private final int width;
    private String res;

    public ThreadPi(String name, int in, int out, int w){//, int hilos) {
        this.A = in;
        this.B = out;
        this.width = w;
        this.res = "";
        //this.N = hilos;
    }
    @Override
    public void run() {
        byte[] digits;
        digits = PiDigits.getDigits(A, B, width);
        res = ParallelCalculation.bytesToHex(digits);
    }
    public String getValue() {
        return res;
    }
}