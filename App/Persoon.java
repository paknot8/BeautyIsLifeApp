abstract class Persoon {
    private int id;
    private String naam;
    private String achternaam;
    private String telefoonnummer;
    private String email;
    private String gebruikersnaam;
    private String wachtwoord;

    // Long parameter fix
    public Persoon(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        this.id = id;
        this.naam = naam;
        this.achternaam = achternaam;
        this.telefoonnummer = telefoonnummer;
        this.email = email;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public Persoon(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNaam() {
        return naam;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }
    public String getAchternaam() {
        return achternaam;
    }
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    public String getTelefoonnummer() {
        return telefoonnummer;
    }
    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGebruikersnaam() {
        return gebruikersnaam;
    }
    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }
    public String getWachtwoord() {
        return wachtwoord;
    }
    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public void getBerichten() {}
    public void controleProductExist(){}
    public void zoekProduct() {}
    public void getBestellingen() {}
}