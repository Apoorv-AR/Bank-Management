import java.util.Scanner;

class BankAccount{
    double bal;
    double tran;
    String CustomerId;
    String CustomerName;

    public BankAccount(String customerId, String customerName) {
        CustomerId = customerId;
        CustomerName = customerName;
    }
    void deposit(double amount){
        if(amount!=0){
            bal += amount;
            tran = amount;
        }
    }
    void withdraw(double amount){
        if(amount!=0 && bal>=amount){
            bal-=amount;
            tran =- amount;
        }
        else if(bal<amount){
            System.out.println("Insufficient balance.");
        }
    }
    void getTran(){
        if(tran>0){
            System.out.println("Deposited: " + tran);
        }
        else if (tran<0) {
            System.out.println("Withdrawn: " + Math.abs(tran));
        }
        else {
            System.out.println("no transaction occurred.");
        }
    }
    void MainMenu(){
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + CustomerName);
        System.out.println("Your Id " + CustomerId);
        System.out.println("\n");
        System.out.println("Choose options for banking: ");
        System.out.println("a. Check Balance");
        System.out.println("b. Deposit");
        System.out.println("c. Withdraw");
        System.out.println("d. Transaction");
        System.out.println("e. Exit");
        do {
            option = sc.next().charAt(0);
            System.out.println("\n");
            switch(option){
                case 'a':
                    System.out.println("Your Balance is: "  + bal);
                    System.out.println("If you want other services then choose otherwise press 'e' fo exit.");
                    break;
                case 'b':
                    System.out.println("Enter the amount you want to deposit: ");
                    double amt = sc.nextDouble();
                    deposit(amt);
                    System.out.println("The amount is added to your account.");
                    System.out.println("If you want other services then choose otherwise press 'e' fo exit.");
                    break;
                case 'c':
                    System.out.println("Enter the amount you want to withdraw: ");
                    double withAmount = sc.nextDouble();
                    withdraw(withAmount);
                    System.out.println("Amount withdraw." + withAmount);
                    System.out.println("If you want other services then choose otherwise press 'e' fo exit.");
                    break;
                case 'd':
                    System.out.println("The previous Transaction are: ");
                    getTran();
                    System.out.println("If you want other services then choose otherwise press 'e' fo exit.");
                    break;
                case 'e':
                    System.out.println("***************** Exit ******************");
                    break;
                default:
                    System.out.println("Choose correct options to get services.");
                    break;
            }
        }while (option != 'e');
        System.out.println("Thanks for using our Bank Services.");
        System.out.println("************** Visit Again **********");
    }
}
public class Main{
    public static void main(String[] args) {
        /*
        1.Previous transaction
        2.Cash withdraw
        3.Deposit
        4.Check balance
        5.Exit
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Our Bank.");
        System.out.println("Enter your Customer Id and Customer Name");
        String cId = sc.next();
        String Cname = sc.next();
        BankAccount b1 = new BankAccount(Cname,cId);
        b1.MainMenu();
    }
}