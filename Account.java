package BMS_Java;

import java.util.*;

public class Account {
    Scanner scanner = new Scanner(System.in);

    String NAME = new String();
    String ADDRESS = new String();
	String PHONE = new String();
	int	ACC_ID;
	char acc_type; // private/business
    double BALANCE;
    
    Account() {
        this.NAME = null;
        this.ADDRESS = null;
        this.PHONE = null;
        this.acc_type = 0;
        this.BALANCE = 0.00;
        ACC_ID = 0;
    }
    
    Account(String name, String address, String phone_num, int id_set) {
        this.NAME = name;
        this.ADDRESS = address;
        this.PHONE = phone_num;
        acc_type = 0;
        BALANCE = 0;
        ACC_ID = id_set;
    }

    void setName(String name) {
        this.NAME = name;
    }
    
    void setAddress(String address) {
        this.ADDRESS = address;
    }
    
    void setAccID(int acc_id) {
        this.ACC_ID = acc_id;
    }
    
    void setPhone(String phone_num) {
        this.PHONE = phone_num;
    }
    
    int getID() {
        try {
            return this.ACC_ID;
        } catch(Exception e){
            System.out.println("Unavailable Account id;");
        }
        return 0;
    }
    
    String getName() {
        return this.NAME;
    }
    
    String getAddress() {
        return this.ADDRESS;
    }
    
    String getPhone() {
        return this.PHONE;
    }
    
    double getBalance() {
        return this.BALANCE;
    }
    
    void update_balance(final float ammount) {
            this.BALANCE += ammount;
    }

    void update_info(){
        System.out.println("Please pick what info you would like to update: ");
        int choice;
        choice = scanner.nextInt();
        System.out.println("1. Name. ");
        System.out.println("2. Address. ");
        System.out.println("3. Phone number. ");

        choice = scanner.nextInt();
        switch (choice) {
        case 1:
            String acc_name = new String(); 
            acc_name = scanner.nextLine();
            this.setName(acc_name);
            break;
        case 2:
            String acc_address = new String();
            acc_address = scanner.nextLine();
            this.setAddress(acc_address);
            break;
        case 3:
            String acc_phone = new String();
            acc_address = scanner.nextLine();
            this.setPhone(acc_phone);
            break;
        default:
            break;
        }
    }

    void print_account(){
        System.out.println("ID: " + this.ACC_ID + ", ");
        System.out.println("Name: " + this.NAME + ", ");
        System.out.println("Address: " + this.ADDRESS + ", ");
        System.out.println("Phone number: " + this.PHONE + ", ");
        System.out.println("Balance: " + this.BALANCE + ", ");
    }

    void print_account(Account A){
        System.out.println("ID: " + A.getID() + ", ");
        System.out.println("Name: " + A.getName() + ", ");
        System.out.println("Address: " + A.getAddress() + ", ");
        System.out.println("Phone number: " + A.getPhone() + ", ");
        System.out.println("Balance: " + A.getBalance() + ", ");
    }
}