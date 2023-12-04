package br.com.ProjetoFood.pedidosFood.service;

import br.com.ProjetoFood.pedidosFood.DTOPedidos.DTOpedidos;
import br.com.ProjetoFood.pedidosFood.Models.Pedidos;
import br.com.ProjetoFood.pedidosFood.Models.Status;
import br.com.ProjetoFood.pedidosFood.repository.PedidosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PedidosService {
    @Autowired
private ModelMapper modelMapper;
    @Autowired
    private PedidosRepository repository;
    public DTOpedidos registrar(DTOpedidos pedidos){
        Pedidos pedidoRegistrar = modelMapper.map(pedidos,Pedidos.class);
        pedidoRegistrar.setData(LocalDateTime.now());
        pedidoRegistrar.setStatus(Status.CONFIRMADO);
        pedidoRegistrar.getItens().forEach(e->e.setPedido(pedidoRegistrar));
          var result = repository.save(pedidoRegistrar);
        return modelMapper.map(pedidoRegistrar,DTOpedidos.class);
    }
    // listando pedidos
    public Page<DTOpedidos> Lista(Pageable paginacao){
        return repository.findAll(paginacao)
                .map(e->modelMapper.map(e,DTOpedidos.class));

    }

    // atualizar
    public DTOpedidos atualizar(Long id,DTOpedidos dtOpedidos){
        Pedidos pedidos = repository.pegarPorId(id);
        if(pedidos==null){
            throw new EntityNotFoundException();
        }
            pedidos.setData(LocalDateTime.now());
            pedidos.setStatus(dtOpedidos.getStatus());
            repository.atualizaStatus(dtOpedidos.getStatus(),pedidos);
      return modelMapper.map(pedidos,DTOpedidos.class);
    }
    // deletando pedido
    public void excluir(Long id){
        repository.deleteById(id);
    }
}
