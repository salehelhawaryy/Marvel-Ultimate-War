package GUI2.copy;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BabaGui {
	

	
	public BabaGui() throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		start frame=new start();
		
		
		frame.setVisible(true);
		
	}
	
	public static void main(String [] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		BabaGui gui=new BabaGui();
	}
}
