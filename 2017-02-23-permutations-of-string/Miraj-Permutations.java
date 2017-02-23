/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mshah
 */
public class Permutations {
    public static void main(String[] args) {
        String str = "ABC";
        Permutations pm = new Permutations();
        pm.permute(new String(), str);
    }
    
    void permute(String perm, String ip) {
        if(ip.length()==0) {
            System.out.println(perm);
        } else {
            for(int i=0;i<ip.length();i++) {
                permute(perm + ip.charAt(i), ip.substring(0, i) + ip.substring(i+1, ip.length()));
            }
        }
    }
    
}
