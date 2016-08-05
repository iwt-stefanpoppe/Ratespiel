/**
 * Created by spoppe on 03.08.2016.
 */
import javax.swing.*;

public class Ratespiel {

    private Spieler[] teilnehmer = new Spieler[Integer.parseInt(JOptionPane.showInputDialog("Wie viele Spieler sollen mitspielen?"))];

    public void starteSpiel() {

        for (int i = 0; i < teilnehmer.length; i++) {

            teilnehmer[i] = new Spieler();
            teilnehmer[i].setRichtig(false);
        }

        int ziel = (int) (Math.random() * 10);
        System.out.println("Ich denke an eine Zahl zwischen 0 und 9");

        while (!gibtEsEinenGewinner(teilnehmer)) {
            System.out.println("Die zu ratende Zahl ist " + ziel);

            for (int i = 0; i < teilnehmer.length; i++) {
                teilnehmer[i].raten();

                System.out.println("Spieler " + (i+1) + " tippt " + teilnehmer[i].getTipp());

                teilnehmer[i].setRichtig( istDerTippKorrekt(teilnehmer[i].getTipp(), ziel));
            }


            if (!gibtEsEinenGewinner(teilnehmer)) {
                System.out.println("Niemand hat Recht! Bitte noch einmal raten.");
            }
            System.out.println("");
        }
        int zaehler = 1;
        for (Spieler k : teilnehmer) {

            if(k.isRichtig()){
                System.out.println("Spieler " + ( zaehler ) + " hat die Zahl " + ziel + " richtig erraten!");}
            zaehler++;

        }
    }

    private boolean gibtEsEinenGewinner(Spieler[] teilnehmer) {
        boolean hatRecht = false;
        for (Spieler aTeilnehmer : teilnehmer) {if (aTeilnehmer.isRichtig()) {return hatRecht = true;}}
        return hatRecht;
    }

    private boolean istDerTippKorrekt(int tipp,int ziel){
        return tipp==ziel;
    }
}

