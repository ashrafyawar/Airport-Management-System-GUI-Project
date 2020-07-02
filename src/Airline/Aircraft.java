package Airline;

import java.util.Comparator;

/**
 * Informative class which has several properties about Aircraft.
 * @author Nevzat Seferoglu
 * @version 1.1
 */
public class Aircraft {

    /* --------------------------- */
    /* Properties */

    /**Holds the type as String.*/
    final String typeInfo;

    /**Origin of Country*/
    final String originAsCountry;

    /***/
    final Integer registrationInfo;

    /**Holds the date that plane has been manufactured.*/
    final String manufacturingDate;

    /**Serial information of aircraft. As string format.*/
    final String serialInfo;

    /***/
    final String manufacturerInfo;

    /**Span of wing, affects flight score.*/
    final Double wingspan;

    /**Number of passengers, that can be in the plane at the same time.*/
    final Double passengerCapacity;

    /**Empy weight (kg) affects flight score.*/
    final Double emptyWeightAsKg;

    /**Max fuel cap can tell us how that plane can go far.*/
    final Double maxFuelCapacity;
    /*-----------------------------*/

    int compareScore;
    static int flightScore;

    /**Aircraft Constructor
     * @param typeInfo
     * @param originAsCountry
     * @param registrationInfo
     * @param manufacturingDate
     * @param serialKey
     * @param manufacturerInfo
     * @param wingspan
     * @param passengerCapacity
     * @param emptyWeightAsKg
     * @param maxFuelCapacity
     * */
    Aircraft(String typeInfo, String originAsCountry, int registrationInfo, String manufacturingDate,
             String serialKey, String manufacturerInfo, Double wingspan, Double passengerCapacity, Double emptyWeightAsKg, Double maxFuelCapacity) {

        this.typeInfo = typeInfo;
        this.originAsCountry = originAsCountry;
        this.registrationInfo = registrationInfo;
        this.manufacturingDate = manufacturingDate;
        this.serialInfo = serialKey;
        this.manufacturerInfo = manufacturerInfo;
        this.wingspan = wingspan;
        this.passengerCapacity = passengerCapacity;
        this.emptyWeightAsKg = emptyWeightAsKg;
        this.maxFuelCapacity = maxFuelCapacity;

    }

    public int getCompareScore() {
        return compareScore;
    }

    public static int getFlightScore() {
        return flightScore;
    }

    public Double getEmptyWeightAsKg() {
        return emptyWeightAsKg;
    }

    public Double getPassengerCapacity() {
        return passengerCapacity;
    }

    public Double getWingspan() {
        return wingspan;
    }

    public String getManufacturerInfo() {
        return manufacturerInfo;
    }

    public String getOriginAsCountry() {
        return originAsCountry;
    }

    public String getSerialInfo() {
        return serialInfo;
    }

    public String getManufacturingDate() {
        return manufacturingDate;
    }

    public int getRegistrationInfo() {
        return registrationInfo;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public static void setFlightScore(int flightScore) {Aircraft.flightScore = flightScore;}

    public void assignCompare(){
        compareScore=Math.abs(getFlightScore()-getScore());
    }

    @Override
    public String toString() {

        return " Type : " + getTypeInfo() + '\n' +
                " Registration : " + getRegistrationInfo() + '\n' +
                " Country of region : " + getOriginAsCountry() + '\n' +
                " Trademark of Manufacturer : " + getManufacturerInfo() + '\n' +
                " Manufacturing Date : " + getManufacturingDate() + '\n' +
                " Serial Number : " + getSerialInfo() + '\n' +
                " Wingspan length : " + getWingspan() + '\n' +
                " Passenger capacity : " + getPassengerCapacity() + '\n' +
                " Empty weight : " + getEmptyWeightAsKg() + '\n';
    }

    /**
     * To get Comparator for using sort algorithms.
     * Switch structure used to determine which feature is
     * gonna be used in sorting
     * @return Comparator to make sorting
     */
    public static Comparator<Aircraft> getComparator(){
        Comparator<Aircraft> comparator = new Comparator<Aircraft>() {
            @Override
            public int compare(Aircraft aircraft, Aircraft t1) {
                return Math.abs(aircraft.getCompareScore()-t1.getCompareScore());
            }
        };
        return comparator;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj ==  this ) {
            return true;
        } else if( !(obj instanceof Aircraft) ) {
            return true;
        }

        return ((Aircraft) obj).typeInfo.equals( this.typeInfo ) &&
                ((Aircraft) obj).originAsCountry.equals( this.originAsCountry ) &&
                ((Aircraft) obj).registrationInfo.equals( this.registrationInfo ) &&
                ((Aircraft) obj).manufacturingDate.equals( this.manufacturingDate ) &&
                ((Aircraft) obj).serialInfo.equals( this.serialInfo ) &&
                ((Aircraft) obj).manufacturerInfo.equals( this.manufacturerInfo ) &&
                ((Aircraft) obj).wingspan.equals( this.wingspan ) &&
                ((Aircraft) obj).passengerCapacity.equals( this.passengerCapacity ) &&
                ((Aircraft) obj).emptyWeightAsKg.equals( this.emptyWeightAsKg ) &&
                ((Aircraft) obj).manufacturingDate.equals( this.manufacturingDate ) &&
                ((Aircraft) obj).maxFuelCapacity.equals( this.maxFuelCapacity );
    }

    public int getScore(){

        int score = 0;
        int temp = 0;

        temp = (int)(maxFuelCapacity - 20)/15 ;
        if(temp < 0 ) temp = 0;
        else if(temp > 10) temp = 10;
        score +=  temp;

        temp = (int)(getPassengerCapacity() - 100) / 40;
        if(temp < 0 ) temp = 0;
        else if(temp > 10) temp = 10;
        score +=  temp;

        temp = (int)(getEmptyWeightAsKg() - 50) / 15;
        if(temp < 0 ) temp = 0;
        else if(temp > 10) temp = 10;
        score +=  temp;

        return score;
    }
}

