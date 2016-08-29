package mx.com.seguros.business.pagos.exception;

public class PagosBusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PagosBusinessException(String msg) {
        super(msg);
    }
}
