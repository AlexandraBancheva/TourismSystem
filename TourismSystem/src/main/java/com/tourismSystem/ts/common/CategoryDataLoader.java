package com.tourismSystem.ts.common;

import com.tourismSystem.ts.entities.Category;
import com.tourismSystem.ts.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CategoryDataLoader implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCategoryData();
    }

    private void loadCategoryData(){
        if (categoryRepository.count() == 0){
            Category cultureCategory = new Category("Културен");
            Category ecoCategory = new Category("Екологичен");
            Category seaCategory = new Category("Морски");
            Category mountainCategory = new Category("Планински/Ски");
            Category spaCategory = new Category("Балнео,СПА и уелнес");
            Category sportCategory = new Category("Спортен/Приключенски");
            Category ruralCategory = new Category("Селски");
            Category congressionalCategory = new Category("Конгресен");
            Category campingCategory = new Category("Къмпинг");
            Category wineCategory = new Category("Винен/Кулинарен");

            categoryRepository.save(cultureCategory);
            categoryRepository.save(ecoCategory);
            categoryRepository.save(seaCategory);
            categoryRepository.save(mountainCategory);
            categoryRepository.save(sportCategory);
            categoryRepository.save(spaCategory);
            categoryRepository.save(ruralCategory);
            categoryRepository.save(congressionalCategory);
            categoryRepository.save(campingCategory);
            categoryRepository.save(wineCategory);
        }
    }
}
