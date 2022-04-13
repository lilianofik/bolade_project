import java.util.Scanner;

public class Cash {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Hello, pls enter the change owed");
        System.out.print(">");
        String change_owed = input.nextLine();
        double change = 0;

        if(change_owed.length() == 0) {
            System.out.println("Please enter a value.");
            System.out.print(">");

            while (true) {
                change_owed = input.nextLine();

                if(change_owed.length() > 0 && Double.parseDouble(change_owed) >= 0 && Double.parseDouble(change_owed) != 0)
                {
                    change = Double.parseDouble(change_owed);
                    break;
                }
                else if(change_owed.length() == 0 || Double.parseDouble(change_owed) < 0) {

                    while (true) {
                        System.out.println("Enter non negative value.");
                        System.out.print(">");
                        change_owed = input.nextLine();
                        if( change_owed.length() > 0 && Double.parseDouble(change_owed) >= 0){
                            change = Double.parseDouble(change_owed);
                            break;
                        }
                    }
                    break;
                }


            }
        }

        //0 is gonna cross

        else {

            if(Double.parseDouble(change_owed) >= 0 && Double.parseDouble(change_owed) != 0) change = Double.parseDouble(change_owed);

            else if(Double.parseDouble(change_owed) < 0) {

                while (true) {
                    System.out.println("Enter non negative value.");
                    System.out.print(">");
                    change_owed = input.nextLine();
                    if(change_owed.length() > 0 && Double.parseDouble(change_owed) >= 0){
                        change = Double.parseDouble(change_owed);
                        break;
                    }
                }

            }


        }

        if(change == 0) {
            System.out.println("You are not owed any change today.");
            return;
        }

        change = Math.round(change * 100);

        //quarters (25¢), dimes (10¢), nickels (5¢), and pennies (1¢).
        // 10 <= change <= $25

        int total_coins = 0;

        while(change != 0) {

            if(change >= 25) {
                change -= 25;
                total_coins++;
            }

            else if(change >= 10 && change <= 25) {
                change -= 10;
                total_coins++;
            }

            else if(change >= 5 && change <= 10) {
                change -= 5;
                total_coins++;
            }

            else {
                change -= 1;
                total_coins++;
            }
        }

        System.out.println("You are owed: " + total_coins);
    }


}
