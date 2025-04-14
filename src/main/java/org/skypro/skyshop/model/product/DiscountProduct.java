package org.skypro.skyshop.model.product;

import java.util.UUID;

public class DiscountProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountProduct(UUID id, String name, int basePrice, int discountPercent) {
        super(id, name);
        if (basePrice < 1) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть в пределах 0-100%");
        }
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getPrice() {
        return basePrice - basePrice * discountPercent / 100;
    }

    @Override
    public String toString() {
        return "<" + name + ">:<" + (basePrice - basePrice * discountPercent / 100) + ">(<" + discountPercent + ">%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
