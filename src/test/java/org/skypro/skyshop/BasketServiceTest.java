package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.exceptions.NoSuchProductException;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.service.BasketService;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private StorageService storageService;
    @Mock
    private ProductBasket productBasket;

    @InjectMocks
    private SearchService searchServiceTest = new SearchService(storageService);
    @InjectMocks
    private BasketService basketServiceTest = new BasketService(productBasket, storageService);


    @Test
    public void givenEmptyBasket_WhenGetProductBasket_ThenReturnEmpty() {
        ProductBasket productBasket = new ProductBasket();
        Map<UUID, Integer> result = productBasket.getProductBasket();
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void givenNonEmptyBasket_WhenGetProductBasket_ThenReturnCollection() {
        UUID id = UUID.randomUUID();
        Product product = new SimpleProduct(id, "Болт", 100);
        ProductBasket productBasket = new ProductBasket();
        BasketService basketService = new BasketService(productBasket, storageService);
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.of(product));
        basketService.setProductInBasket(id);
        Map<UUID, Integer> result = productBasket.getProductBasket();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void givenAddProductToBasket_whenAddingProduct_thenCallAddProduct() {
        UUID id  = UUID.randomUUID();
        Product product = new SimpleProduct(id, "Болт", 100);
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.of(product));
        BasketService basketService = new BasketService(productBasket, storageService);
        basketService.setProductInBasket(id);
        Mockito.verify(productBasket).addProductToBasket(id);
    }


    @Test
    public void givenInvalidProduct_WhenAddProductToBasket_ThenThrowException() {
        UUID id = UUID.randomUUID();
        Mockito.when(storageService.getProductById(id)).thenReturn(Optional.empty());
        ProductBasket productBasket = new ProductBasket();
        BasketService basketService = new BasketService(productBasket, storageService);
        Exception exception = null;
        try {
            basketService.setProductInBasket(id);
        } catch (Exception e) {
            exception = e;
        }
        Assertions.assertEquals(exception.getClass() , NoSuchProductException.class);
    }

}