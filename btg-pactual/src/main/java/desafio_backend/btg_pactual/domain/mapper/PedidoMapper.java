package desafio_backend.btg_pactual.domain.mapper;

import desafio_backend.btg_pactual.api.dto.PedidoDto;
import desafio_backend.btg_pactual.domain.model.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Pedido convertToModel(PedidoDto pedidoInputDto) {
        return modelMapper.map(pedidoInputDto, Pedido.class);
    }

    public PedidoDto convertToDto(Pedido pedido) {
        return modelMapper.map(pedido, PedidoDto.class);
    }

    public List<PedidoDto> convertToDto(List<Pedido> pedidos) {
        return pedidos.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

}
