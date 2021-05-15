public class Bestelling extends Product{
    private final int bestelNummer;
    private final int aantalProducten;
    private final int prijs;

    public Bestelling(int productId, String productNaam, int productVoorraad, int bestelNummer, int aantalProducten, int prijs) {
        super(productId, productNaam, productVoorraad);
        this.bestelNummer = bestelNummer;
        this.aantalProducten = aantalProducten;
        this.prijs = prijs;
    }

    public double kortingOpTotaalAantalProducten(){
        if(aantalProducten > 3 && aantalProducten < 10){
            return (aantalProducten * (prijs - 0.15));
        } else if(aantalProducten > 10 && aantalProducten < 100) {
            return (aantalProducten * (prijs - 0.20));
        } else if(aantalProducten > 100) {
            return (aantalProducten * (prijs - 0.25));
        } else {
            return (aantalProducten * prijs);
        }
    }
}