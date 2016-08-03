/**
 * Created by spoppe on 03.08.2016.
 */
public class Ratespiel {

    Spieler[] teilnehmer = new Spieler[3];


    Spieler s1;
    Spieler s2;
    Spieler s3;

    public void starteSpiel() {
        s1 = new Spieler();
        s2 = new Spieler();
        s3 = new Spieler();

        boolean s1true = false;
        boolean s2true = false;
        boolean s3true = false;

        int ziel = (int) (Math.random() * 10);
        System.out.println("Ich denke an eine Zahl zwischen 0 und 9");

        while (!gibtEsEinenGewinner(s1true, s2true, s3true)) {
            System.out.println("Die zu ratende Zahl ist " + ziel);

            s1.raten();
            s2.raten();
            s3.raten();

            System.out.println("Spieler eins tippt " + s1.tipp);

            System.out.println("Spieler zwei tippt " + s2.tipp);

            System.out.println("Spieler drei tippt " + s3.tipp);

            s1true= istDerTippKorrekt(s1.tipp,ziel);
            s2true= istDerTippKorrekt(s2.tipp,ziel);
            s3true= istDerTippKorrekt(s3.tipp,ziel);


            if (!gibtEsEinenGewinner(s1true, s2true, s3true)) {
                System.out.println("Niemand hat Recht! Bitte noch einmal raten.");
            }
        }

        System.out.println("Ist Spieler 1 der gewinner ? "+ s1true);
        System.out.println("Ist Spieler 2 der gewinner ? "+ s2true);
        System.out.println("Ist Spieler 3 der gewinner ? "+ s3true);

    }

    private boolean gibtEsEinenGewinner(boolean s1true, boolean s2true, boolean s3true) {
        return s1true || s2true || s3true;
    }

    private boolean istDerTippKorrekt(int tipp,int ziel){
        return tipp==ziel;
    }
}

