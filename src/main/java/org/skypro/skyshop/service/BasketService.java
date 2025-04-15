package org.skypro.skyshop.service;

import org.skypro.skyshop.model.basket.ProductBasket;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket basketProduct;
    private final StorageService serviceStorage;

    public BasketService(ProductBasket basketProduct, StorageService serviceStorage) {
        this.basketProduct = basketProduct;
        this.serviceStorage = serviceStorage;
    }

    public void setProductInBasket(UUID id) {
        if (!serviceStorage.getProductById(id).isPresent()) {
            throw new IllegalArgumentException("Класс BasketSevice: Несуществующий ID");
        }
        basketProduct.addProductToBasket(id);
    }

    public UserBasket getUserBasket() {

        return new UserBasket(
                basketProduct.getProductBasket().entrySet().stream()
                        .map(i -> new BasketItem(serviceStorage.getProductById(i.getKey()).orElseThrow(),
                                i.getValue()))
                        .collect(Collectors.toList()));

    }
}







