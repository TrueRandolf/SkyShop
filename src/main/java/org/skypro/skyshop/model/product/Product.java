package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    protected final String name;
    protected final UUID id;

    public Product(UUID id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        this.name = name;
        this.id = id;
        //this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public UUID getId() {
        return this.id;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getStringRepresentation() {
        return "имя \"" + name + "\" тип \"" + getContentType() + "\"";
    }
}

