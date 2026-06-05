public abstract class Parcel {
    protected String description;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;

    protected static final int STANDARD_PARCEL_COST=2;
    protected static final int FRAGILE_PARCEL_COST=4;
    protected static final int PERISHABLE_PARCEL_COST=3;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    public abstract int getCost();

    public int calculateDeliveryCost() {
            return (int) weight*getCost();
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }
}
