package br.com.ebac.memelandia.repositories;

import br.com.ebac.memelandia.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMeme extends JpaRepository<Meme, Long> {
}
