package GUI2.copy;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat.Style;


import javax.imageio.ImageIO;
import javax.management.MBeanNotificationInfo;
import javax.management.timer.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class start extends JFrame implements ActionListener{
	JButton st;
	Image pic;
	Timer timer;
	Clip clip;
	
    public start() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		new JFrame();
		setBounds(150,150 , 1000, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.add(picture);
		setResizable(false);
		
		theme m=new theme();
		m.setSize(1000,300);
		m.setLayout(null);
		//m.setBackground(Color.black);
		ImageIcon starter=new ImageIcon(this.getClass().getResource("marvelgifstarter.gif"));

	    st=new JButton();
     	st.setSize(m.getWidth(),m.getHeight());
     	st.setContentAreaFilled(false);
		st.setFocusable(false);
	    st.setOpaque(false);
		st.setBorder(null);
		st.setBorderPainted(false);
		st.addActionListener(this);
		m.add(st);
		
	
		
		this.add(m);
//		timer=new Timer();
//		timer.start();
		

		
		
		
		
		
		
	
		ImageIcon img=new ImageIcon(this.getClass().getResource("letter_m_PNG56.png"));
		setIconImage(img.getImage());
		setResizable(false);
		
//		JPanel s=new JPanel();
//		s.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
//		ImageIcon starter=new ImageIcon(this.getClass().getResource("marvelgifstarter.gif"));
//		 st=new JButton();
//		st.setSize(this.getWidth(),this.getHeight());
//		st.setIcon(starter);
//		st.setBorderPainted(false);
//		st.addActionListener(this);
		AudioInputStream as= AudioSystem.getAudioInputStream(this.getClass().getResource("marvelstart.wav"));
		clip =AudioSystem.getClip();
		clip.open(as);
		clip.start();
		clip.loop(clip.LOOP_CONTINUOUSLY);
		
	
		setVisible(true);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==st) {
			clip.stop();
			this.setVisible(false);
			MainFrame frame = null;
			try {
				frame = new MainFrame();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MainMenu menu = null;
			try {
				menu = new MainMenu(frame);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.add(menu);
		}
	}
    
    


}
	


