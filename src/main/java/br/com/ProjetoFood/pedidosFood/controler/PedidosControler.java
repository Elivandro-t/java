package br.com.ProjetoFood.pedidosFood.controler;

import br.com.ProjetoFood.pedidosFood.DTOPedidos.DTOpedidos;
import br.com.ProjetoFood.pedidosFood.DTOPedidos.ExibirDTO;
import br.com.ProjetoFood.pedidosFood.DTOPedidos.StatusDTO;
import br.com.ProjetoFood.pedidosFood.service.PedidosService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.login.LoginContext;

@RestController
@RequestMapping("/pedidos")
public class PedidosControler {
    @Autowired
    private PedidosService  pedidosService;
    @GetMapping
    public Page<DTOpedidos> list(@PageableDefault(size = 10) Pageable paginacao){
        return pedidosService.Lista(paginacao);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<DTOpedidos> ListandoPedidoId(@PathVariable Long id){
        var list  = pedidosService.ListaPedidoPorID(id);
        return ResponseEntity.ok(list);
    }
    @PostMapping
    public ResponseEntity<ExibirDTO> registrar(@RequestBody @Valid DTOpedidos dtOpedidos, UriComponentsBuilder builder){
        System.out.println("pedidos "+dtOpedidos);
        DTOpedidos result = pedidosService.registrar(dtOpedidos);
        var uri = builder.path("/pedidos/{id}").buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(uri).body(new ExibirDTO(result));

    }
    @PutMapping("/{id}/status")
    @Transactional
    public ResponseEntity atualizar(@PathVariable @Valid Long id,@RequestBody @Valid StatusDTO statusDTO){
        var result = pedidosService.atualizar(id,statusDTO);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable @Valid Long id){
        pedidosService.excluir(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}/pago")
    public ResponseEntity<Void> StatusPago(@PathVariable @NotNull Long id){
          pedidosService.StatusPago(id);
        return ResponseEntity.ok().build();
    }
}
