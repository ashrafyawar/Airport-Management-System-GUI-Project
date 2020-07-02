package Airline;
import DataStructures.MapGraph;

import java.util.*;

public class AirlineSystemStorage {


    int aircraft_counter;
    public int increment_Aircraft_counter() {
        return ++aircraft_counter;
    }

    public AirlineSystemStorage( AirlineAdmin admin , String nameOfTrademarkAsIdentifier , final String uaid_key , MapGraph ways , ArrayList<Destination> dests)  {

        this.admin = admin;
        aircraft_counter = 0;
        listOfTicket = new HashMap<Integer , Ticket>();
        pilots = new LinkedList<AirlinePersonnel>();
        cabin_crew = new LinkedList<AirlinePersonnel>();
        listOfAirCraft = new ArrayList<Aircraft>();
        /* Destionation initialization */

        this.UAID_KEY = uaid_key;
        this.nameOfTrademarkAsIdentifier = nameOfTrademarkAsIdentifier;

        this.ways = ways;
        this.dests = dests;
    }

    public ArrayList<Destination> dests;
    public MapGraph ways;

    /**
     * <p> Unique Airline Identifier Key. </p>
     * <p> Each airline company has matchless one for each Airport.</p>
     */
    private final transient String UAID_KEY;

    /**
     * Trademark of airline.
     */
    private String nameOfTrademarkAsIdentifier;

    private Map<Integer,Ticket>             listOfTicket; // hashmap kullanılabilir

    /**
     * List of pilots.
     */
    private Queue<AirlinePersonnel>         pilots;

    /**
     * List of cabin_crew.
     */
    private Queue<AirlinePersonnel>         cabin_crew;


    /**
     * List of admin.
     */
    private AirlineAdmin admin;


    /**
     * Aircraft Container.
     */
    private ArrayList< Aircraft >       listOfAirCraft;


    /**
     * Destination Container.
     */
    private Collection< Destination > listOfDestination; // mapGraph implement edilecek


    /*------------------------------------------ Getters -------------------------------------*/

    /**
     * Get aircraft List
     * @return list of aircraft.
     */
    public ArrayList<Aircraft> getListOfAirCraft() {
        return listOfAirCraft;
    }


    /**
     * Get Destination List
     * @return list of destination.
     */
    public Collection<Destination> getListOfDestination() {
        return listOfDestination;
    } // mapGraph yapılacak


    public Map<Integer,Ticket> getListOfTicket() {
        return listOfTicket;
    }
    public int getAircraftCounter() {
        return aircraft_counter;
    }
    public Queue<AirlinePersonnel> getCabin_crew() {
        return cabin_crew;
    }
    public Queue<AirlinePersonnel> getPilots() {
        return pilots;
    }

    private ArrayList<Flight> listOfFlight;

    public ArrayList<Flight> getListOfFlight() {
        return listOfFlight;
    }

    public String getNameOfTrademarkAsIdentifier() {
        return nameOfTrademarkAsIdentifier;
    }

    public String getUAID_KEY() {
        return UAID_KEY;
    }

    public void setNameOfTrademarkAsIdentifier(String nameOfTrademarkAsIdentifier) {
        this.nameOfTrademarkAsIdentifier = nameOfTrademarkAsIdentifier;
    }

}