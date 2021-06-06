public class PrivateMessage extends Bericht{
    public PrivateMessage(int id, int userID, String onderwerp, String beschrijving) {
        super(id, userID, onderwerp, beschrijving);
    }

    public PrivateMessage() { }

    public static void addNewBericht(Bericht newBericht){ BerichtenData.BerichtenLijst.add(newBericht); }
}
