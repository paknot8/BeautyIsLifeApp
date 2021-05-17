public class Medewerker extends Persoon
{
    public Medewerker(int id, String naam, String achternaam, String telefoonnummer, String email, String gebruikersnaam, String wachtwoord) {
        super(id, naam, achternaam, telefoonnummer, email, gebruikersnaam, wachtwoord);
    }

    public static void addNewMedewerker(Medewerker newMedewerker){
        MedewerkersData.MedewerkersLijst.add(newMedewerker);
    }

    public void KlantenLijst(){ }
}