package Airport;

import Airline.Flight;
import Airline.FlightCompareTo;
import Airline.Ticket;

/**Customer interface used for Customers*/
public interface CustomerInterface {

   /**displayFlight method prints all flights avaiable.*/
   void displayFlights();

   /**displayFlight method prints all flights avaiable.
    * with order of flightCompareTo
    * */
   void displayFlights(FlightCompareTo flightCompareTo);

   /**Method to buy ticket from a flight.
    * @param flight to buy ticket from.
    * @return a Ticket, represents a ticket from that flight.*/
   Ticket buyTickets( Flight flight );

   /** Method to search with PNR.
    * @param PNR to search on.*/
   Flight searchWithPNR( final int PNR ) throws Exception;

}
