package desafio_backend.btg_pactual.domain.repository;

import desafio_backend.btg_pactual.domain.model.Cliente;
import desafio_backend.btg_pactual.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
