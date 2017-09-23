package exceptions;

/**
	NoSuchTimeException custom exception - to handle wrong time exceptions
	
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class NoSuchTimeException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 	Constructs an exception for wrong time
	 	@param message - error message
	 */
	public NoSuchTimeException(String message)
	{
		super(message);
	}
			

}
