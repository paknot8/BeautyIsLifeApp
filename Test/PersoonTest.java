import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersoonTest
{
    UserAccount userAccount = new UserAccount("erick123","123",
            "06723452","erick@email.com");

    Persoon gebruiker = new Gebruiker(1,"erick","ibanez",userAccount);
    Persoon medewerker = new Medewerker(2,"tim","kerkhof",userAccount);

    @Test
    public void getId() {
        int expected = 1;
        Assert.assertEquals(expected,gebruiker.getId());
    }

    @Test
    public void setId() {
        int expected = 5;
        gebruiker.setId(5);
        Assert.assertEquals(expected,gebruiker.getId());
    }

    @Test
    public void getNaam() {
        String expected = "erick";
        Assert.assertEquals(expected,gebruiker.getNaam());
    }

    @Test
    public void setNaam() {
        String expected = "gijs";
        gebruiker.setNaam("gijs");
        Assert.assertEquals(expected,gebruiker.getNaam());
    }

    @Test
    public void getAchternaam() {
        String expected = "tim";
        Assert.assertEquals(expected,medewerker.getAchternaam());
    }

    @Test
    public void setAchternaam() {
        String expected = "brood";
        medewerker.setAchternaam("brood");
        Assert.assertEquals(expected,medewerker.getAchternaam());
    }
}