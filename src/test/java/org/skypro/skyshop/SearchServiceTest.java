package org.skypro.skyshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchServiceTest = new SearchService(storageService);

    @Test
    public void givenEmptyStorageService_whenSearchProduct_ThenReturnEmptyCollection() {
        String search = "Гвоздь";
        List<Searchable> searchableList = new LinkedList<>();
        when(storageService.getSearchables()).thenReturn(searchableList);
        List<SearchResult> result = new SearchService(storageService).search(search);
        Assertions.assertTrue(result.isEmpty());
    }


    @Test
    public void givenInappropriateStorageService_whenSearchProduct_ThenReturnEmptyCollection() {
        String search = "Гвоз1дь";
        Product product = new SimpleProduct(UUID.randomUUID(), "Гвоздь", 100);
        List<Searchable> searchableList = new LinkedList<>();
        searchableList.add(product);
        when(storageService.getSearchables()).thenReturn(searchableList);
        List<SearchResult> result = new SearchService(storageService).search(search);
        System.out.println("result = " + result);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void givenAppropriateStorageService_whenSearchProduct_ThenReturnEmptyCollection() {
        String search = "Гвоздь";
        Product product = new SimpleProduct(UUID.randomUUID(), "Гвоздь", 100);
        List<Searchable> searchableList = new LinkedList<>();
        searchableList.add(product);
        when(storageService.getSearchables()).thenReturn(searchableList);
        List<SearchResult> result = new SearchService(storageService).search(search);
        Assertions.assertFalse(result.isEmpty());
    }


}



