package Airport;
import Airline.*;

import Client.Person;
import Client.UserInterface;
import DataStructures.Edge;
import java.util.Objects;
import java.util.Scanner;

/** AirportAdmin class for Admins of airport. Extended from Person Class.
 * This class administrates Airport business as flights, shops.. */
public class AirportAdmin extends Person implements UserInterface, AirportAdminInterface {

    /**Social security number, stored as String.*/
    private String SSN;

    /**Password to log in, stored as String.*/
    private String password;

    /**Helps to reach AirportSystemStorage class' data.*/
    private AirportSystemStorage airportSystemStorage;

    /** AirportAdmin constructor.
     * @param name As the name of user.
     * @param surname As the surname of user.
     * @param password As the password of the user, that helps logging in.
     * @param airportSystemStorage As current airport to be in.
     * @param SSN As the SSN of the user.
     * */
    public AirportAdmin(String name , String surname , final String SSN , final String password
            , final AirportSystemStorage airportSystemStorage  ) {

        super(name, surname);

        this.SSN = SSN;
        this.password = password;

        this.airportSystemStorage = airportSystemStorage;

    }

    public void menu(){

        int choice;
        Scanner in = new Scanner(System.in);
        boolean loop = true, loop2 = true;


        while(loop){

            System.out.printf("\nWelcome to %s Airport's administration page.\n",getName());
            System.out.printf("Airport's funding = %d",airportSystemStorage.getAirportFund());

            System.out.printf("1- Personal info menu \n");
            System.out.printf("2- Set SSN\n");
            System.out.printf("3- Set password.\n");
            System.out.printf("4- Airline administration.\n");
            System.out.printf("5- Airport Personnel administration.\n");
            System.out.printf("6- Shop administration.\n");
            System.out.printf("7- Destination administration.\n");
            System.out.printf("8- Exit.\n");

            choice = in.nextInt();

            switch (choice){
                case 1: super.menu(); // person's menu
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    loop2 = true;
                    while (loop2){
                        System.out.printf("1- See all airlines.\n");
                        System.out.printf("2- Add an airline.\n");
                        System.out.printf("3- Remove an airline.\n");
                        System.out.printf("4- Set Commission.\n");
                        System.out.printf("5- Exit.\n");

                        choice = in.nextInt();

                        switch (choice){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5: loop2 = false;
                                break;
                            default: System.out.printf("Error. Your input is invalid..\n");
                        }
                    }
                    break;
                case 5:
                    loop2 = true;
                    while (loop2){
                        System.out.printf("1- Add an airport personnel.\n");
                        System.out.printf("2- Remove an airport personnel.\n");
                        System.out.printf("3- See all airport personnels.\n"); // eğer hepsini göstermek istemiyorsanız çıkarın.
                        System.out.printf("4- Exit.\n");

                        choice = in.nextInt();

                        switch (choice){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4: loop2 = false;
                                break;
                            default: System.out.printf("Error. Your input is invalid..\n");
                        }
                    }
                    break;
                case 6:
                    loop2 = true;
                    while (loop2){
                        System.out.printf("1- See all shops.\n");
                        System.out.printf("2- Add a shop.\n");
                        System.out.printf("3- Remove a shop.\n");
                        System.out.printf("4- Exit.\n");

                        choice = in.nextInt();

                        switch (choice){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4: loop2 = false;
                                break;
                            default: System.out.printf("Error. Your input is invalid..\n");
                        }
                    }
                    break;
                case 7: loop = false;
                    break;
                default: System.out.printf("Error. Your input is invalid..\n");
            }
        }
    }

    public void addWay(Destination destination) throws Exception {
        Edge e = new Edge(0,airportSystemStorage.destinations.indexOf(destination));
        airportSystemStorage.ways.insertEdge(e);
    }

    public AirportSystemStorage getAirportSystemStorage() {
        return airportSystemStorage;
    }

    @Override
    public String getSSN() {
        return SSN;
    }

    @Override
    public void setSSN(String SSN) throws Exception {
        if( SSN == null || SSN.equals( "" ) ) {
            throw new Exception("SSN cannot be empty or null.");
        }
        this.SSN = SSN;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) throws Exception {
        if( password == null || password.equals( "" ) ) {
            throw new Exception("password cannot be empty or null.");
        }
        this.password = password;
    }

    @Override
    public boolean addAirportPersonnel( AirportPersonnel airportPersonnel) throws Exception {

        if( airportPersonnel == null ) {
            throw new Exception("AirportPersonnel cannot be null.");
        }

        if( airportSystemStorage.airportPersonnel.contains( airportPersonnel ) ) {
            return false;
        } else {
            airportSystemStorage.airportPersonnel.add( airportPersonnel );
            return true;
        }

    }

    @Override
    public boolean removeAirportPersonnel(AirportPersonnel airportPersonnel) throws Exception {

        if( airportPersonnel == null ) {
            throw new Exception("AirportPersonnel cannot be null.");
        }

        return airportSystemStorage.airportPersonnel.remove(airportPersonnel);
    }

    @Override
    public boolean addShop(Shop shop) throws Exception {

        if( shop == null ) {
            throw new Exception("Shop cannot be null.");
        }

        if( airportSystemStorage.places.contains( shop ) ) {
            return false;
        } else {
            airportSystemStorage.places.add( shop );
            return true;
        }

    }

    @Override
    public boolean removeShop(Shop shop) throws Exception {

        if( shop == null ) {
            throw new Exception("Shop cannot be null.");
        }

        return airportSystemStorage.places.remove(shop);
    }

    @Override
    public boolean addAirline(Airline airline) throws Exception {

        if( airline == null ) {
            throw new Exception("Airline cannot be null.");
        }

        if( airportSystemStorage.airlines.containsValue( airline ) ) {
            return false;
        } else {
            airportSystemStorage.airlines.put( airline.getUAID_KEY() , airline );
            return true;
        }

    }

    @Override
    public boolean removeAirline(Airline airline) throws Exception {

        if( airline == null ) {
            throw new Exception("Airline cannot be null.");
        } else {
            return airportSystemStorage.airlines.remove( airline.getUAID_KEY() , airline );
        }
    }

    @Override
    public double getAirportFund() {
        return airportSystemStorage.airportFund;
    }

    @Override
    public boolean setCommissionRate( Airline airline , final double commissionRate ) throws Exception {

        if( airline == null ) {
            throw new Exception("Airline cannot be null.");
        }

        if( commissionRate < 0 ) {
            throw new Exception("Commission-Rate cannot be negative number.");
        }

        if( !airportSystemStorage.airlines.containsValue( airline ) ) {
            return false;
        } else {
            airline.setCommissionRate( commissionRate );
            return true;
        }
    }

    @Override
    public boolean addDestination(Destination destination) throws Exception {

        if( destination == null ) {
            throw new Exception("Destination cannot be null.");
        }
        else {
            airportSystemStorage.destinations.add(destination);
            return true;
        }

    }

    @Override
    public boolean removeDestination(Destination destination) throws Exception {

        if( destination == null ) {
            throw new Exception("Destination cannot be null.");
        }
        else {
            airportSystemStorage.destinations.remove(destination);
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        AirportAdmin that = (AirportAdmin) o;

        return SSN.equals(that.SSN);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSN);
    }

    @Override
    public String toString() {
        return "AirportAdmin{" +
                "SSN='" + SSN + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
