package desafio_backend.btg_pactual.api.model.pedidoInput;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ItemPedidoInput {
    @NotNull
    private Long quantidade;
    @NotNull
    private String produto;
    @NotNull
    private BigDecimal preco;
}
