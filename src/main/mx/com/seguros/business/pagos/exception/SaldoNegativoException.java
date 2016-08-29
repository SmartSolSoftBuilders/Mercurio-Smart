package mx.com.seguros.business.pagos.exception;

public class SaldoNegativoException extends RuntimeException {

	public SaldoNegativoException(String msg) {
		super(msg);
	}
	
	private static final long serialVersionUID = 1L;

}
