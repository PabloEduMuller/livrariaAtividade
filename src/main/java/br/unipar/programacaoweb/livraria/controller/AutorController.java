package br.unipar.programacaoweb.livraria.controller;

import br.unipar.programacaoweb.livraria.model.Autor;
import br.unipar.programacaoweb.livraria.services.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Autor>> listarAutores() {
        List<Autor> autores = autorService.listarTodos();
        if (autores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Long id) {
        Autor autor = autorService.buscarPorId(id);
        if (autor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Autor> salvarAutor(@RequestBody Autor autor) {
        Autor autorSalvo = autorService.salvar(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorSalvo);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Autor> editarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Autor autorAtual = autorService.buscarPorId(id);
        if (autorAtual == null) {
            return ResponseEntity.notFound().build();
        }
        autorAtual.setNome(autor.getNome());
        autorAtual.setNacionalidade(autor.getNacionalidade());
        return ResponseEntity.ok(autorService.salvar(autorAtual));
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirAutor(@PathVariable Long id) {
        Autor autor = autorService.buscarPorId(id);
        if (autor == null) {
            return ResponseEntity.notFound().build();
        }
        autorService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint extra, lista autores com seus livros
    // livros já vem pelo relacionamento
    @GetMapping("/com-livros")
    public ResponseEntity<List<Autor>> listarAutoresComLivros() {
        List<Autor> autores = autorService.listarTodos();
        return ResponseEntity.ok(autores);
    }
}
