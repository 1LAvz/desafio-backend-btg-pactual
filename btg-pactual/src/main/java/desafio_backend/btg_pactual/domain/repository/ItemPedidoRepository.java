package desafio_backend.btg_pactual.domain.repository;

import desafio_backend.btg_pactual.domain.model.ItemPedido;
import desafio_backend.btg_pactual.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
