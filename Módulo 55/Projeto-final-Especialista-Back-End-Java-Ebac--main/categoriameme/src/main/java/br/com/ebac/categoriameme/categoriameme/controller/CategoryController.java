package br.com.ebac.categoriameme.categoriameme.controller;


import br.com.ebac.categoriameme.categoriameme.client.CategoryClient;
import br.com.ebac.categoriameme.categoriameme.entity.CategoryMeme;
import br.com.ebac.categoriameme.categoriameme.entity.User;
import br.com.ebac.categoriameme.categoriameme.service.CategoryServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {


    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryServices categoryServices;

    @Autowired
    private CategoryClient categoryClient;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("/users")
    public Iterable<User> findAllUsers() {
        logger.info("Finding all usuarios");
        Iterable<User> users = categoryClient.FindAllThem();
        int numUsers = 0;
        for(User user : users) {
            numUsers++;
        }
        logger.info("findAllUsers() returned {} users", numUsers);
        return users;
    }

    @PostMapping
    public CategoryMeme createCategory(@RequestBody CategoryMeme categoryMeme) {
        logger.info("Creating category: {}", categoryMeme);
        Long userId = categoryMeme.getUsuarioId();
        User user = categoryClient.FindById(userId);
        if (user == null) {
            logger.info("createCategory() failed: user with ID {} not found", userId);
            return null;
        }
        categoryMeme.setUsuarioId(user.getId());
        CategoryMeme createCategory = categoryServices.createCategory(categoryMeme);
        if (createCategory == null) {
            logger.info("createCategory() failed: could not create categoryMeme={}", categoryMeme);
        } else {
            logger.info("createCategory() succeeded: categoryMeme={} created with ID {}", createCategory,
                    createCategory.getId());
        }
        return createCategory;
    }

    @GetMapping
    public Iterable<CategoryMeme> findAllCategorys() {
        logger.info("Finding all categorys");
        Iterable<CategoryMeme> categorys = categoryServices.findTheAllCategorys();
        int numCategorys = 0;
        for (CategoryMeme category : categorys) {
            numCategorys++;
        }
        logger.info("encontrarTodasCategorias() returned {} categorias", numCategorys);
        return categorys;
    }

    @GetMapping("/{id}")
    public CategoryMeme findCategoryById(@PathVariable Long id) {
        logger.info("Finding category with id={}", id);
        CategoryMeme category = categoryServices.findCategoryById(id);
        if (category == null) {
            logger.info("findCategoryById() failed: category with ID {} not found", id);
        } else {
            logger.info("findCategoryById() succeeded: category={} found", category);
        }
        return category;
    }

}