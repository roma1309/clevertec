package org.example.model.entity;

public class Product {
    private Long id;
    private String name;
    private int count;
    private double price;
    private boolean isStock;

    public Product() {
    }

    public Product(Long id, String name, int count, double price, boolean isStock) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.isStock = isStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isStock() {
        return isStock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", isStock=" + isStock +
                '}';
    }
}
