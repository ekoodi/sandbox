package fi.saimia.ekoodi.sandbox.layer.service.cc;

public class DaoException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static String GENERIC_ERROR_CODE = "3k00d1_error_generic";
	
	private String code;
	
	public DaoException() {
		this(null,null);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message) {
		this(message,null);
		// TODO Auto-generated constructor stub
	}

	public DaoException(Throwable cause) {
		this(null,cause);
		// TODO Auto-generated constructor stub
	}

	public DaoException(String message, Throwable cause) {
		this(message, "error_generic", cause);
		// TODO Auto-generated constructor stub
	}


	public DaoException(String message, String code, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}
	
	
}
