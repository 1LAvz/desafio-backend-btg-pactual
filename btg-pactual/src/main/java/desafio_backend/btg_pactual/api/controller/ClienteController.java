package desafio_backend.btg_pactual.api.controller;

import desafio_backend.btg_pactual.api.dto.PedidoDto;
import desafio_backend.btg_pactual.domain.model.Pedido;
import desafio_backend.btg_pactual.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{clienteCodigo}/pedidos")
    public List<PedidoDto> pedidos(@PathVariable Long clienteCodigo) {
        return pedidoService.todosPedidosPor(clienteCodigo);
    }

    @GetMapping("/{clienteCodigo}/pedidos/quantidade")
    public Long quantidade(@PathVariable Long clienteCodigo) {
        return pedidoService.quantidadeDePedidosPor(clienteCodigo);
    }
}
