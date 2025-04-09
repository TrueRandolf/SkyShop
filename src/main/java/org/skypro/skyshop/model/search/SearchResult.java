package org.skypro.skyshop.model.search;


import org.springframework.stereotype.Service;

//@Service
public class SearchResult {
    final String id;
    final String name;
    final String contentType;

    public SearchResult(Searchable s) {

        this.id = s.getId().toString();
        this.name = s.getName();
        this.contentType = s.getContentType();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }


    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable);
    }

}
