package org.skypro.skyshop.model.product;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int PRICE = 260;

    public FixPriceProduct(UUID id, String name) {
        super(id, name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return "<" + getName() + ">:Фиксированная цена<" + PRICE + ">";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
