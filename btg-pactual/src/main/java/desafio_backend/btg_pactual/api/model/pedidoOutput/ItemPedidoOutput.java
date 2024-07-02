package desafio_backend.btg_pactual.api.model.pedidoOutput;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ItemPedidoOutput {
    @NotNull
    private Long quantidade;
    @NotNull
    private String produto;
    @NotNull
    private BigDecimal preco;
}
