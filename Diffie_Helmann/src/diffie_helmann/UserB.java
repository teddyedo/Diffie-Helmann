/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie_helmann;

import java.util.Random;

/**
 *
 * @author Allari Edoardo
 *
 * @version 1.0.0 - 19/01/2020
 *
 */
public class UserB {

    private String nome;
    private int chiaveCalcolata;
    private int esponenteCasuale;
    private int B;
    private int p;
    private int g;
    private int pseudoKeyA;

    
    
    public UserB(String nome) {
        this.nome = nome;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getChiaveCalcolata() {
        return chiaveCalcolata;
    }

    public void setChiaveCalcolata(int chiaveCalcolata) {
        this.chiaveCalcolata = chiaveCalcolata;
    }

    public int getEsponenteCasuale() {
        return esponenteCasuale;
    }

    public void setEsponenteCasuale(int esponenteCasuale) {
        this.esponenteCasuale = esponenteCasuale;
    }

    public int getB() {
        return B;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getPseudoKeyA() {
        return pseudoKeyA;
    }

    public void setPseudoKeyA(int pseudoKeyA) {
        this.pseudoKeyA = pseudoKeyA;
    }
    

    
    /**
     * This method generate a random int (from 1 to 10 for convenience), and set
     * it as esponenteCasuale (a or b in the teacher example)
     *
     * @return int esponenteCasuale, the exponent to use for the method
     * "calcolaModulo"
     */
    public int generaEsponenteCasuale() {

        Random r = new Random();
        this.esponenteCasuale = r.nextInt(10) + 1;

        return this.esponenteCasuale;
    }

    
    /**
     * This method calculate the "pseudo-key" that will be exchanged from the
     * users (A or B in the teacher example)
     *
     * @return int modulo, the "pseudo key".
     */
    public void calcolaModulo() {

        int modulo = (int) (Math.pow(this.getG(), this.generaEsponenteCasuale()) % this.getP());

        this.setB(modulo);
       
    }

    
    /**
     * This method simulates sending of pseudoKey (B) to userA
     * @param userA that will recieve B  
     */
    public void sendInfo(UserA userA) {

        this.calcolaModulo();
        userA.setPseudoKeyB(this.getB());

    }

    /**
     * This method calculate the key that also A has calculated, without any 
     * exchange of sensible information
     */
    public void calculateKey(){
        this.chiaveCalcolata = (int) (Math.pow(this.pseudoKeyA, this.esponenteCasuale) % this.getP());
    }

     
}