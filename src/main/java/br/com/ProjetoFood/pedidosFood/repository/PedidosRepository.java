package br.com.ProjetoFood.pedidosFood.repository;

import br.com.ProjetoFood.pedidosFood.Models.Pedidos;
import br.com.ProjetoFood.pedidosFood.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PedidosRepository extends JpaRepository<Pedidos,Long> {
        @Transactional
        @Modifying(clearAutomatically = true)
        @Query("update Pedidos p set p.status = :status where p = :pedido")
        void atualizaStatus(Status status, Pedidos pedido);

        @Query("SELECT p from Pedidos p LEFT JOIN FETCH p.itens where p.id = :id")
        Pedidos pegarPorId(Long id);



}
