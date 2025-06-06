package br.unipar.programacaoweb.livraria.repository;

import br.unipar.programacaoweb.livraria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByNomeContainingIgnoreCase(String nome);

    List<Autor> findByNacionalidadeContainingIgnoreCase(String nacionalidade);
}
