package com.shoppinglist.springboot;

import com.shoppinglist.springboot.keywordMapping.KeywordCategoryMappingService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {

    private final KeywordCategoryMappingService keywordCategoryMappingService;

    public DataInitializer(KeywordCategoryMappingService keywordCategoryMappingService) {
        this.keywordCategoryMappingService = keywordCategoryMappingService;
    }

    @Override
    public void run(ApplicationArguments args) {
        try {
            keywordCategoryMappingService.saveMappingsFromJsonFile();
            keywordCategoryMappingService.saveProductFromJsonFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}