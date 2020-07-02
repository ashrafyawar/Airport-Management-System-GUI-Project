package Airport;

import Client.Person;
import Client.UserInterface;

import java.util.Objects;
import java.util.Scanner;

/**ShopManager class, Manager of shops uses this class' methods.*/
public class ShopManager extends Person
        implements UserInterface , ShopManagerInterface {

    /**Social security number, stored as String.*/
    private String SSN;

    /**Password to log in, stored as String.*/
    private String password;

    /**Fee of the manager.*/
    private Double managedFee;

    /**Helps to reach AirportSystemStorage class' data.*/
    private AirportSystemStorage airportSystemStorage;

    /**Method to assign a shop's manager to this manager.
     * @param shop to change shop's manager.
     * @return boolean value, false if shop is not found.*/
    private boolean authenticateManager(Shop shop ) throws Exception {

        if( shop == null ) {
            throw new Exception("Shop cannot be null.");
        }

        return shop.getShopManager() == this;
    }

    /** ShopManager constructor.
     * @param name As the name of user.
     * @param surname As the surname of user.
     * @param password As the password of the user, that helps logging in.
     * @param SSN as new SSN.
     * @param managedFee as the managed fee of user.
     * @throws Exception if managed fee is negative.
     * */
    public ShopManager( String name, String surname , final String SSN , final String password , Double managedFee
            , final AirportSystemStorage airportSystemStorage ) throws Exception {
        super(name, surname);

        this.SSN = SSN;
        this.password = password;
        this.airportSystemStorage = airportSystemStorage;

        if( managedFee < 0 ) {
            throw new Exception("ManagedFee cannot be negative.");
        } else {
            this.managedFee = managedFee;
        }
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
            System.out.printf("4- Get managed total fee.\n");
            System.out.printf("5- See all shops.\n");
            System.out.printf("6- Open a shop.\n");
            System.out.printf("7- Close a shop.\n");
            System.out.printf("8- Exit.\n");

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
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8: loop = false;
                    break;
                default: System.out.printf("Error. Your input is invalid..\n");
            }
        }
    }


    /**get method for managedFee.
     * @return double value of managedFee.*/
    public Double getManagedFee() {
        return managedFee;
    }

    /**set method for managedFee
     * @param managedFee as new managed fee.*/
    public void setManagedFee(double managedFee) {
        this.managedFee = managedFee;
    }

    @Override
    public void openShop( Shop shop ) throws Exception {

        if( authenticateManager( shop ) ) {
            throw new Exception("Authentication failed for shop manager.");
        }

        if( shop.isInService()  ) {
            System.out.println( shop.getName() + " is already in-service.");
        } else {
            shop.setInService( true );
            System.out.println( shop.getName() + " has been opened up.");
        }
    }

    @Override
    public void closeShop( Shop shop ) throws Exception {

        if( authenticateManager( shop ) ) {
            throw new Exception("Authentication failed for shop manager.");
        }

        if( shop.isInService()  ) {
            System.out.println( shop.getName() + " has been closed up.");
        } else {
            shop.setInService( true );
            System.out.println( shop.getName() + " is already out of service.");
        }

    }

    @Override
    public void setName( Shop shop  , final String newName ) throws Exception {

        if( authenticateManager( shop ) ) {
            throw new Exception("Authentication failed for shop manager.");
        }

        if( newName.equals( shop.getName() )) {
            System.out.println( shop.getName() + " is already equivalent with given name.");
        } else {
            System.out.println( "Shop name changed from " + shop.getName() + " to " + newName );
            shop.setName( newName );
        }
    }

    @Override
    public String getSSN() {
        return SSN;
    }

    @Override
    public void setSSN( String SSN ) throws Exception {

        if( SSN == null ) {
            throw new Exception("SSN cannot be null.");
        }

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

        ShopManager that = (ShopManager) o;

        return SSN.equals(that.SSN);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), SSN);
    }


    @Override
    public int compareTo(Person person) {

        ShopManager shopManager;

        try {
            shopManager = (ShopManager) person;
        }
        catch ( Exception e ) {
            return 1;
        }

        return this.getManagedFee().compareTo( shopManager.getManagedFee() );
    }

}
