import org.junit.Assert;
import org.junit.Test;

public class LoginControllerMedewerkerTest
{
    // Mock Data
    UserAccount bella = new UserAccount("bella123","123","06123123","bella@email.nl");
    Medewerker medewerker = new Medewerker(2,"bella","kerkhof",bella);

    @Test // Test om te kijken of een gebruiker bestaat op gebruikersnaam
    public void loginControleMedewerkerTest() {
        String expected = "bella123";
        Assert.assertEquals(expected,bella.getGebruikersnaam());
    }

    // Controleert of gebruikersnaam bestaat in lijst
    @Test
    public void userPassCheckTest() {
        String expected = null;
        String gebNaam = null;
        Medewerker.addNewMedewerker(medewerker);
        for(int i = 0; i < MedewerkersData.MedewerkersLijst.size(); i++) {
            gebNaam = MedewerkersData.MedewerkersLijst.get(i).userAccount.getGebruikersnaam();
            if (gebNaam.equals("bella123")) {
                expected = gebNaam;
                break;
            }
        }
        Assert.assertEquals(expected,gebNaam);
    }
}