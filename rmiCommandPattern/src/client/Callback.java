/**
 * 
 */
package client;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Moritz Mühlehner
 *
 */
public interface Callback extends Remote
{
    public void get(BigDecimal pi) throws RemoteException;
}
