package desafio_backend.btg_pactual.api.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDto {

    @NonNull
    private Long codigoPedido;

    @NonNull
    private Long codigoCliente;

    @NonNull
    @Valid
    private List<ProdutoDto> itens;

}
