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

public class MainMenu extends JPanel implements ActionListener{
	JButton StartGame;
	JButton Options;
	MainFrame TheFrame;
	Image pic;
	
	public MainMenu(MainFrame frame) throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		
		TheFrame=frame;
		
		new JPanel();
		ImageIcon obj=new ImageIcon(this.getClass().getResource("maingif.gif"));
		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
		pic=scaledobj.getImage();
		setSize(1000,1000);
		setLayout(null);
		
		//image
//		ImageIcon obj=new ImageIcon(this.getClass().getResource("back1.png"));
//		pic=obj.getImage();
//
//		TheFrame.add(pic);
		JLabel label=new JLabel();
		JLabel label2=new JLabel();

		ImageIcon logo=new ImageIcon(this.getClass().getResource("logo.png"));
		ImageIcon scaledlogo=new ImageIcon(logo.getImage().getScaledInstance(250,100, Image.SCALE_DEFAULT));
		
		label.setIcon(scaledlogo);
		label.setBounds(360, 10,400, 170);
		label.setVisible(true);
		this.add(label);
		
		ImageIcon logo2=new ImageIcon(this.getClass().getResource("logo2.jpg"));
		ImageIcon scaledlogo2=new ImageIcon(logo2.getImage().getScaledInstance(230,50, Image.SCALE_DEFAULT));
		
		label2.setIcon(scaledlogo2);
		label2.setBounds(368, 85,400, 170);
		label2.setVisible(true);
		this.add(label2);
		
		//video
		
	
//		label.setBounds(330, 32, 1000, 50);
//		label.setText("Marvel: Ultimate War");
//		label.setFont(new Font("SansSerif",Font.ITALIC , 30));
//		label.setForeground(Color.white);
//		this.add(label);
//		setBackground(Color.BLACK);
//		label.setVisible(true);
		
		ImageIcon champ1=new ImageIcon(this.getClass().getResource("iron man trans.gif"));
		ImageIcon scaledchamp1=new ImageIcon(champ1.getImage().getScaledInstance(70,100, Image.SCALE_DEFAULT));
		JLabel champ1Label=new JLabel();
		champ1Label.setIcon(scaledchamp1);
		champ1Label.setBounds(799, 460,90, 90);
		champ1Label.setVisible(true);
		this.add(champ1Label);
		
//		ImageIcon champ2=new ImageIcon(this.getClass().getResource("run2.png"));
//		ImageIcon scaledchamp2=new ImageIcon(champ2.getImage().getScaledInstance(50,80, Image.SCALE_DEFAULT));
//		JLabel champ2Label=new JLabel();
//		champ2Label.setIcon(scaledchamp2);
//		champ2Label.setBounds(350, 435,70, 70);
//		champ2Label.setVisible(true);
//		this.add(champ2Label);
//		
		ImageIcon champ3= new ImageIcon(this.getClass().getResource("venomgif.gif"));
		ImageIcon scaledchamp3=new ImageIcon(champ3.getImage().getScaledInstance(110,160, Image.SCALE_DEFAULT));
		JLabel champ3Label=new JLabel();
		champ3Label.setIcon(scaledchamp3);
		champ3Label.setBounds(120, 386,120, 180);
		champ3Label.setVisible(true);
		this.add(champ3Label);
		
		
		 StartGame=new JButton();
		StartGame.setBackground(Color.BLACK);
		ImageIcon sbutton=new ImageIcon(this.getClass().getResource("startb.png"));
		ImageIcon scaledstart=new ImageIcon(sbutton.getImage().getScaledInstance(150, 60, Image.SCALE_DEFAULT));
		StartGame.setIcon(scaledstart);

		StartGame.setForeground(Color.BLACK);
		StartGame.setFocusable(false);
		StartGame.setBounds(410, 370, 140, 40);
		StartGame.setOpaque(false);

		StartGame.setBorderPainted(false);
		this.add(StartGame);
		StartGame.addActionListener(this);
		//StartGame.addMouseListener(this);
		
		Options =new JButton();
		ImageIcon obutton=new ImageIcon(this.getClass().getResource("options22.png"));
		ImageIcon scaledoption=new ImageIcon(obutton.getImage().getScaledInstance(150, 60, Image.SCALE_DEFAULT));
		Options.setIcon(scaledoption);

		Options.setForeground(Color.white);
		Options.setBackground(Color.white);
		Options.setFocusable(false);
		Options.setOpaque(false);

		Options.setBorderPainted(false);
		Options.setBounds(410, 430, 140, 40);
		this.add(Options);
		
		setVisible(true);
		
		TheFrame.add(this);

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic,0,0,this);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==StartGame)
		{
			this.setVisible(false);
			PlayerSetting setting=new PlayerSetting(TheFrame);
			
		}
		
		
	}
	
	
	
	
}
