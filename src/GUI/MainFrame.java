package GUI2.copy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

@SuppressWarnings("serial")
 
public class MainFrame extends JFrame{

	

	public MainFrame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		new JFrame();
		setBounds(150,80 , 1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.add(picture);
	
		ImageIcon img=new ImageIcon(this.getClass().getResource("letter_m_PNG56.png"));
		setIconImage(img.getImage());
		setResizable(false);
		
		
	
		setVisible(true);
		AudioInputStream as= AudioSystem.getAudioInputStream(this.getClass().getResource("led.wav"));
		Clip clip=AudioSystem.getClip();
		clip.open(as);
		AudioInputStream s= AudioSystem.getAudioInputStream(this.getClass().getResource("marvelTheme.wav"));
		Clip clip2=AudioSystem.getClip();
		clip2.open(s);
		clip.start();
		clip.loop(clip.LOOP_CONTINUOUSLY);
		
	}
	
}
