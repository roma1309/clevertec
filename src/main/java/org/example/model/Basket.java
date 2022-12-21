package org.example.model;

import java.util.Objects;

public class Basket {

    private Long idProduct;
    private int countProduct;

    public Basket() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return idProduct == basket.idProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct);
    }
}
