package GUI2.copy;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
//  https://cooltext.com/?gclid=CjwKCAjw7vuUBhBUEiwAEdu2pEN9jWC1Nwb41_ihU2arIaUW8sxttc64nN3mBXO-A0e03VehP0UXXhoCE1cQAvD_BwE
public class PlayerSetting extends JPanel implements ActionListener{
	String player1Name;
	String player2Name;
	JButton doneOne;
	JButton doneTwo;
	TextField Player1;
	TextField Player2;
	MainFrame theFrame;
	Image pic;
	public PlayerSetting(MainFrame frame)
	{
		theFrame=frame;
		Font SansSerifText=new Font("SansSerif",Font.ITALIC,20);
		Font SansSerifBut=new Font("SansSerif",Font.ITALIC,20);
		Font Title=new Font("SansSerif",Font.ITALIC,40);
		new JPanel();
		ImageIcon obj=new ImageIcon(this.getClass().getResource("back1.png"));
		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
		pic=scaledobj.getImage();
		setBackground(Color.black);
		setLayout(null);
		//setOpaque(false);
		 Player1=new TextField();
		 Player2=new TextField();
		 
		 JLabel text=new JLabel("Players, enter your names.");
		 text.setFont(Title);
		 text.setForeground(Color.white);
		 text.setBounds(260,50, 1000,40);
		 
		 
		 JLabel firstandsec= new JLabel();
		 ImageIcon fir=new ImageIcon(this.getClass().getResource("firstp.gif"));
		 ImageIcon scaledfir=new ImageIcon(fir.getImage().getScaledInstance(153, 46, Image.SCALE_DEFAULT));
		 firstandsec.setIcon(scaledfir);
//		 firstandsec.setFont(SansSerifText);
//		 firstandsec.setForeground(Color.white);
		 firstandsec.setBounds(310,160,180,40);
		 
		 JLabel firstandsecc= new JLabel();
		 ImageIcon sec=new ImageIcon(this.getClass().getResource("secp.gif"));
		 ImageIcon scaledsec=new ImageIcon(sec.getImage().getScaledInstance(173, 46, Image.SCALE_DEFAULT));
		 firstandsecc.setIcon(scaledsec);
//		 firstandsec.setFont(SansSerifText);
//		 firstandsec.setForeground(Color.white);
		 firstandsecc.setBounds(540,160,186,40);
		 
		
		Player2.setBounds(520, 200,200, 43);
		Player1.setBounds(290, 200, 200, 43);
		Player1.setFont(Title);
		Player2.setFont(Title);
		
		
		 doneOne=new JButton();
		//doneOne.setFont(SansSerifBut);
	    ImageIcon dbutton= new ImageIcon(this.getClass().getResource("donebutf.png"));
	    ImageIcon scaleddone=new ImageIcon(dbutton.getImage().getScaledInstance(150, 67, Image.SCALE_DEFAULT));
	    doneOne.setIcon(scaleddone);
	    doneOne.setBorderPainted(false);
		doneOne.setBounds(425,300,145, 47);
		doneOne.setForeground(Color.white);
		doneOne.setBackground(Color.white);
		doneOne.setFocusable(false);
		doneOne.setOpaque(false);
		//doneOne.setBorderPainted(false);
		doneOne.addActionListener(this);
		
	
		this.add(firstandsec);
		this.add(firstandsecc);
		//this.add(text);
		this.add(Player1);
		this.add(Player2);
		this.add(doneOne);
		theFrame.add(this);
		setVisible(true);
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(pic,0,0,null);
	}

	public String getPlayer1Name() {
		return player1Name;
	}

	public String getPlayer2Name() {
		return player2Name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==doneOne)
		{
			player1Name=Player1.getText();
			player2Name=Player2.getText();
			if(player1Name!=null && player2Name!=null)
			{
				this.setVisible(false);
				try {
					ChampSelect select=new ChampSelect(theFrame,player1Name,player2Name);
				} catch (AbilityUseException | NotEnoughResourcesException | InvalidTargetException
						| ChampionDisarmedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
				
		}
		
	}
}
