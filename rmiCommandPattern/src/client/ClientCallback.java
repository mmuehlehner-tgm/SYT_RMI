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
    public void get(BigDecimal pi) throws RemoteException
    {
	System.out.println(""+pi);
    }
    
}
