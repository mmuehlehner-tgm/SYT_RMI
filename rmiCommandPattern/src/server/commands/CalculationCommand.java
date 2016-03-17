package server.commands;

import java.io.Serializable;
import java.rmi.RemoteException;

import calculation.Calculation;
import calculation.PICalc;
import client.Callback;

public class CalculationCommand implements Command, Serializable
{

    private static final long serialVersionUID = 3202369269194172790L;
    private Calculation calc;
    private int digits;
    private Callback clientstub;

    /**
     * Constructor
     * 
     * @param digits
     *            - amount of digits
     * @param clientstub
     *            - client callback reference that gets the result of pi
     */
    public CalculationCommand(int digits, Callback clientstub)
    {
	this.digits = digits;
	this.clientstub = clientstub;
    }

    @Override
    public void execute()
    {
	System.out.println("CalculationCommand called!");
	calc = new PICalc();
	calc.calculate(this.digits);
	try
	{
	    calc.getResult(this.clientstub);
	} catch (RemoteException e)
	{
	    System.out.println("Could not get result!");
	    e.printStackTrace();
	}
    }
}
