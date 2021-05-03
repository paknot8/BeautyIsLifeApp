public class bestelling {
    private int bestelnummer;
    private String productnaam;
    private int aantal;

    public bestelling(int bestelnummer, String productnaam, int aantal) {
        this.bestelnummer = bestelnummer;
        this.productnaam = productnaam;
        this.aantal = aantal;
    }

    public int getBestelnummer() {
        return bestelnummer;
    }

    public void setBestelnummer(int bestelnummer) {
        this.bestelnummer = bestelnummer;
    }

    public String getProductnaam() {
        return productnaam;
    }

    public void setProductnaam(String productnaam) {
        this.productnaam = productnaam;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}