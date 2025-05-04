package br.unipar.programacaoweb.livraria.services;

import br.unipar.programacaoweb.livraria.model.Autor;
import br.unipar.programacaoweb.livraria.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.orElse(null);
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void excluir(Long id) {
        autorRepository.deleteById(id);
    }
}
