import java.util.Scanner;

public class banken {

    static double saldo = 0.0;

    static void saldoKonto(){
        System.out.println("Tryck 1 för att se saldo/ Tryck 2 för att gå tillbaka");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if ( choice == 1){
            System.out.println("Ditt saldo är: " + saldo);
            return;
        } else if 
            (choice == 2){
                return;
            }
         else {
            System.out.println("Ogiltigt val, ange nummer mellan (1-2");
            return;

        }
        scan.close();
    }

    static void deposit(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Välj hur mycket du vill sätta in (1-4) / 0 exit");
            System.out.println("1. 100");
            System.out.println("2. 500");
            System.out.println("3. 1000");
            System.out.println("4. Skriv antal själv");

            int choice = scan.nextInt();
            if (choice == 0){
                return;
            }
            double result = 0.0;
            boolean validChoice = true;
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
                default:
                    validChoice = false;
                    System.out.println("Ogiltigt val, ange nummer mellan (1-4) eller 0 för att avsluta");
                    break;
            }
            if (validChoice) {
                saldo += result;
                System.out.println("Du har satt in: " + result + "Nu har du: " + saldo + " på ditt konto");
                return;
            }
            scan.close();
        }
    }

    static void withdraw(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Välj hur mycket du vill ta ut (1-4) / 0 exit");
            System.out.println("1. 100");
            System.out.println("2. 500");
            System.out.println("3. 1000");
            System.out.println("4. Skriv antal själv");

            int choice = scan.nextInt();
            if (choice == 0){
                return;
            }
            double result = 0.0;
            boolean validChoice = true;
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
                default:
                    validChoice = false;
                    System.out.println("Ogiltigt val, ange nummer mellan (1-4) eller 0 för att avsluta");
                    break;
            }
            if (validChoice) { 
                if (saldo >= result){
                    saldo -= result;
                    System.out.println("Du har tagit ut: " + result + "Nu har du: " + saldo + " på ditt konto");

                } else {
                    System.out.println("Inte tillräckligt med pengar! Du har: " + saldo + " på ditt konto");
                }
                return;
            }
            scan.close();
        }
    }
    static void transaktion(){

    }
    static void pin(){

    }
    static void admin(){

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("Välkomna till Banken, välj ett alternative (1-7)");
            System.out.println("1. Se saldo");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Ta ut pengar");
            System.out.println("4. Visa transaktionshistorik");
            System.out.println("5. Byt PIN");
            System.out.println("6. Admin");
            System.out.println("7. Avsluta programmet");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    saldoKonto();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    transaktion();
                    break;
                case 5:
                    pin();
                    break;
                case 6:
                    admin();
                    break;
                case 7:
                    System.out.println("Tack för att du avände banken");
                    scan.close();
                    return;
                default:
                    System.out.println("Ogiltigt val, ange nummer mellan (1-7)");
                    break;
            }

        }
    }
} 
