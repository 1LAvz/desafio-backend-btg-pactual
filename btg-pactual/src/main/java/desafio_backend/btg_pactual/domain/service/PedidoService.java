package desafio_backend.btg_pactual.domain.service;

import desafio_backend.btg_pactual.api.dto.PedidoDto;
import desafio_backend.btg_pactual.domain.exception.PedidoNaoEncontradoException;
import desafio_backend.btg_pactual.domain.mapper.PedidoMapper;
import desafio_backend.btg_pactual.domain.model.Pedido;
import desafio_backend.btg_pactual.domain.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Transactional
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public PedidoDto salvar(PedidoDto pedidoInput) {
        Pedido pedido = pedidoMapper.convertToModel(pedidoInput);

        pedido.getItens().forEach(item -> item.setPedido(pedido));

        Pedido pedidoSalvo = salvar(pedido);
        return pedidoMapper.convertToDto(pedidoSalvo);
    }

    public List<PedidoDto> todosPedidosPor(Long clienteCodigo) {
        Optional<List<Pedido>> pedidos = pedidoRepository.findPedidosByCodigoCliente(clienteCodigo);

        if (pedidos.isPresent()) {
            return pedidoMapper.convertToDto(pedidos.get());
        }

        return new ArrayList<>();
    }

    public BigDecimal valorTotalPedido(Long pedidoId) {
        Pedido pedido = buscarOuFalhar(pedidoId);

        return pedido.getItens().stream()
                .map(item -> new BigDecimal(item.getQuantidade()).multiply(item.getPreco()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long quantidadeDePedidosPor(Long clienteCodigo) {
        return pedidoRepository.countPedidosByCodigoCliente(clienteCodigo);
    }

    public Pedido buscarOuFalhar(Long pedidoId) {
        return pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new PedidoNaoEncontradoException("Pedido não encontrado"));
    }
}
