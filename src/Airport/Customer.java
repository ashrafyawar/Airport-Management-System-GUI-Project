package Airport;

import Airline.Flight;
import Airline.FlightCompareTo;
import Airline.Ticket;
import Client.Person;
import Client.UserInterface;


import java.util.*;

/**Customer class. Users can buy ticket here, see flights...*/
public class Customer extends Person
        implements UserInterface ,  CustomerInterface {

    /**Ticket TreeMap. Uses integer values as key.*/
    private TreeMap<Integer,Ticket> tickets;

    /**compare to hold as Enum*/
    static CustomerCompareTo customerCompareTo;

    /**Social security number, stored as String.*/
    private String SSN;

    /**Password to log in, stored as String.*/
    private String password;

    /**Helps to reach AirportSystemStorage class' data.*/
    AirportSystemStorage airportSystemStorage;

    /** Customer constructor.
     * @param name As the name of user.
     * @param surname As the surname of user.
     * @param SSN As the SSN of user.
     * @param password As the password of the user, that helps logging in.
     * @param airportSystemStorage As current airport to be in.
     * @throws Exception if SSN is already used, or password is not valid.
     * */
    public Customer( String name , String surname , final String SSN , final String password
            , final AirportSystemStorage airportSystemStorage ) throws Exception {

        super( name , surname );
        if(airportSystemStorage.isValidSSN(SSN)){
            this.SSN = SSN;
            if(password == null || password.equals(""))
                throw (new Exception("Given password is not proper!"));
            else{
                this.password = password;
                tickets = new TreeMap<>();
                this.airportSystemStorage = airportSystemStorage;
            }
        }
        else {
            throw(new Exception("Given SSN is currently used!"));
        }

        customerCompareTo = CustomerCompareTo.ACCORDING_TO_NAME;
    }

    public void menu(){

        int choice;
        Scanner in = new Scanner(System.in);
        boolean loop = true,loop2 = true;


        while(loop){

            System.out.printf("\nWelcome to our airport page, %s.\n",getName());

            System.out.printf("1- Personal info menu \n");
            System.out.printf("2- Change ssn\n");
            System.out.printf("3- Change password.\n");
            System.out.printf("4- Buy Tickets.\n");
            System.out.printf("5- See your Tickets.\n");
            System.out.printf("6- See all shops.\n");
            System.out.printf("7- Exit.\n");

            choice = in.nextInt();

            switch (choice){
                case 1: super.menu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    loop2 = true;
                    while (loop2){
                        System.out.printf("1- See all flights.\n");
                        System.out.printf("2- Search a flight using PNR.\n");
                        System.out.printf("3- Buy a ticket.\n");
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
                case 5:
                    break;
                case 6:
                    break;
                case 7: loop = false;
                    break;
                default: System.out.printf("Error. Your input is invalid..\n");
            }
        }
    }

    /**get Method for tickets.
     * @return tickets , as TreeMap.*/
    public TreeMap<Integer, Ticket> getTickets() {
        return tickets;
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
    public void displayFlights() {

        airportSystemStorage.getFlights().forEach((k,v)->{
            System.out.print(k+"- "+v.customerShow());
        });

    }

    /**
     * displayFlight method prints all flights avaiable.
     * with order of flightCompareTo
     *
     * @param flightCompareTo
     */
    @Override
    public void displayFlights(FlightCompareTo flightCompareTo) {
        Flight.setFlightCompareTo(flightCompareTo);
        TreeMap<Integer,Flight> sorted = new TreeMap<>();
        airportSystemStorage.getFlights().forEach(sorted::put);
        airportSystemStorage.setFlights(sorted);
        displayFlights();
    }

    @Override
    public Ticket buyTickets( Flight flight ) {

        try {
            return airportSystemStorage.getAirlines().get( flight.getUAID_KEY() ).createTicket(this,flight);
        }catch (Exception e){
            System.out.print(e);
            return null;
        }

    }

    @Override
    public Flight searchWithPNR( final int PNR ) throws Exception {

        if(airportSystemStorage.getFlights().containsKey(PNR))
            return airportSystemStorage.getFlights().get(PNR);
        throw(new Exception("Given PNR has no ticket, please check your information carefully!"));

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        Customer customer = (Customer) o;

        return Objects.equals(SSN, customer.SSN);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), SSN);

    }

    @Override
    public String toString() {
        return "Customer{" +
                "tickets=" + tickets +
                ", SSN='" + SSN + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**Compare method that works with enums,
     * because sometimes we want to compare them with surname,
     * ticket number or SSN.
     * @param person to compare.
     * @return result of the comparison.*/
    @Override
    public int compareTo(Person person) {

        Customer customer;

        try {
            customer = (Customer) person;
        }
        catch ( Exception e ) {
            return 1;
        }

        switch ( customerCompareTo ) {

            case ACCORDING_TO_SURNAME:
                return this.getSurname().compareTo( customer.getSurname() );

            case ACCORDING_TO_TICKET_NUMBER:
                return Integer.compare(this.getTickets().size(), customer.getTickets().size());

            case ACCORDING_TO_SSN:
                return this.getSSN().compareTo( customer.getSSN() );

            default:
                return this.getName().compareTo( customer.getName() );

        }
    }

    /**
     * To get Comparator for the sake of using sort algorithms.
     * Switch structure used to determine which feature is
     * gonna be used in sorting
     * @return Comparator to make sorting
     */
    public static Comparator<Customer> getComparator(){
        Comparator<Customer> comparator = new Comparator<Customer>(){
            @Override
            public int compare(Customer t0, Customer t1) {
                switch (customerCompareTo){
                    case ACCORDING_TO_SSN:
                        return t0.getSSN().compareTo(t1.getSSN());
                    default:
                    case ACCORDING_TO_NAME:
                        return t0.getName().compareTo(t1.getName());
                    case ACCORDING_TO_SURNAME:
                        return t0.getSurname().compareTo(t1.getSurname());
                    case ACCORDING_TO_TICKET_NUMBER:
                        return t0.getTickets().size()-t1.getTickets().size();
                }
            }
        };
        return comparator;
    }
}
