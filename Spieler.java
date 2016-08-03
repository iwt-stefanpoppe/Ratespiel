/**
 * Created by spoppe on 03.08.2016.
 */
public class Spieler {
    int tipp=0;
    boolean richtig=false;

    public void raten() {
        tipp = (int) (Math.random() * 10);
        System.out.println("Ich tippe auf die Zahl: " + tipp);
    }
}
