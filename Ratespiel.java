/**
 * Created by spoppe on 03.08.2016.
 */

import javax.swing.*;

public class Ratespiel {

    private int zahlenAbfrager(String inputText) {
        return Integer.parseInt(JOptionPane.showInputDialog(inputText));
    }

    int spielerAnzahl = zahlenAbfrager("Wie viele Spieler sollen mitspielen?");
    private Spieler[] teilnehmer = new Spieler[spielerAnzahl];

    public void starteSpiel() {

        int maxWert = zahlenAbfrager("Geben sie die höchste zu ratende Zahl ein.") + 1;
        double spielQuotient = spielerAnzahl / maxWert;
        int ziel = (int) (Math.random() * maxWert);

        for (int i = 0; i < teilnehmer.length; i++) {

            teilnehmer[i] = new Spieler();
            teilnehmer[i].setRichtig(false);
            teilnehmer[i].setName("Spieler " + (i + 1));
            teilnehmer[i].setMaxWert(maxWert);
        }

        System.out.println("Ich denke an eine Zahl zwischen 0 und ");

        while (!gibtEsEinenGewinner(teilnehmer)) {
            System.out.println("Die zu ratende Zahl ist " + ziel);

            for (Spieler spieler : teilnehmer) {
                spieler.raten();

                spieler.setRichtig(istDerTippKorrekt(spieler.getTipp(), ziel));
            }


            if (!gibtEsEinenGewinner(teilnehmer)) {
                System.out.println("Niemand hat Recht! Bitte noch einmal raten.");
            }
            System.out.println("");
        }

        int gewinnerZähler = 0;

        for (Spieler spieler : teilnehmer) {

            if (spieler.isRichtig()) {
                {
                    System.out.println(spieler.getName() + " hat die Zahl " + ziel + " richtig erraten!");
                }
                gewinnerZähler++;
            }

        }
        if (gewinnerZähler > 1)
            System.out.println("\nInsgesamt haben " + gewinnerZähler + " die Zahl " + ziel + " erraten!");
    }

    private boolean gibtEsEinenGewinner(Spieler[] teilnehmer) {
        boolean hatRecht = false;
        for (Spieler aTeilnehmer : teilnehmer) {
            if (aTeilnehmer.isRichtig()) {
                hatRecht = true;
                break;
            }
        }
        return hatRecht;
    }

    private boolean istDerTippKorrekt(int tipp, int ziel) {
        return tipp == ziel;
    }
}

