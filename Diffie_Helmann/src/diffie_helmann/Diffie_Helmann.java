/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie_helmann;

/**
 *
 * @author Allari Edoardo
 * 
 * @version 1.0.0 - 19/01/2020
 * 
 */

public class Diffie_Helmann {

    public static void main(String[] args) {
        
        //Instance of our 2 users, A and B
        UserA A = new UserA("Alice");
        UserB B = new UserB("Bob");
        
        //User A calculate his pseudoKey and send it to B
        A.sendInfo(B);
        
        //User B calculate his pseudoKey and send it to A
        B.sendInfo(A);
        
        //User A and B calculate the key
        A.calculateKey();
        B.calculateKey();
        
        System.out.println("La chiave di " + A.getNome() + " é " + A.getChiaveCalcolata());
        System.out.println("La chiave di " + B.getNome() + " é " + B.getChiaveCalcolata());
        
        
    }
    
}
