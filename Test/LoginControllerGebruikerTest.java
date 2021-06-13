import org.junit.Assert;
import org.junit.Test;

public class LoginControllerGebruikerTest
{
    // Mock Data
    UserAccount tom = new UserAccount("tom123","123","06123123","tom@email.nl");
    Gebruiker gebruiker = new Gebruiker(1,"tom","kramer",tom);

    @Test // Test om te kijken of een gebruiker bestaat op gebruikersnaam
    public void LoginControle() {
        String expected = "tom123";
        Assert.assertEquals(expected,tom.getGebruikersnaam());
    }

    // Controleert of gebruikersnaam bestaat in lijst
    @Test
    public void userPassCheckTest() {
        String expected = null;
        String gebNaam = null;
        Medewerker.addNewGebruiker(gebruiker);
        for(int i = 0; i < GebruikersData.GebruikersLijst.size(); i++) {
            gebNaam = GebruikersData.GebruikersLijst.get(i).userAccount.getGebruikersnaam();
            if (gebNaam.equals("tom123")) {
                expected = gebNaam;
                break;
            }
        }
        Assert.assertEquals(expected,gebNaam);
    }
}