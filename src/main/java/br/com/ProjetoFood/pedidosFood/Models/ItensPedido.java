package br.com.ProjetoFood.pedidosFood.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "itens_pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItensPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int quantidade;
    @NotBlank(message = "campo nao pode ser nulo")
    private String descricao;
    @ManyToOne(optional = false)
    private Pedidos pedido;
}
