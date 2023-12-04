package br.com.ProjetoFood.pedidosFood.DTOPedidos;

import br.com.ProjetoFood.pedidosFood.Models.Status;

import java.time.LocalDateTime;
import java.util.List;

public record ExibirDTO(Long id,
        LocalDateTime data,
        Status status,
        List<DTOItensPedidos>itens) {
    public ExibirDTO(DTOpedidos result) {
        this(result.id,result.data,result.status,result.itens);
    }
}
