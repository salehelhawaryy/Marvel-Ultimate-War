package GUI2.copy;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.world.Champion;


public class popup extends JOptionPane{
	Image pic;
	popup(){
		new JOptionPane();
		this.setVisible(true);
		setLayout(null);
		ImageIcon obj=new ImageIcon(this.getClass().getResource("popupb.png"));
		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
		pic=scaledobj.getImage();
		this.setForeground(Color.cyan);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic,0,0,null);
	}

}
