import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private int itemCount;
    private double itemCost;
    private double discount;
    private double shippingCost;
    private List<OrderObserver> observers;

    public Order(int id) {
        this.id = id;
        this.itemCount = 0;
        this.itemCost = 0.0;
        this.discount = 0.0;
        this.shippingCost = 10.0;
        this.observers = new ArrayList<>();
    }

    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    public void detach(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void addItem(double price) {
        this.itemCount++;
        this.itemCost += price;
        notifyObservers();
    }

    public double getTotalPrice() {
        return (itemCost - discount) + shippingCost;
    }

    public int getCount() {
        return itemCount;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String toString() {
        return "Order number : " + id +
                "\n" + "Items: " + itemCount + 
                "\n" + "Items cost: $" + itemCost + 
                "\n" + "Discount: $" + discount + 
                "\n" + "Shipping cost: $" + shippingCost + 
                "\n" + "Total: $" + getTotalPrice();
    }
}