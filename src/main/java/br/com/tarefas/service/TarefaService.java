package br.com.tarefas.service;

import br.com.tarefas.dto.TarefaDTO;
import br.com.tarefas.entity.Tarefa;
import br.com.tarefas.exception.TarefaNotFound;
import br.com.tarefas.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TarefaDTO recuperarTarefa(Long id) {
        Optional<Tarefa> tarefaOp = tarefaRepository.findById(id);
        return modelMapper.map(tarefaOp.orElseThrow(() -> new TarefaNotFound("tarefa com o id " + id + " não encontrada.")), TarefaDTO.class);
    }

    public TarefaDTO adicionarTarefa(TarefaDTO tarefa) {
        Tarefa tarefaEntity = modelMapper.map(tarefa, Tarefa.class);
        return modelMapper.map(tarefaRepository.save(tarefaEntity), TarefaDTO.class);
    }

    public List<TarefaDTO> retornaListaDeTarefas() {
        return modelMapper.map(tarefaRepository.findAll(), new TypeToken<List<TarefaDTO>>() {}.getType());
    }

    public TarefaDTO atualizarTarefa(TarefaDTO tarefa) {
        Tarefa tarefaEntity = modelMapper.map(tarefa, Tarefa.class);
        if(tarefaRepository.existsById(tarefaEntity.getId())) {
            return modelMapper.map(tarefaRepository.save(tarefaEntity), TarefaDTO.class);
        }
        throw new TarefaNotFound("tarefa com o id " + tarefaEntity.getId() + " não existe.");
    }

    public void deletarTarefa(Long id) {
        if(!tarefaRepository.existsById(id)) {
            throw new TarefaNotFound("tarefa com o id " + id + " não existe.");
        }
        tarefaRepository.deleteById(id);
    }
}
