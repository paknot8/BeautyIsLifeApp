public class PrivatePrivateMessage extends Bericht
{
    public PrivatePrivateMessage(int id, int userID, String onderwerp, String beschrijving) {
        super(id, userID, onderwerp, beschrijving);
    }

    public void addBericht(PrivatePrivateMessage newPrivateMessage){
        BerichtenData.PrivatemessageLijst.add(newPrivateMessage);
    }
}