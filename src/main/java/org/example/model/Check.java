package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Check {

    private List<ProductInCheck> product = new ArrayList<>();
    private double totalStock;
    private double cost;
    private double totalCost;

    public Check() {
    }

    public List<ProductInCheck> getProduct() {
        return product;
    }

    public void setProduct(List<ProductInCheck> product) {
        this.product = product;
    }

    public double getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(double totalStock) {
        this.totalStock = totalStock;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost() {
        double totalCost = 0;
        for (ProductInCheck productInCheck : product) {
            totalCost += productInCheck.getTotal();
        }
        this.totalCost = totalCost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Check{" +
                "product=" + product +
                ", totalStock=" + totalStock +
                ", cost=" + cost +
                ", totalCost=" + totalCost +
                '}';
    }
}
