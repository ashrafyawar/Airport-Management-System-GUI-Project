package Airport;

import java.util.Objects;

/** Shop class that has information of the class.*/
public class Shop extends Place implements ShopInterface {

    /**Name of the shop.*/
    private String name;

    /**Fee of the shop.*/
    private int fee;

    /**Manager of the shop, as ShopManager class.*/
    private ShopManager shopManager;

    /**This boolean is true if, it is in service.*/
    private boolean inService;

    /** Shop constructor.
     * @param name As the name of shop.
     * @param shopManager As the shop manager of the shop.
     * @param fee As fee of the shop.
     * @param id as id of the shop.
     * */
    public Shop( final String name ,ShopManager shopManager , final int fee , final String id ) {
        super( PlaceType.SHOP , id );

        this.name = name;
        this.shopManager = shopManager;
        this.fee = fee;
        this.inService = true;
    }

    @Override
    public int getFee() {
        return fee;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ShopManager getShopManager() {
        return shopManager;
    }

    @Override
    public String getID() {
        return super.getID();
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public void setType(PlaceType type) {
        super.setType(type);
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public void setShopManager(ShopManager shopManager) {
        this.shopManager = shopManager;
    }

    public boolean isInService() {
        return inService;
    }

    /** Method to compare an object to this.
     * @param o Object to compare.
     * @return true if they are equal.*/
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass() ) return false;

        if (!super.equals(o)) return false;

        Shop shop = (Shop) o;

        return fee == shop.fee &&
                name.equals(shop.name) &&
                shopManager.equals(shop.shopManager);
    }

    /** Method that retursn hashcode of object.
     * @return hashCode, as integer.*/
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, fee, shopManager);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    /** toString method to represent the object in form of string.
     * @return String format.*/
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", fee=" + fee +
                ", status=" + inService +
                ", shopManager=" + shopManager +
                ", type=" + type +
                ", id='" + id + '\'' +
                '}';
    }

}
