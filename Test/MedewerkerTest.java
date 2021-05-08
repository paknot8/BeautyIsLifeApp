import org.junit.Assert;
import org.junit.Test;

public class MedewerkerTest
{
    // Data
    Medewerker medewerker = new Medewerker(3,"bas","bouwer",
            "0612345678","bas@email.nl","bas123","123");

    @Test
    public void loginControleMedewerkerTest() {
        String expected = "bas123";
        Assert.assertEquals(expected,medewerker.getGebruikersnaam());
    }

    // Controleert of gebruikersnaam bestaat
    @Test
    public void addNewMedewerkerTest() {
        String expected = null;
        String gebNaam = null;
        Medewerker.addNewMedewerker(medewerker);
        for(Medewerker medewerker : MedewerkersData.MedewerkersLijst){
            gebNaam = medewerker.getGebruikersnaam();
            if (gebNaam.equals("bas123")) {
                expected = "bas123";
                break;
            }
        }
        Assert.assertEquals(expected,gebNaam);
    }
}