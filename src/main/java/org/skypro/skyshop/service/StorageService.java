package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class StorageService {

    private final HashMap<UUID, Product> productHashMap = new HashMap<>();
    private final HashMap<UUID, Article> articleHashMap = new HashMap<>();

    public StorageService() {
        setAllStorageValues();
    }

    public HashMap getProducts() {
        return productHashMap;
    }

    public HashMap getArticles() {
        return articleHashMap;
    }

    public HashMap getSearchable() {
        HashMap allInOne = new HashMap();
        allInOne.putAll(articleHashMap);
        allInOne.putAll(productHashMap);
        return allInOne;
    }

    private void setAllStorageValues() {

        Product product = new FixPriceProduct(UUID.randomUUID(), "Глухарь");
        this.productHashMap.put(product.getId(), product);
        product = new DiscountProduct(UUID.randomUUID(), "Рымболт", 500, 5);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Шайба", 100);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Гвоздь", 50);
        this.productHashMap.put(product.getId(), product);
        product = new FixPriceProduct(UUID.randomUUID(), "Саморез");
        this.productHashMap.put(product.getId(), product);
        product = new DiscountProduct(UUID.randomUUID(), "Винт", 100, 10);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт М5", 10);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 15);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 20);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 30);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 80);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 100);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 130);
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 150);
        this.productHashMap.put(product.getId(), product);
        product = new DiscountProduct(UUID.randomUUID(), "Гвоздь", 50, 20);
        this.productHashMap.put(product.getId(), product);
        product = new FixPriceProduct(UUID.randomUUID(), "Шуруп");
        this.productHashMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Гровер", 100);
        this.productHashMap.put(product.getId(), product);

        Article article = new Article("Наиболее длинный Гвоздь в названии статьи",
                "Гвоздь или Гвоздь? Болт или Болт?");
        this.articleHashMap.put(article.getId(), article);
        article = new Article("Гвоздь совсем маленький", "Гвоздь. Болт.");
        this.articleHashMap.put(article.getId(), article);
        article = new Article("Гвоздь", "Гвоздь одноразрядный");
        this.articleHashMap.put(article.getId(), article);
        article = new Article("Гвоздь поменьше (но все равно норм)", "Гвоздь - Гвоздь или Гвоздь, Болт - Болт");
        this.articleHashMap.put(article.getId(), article);
        article = new Article("Гвоздь", "Гвоздь Гвоздь - не Болт не Болт");
        this.articleHashMap.put(article.getId(), article);
        article = new Article("Болт", "Гвоздь Гвоздь - не Болт и недостаточно гвоздей для критерия BestResult");
        this.articleHashMap.put(article.getId(), article);
        article = new Article("Молоток", "Гвоздь Гвоздь Гвоздь Гвоздь Гвоздь - забиваем молотком такое многообразие гвоздей в статье для демонстрации BestResult");
        this.articleHashMap.put(article.getId(), article);
    }

}

