package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {

    private final String articleTitle;
    private final String articleText;
    private final UUID id;

    public Article(UUID id, String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
        this.id = id;
    }

    @Override
    public String getName() {
        return articleTitle;
    }

    @Override
    public String toString() {
        return "статья: " + articleTitle + "\n" + "текст: " + articleText;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return articleTitle + "\n" + articleText;
    }

    @JsonIgnore
    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return "имя \"" + articleTitle + "\" тип \"" + getContentType() + "\"";
    }

    @Override
    public UUID getId() {
        return this.id;
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(articleTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle);
    }

}