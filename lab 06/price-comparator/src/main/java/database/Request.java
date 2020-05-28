package database;

public class Request {
    private String productName;
    private int counter;

    public Request(String productName, int counter) {
        this.productName = productName;
        this.counter = counter;
    }

    public String getProductName() {
        return productName;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Request{" +
                "productName='" + productName + '\'' +
                ", counter=" + counter +
                '}';
    }

    void incrementCounter() {
        this.counter++;
    }
}
