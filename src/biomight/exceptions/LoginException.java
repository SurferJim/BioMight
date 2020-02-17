/*
 * Created on Aug 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.exceptions;

/**
 * @author cohena
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LoginException extends Exception
{
public static final int INVALID = 1;
public static final int PASSWORD_EXPIRED = 2;
public static final int LOGIN_EXPIRED = 3;
public static final int LOGIN_DISABLED = 4;
public static final int NO_GROUPS = 5;
public static final int NO_PYRLS = 6;
public static final int BAD_PYRL = 7;


private int type = 0;

public LoginException(int type)
{
	super();
	this.type = type;
}

public LoginException(int type, String s)
{
	super(s);
	this.type = type;
}

public int getExceptionType()
{
	return type;
}

}
