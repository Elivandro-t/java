package br.com.ProjetoFood.pedidosFood.DTOPedidos;

import br.com.ProjetoFood.pedidosFood.Models.ItensPedido;
import br.com.ProjetoFood.pedidosFood.Models.Pedidos;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DTOItensPedidos{
    Long id;
    String nome;
    int quantidade;
    String descricao;
}
