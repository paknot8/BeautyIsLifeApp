public class Bericht {
    private int id, userID;
    private String onderwerp;
    private String beschrijving;

    public Bericht(int id, int userID, String onderwerp, String beschrijving) {
        this.id = id;
        this.userID = userID;
        this.onderwerp = onderwerp;
        this.beschrijving = beschrijving;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    public String getOnderwerp() {
        return onderwerp;
    }
    public void setOnderwerp(String onderwerp) { this.onderwerp = onderwerp; }
    public String getBeschrijving() {
        return beschrijving;
    }
    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}