import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GebruikerTest {

    @Test // Test om te kijken of een gebruiker bestaat op gebruikersnaam
    public void loginControleGebruikerTest() {
        Gebruiker gebruiker = new Gebruiker(3,"tom","kramer",
                "0612345678","tom@email.nl","tom123","123");
        String expected = "tom123";
        Assert.assertEquals(expected,gebruiker.getGebruikersnaam());
    }
}