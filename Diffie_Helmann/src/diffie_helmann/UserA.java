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
public class UserA {

    private String nome;
    private int chiaveCalcolata;
    private int esponenteCasuale;
    private int A;
    private int p;
    private int g;
    private int pseudoKeyB;

    public UserA(String nome) {
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

    public int getA() {
        return A;
    }

    public void setA(int A) {
        this.A = A;
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

    public int getPseudoKeyB() {
        return pseudoKeyB;
    }

    public void setPseudoKeyB(int pseudoKeyB) {
        this.pseudoKeyB = pseudoKeyB;
    }
    
    

    /**
     * generate a random number (p in the teacher example)
     *
     * @return int p
     */
    public int generaG() {

        Random r = new Random();
        this.g = r.nextInt(10) + 1;

        return this.g;
    }

    /**
     * Generate a random prime number (p in the teacher example)
     *
     * @return int p
     */
    public int generaP() {

        boolean find = false;
        int number = 0;

        while (!find) {

            Random r = new Random();
            number = r.nextInt(100) + 1;

            //Check if the number selected is a prime number
            for (int i = 2; i < number; i++) {

                //if the module of the division between number and i is 0, number
                //isn't a prime number
                if (number % i == 0) {
                    find = false;
                } //if also the last number of the loop give a module different from 
                //0, it means that number is a prime number.
                else if (number % i != 0 && i == number - 1) {
                    find = true;
                }
            }

            this.p = number;
        }

        return this.p;
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

        int modulo = (int) (Math.pow(this.generaG(), this.generaEsponenteCasuale()) % this.generaP());
        
        this.setA(modulo);
        
    }

    /**
     * //This method simulates sending of g,p and pseudoKey (A) to userB
     * @param userB the user that will recieve g, p and A
     */
    public void sendInfo(UserB userB) {

        this.calcolaModulo();
        
        userB.setG(this.getG());
        userB.setP(this.getP());
        userB.setPseudoKeyA(this.getA());

    }

    /**
     * This method calculate the key that also A has calculated, without any 
     * exchange of sensible information
     */
    public void calculateKey(){
        this.chiaveCalcolata = (int) (Math.pow(this.pseudoKeyB, this.esponenteCasuale) % this.getP());
    }
    
}
