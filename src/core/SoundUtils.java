package core;
import javax.sound.sampled.*;

/**
  	SoundUtils - util to make sound by entering the hz and time interval 
  	
  	@author written from the internet source - StackOverFlow
	@version 1.00
 */

public class SoundUtils 
{
	//class varible(s)
	  public static float SAMPLE_RATE = 8000f;
	
	  /**
	  	constructs a sound with the parameters (with constant sound)
	  	@param hz - speed of sound
	  	@param msecs - time interval of the sound
	 */
	  public static void tone(int hz, int msecs) throws LineUnavailableException 
	  {
		  tone(hz, msecs, 1.0);
	  }
	
	  /**
	    	constructs a sound with the parameters
	    	@param hz - speed of sound
	    	@param msecs - time interval of the sound
	    	@param vol - volume of the sound
	   */
	  public static void tone(int hz, int msecs, double vol) throws LineUnavailableException 
	  {
		  byte[] buf = new byte[1];
		  AudioFormat af =  new AudioFormat(SAMPLE_RATE, // sampleRate
					  							8,	           // sampleSizeInBits
					  							1,           // channels
					  							true,        // signed
					  							false);      // bigEndian
		  SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		  sdl.open(af);
		  sdl.start();
		  for (int i = 0; i < msecs * 8; i++) 
		  {
			  double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
			  buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
		      sdl.write(buf,0,1);
		  }  
		  sdl.drain();
		  sdl.stop();
		  sdl.close();
	  }
	  
	  /**
	    	Makes the sound of our Reminder (3 times, 5500hz, 100mseconds)
	   */
	  public static void makeSound()
	  {
		  for(int i = 0; i < 3; i++)
			try 
		  	{
				SoundUtils.tone(5500,100);
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		  try
		  {
			  Thread.sleep(1000);
		  } catch (InterruptedException e) 
		  {
			  e.printStackTrace();
		  }
	  }

}
