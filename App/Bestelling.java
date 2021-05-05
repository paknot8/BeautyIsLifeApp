public class Bestelling {
    private double totaalPrijs;

    private int prijs;
    private int aantalProducten;

    public Bestelling(int aantalProducten, int prijs) {
        this.aantalProducten = aantalProducten;
        this.prijs = prijs;
    }

    public double kortingOpTotaalAantalProducten(){
       if(aantalProducten <= 100){
           return totaalPrijs = (aantalProducten * prijs);
       } else {
           return totaalPrijs = aantalProducten * (prijs - 0.15);
       }
    }
}