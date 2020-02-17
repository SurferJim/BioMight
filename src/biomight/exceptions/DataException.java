package biomight.exceptions;

import javax.ejb.EJBException;

public class DataException extends EJBException {
	private Exception origException;

	public DataException(String s) {
		super(s);
	}

	public DataException(String s, Exception origException) {
		super(s, origException);
		this.origException = origException;
	}

	public Exception getOrigException() {
		return origException;
	}
}
