package br.unipar.programacaoweb.livraria.services;

import br.unipar.programacaoweb.livraria.model.Livro;
import br.unipar.programacaoweb.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    public void excluir(Long id){
        livroRepository.deleteById(id);
    }

    public Livro buscarPorId(Long id){
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> buscarPorTitulo(String titulo){
        return livroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

}
