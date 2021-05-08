import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GebruikerTest
{
    // Data
    Gebruiker gebruiker = new Gebruiker(3,"tom","kramer",
            "0612345678","tom@email.nl","tom123","123");

    @Test // Test om te kijken of een gebruiker bestaat op gebruikersnaam
    public void loginControleGebruikerTest() {
        String expected = "tom123";
        Assert.assertEquals(expected,gebruiker.getGebruikersnaam());
    }

    // Controleert of gebruikersnaam bestaat
    @Test
    public void addNewGebruikerTest() {
        String expected = null;
        String gebNaam = null;
        gebruiker.ad
        for(Medewerker medewerker : MedewerkersData.MedewerkersLijst){
            gebNaam = medewerker.getGebruikersnaam();
            if (gebNaam.equals("bas123")) {
                expected = "bas123";
                gebNaam = "bas123";
                break;
            }
        }
        Assert.assertEquals(expected,gebNaam);
    }
}