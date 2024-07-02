package desafio_backend.btg_pactual.api.model.pedidoInput;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PedidoInput {
    @NotNull
    private Long codigoPedido;

    @NotNull
    private Long codigoCliente;

    @Valid
    @NotNull
    private List<ItemPedidoInput> itens;
}
