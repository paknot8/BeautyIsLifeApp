public class Email extends Bericht{
    private String email;

    public Email(int id, int userID, String onderwerp, String beschrijving, String email) {
        super(id, userID, onderwerp, beschrijving);
        this.email = email;
    }

    public Email(){}

    public static void addNewBericht(Bericht newBericht){ BerichtenData.BerichtenLijst.add(newBericht); }
}

