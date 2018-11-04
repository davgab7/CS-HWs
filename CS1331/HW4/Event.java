//I worked on the homework assignment alone, using only course materials.

import java.util.Random;

public class Event {

    private Athlete[] competitors;
    private Athlete goldMedalist;
    private Athlete silverMedalist;
    private Athlete bronzeMedalist;
    private boolean eventPlayed;


    public Event(Athlete[] competitors) {

        this.competitors = new Athlete[competitors.length];
        for (int i = 0; i < this.competitors.length; i++) {
            this.competitors[i] = competitors[i];
        }

        this.goldMedalist = null;
        this.silverMedalist = null;
        this.bronzeMedalist = null;
        this.eventPlayed = false;
    }

    public boolean injure(double probability) {

        Random rand = new Random();
        int k = 0;

        for (int i = 0; i < this.competitors.length; i++) {
            double prob = rand.nextFloat();
            if (probability > prob) {
                this.competitors[i].setInjured(true);
                k = 1;
            }
        }

        return (k == 1);
    }


    public void play() {

        boolean p;
        int x = 0, j = -1, k = -1, m = -1;
        Random rand = new Random();

        this.injure(((double) rand.nextInt(1000)) / 10000);

        for (int i = 0; i < this.competitors.length; i++) {
            if (this.competitors[i].getGoldMedals() > x
                && !(this.competitors[i].isInjured())) {
                x = this.competitors[i].getGoldMedals();
                j = i;
            } else if (this.competitors[i].getGoldMedals() == x
                && !(this.competitors[i].isInjured())) {
                p = rand.nextBoolean();
                if (p) {
                    x = this.competitors[i].getGoldMedals();
                    j = i;
                }
            }
        }

        if (j != -1) {
            this.goldMedalist = this.competitors[j];
            this.competitors[j].winGoldMedal();
        }

        x = 0;

        for (int i = 0; i < this.competitors.length; i++) {
            if (this.competitors[i].getSilverMedals() > x && i != j
                && !(this.competitors[i].isInjured())) {
                x = this.competitors[i].getSilverMedals();
                k = i;
            } else if (this.competitors[i].getSilverMedals() == x
                && i != j && !(this.competitors[i].isInjured())) {
                p = rand.nextBoolean();
                if (p) {
                    x = this.competitors[i].getSilverMedals();
                    k = i;
                }
            }
        }

        if (k != -1) {
            this.silverMedalist = this.competitors[k];
            this.competitors[k].winSilverMedal();
        }

        x = 0;

        for (int i = 0; i < this.competitors.length; i++) {
            if (this.competitors[i].getBronzeMedals() > x
                && i != j && i != k && !(this.competitors[i].isInjured())) {
                x = this.competitors[i].getBronzeMedals();
                m = i;
            } else if (this.competitors[i].getBronzeMedals() == x
                && i != j && i != k && !(this.competitors[i].isInjured())) {
                p = rand.nextBoolean();
                if (p) {
                    x = this.competitors[i].getBronzeMedals();
                    m = i;
                }
            }
        }

        if (m != -1) {
            this.bronzeMedalist = this.competitors[m];
            this.competitors[m].winBronzeMedal();
        }

        this.eventPlayed = true;
    }


    /*
    public static void main(String[] args) {

        Athlete[] a = new Athlete[3];
        Sport sport1 = Sport.LUGE;
        a[0] = new Athlete("Valod", "Armenia", sport1, 1, 2, 1);
        a[1] = new Athlete("Gugo", "Armenia", sport1, 2, 2, 1);
        a[2] = new Athlete("Karen", "Armenia", sport1, 3, 3, 3);

        Event k = new Event(a);

        k.play();

        System.out.println(k.goldMedalist);
        System.out.println(k.silverMedalist);
        System.out.println(k.bronzeMedalist);
    }
    */

}


