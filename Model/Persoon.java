public abstract class Persoon {
    private int id;
    private String naam;
    private String achternaam;

    public UserAccount userAccount;

    public Persoon(int id, String naam, String achternaam, UserAccount userAccount) {
        this.id = id;
        this.naam = naam;
        this.achternaam = achternaam;
        this.userAccount = userAccount;
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

    public abstract void getBerichten();
    public abstract void getBestellingen();
}