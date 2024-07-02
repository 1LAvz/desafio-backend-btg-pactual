package desafio_backend.btg_pactual.domain.service;

import desafio_backend.btg_pactual.api.model.pedidoInput.PedidoInput;
import desafio_backend.btg_pactual.api.model.pedidoOutput.ItemPedidoOutput;
import desafio_backend.btg_pactual.api.model.pedidoOutput.PedidoOutput;
import desafio_backend.btg_pactual.domain.model.Cliente;
import desafio_backend.btg_pactual.domain.model.ItemPedido;
import desafio_backend.btg_pactual.domain.model.Pedido;
import desafio_backend.btg_pactual.domain.model.Produto;
import desafio_backend.btg_pactual.domain.repository.ClienteRepository;
import desafio_backend.btg_pactual.domain.repository.ItemPedidoRepository;
import desafio_backend.btg_pactual.domain.repository.PedidoRepository;
import desafio_backend.btg_pactual.domain.repository.ProdutoRepository;
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
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public BigDecimal valorTotalPedido(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId).get();

        BigDecimal soma = new BigDecimal(0);

        pedido.getItens().forEach(item -> {
            BigDecimal quantidadeProduto = new BigDecimal(item.getQuantidade());
            soma.add(item.getProduto().getPreco().multiply(quantidadeProduto));
        });

        return soma;
    }

    @Transactional
    public PedidoOutput salvar(PedidoInput pedidoInput) {

        Cliente cliente = Cliente.builder()
                .codigo(pedidoInput.getCodigoCliente())
                .nome("defaul-name")
                .build();

        cliente = clienteRepository.save(cliente);

        List<ItemPedido> itensPedido = new ArrayList<>();
        pedidoInput.getItens().forEach(item -> {
            Produto produto = Produto.builder()
                    .nome(item.getProduto())
                    .preco(item.getPreco())
                    .build();

            produto = produtoRepository.save(produto);

            ItemPedido itemPedido = ItemPedido.builder()
                    .quantidade(item.getQuantidade())
                    .produto(produto)
                    .build();

            itemPedido = itemPedidoRepository.save(itemPedido);
            itensPedido.add(itemPedido);
        });

        Pedido pedido = Pedido.builder()
                .codigo(pedidoInput.getCodigoPedido())
                .cliente(cliente)
                .itens(itensPedido)
                .build();

        itensPedido.forEach(itemPedido -> {
            itemPedido.setPedido(pedido);
        });

        return converterParaModeloRepresentacao(pedidoRepository.save(pedido));
    }

    public PedidoOutput converterParaModeloRepresentacao(Pedido pedido) {

        return PedidoOutput.builder()
                .codigoPedido(pedido.getCodigo())
                .codigoCliente(pedido.getCliente().getCodigo())
                .itens(getItensPedidoOutPut(pedido.getItens()))
                .build();
    }

    public List<ItemPedidoOutput> getItensPedidoOutPut(List<ItemPedido> itensPedido) {
        List<ItemPedidoOutput> itensPedidoOutput = new ArrayList<>();

        itensPedido.forEach(itemPedido -> {
            ItemPedidoOutput itemPedidoOutput = ItemPedidoOutput.builder()
                    .quantidade(itemPedido.getQuantidade())
                    .produto(itemPedido.getProduto().getNome())
                    .preco(itemPedido.getProduto().getPreco())
                    .build();

            itensPedidoOutput.add(itemPedidoOutput);
        });

        return itensPedidoOutput;
    }

}
