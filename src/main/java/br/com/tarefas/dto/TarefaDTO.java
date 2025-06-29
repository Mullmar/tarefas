package br.com.tarefas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class TarefaDTO {

    public TarefaDTO() {

    }
    private Long id;
    @NotBlank(message = "O título é obrigatório")
    @Size(min = 5, max = 15, message = "Tamanho mínimo de 5 caracteres e máximo de 15")
    private String titulo;
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotBlank(message = "O local é obrigatório")
    private String local;
    @NotNull(message = "Data/Hora é obrigatória")
    private LocalDateTime dataHora;
}
