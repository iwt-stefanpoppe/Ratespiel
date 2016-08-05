/**
 * Created by spoppe on 03.08.2016.
 */
public class Spieler {
    private int tipp=0;
    private boolean richtig=false;

    public void raten() {
        tipp = (int) (Math.random() * 10);
        System.out.println("Ich tippe auf die Zahl: " + tipp);
    }

    public int getTipp(){
        return tipp;
    }

    public void setTipp(int rateZahl){
        tipp=rateZahl;
    }

    public boolean isRichtig(){
        return richtig;
    }

    public void setRichtig(boolean übereinstimmung){
        richtig=übereinstimmung;
    }


}
