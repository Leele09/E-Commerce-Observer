public class Client {
    public static void main(String[] args) {
        Order myOrder = new Order(101);

        PriceObserver priceMonitor = new PriceObserver();
        QuantityObserver quantityMonitor = new QuantityObserver();
        
        // Attach the Observers to the Order
        myOrder.attach(priceMonitor);
        myOrder.attach(quantityMonitor);

        // Add first item
        System.out.println("\n--------------------------");
        myOrder.addItem(50.0);
        System.out.println(myOrder.toString());
        System.out.println("--------------------------");

        // Add second item, and see the price discount
        System.out.println("\n--------------------------");
        myOrder.addItem(160.0);
        System.out.println(myOrder.toString());
        System.out.println("--------------------------");

        // Add more than 5 items to the order to be abel to see the shiping discount
        System.out.println("\n--------------------------");
        myOrder.addItem(5.0);
        myOrder.addItem(5.0);
        myOrder.addItem(5.0);
        myOrder.addItem(5.0);
        System.out.println(myOrder.toString());
        System.out.println("--------------------------");
    }
}