package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
public class ShopController {

    public ShopController() {
    }

    @GetMapping("/products")
    public Map getAllProducts() {
        return new StorageService().getProducts();
    }

    @GetMapping("/articles")
    public Map getAllArticles() {
        return new StorageService().getArticles();
    }

    @GetMapping("/all")
    public Map getAll() {
        return new StorageService().getSearchable();
    }

    @GetMapping("/search")
    public List<SearchResult> searchpattern(@RequestParam("pattern") String pattern) {
        return new SearchService(new StorageService()).search(pattern);
    }


}
