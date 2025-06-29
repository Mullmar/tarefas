package br.com.tarefas.controller;

import br.com.tarefas.dto.TarefaDTO;
import br.com.tarefas.entity.Tarefa;
import br.com.tarefas.repository.TarefaRepository;
import br.com.tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> recuperarTarefa(@PathVariable Long id) {

        return ResponseEntity.ok(tarefaService.recuperarTarefa(id));
    }

    @PostMapping
    public ResponseEntity<TarefaDTO> adicionarTarefa(@Valid @RequestBody TarefaDTO tarefa){
        tarefa = tarefaService.adicionarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> retornaListaDeTarefas() {
        return ResponseEntity.ok(tarefaService.retornaListaDeTarefas());
    }

    @PutMapping
    public ResponseEntity<TarefaDTO> atualizarTarefa(@Valid @RequestBody TarefaDTO tarefa) {
        tarefaService.atualizarTarefa(tarefa);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {

        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
