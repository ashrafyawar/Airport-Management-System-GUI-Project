package Airline;

import Client.Person;
import Client.UserInterface;

import java.util.Objects;
import java.util.Scanner;

/**
 * Backbone of airline personnel .
 * In case of needed  other personnel type can be derived.
 * @author Nevzat Seferoglu
 * @version 1.0
 */
public class AirlinePersonnel extends Person implements UserInterface {

    private String SSN;
    private String password;
    boolean isPilot;


    public AirlinePersonnel(String name, String surname , boolean isPilot) {
        super(name, surname);
        this.isPilot = isPilot;
    }

    public void menu(){

        int choice;
        Scanner in = new Scanner(System.in);
        boolean loop = true;


        while(loop){

            System.out.printf("\nWelcome to airline personnel page, %s.\n",getName());

            System.out.printf("1- Personal info menu \n");
            System.out.printf("2- Change ssn\n");
            System.out.printf("3- Change password.\n");
            System.out.printf("4- Exit.\n");

            choice = in.nextInt();

            switch (choice){
                case 1: super.menu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: loop = false;
                    break;
                default: System.out.printf("Error. Your input is invalid..\n");
            }
        }
    }

    @Override
    public String getSSN() {
        return SSN;
    }

    @Override
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AirlinePersonnel that = (AirlinePersonnel) o;
        return SSN.equals(that.SSN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSN);
    }

    @Override
    public String toString() {
        return "AirlinePersonnel{" +
                "SSN='" + SSN + '\'' +
                ", password='" + password + '\'' +
                ", isPilot=" + isPilot +
                '}';
    }

}
