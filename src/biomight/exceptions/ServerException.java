package biomight.exceptions;

import javax.ejb.EJBException;

/**
 * @author Andrew Cohen
 *
 * This exception is generated when there is an error reading the 
 * screen and tab config file (NavMenu.xml).
 */
public class ServerException extends EJBException {
	private Exception origException;

	public ServerException(String s) {
		super(s);
	}

	public ServerException(String s, Exception origException) {
		super(s, origException);
		this.origException = origException;
	}

	public Exception getOrigException() {
		return origException;
	}
}