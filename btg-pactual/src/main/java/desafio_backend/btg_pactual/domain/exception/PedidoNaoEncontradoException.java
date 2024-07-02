package desafio_backend.btg_pactual.domain.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
