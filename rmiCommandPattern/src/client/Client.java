package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import remoteService.DoSomethingService;
import server.commands.CalculationCommand;
import server.commands.Command;
import server.commands.RegisterCommand;
import server.commands.LoginCommand;

public class Client
{

    public static void main(String[] args)
    {
	if (System.getSecurityManager() == null)
	{
	    System.setSecurityManager(new SecurityManager());
	}
	try
	{
	    Registry registry = LocateRegistry.getRegistry(1234);

	    DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
	    System.out.println("Service found");

	    Command rc = new RegisterCommand();
	    Command lc = new LoginCommand();
	    Command cc;
	    try
	    {
		cc = new CalculationCommand(Integer.parseInt(args[0]));
	    } catch (Exception e)
	    {
		System.err.println("Check your arguments! Could not find arguments or arguments are not int!");
		System.err.println("Using default amount of digits! (200)");
		cc = new CalculationCommand(200);
	    }
	    uRemoteObject.doSomething(rc);
	    uRemoteObject.doSomething(lc);
	    uRemoteObject.doSomething(cc);

	} catch (RemoteException re)
	{
	    System.err.println("Service not found?" + " Check your RMI-Registry!");
	    System.exit(1);
	} catch (Exception e)
	{
	    System.err.println("Service exception:");
	    e.printStackTrace();
	    System.exit(1);
	}
    }
}
