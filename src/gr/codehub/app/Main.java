package gr.codehub.app;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Ui ui = new Ui();
        Basket basket = new Basket();
        Customer newCustomer = Customer.createCustomer();
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Please type an address:");
            String address = scanner.next();                // Ερώτηση γιατι δεν δεχεται με κενό
            newCustomer.addAddress(address);
            System.out.println("Do you want to add a new address? (YES/No)");
            choice = scanner.next();
        }while(choice.equalsIgnoreCase("YES"));
        System.out.println(newCustomer.toString());

        ui.manageBasket(basket);

    }



}