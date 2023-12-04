package br.com.ProjetoFood.pedidosFood.DTOPedidos;

import br.com.ProjetoFood.pedidosFood.Models.ItensPedido;
import br.com.ProjetoFood.pedidosFood.Models.Pedidos;
import br.com.ProjetoFood.pedidosFood.Models.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOpedidos{
    Long id;
    LocalDateTime data;
    Status status;
    List<DTOItensPedidos> itens;

}
