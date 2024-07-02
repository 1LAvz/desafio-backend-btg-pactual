package domain.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemPedido {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private Long quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    @ManyToOne
    private Pedido pedido;

    @OneToOne
    private Produto produto;
}
