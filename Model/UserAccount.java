public class UserAccount
{
    private String gebruikersnaam;
    private String wachtwoord;
    private String telefoonnummer;
    private String email;

    public UserAccount(String gebruikersnaam, String wachtwoord, String telefoonnummer, String email) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.telefoonnummer = telefoonnummer;
        this.email = email;
    }

    public String getGebruikersnaam() { return gebruikersnaam; }
    public void setGebruikersnaam(String gebruikersnaam) { this.gebruikersnaam = gebruikersnaam; }
    public String getWachtwoord() { return wachtwoord; }
    public void setWachtwoord(String wachtwoord) { this.wachtwoord = wachtwoord; }
    public String getTelefoonnummer() { return telefoonnummer; }
    public void setTelefoonnummer(String telefoonnummer) { this.telefoonnummer = telefoonnummer; }
    public String getEmail() { return email; }public void setEmail(String email) { this.email = email; }
}