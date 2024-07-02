package desafio_backend.btg_pactual.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDto {

    @NonNull
    private String produto;

    @NonNull
    private Long quantidade;

    @NonNull
    private BigDecimal preco;

}
