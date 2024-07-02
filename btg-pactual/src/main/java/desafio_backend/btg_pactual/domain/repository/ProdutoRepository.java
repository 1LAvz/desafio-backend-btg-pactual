package desafio_backend.btg_pactual.domain.repository;

import desafio_backend.btg_pactual.domain.model.Pedido;
import desafio_backend.btg_pactual.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
