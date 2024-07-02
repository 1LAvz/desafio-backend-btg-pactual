package desafio_backend.btg_pactual.domain.repository;

import desafio_backend.btg_pactual.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public Long countPedidosByCodigoCliente(Long clienteCodigo);

    public Optional<List<Pedido>> findPedidosByCodigoCliente(Long clienteCodigo);
}
