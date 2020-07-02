package Airport;
import Airline.*;
import DataStructures.Edge;
import DataStructures.MapGraph;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**AirportSystemStorage class. Has various information and methods for airport.*/
public class AirportSystemStorage {

    /**AirportSystemStorage constructor.*/
    public AirportSystemStorage() {

        airlines            = new TreeMap< String , Airline>();
        flights             = new TreeMap<Integer, Flight>();
        airportPersonnel    = new ArrayList<AirportPersonnel>();
        customers           = new TreeMap< String , Customer>();
        places              = new ArrayList<Place>();
        shopManagers        = new PriorityQueue<ShopManager>();

        airportFund = 0;

       destinations = new ArrayList<Destination>();
       destinations.add(new Destination("Istanbul",0.0,0.0));
       destinations.add(new Destination("Ankara",50.0,25.0));
       destinations.add(new Destination("Izmir",80.0,10.0));

       ways = new MapGraph(15,false);
    }

    /**airportFund, represents airport's total money.*/
    double airportFund;

    TreeMap< String , Airline >     airlines;
    TreeMap< Integer , Flight >     flights;
    ArrayList<AirportPersonnel>     airportPersonnel;
    TreeMap< String , Customer >    customers;
    ArrayList<Place>                places;         /* included shops */
    PriorityQueue<ShopManager>      shopManagers;

    ArrayList<Destination> destinations;
    MapGraph ways;

    public boolean isWay(Destination destination){
        return ways.isEdge(0,destinations.indexOf(destination));
    }

    /* Destination  MapGraph */

    public boolean isValidSSN( String SSN ){

        AtomicBoolean a= new AtomicBoolean(true); // multi thread operationlar da falanda kullanılan bir veri yapısı
        getCustomers().forEach((k,v)->{
            if(SSN.equals(k))
                a.set(false);
        });

        return a.getPlain();

    }

    public double getAirportFund() {
        return airportFund;
    }

    public void setAirportFund(double airportFund) {
        this.airportFund = airportFund;
    }

    public TreeMap< String , Airline > getAirlines() {
        return airlines;
    }

    public void setAirlines(TreeMap< String , Airline > airlines) {
        this.airlines = airlines;
    }

    public TreeMap< Integer , Flight> getFlights() {
        return flights;
    }

    public void setFlights(TreeMap< Integer , Flight > flights) {
        this.flights = flights;
    }

    public ArrayList<AirportPersonnel> getAirportPersonnel() {
        return airportPersonnel;
    }

    public void setAirportPersonnel(ArrayList<AirportPersonnel> airportPersonnel) {
        this.airportPersonnel = airportPersonnel;
    }

    public TreeMap<String,Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(TreeMap<String,Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public PriorityQueue<ShopManager> getShopManagers() {
        return shopManagers;
    }

    public void setShopManagers(PriorityQueue<ShopManager> shopManagers) {
        this.shopManagers = shopManagers;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }
}
