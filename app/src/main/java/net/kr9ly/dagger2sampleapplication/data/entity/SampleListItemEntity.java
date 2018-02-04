package net.kr9ly.dagger2sampleapplication.data.entity;

public class SampleListItemEntity {

    private final int id;

    private final String name;

    private final int quantity;

    public SampleListItemEntity(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
