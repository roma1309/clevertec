package org.example.model;

public class ProductInCheck {

    private Long id;
    private String name;
    private int count;

    private boolean isStock;
    private double cost;
    private double stock;
    private double total;

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

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public void setStock(boolean stock) {
        isStock = stock;
    }


    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductInCheck{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", isStock=" + isStock +
                ", cost=" + cost +
                ", stock=" + stock +
                ", total=" + total +
                '}';
    }
}
