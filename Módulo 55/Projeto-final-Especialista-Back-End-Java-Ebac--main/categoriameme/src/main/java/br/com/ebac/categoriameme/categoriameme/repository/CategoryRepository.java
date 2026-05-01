package br.com.ebac.categoriameme.categoriameme.repository;

import br.com.ebac.categoriameme.categoriameme.entity.CategoryMeme;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryMeme, Long> {
}
