import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountTest
{
    // Mock data
    UserAccount userAccount = new UserAccount("erick123","123",
            "08429","erick@email.com");

    @Test
    public void getGebruikersnaam() {
        String expected = "erick123";
        Assert.assertEquals(expected,userAccount.getGebruikersnaam());
    }

    @Test
    public void setGebruikersnaam() {
        String expected = "erick";
        userAccount.setGebruikersnaam("erick");
        Assert.assertEquals(expected,userAccount.getGebruikersnaam());
    }

    @Test
    public void getWachtwoord() {
        String expected = "123";
        Assert.assertEquals(expected,userAccount.getWachtwoord());
    }

    @Test
    public void setWachtwoord() {
        String expected = "111";
        userAccount.setWachtwoord("111");
        Assert.assertEquals(expected,userAccount.getWachtwoord());
    }

    @Test
    public void getTelefoonnummer() {
        String expected = "08429";
        Assert.assertEquals(expected,userAccount.getTelefoonnummer());
    }

    @Test
    public void setTelefoonnummer() {
        String expected = "5555";
        userAccount.setTelefoonnummer("5555");
        Assert.assertEquals(expected,userAccount.getTelefoonnummer());
    }

    @Test
    public void getEmail() {
        String expected = "erick@email.com";
        Assert.assertEquals(expected,userAccount.getEmail());
    }

    @Test
    public void setEmail() {
        String expected = "e@e.nl";
        userAccount.setEmail("e@e.nl");
        Assert.assertEquals(expected,userAccount.getEmail());
    }
}