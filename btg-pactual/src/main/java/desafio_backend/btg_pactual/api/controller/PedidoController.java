package desafio_backend.btg_pactual.api.controller;

import desafio_backend.btg_pactual.api.dto.PedidoDto;
import desafio_backend.btg_pactual.domain.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping()
    public ResponseEntity<PedidoDto> adicionar(@RequestBody @Valid PedidoDto pedidoInput) {
        PedidoDto pedido = pedidoService.salvar(pedidoInput);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedido);
    }

    @GetMapping("/{codigoPedido}/valor-total")
    public BigDecimal valorTotalPedido(@PathVariable Long codigoPedido) {
        return pedidoService.valorTotalPedido(codigoPedido);
    }
}
