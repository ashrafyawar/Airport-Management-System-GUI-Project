package Airport;

import Client.Person;
import Client.UserInterface;

import java.util.Objects;
import java.util.Scanner;

/**AirportPersonnel class, The class that administrates users.*/
public class AirportPersonnel extends Person implements UserInterface , AirportPersonnelInterface {

    /**Social security number, stored as String.*/
    private String SSN;

    /**Password to log in, stored as String.*/
    private String password;

    /**Helps to reach AirportSystemStorage class' data.*/
    private AirportSystemStorage airportSystemStorage;

    /** AirportPersonnel constructor.
     * @param name As the name of user.
     * @param surname As the surname of user.
     * @param password As the password of the user, that helps logging in.
     * @param SSN As the SSN of the user.
     * @param airportSystemStorage As current airport to be in.
     * */
    public AirportPersonnel( String name , String surname , final String SSN , final String password
            , final AirportSystemStorage airportSystemStorage  ) {
        super(name, surname);


        this.SSN = SSN;
        this.password = password;

        this.airportSystemStorage = airportSystemStorage;
    }


    public void menu(){

        int choice;
        Scanner in = new Scanner(System.in);
        boolean loop = true;


        while(loop){

            System.out.printf("\nWelcome to airport personnel page, %s.\n",getName());

            System.out.printf("1- Personal info menu \n");
            System.out.printf("2- Change ssn\n");
            System.out.printf("3- Change password.\n");
            System.out.printf("4- Dismiss a customer.\n");
            System.out.printf("5- Exit.\n");

            choice = in.nextInt();

            switch (choice){
                case 1: super.menu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5: loop = false;
                    break;
                default:

            }
        }
    }

    @Override
    public boolean dismissCustomer( final String SSN ) throws Exception {

        if( SSN == null ) {
            throw new Exception("SSN cannot be null.");
        }

        if( SSN.equals("") ) {
            throw new Exception("SSN cannot be empty.");
        }

        if( airportSystemStorage.customers.containsKey( SSN )) {
            airportSystemStorage.customers.remove( SSN );
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSSN() {
        return SSN;
    }


    @Override
    public void setSSN( String SSN ) {
        this.SSN = SSN;
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public void setPassword( String password ) throws Exception {
        if( password == null ) {
            throw new Exception("Password cannot be null.");
        }

        this.password = password;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        AirportPersonnel that = (AirportPersonnel) o;

        return SSN.equals(that.SSN);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSN);
    }

    @Override
    public String toString() {
        return "AirportPersonnel{" +
                "SSN='" + SSN + '\'' +
                ", password='" + password + '\'' +
                ", airportSystemStorage=" + airportSystemStorage +
                '}';
    }

}
