package desafio_backend.btg_pactual.messaging.rabbitmq;

import desafio_backend.btg_pactual.api.dto.PedidoDto;
import desafio_backend.btg_pactual.domain.service.PedidoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @Autowired
    private PedidoService pedidoService;

    @RabbitListener(queues = "btg-pactual-order-created")
    public void processMessage(PedidoDto pedidoDto) {
        System.out.println(pedidoDto);
        pedidoService.salvar(pedidoDto);
    }
}