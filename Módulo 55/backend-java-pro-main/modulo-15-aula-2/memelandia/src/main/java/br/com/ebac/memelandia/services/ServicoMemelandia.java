package br.com.ebac.memelandia.services;

import br.com.ebac.memelandia.entities.CategoriaMeme;
import br.com.ebac.memelandia.entities.Meme;
import br.com.ebac.memelandia.entities.Usuario;
import br.com.ebac.memelandia.repositories.RepositorioCategoriaMeme;
import br.com.ebac.memelandia.repositories.RepositorioMeme;
import br.com.ebac.memelandia.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoMemelandia {
    @Autowired
    private RepositorioMeme repositorioMeme;

    @Autowired
    private RepositorioCategoriaMeme repositorioCategoriaMeme;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario novoUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Meme novoMeme(Meme meme) {
        return repositorioMeme.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        return repositorioCategoriaMeme.save(categoriaMeme);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return repositorioCategoriaMeme.findAll();
    }
}
