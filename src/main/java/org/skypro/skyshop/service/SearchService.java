package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
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
        return
                this.storageService.getSearchables().stream()
                        .filter(s -> s.getSearchTerm().toLowerCase().contains(pattern.toLowerCase()))
                        .map(SearchResult::fromSearchable)
                        .collect(Collectors.toList());
    }
}

