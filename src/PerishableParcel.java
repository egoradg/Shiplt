public class PerishableParcel extends Parcel {
    private final int timeToLive;

    public PerishableParcel(String description, double weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive=timeToLive;
    }

    @Override
    public int getCost() {
        return PERISHABLE_PARCEL_COST;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    public boolean isExpired(int currentDay) {
        return currentDay - sendDay > timeToLive;
    }
}
