package Products;

import java.util.Random;

public class Product {

    private int id;
    private String name;
    private int cost;

    public Product (int id, String name) {
        this.id = id;
        this.name = name;
        this.cost = getRandom();
    }

    private int getRandom () {
        return new Random().nextInt(900) + 100;
    }

    @Override
    public String toString () {
        return String.format("Num-%s Name: %s Cost: %s", id, name, cost);
    }
}
