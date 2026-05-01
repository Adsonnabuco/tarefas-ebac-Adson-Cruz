package br.com.ebac.categoriameme.categoriameme.service;

import br.com.ebac.categoriameme.categoriameme.entity.CategoryMeme;
import br.com.ebac.categoriameme.categoriameme.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryServices {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CategoryMeme> findTheAllCategorys() {
        return categoryRepository.findAll();
    }

    public CategoryMeme createCategory(CategoryMeme categoryMeme) {
        return categoryRepository.save(categoryMeme);
    }

    public CategoryMeme findCategoryById(Long id) {
        Optional<CategoryMeme> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            return  categoryOptional.get();
        } else {
            throw  new RuntimeException(" //////////// Category not found! //////////// ");
        }
    }
}
