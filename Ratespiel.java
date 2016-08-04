/**
 * Created by spoppe on 03.08.2016.
 */
public class Ratespiel {

    Spieler[] teilnehmer = new Spieler[3];

    public void starteSpiel() {

        for (int i = 0; i < teilnehmer.length; i++) {

            teilnehmer[i] = new Spieler();
            teilnehmer[i].richtig = false;
        }

        int ziel = (int) (Math.random() * 10);
        System.out.println("Ich denke an eine Zahl zwischen 0 und 9");

        while (!gibtEsEinenGewinner(teilnehmer)) {
            System.out.println("Die zu ratende Zahl ist " + ziel);

            for (int i = 0; i < teilnehmer.length; i++) {
                teilnehmer[i].raten();

                System.out.println("Spieler " + (i+1) + " tippt " + teilnehmer[i].tipp);

                teilnehmer[i].richtig = istDerTippKorrekt(teilnehmer[i].tipp, ziel);
            }


            if (!gibtEsEinenGewinner(teilnehmer)) {
                System.out.println("Niemand hat Recht! Bitte noch einmal raten.");
            }
        }
        int zaehler = 1;
        for (Spieler k : teilnehmer) {


            System.out.println("Ist Spieler " + ( zaehler ) + " der Gewinner ? " + k.richtig);
            zaehler++;

        }
    }

    private boolean gibtEsEinenGewinner(Spieler[] teilnehmer) {
        boolean hatRecht = false;

        for (Spieler aTeilnehmer : teilnehmer) {

            if (aTeilnehmer.richtig) {
                return hatRecht = true;
            }


        }
        return hatRecht;
    }

    private boolean istDerTippKorrekt(int tipp,int ziel){
        return tipp==ziel;
    }
}

