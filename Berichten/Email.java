public class Email extends Bericht
{
    public String email;

    public Email(int id, int userID, String onderwerp, String beschrijving, String email) {
        super(id, userID, onderwerp, beschrijving);
        this.email = email;
    }

    public void addEmail(Email newEmail){ BerichtenData.EmailLijst.add(newEmail); }
}