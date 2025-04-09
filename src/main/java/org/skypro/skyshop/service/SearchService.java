package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }


    public List<SearchResult> search(String pattern) {
        return (List)
                (new StorageService().getSearchable()).values().stream()
                        .filter(s -> ((Searchable) s).getSearchTerm().contains(pattern))
                        .map(s -> SearchResult.fromSearchable((Searchable) s))
                        .collect(Collectors.toList());
    }
}

