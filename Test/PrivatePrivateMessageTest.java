import junit.framework.TestCase;
import org.junit.Assert;

public class PrivatePrivateMessageTest extends TestCase
{
    public void testAddBericht() {
        boolean control = false;
        PrivatePrivateMessage pm = new PrivatePrivateMessage(1,1,"klacht","product gebroken");
        pm.addBericht(pm);
        for(int i = 0; i < BerichtenData.PrivatemessageLijst.size(); i++){
            String onderwerp = BerichtenData.PrivatemessageLijst.get(i).getOnderwerp();
            if(onderwerp.equals(pm.getOnderwerp())){
                control = true;
                break;
            }
        }
        Assert.assertTrue(pm.getOnderwerp(),control);
    }
}