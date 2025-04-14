package org.skypro.skyshop.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component

public final class UserBasket {
    private List<BasketItem> basketItems;
    private Long total;

    public UserBasket(List<BasketItem> basketItems) {
        this.basketItems = basketItems;

        total = basketItems.stream()
                .mapToLong(p -> (p.getProduct().getPrice() * p.getQuantity()))
                .sum();
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public Long getTotal() {
        return total;
    }
}
