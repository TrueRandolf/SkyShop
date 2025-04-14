package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {

    private final Map<UUID, Product> productMap = new HashMap<>();
    private final Map<UUID, Article> articleMap = new HashMap<>();

    public StorageService() {
        setAllStorageValues();
    }

    public Collection<Product> getProducts() {
        return productMap.values();
    }

    public Collection<Article> getArticles() {
        return articleMap.values();
    }

    public List<Searchable> getSearchables() {
        List<Searchable> searchables = new LinkedList<>();
        searchables.addAll(productMap.values());
        searchables.addAll(articleMap.values());
        return searchables;
    }

    private void setAllStorageValues() {
        Product product = new FixPriceProduct(UUID.randomUUID(), "Глухарь");
        this.productMap.put(product.getId(), product);
        product = new DiscountProduct(UUID.randomUUID(), "Рымболт", 500, 5);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Шайба", 100);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Гвоздь", 50);
        this.productMap.put(product.getId(), product);
        product = new FixPriceProduct(UUID.randomUUID(), "Саморез");
        this.productMap.put(product.getId(), product);
        product = new DiscountProduct(UUID.randomUUID(), "Винт", 100, 10);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт М5", 10);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 15);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 20);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 30);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 80);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 100);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 130);
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Болт", 150);
        this.productMap.put(product.getId(), product);
        product = new DiscountProduct(UUID.randomUUID(), "Гвоздь", 50, 20);
        this.productMap.put(product.getId(), product);
        product = new FixPriceProduct(UUID.randomUUID(), "Шуруп");
        this.productMap.put(product.getId(), product);
        product = new SimpleProduct(UUID.randomUUID(), "Гровер", 100);
        this.productMap.put(product.getId(), product);

        Article article = new Article(UUID.randomUUID(), "Наиболее длинный Гвоздь в названии статьи",
                "Гвоздь или Гвоздь? Болт или Болт?");
        this.articleMap.put(article.getId(), article);
        article = new Article(UUID.randomUUID(), "Гвоздь совсем маленький", "Гвоздь. Болт.");
        this.articleMap.put(article.getId(), article);
        article = new Article(UUID.randomUUID(), "Гвоздь", "Гвоздь одноразрядный");
        this.articleMap.put(article.getId(), article);
        article = new Article(UUID.randomUUID(), "Гвоздь поменьше (но все равно норм)", "Гвоздь - Гвоздь или Гвоздь, Болт - Болт");
        this.articleMap.put(article.getId(), article);
        article = new Article(UUID.randomUUID(), "Гвоздь", "Гвоздь Гвоздь - не Болт не Болт");
        this.articleMap.put(article.getId(), article);
        article = new Article(UUID.randomUUID(), "Болт", "Гвоздь Гвоздь - не Болт и недостаточно гвоздей для критерия BestResult");
        this.articleMap.put(article.getId(), article);
        article = new Article(UUID.randomUUID(), "Молоток", "Гвоздь Гвоздь Гвоздь Гвоздь Гвоздь - забиваем молотком такое многообразие гвоздей в статье для демонстрации BestResult");
        this.articleMap.put(article.getId(), article);
    }

}

