package exceptions;

/**
  	NoSuchDateException custom exception - to handle wrong date inputs
  
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class NoSuchDateException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 	Constructs an exception for wrong dates
	 	@param message - error message
	 */
	public NoSuchDateException(String message)
	{
		super(message);
	}
			

}
