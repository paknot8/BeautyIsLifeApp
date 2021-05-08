public class Persoon {
    private int id;
    private String naam;
    private String achternaam;
    private String email;
    private String gebruikersnaam;
    private String wachtwoord;

    public Persoon(int id, String naam, String achternaam, String email, String gebruikersnaam, String wachtwoord) {
        this.id = id;
        this.naam = naam;
        this.achternaam = achternaam;
        this.email = email;
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public int id() {
        return id;
    }

    public void setid(int id) {
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
}
