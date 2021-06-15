import junit.framework.TestCase;
import org.junit.Assert;

public class EmailTest extends TestCase
{
    public void testAddEmail() {
        boolean control = false;
        Email email = new Email(1,1,"klacht","product gebroken","bob@email.com");
        email.addEmail(email);
        for(int i = 0; i < BerichtenData.EmailLijst.size(); i++){
            String onderwerp = BerichtenData.EmailLijst.get(i).getOnderwerp();
            if(onderwerp.equals(email.getOnderwerp())){
                control = true;
                break;
            }
        }
        Assert.assertTrue(email.getOnderwerp(),control);
    }
}