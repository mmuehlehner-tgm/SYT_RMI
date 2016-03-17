/**
 * 
 */
package client;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Callback Interface
 * 
 * @author Moritz M�hlehner
 *
 */
public interface Callback extends Remote
{
    public void get(BigDecimal pi) throws RemoteException;
}
