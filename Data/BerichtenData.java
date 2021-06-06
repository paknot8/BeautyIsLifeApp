import java.util.ArrayList;

public class BerichtenData {
    public static PrivatePrivateMessage privatemessage;
    public static ArrayList<PrivatePrivateMessage> PrivatemessageLijst = new ArrayList<>() {
        {
            add(privatemessage = new PrivatePrivateMessage(1,1,"verkeerde aankoop","Ik heb een verkeerde aankoop gedaan, graag annuleren!"));
            add(privatemessage = new PrivatePrivateMessage(2,1,"klacht","Ontevreden met service!"));
        }
    };

    public static Email email;
    public static ArrayList<Email> EmailLijst = new ArrayList<>() {
        {
            add(email = new Email(1,1,"verkeerde aankoop","Ik heb een verkeerde aankoop gedaan, graag annuleren!","erick@email.com"));
            add(email = new Email(2,2,"klacht","Ontevreden met service!","tim@email.com"));
        }
    };
}