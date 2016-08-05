/**
 * Created by spoppe on 03.08.2016.
 */
public class Spieler {
    private int tipp=0;
    private boolean richtig=false;
    private String name;
    private int maxWert=10;

    public void setMaxWert(int maxWert) {
        this.maxWert = maxWert;
    }



    public void raten() {
        tipp = (int) (Math.random() * maxWert);
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
