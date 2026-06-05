public class StandardParcel extends Parcel {

    public StandardParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getCost() {
        return STANDARD_PARCEL_COST;
    }
}
