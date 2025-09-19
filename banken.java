import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class banken {

    //Global vairabler för saldo, pin, transaktionshistorik och username
    static double saldo = 0.0; 
    static String pin;
    static String username;
    static List<String> transaktionshistorik = new ArrayList<>();
    // Variabel Datum och tid, of pattern yyyy,MM,dd HH:mm
    static DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy,MM,dd HH:mm");

    //Metod för att visa saldot
    static void saldoKonto(Scanner scan){
        System.out.println("Tryck 1 för att se saldo/ Tryck 2 för att gå tillbaka");
        
        int choice = scan.nextInt();
        if ( choice == 1){
            // Visa saldo
            System.out.println("Ditt saldo är: " + saldo);
            return;
        } else if 
        // Återgå till menyn
            (choice == 2){
                return;
            }
         else {
            // Ogiltigt val hantering
            System.out.println("Ogiltigt val, ange nummer mellan (1-2");
            return;

        }
    }

    // Metod för att sätta in pengar
    static void deposit(Scanner scan){
        
        System.out.println("Gärna ange ditt pin för att kunna fortsätta");
        String cPin = scan.next(); //cPin = nuvarande pin
        if (!cPin.equals(pin)) {
            System.out.println("Fel pin");
            return;
        }
        while (true) {
            // Meny för insättning
            System.out.println("Välj hur mycket du vill sätta in (1-4) / 0 exit");
            System.out.println("1. 100");
            System.out.println("2. 500");
            System.out.println("3. 1000");
            System.out.println("4. Skriv antal själv");

            int choice = scan.nextInt();
            //0 för att avsluta
            if (choice == 0){
                return;
            }
            double result = 0.0;
            boolean validChoice = true;

            //Beslut för val, (summan att sätta in)
            switch (choice) {
                case 1:
                    result = 100;
                    break;
                case 2:
                    result = 500;
                    break;
                case 3:
                    result = 1000;
                    break;
                case 4:
                    System.out.println("Skriv in antal");
                    double antal = scan.nextDouble();
                    result = antal;
                    break;
                default:
                    validChoice = false;
                    System.out.println("Ogiltigt val, ange nummer mellan (1-4) eller 0 för att avsluta");
                    break;
            }
            // Om valet är giltigt så uppdateras saldot
            if (validChoice) {
                saldo += result;
                System.out.println("Du har satt in: " + result + "Nu har du: " + saldo + " på ditt konto");
                String tid = LocalDateTime.now().format(dateTime); // Skapade string som med nuvarande datum och tid
                transaktionshistorik.add(tid + " Insättning " + result); // Lägg till transaktion till en lista för att kalla belopp och tid senare
                return; // Återgå till menyn
            }
            
        }
    }
    // Metod för att ta ut pengar, liknande som deposit
    static void withdraw(Scanner scan){
        
        System.out.println("Gärna ange ditt pin för att kunna fortsätta");
        String cPin = scan.next(); //cPin = nuvarande pin
        if (!cPin.equals(pin)) {
            System.out.println("Fel pin");
            return;
        }
        while (true) {
            // Meny för uttag
            System.out.println("Välj hur mycket du vill ta ut (1-4) / 0 exit");
            System.out.println("1. 100");
            System.out.println("2. 500");
            System.out.println("3. 1000");
            System.out.println("4. Skriv antal själv");

            int choice = scan.nextInt();
            // 0 för att avsluta
            if (choice == 0){
                return;
            }
            double result = 0.0;
            boolean validChoice = true;

            // Beslut för val, (summan att ta ut)
            switch (choice) {
                case 1:
                    result = 100;
                    break;
                case 2:
                    result = 500;
                    break;
                case 3:
                    result = 1000;
                    break;
                case 4:
                    System.out.println("Skriv in antal");
                    double antal = scan.nextDouble();
                    result = antal;
                    break;
                default:
                    validChoice = false;
                    System.out.println("Ogiltigt val, ange nummer mellan (1-4) eller 0 för att avsluta");
                    break;
            }
            if (validChoice) { 
                // Kontrollera om det finns tillräckligt pengar på kontot
                if (saldo >= result){
                    saldo -= result;
                    System.out.println("Du har tagit ut: " + result + "Nu har du: " + saldo + " på ditt konto");
                    String tid = LocalDateTime.now().format(dateTime); // Skapade string som med nuvarande datum och tid
                    transaktionshistorik.add(tid + " Uttag " + result); // Lägg till transaktion till en lista för att kalla belopp och tid senare

                } else {
                    // Om inte tillräckligt med pengar
                    System.out.println("Inte tillräckligt med pengar! Du har: " + saldo + " på ditt konto");
                }
                return;
            }
        }
        }
    
         static void transaktion(Scanner scan){
        // Metod för att visa transaktionshistorik
        System.out.println("Transaktionshistorik:");
        System.out.println("Gärna ange ditt pin för att kunna fortsätta");
        String cPin = scan.next(); //cPin = nuvarande pin
        if (cPin.equals(pin)) {
            if (transaktionshistorik.isEmpty()){
                System.out.println("Du har inga transaktioner än");
            } else {
                for (String printTransaktion: transaktionshistorik) { // enhanced for loop för att gå igenom listan
                System.out.println(printTransaktion);
                }
            }
        } else {
            System.out.println("fel pin");
            return;
            }
        }
    static void pin(Scanner scan){
        // Metod för att byta pin
    
        System.out.println("Ange ditt pin");
        String cPin = scan.next(); //cPin = nuvarande pin
        if (cPin.equals(pin)) { // Kontrollera om inmatat pin är korrekt genom (equals)
            System.out.println("Ange nytt pin");
            String newPin = scan.next();
            boolean newPinValid = true;

        // Kontrollera att pin är exakt 4 siffror
        if (newPin.length() != 4) {
            newPinValid = false;
            System.out.println("PIN måste vara 4 siffor");
        }
        // Kontrollera att pin bara innehåller siffror
        for (int i = 0; i < newPin.length(); i++) {
            if (!Character.isDigit(newPin.charAt(i))) {
                newPinValid = false;
                System.out.println("PIN måste inneholla siffor");
                break;
            }
        }
        // OM pin är godkänt så gå till menyn
        if (newPinValid) {
            pin = newPin; // Uppdatera pin, har använt samma kod som i main fast ändrat variabel namn
            System.out.println("Ditt pin har blivit ändrat");
        }
        }
        

    }
    // Huvudmeny metod
    static void meny(Scanner scan){
        

        while (true) {
            // Meny
            System.out.println("Välkomna till Banken, välj ett alternative (1-7)");
            System.out.println("1. Se saldo");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Ta ut pengar");
            System.out.println("4. Visa transaktionshistorik");
            System.out.println("5. Byt PIN");
            System.out.println("6. Avsluta programmet");
            int choice = scan.nextInt();

            // Välj alternativ, baserat på användarens inmatning
            switch (choice) {
                case 1:
                    saldoKonto(scan);
                    break;
                case 2:
                    deposit(scan);
                    break;
                case 3:
                    withdraw(scan);
                    break;
                case 4:
                    transaktion(scan);
                    break;
                case 5:
                    pin(scan);
                    break;
                case 6:
                // Case för att avsluta programmet
                    System.out.println("Tack för att du avände banken");
                    scan.close();
                    return;
                default:
                    System.out.println("Ogiltigt val, ange nummer mellan (1-7)");
                    break;
            }

        }
    }
    // Main metod när programmet startar
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        // Fråga för att skapa username och pin
        System.out.println("Välkomna, gärna ange ditt username ");
        username = scan.next();
        
        while (true){
            System.out.println("Skapa eget pin code (4 syfror style)");
            pin = scan.next(); 
            boolean pinValid = true;
            // Kontrollera att pin är exakt 4 siffror
        if (pin.length() != 4) {
            pinValid = false;
            System.out.println("PIN måste vara 4 siffor");
            continue;
        }
        // Kontrollera att pin bara innehåller siffror
        for (int i = 0; i < pin.length(); i++) {
            if (!Character.isDigit(pin.charAt(i))) {
                pinValid = false;
                System.out.println("PIN måste inneholla siffor");
                break;
            }
        }
        // OM pin är godkänt så gå till menyn
        if (pinValid) {
            System.out.println("Username : " + username + " PIN: " + pin);
            meny(scan); // huvudmeny
        }
        scan.close();
            }
        }
    }