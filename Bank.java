package BMS_Java;

import java.util.*;

public class Bank {
    Scanner scanner = new Scanner(System.in);

    String NAME = new String();
    String  ADDRESS = new String();
    String  BRANCH = new String();
    Account accounts[];
    
    public static int ACC_COUNT = 0; // counter for new account id
    
    Bank(String name, String address, String branch){
        accounts = new Account[100];
    }

    void setName(String name){
        this.NAME = name;
    }

    void setAddress(String address){
        this.ADDRESS = address;
    }

    void setBranch(String branch){
    this.BRANCH = branch;
    }

    int getSize(){
        return ACC_COUNT;
    }

    void transaction(){
        Account current = find_account();

        int choice;
        System.out.println("Please pick one of the following Actions: ");
        System.out.println("1. Withdraw. ");
        System.out.println("2. Deposit. ");
        System.out.println("3. Check Balance. ");
        System.out.println("Any other choice would take you back to the menu.");
        choice = scanner.nextInt();
        switch (choice) {
        case 1: 
            withdraw(current);
            break;
        case 2: 
            deposit(current);
            break;
        case 3: 
            current.getBalance();
            break;
        default: 
            return;
        }
    }

    void withdraw(Account current){
        float ammount;
        System.out.println("Please enter ammount to withdraw: ");
        ammount = scanner.nextInt();
        if(current.getBalance() >= 0 && current.getBalance() - ammount < 0 ){
            System.out.println("withdrawing this ammount will put you under 0, are you sure you want to advance? ");
            System.out.println("1. Approve");
            System.out.println("2. Change ammount");
            System.out.println("3. Exit");
            int answer = scanner.nextInt();
            switch(answer){
                case 1:
                    current.update_balance(-ammount);
                    break;
                case 2:
                    withdraw(current);
                    break;
                case 3:
                    break;
            }
        }
    }

    void deposit(Account current){
        float ammount;
        System.out.println("Please enter ammount to deposit: ");
        ammount = scanner.nextInt();
        current.update_balance(ammount);
    }

    double get_bank_overall(){
        int overall = 0;
        for(int i = 0; i < getSize(); i++){
            overall += accounts[i].getBalance();
        }
        return overall;
    }

    void new_acc(){
        String name = new String();
        String address = new String();
        String phone = new String();

        System.out.println("Please enter account's name: " );
        name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Please enter account's address: ");
        address = scanner.nextLine();

        System.out.println("Please enter account's phone number: ");       
        phone = scanner.nextLine();
        
        Account newAcc = new Account(name, address, phone, ACC_COUNT);
        ACC_COUNT++;
        add_new_acc(newAcc);
    }

    void add_new_acc(Account acc){
        accounts[getSize() - 1] = acc;
    }

    void merge_accounts(){
        
    }

    Account find_account(){
        System.out.println("Please Enter the following: ");
        System.out.println("1. ID ");
        int id;
        id = scanner.nextInt();

        System.out.println("2. Name ");
        String acc_name = new String();
        acc_name = scanner.nextLine();
        
        for (int i = 0; i < this.getSize(); i++)
        {
            if (accounts[i].getID() == id){
                if (accounts[i].NAME == acc_name)
                    return accounts[i];
            }
        }
        System.out.println("Sorry, your account information was not found, please try again or get back to menu.");
        return null;
    }

    void update_acc_info(){
        Account current = find_account();
        current.update_info();
    }

    void print_acc_info(){
        Account current = find_account();
        current.print_account();
    }

    void show_accounts(){
        System.out.println("Customers List: ");
        for (int i = 0; i < this.getSize(); i++)
        {
            accounts[i].print_account();
            System.out.println();
        }
    }

    void show_menu(){
        int choice;
        System.out.println("Please pick one of the following Actions: ");
        System.out.println("1. Create a new account. ");
        System.out.println("2. transactions. ");
        System.out.println("3. Update account information. ");
        System.out.println("4. Merge accounts. ");
        System.out.println("5. Show account's info.");
        System.out.println("6. Show all accounts info.");
        System.out.println("7. Exit");
    
        choice = scanner.nextInt();

        switch (choice) {
        case 1: 
            new_acc();
            break;
        case 2: 
            transaction();
            break;
        case 3:
            update_acc_info();
            break;
        case 4:
            merge_accounts();
            break;
        case 5:
            print_acc_info();
            break;
        case 6:
            show_accounts();
            break;
        case 7:
            return;
        }
        show_menu();
    }
}