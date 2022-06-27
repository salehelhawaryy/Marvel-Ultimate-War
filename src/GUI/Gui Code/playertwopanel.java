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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class playertwopanel extends JPanel {
	Image pic;
	public playertwopanel() {
		new JPanel();
		this.setVisible(true);
		setLayout(null);
		
		ImageIcon obj=new ImageIcon(this.getClass().getResource("lavagif.gif"));
		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(500, 330, Image.SCALE_DEFAULT));
		pic=scaledobj.getImage();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic,0,0,this);
	}

}
