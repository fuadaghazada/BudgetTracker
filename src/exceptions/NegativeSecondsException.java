package exceptions;

/**
 	NegativeSecondsException - custum exception to handle reminder errors 
 
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */

public class NegativeSecondsException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 	Constructs an exception for negative seconds in the Reminder
	 	@param message - error message
	 */
	public NegativeSecondsException(String message)
	{
		super(message);
	}
			

}
