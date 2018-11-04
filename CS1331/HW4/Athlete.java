//I worked on the homework assignment alone, using only course materials.


public class Athlete {

    private String name;
    private String country;
    private Sport sport;
    private int goldMedals, silverMedals, bronzeMedals;
    private boolean injured;

    public Athlete(String name, String country,
        Sport sport, int g, int s, int b) {
        this.name = name;
        this.country = country;
        this.sport = sport;
        goldMedals = g;
        silverMedals = s;
        bronzeMedals = b;
        injured = false;
    }

    public Athlete(String name, String country, Sport sport) {
        this(name, country, sport, 0, 0, 0);
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public Sport getSport() {
        return this.sport;
    }

    public int getGoldMedals() {
        return this.goldMedals;
    }

    public int getSilverMedals() {
        return this.silverMedals;
    }

    public int getBronzeMedals() {
        return this.bronzeMedals;
    }

    public boolean isInjured() {
        return this.injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public void winGoldMedal() {
        this.goldMedals++;
    }

    public void winSilverMedal() {
        this.silverMedals++;
    }

    public void winBronzeMedal() {
        this.bronzeMedals++;
    }

    public int getTotalMedals() {
        return (this.goldMedals + this.silverMedals + this.bronzeMedals);
    }

}