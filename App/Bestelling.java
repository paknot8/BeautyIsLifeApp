public class Bestelling {
    private int totaalProducten;
    private double totaalPrijs;

    private int prijs;
    private int aantalProducten;

    public Bestelling(int aantalProducten, int prijs) {
        this.aantalProducten = aantalProducten;
        this.prijs = prijs;
    }

    public int aantalBesteldeProducten(int aantalBesteld){
        return totaalProducten = aantalBesteld;
    }

    public boolean korting(){
       if(totaalProducten > 100){
            totaalPrijs = totaalProducten - 0.15;
       }
       return true;
    }
}