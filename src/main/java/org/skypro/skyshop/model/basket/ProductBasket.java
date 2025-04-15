package org.skypro.skyshop.model.basket;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@SessionScope
public class ProductBasket {
    private final Map<UUID, Integer> productBasket = new HashMap<>();

    public void addProductToBasket(UUID id) {
        int quantity = 0;
        if(productBasket.containsKey(id)) {
            quantity = productBasket.get(id);
        }
        productBasket.put(id, ++quantity);
    }

    public Map<UUID, Integer> getProductBasket() {
        return Collections.unmodifiableMap(productBasket);
    }
}




