/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author ykretov
 */

public class MyTimer {
    private final String label;
    private final long start_time;
    private long elapsed_time;

    public MyTimer(String label) {
        start_time = System.currentTimeMillis();
        this.label = label;
    }

    public void timeit() {
        elapsed_time = System.currentTimeMillis() - start_time;
        String str = label + ": Time elapsed: " + elapsed_time/1000.0 + "sec";
        System.out.println(str);
    }
}
