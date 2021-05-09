public class Bestelling {
    private final int prijs;
    private final int aantalProducten;

    public Bestelling(int aantalProducten, int prijs) {
        this.aantalProducten = aantalProducten;
        this.prijs = prijs;
    }

    public double kortingOpTotaalAantalProducten(){
        if(aantalProducten > 3 && aantalProducten < 10)
        {
            return (aantalProducten * (prijs - 0.15));
        } else if(aantalProducten > 10 && aantalProducten < 100)
        {
            return (aantalProducten * (prijs - 0.20));
        } else if(aantalProducten > 100)
        {
            return (aantalProducten * (prijs - 0.25));
        } else {
            return (aantalProducten * prijs);
        }
    }
}