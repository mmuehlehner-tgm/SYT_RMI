/**
 * 
 */
package client;

import java.math.BigDecimal;
import java.rmi.RemoteException;

/**
 * @author Moritz M�hlehner
 *
 */
public class ClientCallback implements Callback
{

    @Override
    /**
     * prints pi which is given as a parameter
     * 
     * @param BigDecimal
     *            pi (gets the calculated pi)
     */
    public void get(BigDecimal pi) throws RemoteException
    {
	System.out.println("" + pi);
    }

}
