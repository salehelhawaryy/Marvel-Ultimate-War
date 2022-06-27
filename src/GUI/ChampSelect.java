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
import javax.swing.UIManager;
import javax.swing.border.Border;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughResourcesException;
import model.world.Champion;
import model.world.Hero;
import model.world.Villain;

public class ChampSelect extends JPanel implements ActionListener{
	MainFrame theFrame;
	String firstname;
	String secondname;
	JButton button;
	boolean firstPlayerTurn=true;
	Game game;
	Player player2;
	Player player1;
	int secondPlayerCounter=0;
	JPanel Player1Panel;
	ArrayList<JButton> ChampButtons;
	ArrayList<Champion> champions;
	JPanel Player2Panel;
	JButton back;
	Image pic;
	JPanel vsPanel;
	JButton Champ11;
	JButton Champ12;
	JButton Champ13;
	JButton Champ21;
	JButton Champ22;
	JButton Champ23;
	Font font;
	Background NamesPanel;
	JPanel availableChamps;
	
	public ChampSelect(MainFrame frame,String player1name,String player2name) throws AbilityUseException, NotEnoughResourcesException, InvalidTargetException, ChampionDisarmedException
	{
		theFrame=frame;
		firstname=player1name;
		secondname=player2name;
		//setOpaque(false);
		new JPanel();
		setBackground(Color.white);
		setLayout(new BorderLayout());
		//North
		ImageIcon obj=new ImageIcon(this.getClass().getResource("back1.png"));
		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
		pic=scaledobj.getImage();
		
		
//		//West
//		ImageIcon obj=new ImageIcon(this.getClass().getResource("back1.png"));
//		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
//		pic=scaledobj.getImage();
//		
//		//East
//		ImageIcon obj=new ImageIcon(this.getClass().getResource("back1.png"));
//		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
//		pic=scaledobj.getImage();
//		
//		//South
//		ImageIcon obj=new ImageIcon(this.getClass().getResource("back1.png"));
//		ImageIcon scaledobj=new ImageIcon(obj.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT));
//		pic=scaledobj.getImage();
		
		
		 availableChamps=new Background();
		availableChamps.setBackground(Color.black);
		availableChamps.setPreferredSize(new Dimension(1000,200));
		availableChamps.setVisible(true);
		availableChamps.setLayout(new FlowLayout());
		this.add(availableChamps,BorderLayout.SOUTH);
		
		
		
		 NamesPanel=new Background();
		NamesPanel.setLayout(null);
		NamesPanel.setPreferredSize(new Dimension(1000,50));
		NamesPanel.setBackground(Color.BLACK);
		this.add(NamesPanel,BorderLayout.NORTH);
		JLabel Player1Text=new JLabel(player1name);
		Font LabelFont=new Font("SansSerif", Font.ITALIC, 38);
		Player1Text.setFont(LabelFont);
		
		
		Player1Text.setForeground(Color.white);
		Player1Text.setPreferredSize(new Dimension(70,47));
		Player1Text.setBounds(170,10,300,47);
		
		JLabel Player2Text=new JLabel(player2name);
		Player2Text.setForeground(Color.white);
		Player2Text.setPreferredSize(new Dimension(70,47));
		Player2Text.setBounds(730,10,300,47);
		Player2Text.setFont(LabelFont);
		
		/////////////////////////
		
		
		
		
	    NamesPanel.add(Player1Text);
		NamesPanel.add(Player2Text);
		
		
		
		
		 Player1Panel = new playeronepanel();
			Player1Panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			Player1Panel.setBackground(Color.black);
			Player1Panel.setPreferredSize(new Dimension(500,theFrame.getHeight()-205));
			Player1Panel.setVisible(true);
			this.add(Player1Panel,BorderLayout.WEST);
		
		//Back button
		back=new JButton();

		
		ImageIcon bbutton=new ImageIcon(this.getClass().getResource("back233.png"));
		ImageIcon scaledback=new ImageIcon(bbutton.getImage().getScaledInstance(60, 36, Image.SCALE_DEFAULT));
		back.setIcon(scaledback);
		back.setBackground(Color.BLACK);
		back.setBounds(5, 5, 45, 26);
		back.setFocusable(false);
		back.setBorderPainted(false);
		back.addActionListener(this);
		NamesPanel.add(back);
		
		//back button
		
		
		
		 Player2Panel = new playertwopanel();
			Player2Panel.setBackground(Color.black);
			Player2Panel.setPreferredSize(new Dimension(487,theFrame.getHeight()-205));
			Player2Panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			Player2Panel.setVisible(true);
			this.add(Player2Panel,BorderLayout.EAST);
		
			
			
			
			
			

			JLabel s=new JLabel();

			s.setPreferredSize(new Dimension(25,440));
			ImageIcon S=new ImageIcon(this.getClass().getResource("s.png"));
			ImageIcon scaledS=new ImageIcon(S.getImage().getScaledInstance(30, 50, Image.SCALE_DEFAULT));
			s.setIcon(scaledS);
			s.setVisible(true);
			Player2Panel.add(s);
			
			
			
			
			
			
			
		
		 Champ21=new JButton();
		 Champ21.setIcon(null);
			Champ21.setPreferredSize(new Dimension(145,440));
 		Champ21.setContentAreaFilled(false);
			Champ21.setFocusable(false);
		    Champ21.setOpaque(false);
			Champ21.setBorder(null);
			Champ21.setName("lol");
			Champ21.addActionListener(this);
			
			
			 Champ22=new JButton();
			Champ22.setPreferredSize(new Dimension(145,440));
			Champ22.setFocusable(false);
		    Champ22.setOpaque(false);
			Champ22.setBorder(null);
			Champ22.setName("lol");
			Champ22.setContentAreaFilled(false);
			Champ22.addActionListener(this);
			
			
			Champ23=new JButton();
			Champ23.setContentAreaFilled(false);
			Champ23.setPreferredSize(new Dimension(145,440));
			Champ23.setName("lol");
			Champ23.setFocusable(false);
		    Champ23.setOpaque(false);
			Champ23.setBorder(null);
			Champ23.addActionListener(this);
			Player2Panel.add(Champ21);
			Player2Panel.add(Champ22);
			Player2Panel.add(Champ23);
		
			 Champ11=new JButton();
				Champ11.setPreferredSize(new Dimension(145,440));
				Champ11.setContentAreaFilled(false);
				Champ11.setFocusable(false);
			    Champ11.setOpaque(false);
				Champ11.setBorder(null);
				Champ11.setName("lol");
				Champ11.addActionListener(this);
				
				
				 Champ12=new JButton();
				Champ12.setPreferredSize(new Dimension(145,440));
				Champ12.setContentAreaFilled(false);
				Champ12.setName("lol");
				Champ12.setFocusable(false);
			    Champ12.setOpaque(false);
				Champ12.setBorder(null);
				Champ12.addActionListener(this);
				
				
				Champ13=new JButton();
				Champ13.setPreferredSize(new Dimension(145,440));
				Champ13.setContentAreaFilled(false);
				Champ13.setFocusable(false);
			    Champ13.setOpaque(false);
			    Champ13.setName("lol");
				Champ13.setBorder(null);
				Champ13.addActionListener(this);
				Player1Panel.add(Champ13);
				Player1Panel.add(Champ12);
				Player1Panel.add(Champ11);
				
				
				
				
				JLabel v=new JLabel();

				v.setPreferredSize(new Dimension(25,440));
				ImageIcon V=new ImageIcon(this.getClass().getResource("vnew.png"));
				ImageIcon scaledV=new ImageIcon(V.getImage().getScaledInstance(30, 55, Image.SCALE_DEFAULT));
				v.setIcon(scaledV);
				v.setVisible(true);
				Player1Panel.add(v);
				
				
				

//		 vsPanel=new Background();
//		vsPanel.setPreferredSize(new Dimension(100,theFrame.getHeight()-200));
//		vsPanel.setLayout(null);
//		JLabel vsLabel=new JLabel("VS");
//		vsLabel.setBounds(10, 260, 100, 40);
//		vsLabel.setForeground(Color.white);
//		vsPanel.setBackground(Color.black);
//		
//		vsLabel.setFont(LabelFont);
//		vsPanel.add(vsLabel);
//		vsPanel.setVisible(true);
		//this.add(vsPanel,BorderLayout.CENTER);
		
		
		 player1= new Player(player1name);
		 player2=new Player(player2name);
		try {
			game=new Game(player1, player2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//popup
		UIManager UI=new UIManager();
		 UI.put("OptionPane.background", Color.black);
		 UI.put("Panel.background", Color.black);
		 UI.put("OptionPane.messageForeground",Color.white);
		 
		 JButton but=new JButton();
		 but.setPreferredSize(new Dimension(52,26));
			but.setBackground(Color.white);
			but.setFocusable(false);
			but.setOpaque(false);
			but.setForeground(Color.black);
			but.addActionListener(this);
			ImageIcon ok= new ImageIcon(this.getClass().getResource("okbut.png"));
			ImageIcon scaledok=new ImageIcon(ok.getImage().getScaledInstance(59, 34, Image.SCALE_DEFAULT));
			but.setIcon(scaledok);
			but.setName("khara");
			
			JButton[] buts= {but};
			ImageIcon ic=new ImageIcon(this.getClass().getResource("letter_m_PNG56.png"));
			ImageIcon scaledic=new ImageIcon(ic.getImage().getScaledInstance(30, 26, Image.SCALE_DEFAULT));
			//ENd of pop up
		 
		
		
		ChampButtons=new ArrayList<>();
		champions=game.getAvailableChampions();
		for(int i=0;i<Game.getAvailableChampions().size();i++)
		{
			button=new JButton();
			button.setPreferredSize(new Dimension(100,90));
			button.setName(Game.getAvailableChampions().get(i).getName());
			button.setBackground(Color.white);
			button.setFocusable(false);
			button.setOpaque(false);
			button.setBorder(BorderFactory.createLineBorder(Color.white,3));
			button.setForeground(Color.black);
			button.addActionListener(this);
			switch(button.getName())
			{
			case "Loki":
				ImageIcon loki= new ImageIcon(this.getClass().getResource("lokiffn.png"));
				ImageIcon scaledloki=new ImageIcon(loki.getImage().getScaledInstance(110, 80, Image.SCALE_DEFAULT));
				button.setIcon(scaledloki);
				break;
				
			case "Hela":
				ImageIcon hela= new ImageIcon(this.getClass().getResource("helahela.png"));
				ImageIcon scaledhela=new ImageIcon(hela.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT));
				button.setIcon(scaledhela);
				break;
			case "Ghost Rider":
				ImageIcon ghost= new ImageIcon(this.getClass().getResource("ghost but.png"));
				ImageIcon scaledghost=new ImageIcon(ghost.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledghost);
				break;
			case "Quicksilver":
				ImageIcon quick= new ImageIcon(this.getClass().getResource("quicksilver final.png"));
				ImageIcon scaledquick=new ImageIcon(quick.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledquick);
				break;
			case "Ironman":
					ImageIcon Ironman= new ImageIcon(this.getClass().getResource("iron but.png"));
					ImageIcon scaledIronman=new ImageIcon(Ironman.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
					button.setIcon(scaledIronman);
					break;
					
			case "Deadpool":
				ImageIcon Deadpool= new ImageIcon(this.getClass().getResource("deadpoolicon.png"));
				ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledDeadpool);
				break;
				
			case "Venom":
				ImageIcon venom= new ImageIcon(this.getClass().getResource("venomIcon.png"));
				ImageIcon scaledVenom=new ImageIcon(venom.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledVenom);
				break;
			case "Captain America":
				ImageIcon Captain= new ImageIcon(this.getClass().getResource("ca.png"));
				ImageIcon scaledCaptain=new ImageIcon(Captain.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledCaptain);
				break;
			case "Hulk":
				ImageIcon Hulk= new ImageIcon(this.getClass().getResource("hulk.png"));
				ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledHulk);
				break;
				
			case "Thor":
				ImageIcon Thor= new ImageIcon(this.getClass().getResource("thorffn.png"));
				ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(115, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledThor);
				break;
			
			case "Spiderman":
				ImageIcon spider= new ImageIcon(this.getClass().getResource("spidey.png"));
				ImageIcon scaledspider=new ImageIcon(spider.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledspider);
				break;
				
			case "Yellow Jacket":
				ImageIcon yellow= new ImageIcon(this.getClass().getResource("yellow jacket final.png"));
				ImageIcon scaledyellow=new ImageIcon(yellow.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledyellow);
				break;
			
			case "Electro":
				ImageIcon electro= new ImageIcon(this.getClass().getResource("electrolo.png"));
				ImageIcon scaledelectro=new ImageIcon(electro.getImage().getScaledInstance(90, 100, Image.SCALE_DEFAULT));
				button.setIcon(scaledelectro);
				break;
				
			case "Dr Strange":
				ImageIcon dr= new ImageIcon(this.getClass().getResource("dr but.png"));
				ImageIcon scaleddr=new ImageIcon(dr.getImage().getScaledInstance(115, 110, Image.SCALE_DEFAULT));
				
				button.setIcon(scaleddr);
				break;
				
			case "Iceman":
				ImageIcon ice= new ImageIcon(this.getClass().getResource("ice man final.png"));
				ImageIcon scaledice=new ImageIcon(ice.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));
				button.setIcon(scaledice);
				break;
			}
			ChampButtons.add(button);
			availableChamps.add(button);
		}
		
		
		
		
		theFrame.add(this);
		JOptionPane.showOptionDialog(null, "First player will start by selecting a champion,\n and then it will be alternated between both players.", "", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE,scaledic , buts, buts[0]);
		
	}
	
	

	@SuppressWarnings("static-access")
	public Champion getChamp(String name)
	{
		for(int i=0;i<game.getAvailableChampions().size();i++)
		{
			if(name.equals(game.getAvailableChampions().get(i).getName()))
				return game.getAvailableChampions().get(i);
		}
		return null;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.getRootFrame().dispose();
		if(e.getSource()==back) {
			
			this.setVisible(false);
			PlayerSetting set=new PlayerSetting(theFrame);
			return;
		}
		if(e.getSource()==Champ11)
		{
			if(Champ11.getIcon()!=null)
			{
				for(int i=0;i<player1.getTeam().size();i++)
				{
					if(player1.getTeam().get(i).getName().equals(Champ11.getName()))
					{
						player1.setLeader(player1.getTeam().get(i));
						JOptionPane.showMessageDialog(this,player1.getTeam().get(i).getName()+" Selected As Leader!");
						return;
					}
				}
			}
			else
				System.out.println("dehk");
		}
		if(e.getSource()==Champ12)
		{
			if(Champ12.getIcon()!=null)
			{
				for(int i=0;i<player1.getTeam().size();i++)
				{
					if(player1.getTeam().get(i).getName().equals(Champ12.getName()))
					{
						player1.setLeader(player1.getTeam().get(i));
						JOptionPane.showMessageDialog(this,player1.getTeam().get(i).getName()+" Selected As Leader!");
						return;
					}
				}
			}
		}
		if(e.getSource()==Champ13)
		{
			if(Champ13.getIcon()!=null)
			{
				for(int i=0;i<player1.getTeam().size();i++)
				{
					if(player1.getTeam().get(i).getName().equals(Champ13.getName()))
					{
						player1.setLeader(player1.getTeam().get(i));
						JOptionPane.showMessageDialog(this,player1.getTeam().get(i).getName()+" Selected As Leader!");
						return;
					}
				}
			}
				
		}
		
		if(e.getSource()==Champ21)
		{
			if(Champ21.getIcon()!=null)
			{
				for(int i=0;i<player2.getTeam().size();i++)
				{
					if(player2.getTeam().get(i).getName().equals(Champ21.getName()))
					{
						player2.setLeader(player2.getTeam().get(i));
						JOptionPane.showMessageDialog(this,player2.getTeam().get(i).getName()+" Selected As Leader!");
						return;
					}
				}
			}
		}
		if(e.getSource()==Champ22)
		{
			if(Champ22.getIcon()!=null)
			{
				for(int i=0;i<player2.getTeam().size();i++)
				{
					if(player2.getTeam().get(i).getName().equals(Champ22.getName()))
					{
						player2.setLeader(player2.getTeam().get(i));
						JOptionPane.showMessageDialog(this,player2.getTeam().get(i).getName()+" Selected As Leader!");
						return;
					}
				}
			}
		}
		
		if(e.getSource()==Champ23)
		{
			if(Champ23.getIcon()!=null)
			{
				for(int i=0;i<player2.getTeam().size();i++)
				{
					if(player2.getTeam().get(i).getName().equals(Champ23.getName()))
					{
						player2.setLeader(player2.getTeam().get(i));
						JOptionPane.showMessageDialog(this,player2.getTeam().get(i).getName()+" Selected As Leader!");
						return;
					}
				}
			}
		}
		
		
		
		
		
		JButton curr=null;
		for(int i=0;i<ChampButtons.size();i++)
		{
			 curr=(JButton)e.getSource();
			if(curr.getName().equals("Start"))
			{
				if(game.getFirstPlayer().getLeader()!=null && game.getSecondPlayer().getLeader()!=null)
				{
					this.setVisible(false);
					Gameplay gameplay=new Gameplay(theFrame,game,firstname,secondname);
					return;
				}
					
			}
			if(ChampButtons.get(i).getName().equals(curr.getName()))
			break;
		}
		
		
		
		
		switch(curr.getName())
		{
		case "Ironman":
			ButtonOption("Ironman",curr);
			break;
		case "Loki":
			ButtonOption("Loki",curr);
			break;
		case "Captain America":
			ButtonOption("Captain America",curr);
			break;
		case "Spiderman":
			ButtonOption("Spiderman",curr);
			break;
		case "Thor":
			ButtonOption("Thor",curr);
			break;
		case "Hela":
			ButtonOption("Hela",curr);
			break;
		case "Hulk":
			ButtonOption("Hulk",curr);
			break;
		case "Quicksilver":
			ButtonOption("Quicksilver",curr);
			break;
		case "Iceman":
			ButtonOption("Iceman",curr);
			break;
		case "Venom":
			ButtonOption("Venom",curr);
			break;
		case "Yellow Jacket":
			ButtonOption("Yellow Jacket",curr);
			break;
		case "Deadpool":
			ButtonOption("Deadpool",curr);
			break;
		case "Dr Strange":
			ButtonOption("Dr Strange",curr);
			break;
		case "Electro":
			ButtonOption("Electro",curr);
			break;
		case "Ghost Rider":
			ButtonOption("Ghost Rider",curr);
			break;
 		}
	}

	private void ButtonOption(String string, JButton curr) {
		String[] options= {"Select Champion","Show Information"};
		String[] second= {"Select Champion"};
		Champion myChampion=null;
		String []abilities=new String[3];
		for(int i=0;i<champions.size();i++)
		{
			if(champions.get(i).getName().equals(string))
			{
				myChampion=champions.get(i);
				break;
			}
		}
		int decision =JOptionPane.showOptionDialog(this, "Choose Action", curr.getName(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		if(decision==0) //select champ
		{
			
			SetAvatar(string,myChampion);
			if(firstPlayerTurn)
			{
				player1.getTeam().add(myChampion);
				firstPlayerTurn=false;
				
				//System.out.println(player1.getTeam().get(0).getName());
			}
			else
			{
				player2.getTeam().add(myChampion);
				firstPlayerTurn=true;
				secondPlayerCounter++;
				//System.out.println(player2.getTeam().get(0).getName());
				
				if(secondPlayerCounter==3)
				{
					JOptionPane.showMessageDialog(this,"Players, Please Select Your Leaders by clicking on them");
					//vsLabel.setBounds(18, 260, 100, 40);
					JButton start= new JButton();
					start.setBounds(460,14, 75, 27);
					
					ImageIcon star=new ImageIcon(this.getClass().getResource("startboard.png"));
					ImageIcon scaledstar=new ImageIcon(star.getImage().getScaledInstance(85, 43, Image.SCALE_DEFAULT));
					start.setIcon(scaledstar);
					start.setName("Start");
					NamesPanel.add(start);
					NamesPanel.revalidate();
					NamesPanel.repaint();
					start.addActionListener(this);
					ChampButtons.add(start);
				}
			}
			curr.setEnabled(false);
		}
		else if(decision==1)
		{
			
			for(int i=0;i<myChampion.getAbilities().size();i++)
				abilities[i]=myChampion.getAbilities().get(i).getName();
			String Imp="Name: "+myChampion.getName()+"\n"+"Max Health: "+myChampion.getMaxHP()+"\nMax Actions Points: "+myChampion.getMaxActionPointsPerTurn()+"\nMax Mana: "+myChampion.getMana()
			+"\nAttack Damage: "+myChampion.getAttackDamage()+"\nAttack Range: "+myChampion.getAttackRange()+"\nSpeed: "+myChampion.getSpeed()+"\nAbilities: "+abilities[0]+", "+abilities[1]+", "+abilities[2];
			
			
			int two =JOptionPane.showOptionDialog(this, Imp, "Infomation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
			JOptionPane ddJOptionPane=new JOptionPane();
			if(two==0)
			{
				SetAvatar(string,myChampion);
				if(firstPlayerTurn)
				{
					player1.getTeam().add(myChampion);
					firstPlayerTurn=false;
					//System.out.println(player1.getTeam().get(0).getName());
				}
				else
				{
					player2.getTeam().add(myChampion);
					firstPlayerTurn=true;
					secondPlayerCounter++;
					if(secondPlayerCounter==3)
					{
						//vsLabel.setBounds(18, 260, 100, 40);
						JButton start= new JButton();
						start.setBounds(200,10, 73, 20);
						start.setVisible(true);
						ImageIcon star=new ImageIcon(this.getClass().getResource("startboard.png"));
						ImageIcon scaledstar=new ImageIcon(star.getImage().getScaledInstance(80, 37, Image.SCALE_DEFAULT));
						start.setIcon(scaledstar);
						//start.setFont(new Font("SansSerif",Font.ITALIC,15));
						start.setName("Start");
						NamesPanel.add(start);
						NamesPanel.revalidate();
						NamesPanel.repaint();
						start.addActionListener(this);
						ChampButtons.add(start);
						//Champ11.setBorder(getBorder());
					}
					//System.out.println(player2.getTeam().get(0).getName());
				}
				curr.setEnabled(false);
			}
		}
		
	}
		
		
		
		
//	public void SetAvatar(String name)
//	{
////		JLabel CurrChamp=new JLabel();
////		CurrChamp.setSize(new Dimension(145,440));
////		JButton button=new JButton("dehk");
////		button.setForeground(Color.white);
//		//Player1Panel.add(button);
//		
//		switch (name)
//		{
//		case "Ironman":
//			
//			if(firstPlayerTurn)
//			{
//				ImageIcon ironman=new ImageIcon(this.getClass().getResource("ironavatarp1.png"));
//				ImageIcon scaledironman=new ImageIcon(ironman.getImage().getScaledInstance(145,250, Image.SCALE_DEFAULT));
//				if(secondPlayerCounter==0)
//				{
//					Champ11.setIcon(scaledironman);
//					Champ11.setName(name);
//					Player1Panel.revalidate();
//					Player1Panel.repaint();
//					//Player1Panel.add(button);
//				}
//				else if(secondPlayerCounter==1)
//				{
//					Champ12.setIcon(scaledironman);
//					Champ12.setName(name);
//					Player1Panel.revalidate();
//					Player1Panel.repaint();
//				}
//				else 
//				{
//					Champ13.setIcon(scaledironman);
//					Champ13.setName(name);
//					Player1Panel.revalidate();
//					Player1Panel.repaint();
//				}
//			}
//			else 
//			{
//				ImageIcon ironman=new ImageIcon(this.getClass().getResource("ironavatarp2.png"));
//				ImageIcon scaledironman=new ImageIcon(ironman.getImage().getScaledInstance(145,250, Image.SCALE_DEFAULT));
//				if(secondPlayerCounter==0)
//				{
//					Champ21.setIcon(scaledironman);
//					Champ21.setName(name);
//					Player2Panel.revalidate();
//					Player2Panel.repaint();
//					//Player1Panel.add(button);
//				}
//				else if(secondPlayerCounter==1)
//				{
//					Champ22.setIcon(scaledironman);
//					Champ22.setName(name);
//					Player2Panel.revalidate();
//					Player2Panel.repaint();
//				}
//				else 
//				{
//					Champ23.setIcon(scaledironman);
//					Champ23.setName(name);
//					Player2Panel.revalidate();
//					Player2Panel.repaint();
//				}
//			}
////			Player1Panel.setBackground(Color.black);
////			Player2Panel.setBackground(Color.black);
//			break;
//			
//		case "Venom":
//			if(firstPlayerTurn)
//			{
//				ImageIcon venom=new ImageIcon(this.getClass().getResource("venom avatar p1.png"));
//				ImageIcon scaledvenom=new ImageIcon(venom.getImage().getScaledInstance(145,250, Image.SCALE_DEFAULT));
//				if(secondPlayerCounter==0)
//				{
//					Champ11.setIcon(scaledvenom);
//					Champ11.setName(name);
//					Player1Panel.revalidate();
//					Player1Panel.repaint();
//					//Player1Panel.add(button);
//				}
//				else if(secondPlayerCounter==1)
//				{
//					Champ12.setIcon(scaledvenom);
//					Champ12.setName(name);
//					Player1Panel.revalidate();
//					Player1Panel.repaint();
//				}
//				else 
//				{
//					Champ13.setIcon(scaledvenom);
//					Champ13.setName(name);
//					Player1Panel.revalidate();
//					Player1Panel.repaint();
//				}
//			}
//			else 
//			{
//				ImageIcon venom=new ImageIcon(this.getClass().getResource("venom avatar p2.png"));
//				ImageIcon scaledvenom=new ImageIcon(venom.getImage().getScaledInstance(145,250, Image.SCALE_DEFAULT));
//				if(secondPlayerCounter==0)
//				{
//					Champ21.setIcon(scaledvenom);
//					Champ21.setName(name);
//					Player2Panel.revalidate();
//					Player2Panel.repaint();
//					//Player1Panel.add(button);
//				}
//				else if(secondPlayerCounter==1)
//				{
//					Champ22.setIcon(scaledvenom);
//					Champ22.setName(name);
//					Player2Panel.revalidate();
//					Player2Panel.repaint();
//				}
//				else 
//				{
//					Champ23.setIcon(scaledvenom);
//					Champ23.setName(name);
//					Player2Panel.revalidate();
//					Player2Panel.repaint();
//				}
//				
//			}
////			Player1Panel.setBackground(Color.black);
////			Player2Panel.setBackground(Color.black);
//			break;
//		}
//		
//	}
			
		
	public void SetAvatar(String name,Champion myChampion)
	{
		Font font = new Font("Sanserif",Font.ITALIC,12);
		switch (name)
		{
		case "Ironman":
			if(firstPlayerTurn)
			{
				ImageIcon ironman=new ImageIcon(this.getClass().getResource("IronSprite1.png"));
				ImageIcon scaledironman=new ImageIcon(ironman.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ11.setIcon(scaledironman);
					Champ11.setName(name);
					Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ11.setForeground(Color.white);
					Champ11.setVerticalTextPosition(SwingConstants.TOP);
					Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ11.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ11.setText(name+" - Hero");
					else 
						Champ11.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else if(secondPlayerCounter==1)
				{
					Champ12.setIcon(scaledironman);
					Champ12.setName(name);
					Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ12.setForeground(Color.white);
					Champ12.setVerticalTextPosition(SwingConstants.TOP);
					Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ12.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ12.setText(name+" - Hero");
					else 
						Champ12.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else 
				{
					Champ13.setIcon(scaledironman);
					Champ13.setName(name);
					Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ13.setForeground(Color.white);
					Champ13.setVerticalTextPosition(SwingConstants.TOP);
					Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ13.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ13.setText(name+" - Hero");
					else 
						Champ13.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
			}
			else 
			{
				ImageIcon ironman=new ImageIcon(this.getClass().getResource("IronSprite2.png"));
				ImageIcon scaledironman=new ImageIcon(ironman.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ21.setIcon(scaledironman);
					Champ21.setName(name);
					Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ21.setForeground(Color.white);
					Champ21.setVerticalTextPosition(SwingConstants.TOP);
					Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ21.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ21.setText(name+" - Hero");
					else 
						Champ21.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else if(secondPlayerCounter==1)
				{
					Champ22.setIcon(scaledironman);
					Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ22.setForeground(Color.white);
					Champ22.setVerticalTextPosition(SwingConstants.TOP);
					Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ22.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ22.setText(name+" - Hero");
					else 
						Champ22.setText(name+" - AntiHero");
					Champ22.setName(name);
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else 
				{
					Champ23.setIcon(scaledironman);
					Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ23.setForeground(Color.white);
					Champ23.setVerticalTextPosition(SwingConstants.TOP);
					Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ23.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ23.setText(name+" - Hero");
					else 
						Champ23.setText(name+" - AntiHero");
					Champ23.setName(name);
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
			}
			break;
			
		case "Venom":
			if(firstPlayerTurn)
			{
				ImageIcon venom=new ImageIcon(this.getClass().getResource("VenomSprite1.png"));
				ImageIcon scaledvenom=new ImageIcon(venom.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ11.setIcon(scaledvenom);
					Champ11.setName(name);
					Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ11.setForeground(Color.white);
					Champ11.setVerticalTextPosition(SwingConstants.TOP);
					Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ11.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ11.setText(name+" - Hero");
					else 
						Champ11.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else if(secondPlayerCounter==1)
				{
					Champ12.setIcon(scaledvenom);
					Champ12.setName(name);
					Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ12.setForeground(Color.white);
					Champ12.setVerticalTextPosition(SwingConstants.TOP);
					Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ12.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ12.setText(name+" - Hero");
					else 
						Champ12.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else 
				{
					Champ13.setIcon(scaledvenom);
					Champ13.setName(name);
					Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ13.setForeground(Color.white);
					Champ13.setVerticalTextPosition(SwingConstants.TOP);
					Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ13.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ13.setText(name+" - Hero");
					else 
						Champ13.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
			}
			else 
			{
				ImageIcon venom=new ImageIcon(this.getClass().getResource("VenomSprite2.png"));
				ImageIcon scaledvenom=new ImageIcon(venom.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ21.setIcon(scaledvenom);
					Champ21.setName(name);
					Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ21.setForeground(Color.white);
					Champ21.setVerticalTextPosition(SwingConstants.TOP);
					Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ21.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ21.setText(name+" - Hero");
					else 
						Champ21.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else if(secondPlayerCounter==1)
				{
					Champ22.setIcon(scaledvenom);
					Champ22.setName(name);
					Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ22.setForeground(Color.white);
					Champ22.setVerticalTextPosition(SwingConstants.TOP);
					Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ22.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ22.setText(name+" - Hero");
					else 
						Champ22.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else 
				{
					Champ23.setIcon(scaledvenom);
					Champ23.setName(name);
					Champ23.setName(name);
					Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ23.setForeground(Color.white);
					Champ23.setVerticalTextPosition(SwingConstants.TOP);
					Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ23.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ23.setText(name+" - Hero");
					else 
						Champ23.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
			}
			break;
			
		case "Captain America":
			if(firstPlayerTurn)
		    {
				ImageIcon CaptainAmerica= new ImageIcon(this.getClass().getResource("CaptainAmericaSprite1.png"));
			    ImageIcon scaledCaptainAmerica=new ImageIcon(CaptainAmerica.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			    if(secondPlayerCounter==0)
			    {
			    	Champ11.setIcon(scaledCaptainAmerica);
				    Champ11.setName(name);
				    Champ11.setFont(new Font("SansSerif",Font.ITALIC,12));
					Champ11.setForeground(Color.white);
					Champ11.setVerticalTextPosition(SwingConstants.TOP);
					Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ11.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ11.setText(name+" - Hero");
					else 
						Champ11.setText(name+" - AntiHero");
				    Player1Panel.revalidate();
				    Player1Panel.repaint();
			    }
			    else if(secondPlayerCounter==1)
			    {
			    	Champ12.setIcon(scaledCaptainAmerica);
				    Champ12.setName(name);
				    Champ12.setFont(new Font("SansSerif",Font.ITALIC,12));
					Champ12.setForeground(Color.white);
					Champ12.setVerticalTextPosition(SwingConstants.TOP);
					Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ12.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ12.setText(name+" - Hero");
					else 
						Champ12.setText(name+" - AntiHero");
				    Player1Panel.revalidate();
				    Player1Panel.repaint();
			    }
			    else 
			    {
				    Champ13.setIcon(scaledCaptainAmerica);
				    Champ13.setName(name);
				    Champ13.setFont(new Font("SansSerif",Font.ITALIC,12));
					Champ13.setForeground(Color.white);
					Champ13.setVerticalTextPosition(SwingConstants.TOP);
					Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ13.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ13.setText(name+" - Hero");
					else 
						Champ13.setText(name+" - AntiHero");
				    Player1Panel.revalidate();
				    Player1Panel.repaint();
			    }
		    }
		    else 
		    {
		    	ImageIcon CaptainAmerica=new ImageIcon(this.getClass().getResource("CaptainAmericaSprite2.png"));
			    ImageIcon scaledCaptainAmerica=new ImageIcon(CaptainAmerica.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			    if(secondPlayerCounter==0)
			    {
			    Champ21.setIcon(scaledCaptainAmerica);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledCaptainAmerica);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledCaptainAmerica);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
		
	case "Deadpool":
		if(firstPlayerTurn)
		{
			ImageIcon Deadpool = new ImageIcon(this.getClass().getResource("DeadpoolSprite1.png"));
			ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledDeadpool);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledDeadpool);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledDeadpool);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon Deadpool=new ImageIcon(this.getClass().getResource("DeadpoolSprite2.png"));
			ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledDeadpool);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledDeadpool);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledDeadpool);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
		
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
		
		
        case "Dr Strange":
			
			if(firstPlayerTurn)
			{
				ImageIcon DrStrange=new ImageIcon(this.getClass().getResource("DrStrangeModel1.png"));
				ImageIcon scaledDrStrange=new ImageIcon(DrStrange.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ11.setIcon(scaledDrStrange);
					Champ11.setName(name);
					Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ11.setForeground(Color.white);
					Champ11.setVerticalTextPosition(SwingConstants.TOP);
					Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ11.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ11.setText(name+" - Hero");
					else 
						Champ11.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ12.setIcon(scaledDrStrange);
					Champ12.setName(name);
					Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ12.setForeground(Color.white);
					Champ12.setVerticalTextPosition(SwingConstants.TOP);
					Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ12.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ12.setText(name+" - Hero");
					else 
						Champ12.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else 
				{
					Champ13.setIcon(scaledDrStrange);
					Champ13.setName(name);
					Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ13.setForeground(Color.white);
					Champ13.setVerticalTextPosition(SwingConstants.TOP);
					Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ13.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ13.setText(name+" - Hero");
					else 
						Champ13.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
			}
			else 
			{
				ImageIcon DrStrange=new ImageIcon(this.getClass().getResource("DrStrangeModel2.png"));
				ImageIcon scaledDrStrange=new ImageIcon(DrStrange.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ21.setIcon(scaledDrStrange);
					Champ21.setName(name);
					Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ21.setForeground(Color.white);
					Champ21.setVerticalTextPosition(SwingConstants.TOP);
					Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ21.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ21.setText(name+" - Hero");
					else 
						Champ21.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ22.setIcon(scaledDrStrange);
					Champ22.setName(name);
					Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ22.setForeground(Color.white);
					Champ22.setVerticalTextPosition(SwingConstants.TOP);
					Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ22.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ22.setText(name+" - Hero");
					else 
						Champ22.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else 
				{
					Champ23.setIcon(scaledDrStrange);
					Champ23.setName(name);
					Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ23.setForeground(Color.white);
					Champ23.setVerticalTextPosition(SwingConstants.TOP);
					Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ23.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ23.setText(name+" - Hero");
					else 
						Champ23.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
			}
//			Player1Panel.setBackground(Color.black);
//			Player2Panel.setBackground(Color.black);
			break;
			
		case "Electro":
			if(firstPlayerTurn)
			{
				ImageIcon electro=new ImageIcon(this.getClass().getResource("ElectroSprite1.png"));
				ImageIcon scaledElectro=new ImageIcon(electro.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ11.setIcon(scaledElectro);
					Champ11.setName(name);
					Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ11.setForeground(Color.white);
					Champ11.setVerticalTextPosition(SwingConstants.TOP);
					Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ11.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ11.setText(name+" - Hero");
					else 
						Champ11.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ12.setIcon(scaledElectro);
					Champ12.setName(name);
					Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ12.setForeground(Color.white);
					Champ12.setVerticalTextPosition(SwingConstants.TOP);
					Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ12.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ12.setText(name+" - Hero");
					else 
						Champ12.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else 
				{
					Champ13.setIcon(scaledElectro);
					Champ13.setName(name);
					Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ13.setForeground(Color.white);
					Champ13.setVerticalTextPosition(SwingConstants.TOP);
					Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ13.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ13.setText(name+" - Hero");
					else 
						Champ13.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
			}
			else 
			{
				ImageIcon electro=new ImageIcon(this.getClass().getResource("ElectroSprite2.png"));
				ImageIcon scaledElectro=new ImageIcon(electro.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ21.setIcon(scaledElectro);
					Champ21.setName(name);
					Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ21.setForeground(Color.white);
					Champ21.setVerticalTextPosition(SwingConstants.TOP);
					Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ21.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ21.setText(name+" - Hero");
					else 
						Champ21.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ22.setIcon(scaledElectro);
					Champ22.setName(name);
					Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ22.setForeground(Color.white);
					Champ22.setVerticalTextPosition(SwingConstants.TOP);
					Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ22.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ22.setText(name+" - Hero");
					else 
						Champ22.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else 
				{
					Champ23.setIcon(scaledElectro);
					Champ23.setName(name);
					Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ23.setForeground(Color.white);
					Champ23.setVerticalTextPosition(SwingConstants.TOP);
					Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ23.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ23.setText(name+" - Hero");
					else 
						Champ23.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				
			}
//			Player1Panel.setBackground(Color.black);
//			Player2Panel.setBackground(Color.black);
			break;
			
			
		
	case "Ghost Rider":
		
		if(firstPlayerTurn)
		{
			ImageIcon ghostRider=new ImageIcon(this.getClass().getResource("GhostRider1.png"));
			ImageIcon scaledGhostRider=new ImageIcon(ghostRider.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledGhostRider);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledGhostRider);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledGhostRider);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon ghostRider=new ImageIcon(this.getClass().getResource("GhostRider2.png"));
			ImageIcon scaledGhostRider=new ImageIcon(ghostRider.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledGhostRider);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledGhostRider);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledGhostRider);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
		
	case "Hela":
		if(firstPlayerTurn)
		{
			ImageIcon Hela=new ImageIcon(this.getClass().getResource("Hela1.png"));
			ImageIcon scaledHela=new ImageIcon(Hela.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledHela);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledHela);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledHela);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon Hela=new ImageIcon(this.getClass().getResource("Hela2.png"));
			ImageIcon scaledHela=new ImageIcon(Hela.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledHela);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledHela);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledHela);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			
		}
		break;
		
      case "Hulk":
			
			if(firstPlayerTurn)
			{
				ImageIcon Hulk=new ImageIcon(this.getClass().getResource("HulkSprite1.png"));
				ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ11.setIcon(scaledHulk);
					Champ11.setName(name);
					Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ11.setForeground(Color.white);
					Champ11.setVerticalTextPosition(SwingConstants.TOP);
					Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ11.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ11.setText(name+" - Hero");
					else 
						Champ11.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ12.setIcon(scaledHulk);
					Champ12.setName(name);
					Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ12.setForeground(Color.white);
					Champ12.setVerticalTextPosition(SwingConstants.TOP);
					Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ12.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ12.setText(name+" - Hero");
					else 
						Champ12.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else 
				{
					Champ13.setIcon(scaledHulk);
					Champ13.setName(name);
					Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ13.setForeground(Color.white);
					Champ13.setVerticalTextPosition(SwingConstants.TOP);
					Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ13.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ13.setText(name+" - Hero");
					else 
						Champ13.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
			}
			else 
			{
				ImageIcon Hulk=new ImageIcon(this.getClass().getResource("HulkSprite2.png"));
				ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ21.setIcon(scaledHulk);
					Champ21.setName(name);
					Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ21.setForeground(Color.white);
					Champ21.setVerticalTextPosition(SwingConstants.TOP);
					Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ21.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ21.setText(name+" - Hero");
					else 
						Champ21.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ22.setIcon(scaledHulk);
					Champ22.setName(name);
					Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ22.setForeground(Color.white);
					Champ22.setVerticalTextPosition(SwingConstants.TOP);
					Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ22.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ22.setText(name+" - Hero");
					else 
						Champ22.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else 
				{
					Champ23.setIcon(scaledHulk);
					Champ23.setName(name);
					Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ23.setForeground(Color.white);
					Champ23.setVerticalTextPosition(SwingConstants.TOP);
					Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ23.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ23.setText(name+" - Hero");
					else 
						Champ23.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
			}
//			Player1Panel.setBackground(Color.black);
//			Player2Panel.setBackground(Color.black);
			break;
			
		case "Iceman":
			if(firstPlayerTurn)
			{
				ImageIcon Iceman=new ImageIcon(this.getClass().getResource("IceManSprite1.png"));
				ImageIcon scaledIceman=new ImageIcon(Iceman.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ11.setIcon(scaledIceman);
					Champ11.setName(name);
					Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ11.setForeground(Color.white);
					Champ11.setVerticalTextPosition(SwingConstants.TOP);
					Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ11.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ11.setText(name+" - Hero");
					else 
						Champ11.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ12.setIcon(scaledIceman);
					Champ12.setName(name);
					Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ12.setForeground(Color.white);
					Champ12.setVerticalTextPosition(SwingConstants.TOP);
					Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ12.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ12.setText(name+" - Hero");
					else 
						Champ12.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
				else 
				{
					Champ13.setIcon(scaledIceman);
					Champ13.setName(name);
					Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ13.setForeground(Color.white);
					Champ13.setVerticalTextPosition(SwingConstants.TOP);
					Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ13.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ13.setText(name+" - Hero");
					else 
						Champ13.setText(name+" - AntiHero");
					Player1Panel.revalidate();
					Player1Panel.repaint();
				}
			}
			else 
			{
				ImageIcon Iceman=new ImageIcon(this.getClass().getResource("IceManSprite2.png"));
				ImageIcon scaledIceman=new ImageIcon(Iceman.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
				if(secondPlayerCounter==0)
				{
					Champ21.setIcon(scaledIceman);
					Champ21.setName(name);
					Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ21.setForeground(Color.white);
					Champ21.setVerticalTextPosition(SwingConstants.TOP);
					Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ21.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ21.setText(name+" - Hero");
					else 
						Champ21.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
					//Player1Panel.add(button);
				}
				else if(secondPlayerCounter==1)
				{
					Champ22.setIcon(scaledIceman);
					Champ22.setName(name);
					Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ22.setForeground(Color.white);
					Champ22.setVerticalTextPosition(SwingConstants.TOP);
					Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ22.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ22.setText(name+" - Hero");
					else 
						Champ22.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				else 
				{
					Champ23.setIcon(scaledIceman);
					Champ23.setName(name);
					Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
					Champ23.setForeground(Color.white);
					Champ23.setVerticalTextPosition(SwingConstants.TOP);
					Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
					if(myChampion instanceof Villain)
						Champ23.setText(name+" - Villain");
					else if(myChampion instanceof Hero)
						Champ23.setText(name+" - Hero");
					else 
						Champ23.setText(name+" - AntiHero");
					Player2Panel.revalidate();
					Player2Panel.repaint();
				}
				
			}
//			Player1Panel.setBackground(Color.black);
//			Player2Panel.setBackground(Color.black);
			break;
			
			
		
	case "Loki":
		
		if(firstPlayerTurn)
		{
			ImageIcon Loki=new ImageIcon(this.getClass().getResource("LokiSprite1.png"));
			ImageIcon scaledLoki=new ImageIcon(Loki.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledLoki);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledLoki);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledLoki);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon Loki=new ImageIcon(this.getClass().getResource("LokiSprite2.png"));
			ImageIcon scaledLoki=new ImageIcon(Loki.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledLoki);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledLoki);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledLoki);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
		
	case "Quicksilver":
		if(firstPlayerTurn)
		{
			ImageIcon Quicksilver=new ImageIcon(this.getClass().getResource("QuickSilverSprite1.png"));
			ImageIcon scaledQuicksilver=new ImageIcon(Quicksilver.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledQuicksilver);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledQuicksilver);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledQuicksilver);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon Quicksilver=new ImageIcon(this.getClass().getResource("QuickSilverSprite2.png"));
			ImageIcon scaledQuicksilver=new ImageIcon(Quicksilver.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledQuicksilver);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledQuicksilver);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledQuicksilver);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
			
		
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
		
		
	case "Thor":
		if(firstPlayerTurn)
		{
			ImageIcon Thor=new ImageIcon(this.getClass().getResource("ThorSprite1.png"));
			ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledThor);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledThor);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledThor);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon Thor=new ImageIcon(this.getClass().getResource("ThorSprite2.png"));
			ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledThor);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledThor);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledThor);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
			
		
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
	case "Spiderman":
		if(firstPlayerTurn)
		{
			ImageIcon Spiderman=new ImageIcon(this.getClass().getResource("SpidermanSprite1.png"));
			ImageIcon scaledSpiderman=new ImageIcon(Spiderman.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledSpiderman);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledSpiderman);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledSpiderman);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon Quicksilver=new ImageIcon(this.getClass().getResource("SpidermanSprite2.png"));
			ImageIcon scaledQuicksilver=new ImageIcon(Quicksilver.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledQuicksilver);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledQuicksilver);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledQuicksilver);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,16));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
			
		
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
	case "Yellow Jacket":
		if(firstPlayerTurn)
		{
			ImageIcon YellowJacket=new ImageIcon(this.getClass().getResource("YellowJacketSprite1.png"));
			ImageIcon scaledYellowJacket=new ImageIcon(YellowJacket.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ11.setIcon(scaledYellowJacket);
				Champ11.setName(name);
				Champ11.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ11.setForeground(Color.white);
				Champ11.setVerticalTextPosition(SwingConstants.TOP);
				Champ11.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ11.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ11.setText(name+" - Hero");
				else 
					Champ11.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ12.setIcon(scaledYellowJacket);
				Champ12.setName(name);
				Champ12.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ12.setForeground(Color.white);
				Champ12.setVerticalTextPosition(SwingConstants.TOP);
				Champ12.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ12.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ12.setText(name+" - Hero");
				else 
					Champ12.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
			else 
			{
				Champ13.setIcon(scaledYellowJacket);
				Champ13.setName(name);
				Champ13.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ13.setForeground(Color.white);
				Champ13.setVerticalTextPosition(SwingConstants.TOP);
				Champ13.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ13.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ13.setText(name+" - Hero");
				else 
					Champ13.setText(name+" - AntiHero");
				Player1Panel.revalidate();
				Player1Panel.repaint();
			}
		}
		else 
		{
			ImageIcon YellowJacket=new ImageIcon(this.getClass().getResource("YellowJacketSprite2.png"));
			ImageIcon scaledYellowJacket=new ImageIcon(YellowJacket.getImage().getScaledInstance(145,145, Image.SCALE_DEFAULT));
			if(secondPlayerCounter==0)
			{
				Champ21.setIcon(scaledYellowJacket);
				Champ21.setName(name);
				Champ21.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ21.setForeground(Color.white);
				Champ21.setVerticalTextPosition(SwingConstants.TOP);
				Champ21.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ21.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ21.setText(name+" - Hero");
				else 
					Champ21.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
				//Player1Panel.add(button);
			}
			else if(secondPlayerCounter==1)
			{
				Champ22.setIcon(scaledYellowJacket);
				Champ22.setName(name);
				Champ22.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ22.setForeground(Color.white);
				Champ22.setVerticalTextPosition(SwingConstants.TOP);
				Champ22.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ22.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ22.setText(name+" - Hero");
				else 
					Champ22.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
			else 
			{
				Champ23.setIcon(scaledYellowJacket);
				Champ23.setName(name);
				Champ23.setFont(new Font("SansSerif",Font.ITALIC,14));
				Champ23.setForeground(Color.white);
				Champ23.setVerticalTextPosition(SwingConstants.TOP);
				Champ23.setHorizontalTextPosition(SwingConstants.CENTER);
				if(myChampion instanceof Villain)
					Champ23.setText(name+" - Villain");
				else if(myChampion instanceof Hero)
					Champ23.setText(name+" - Hero");
				else 
					Champ23.setText(name+" - AntiHero");
				Player2Panel.revalidate();
				Player2Panel.repaint();
			}
		}
			
	
//		Player1Panel.setBackground(Color.black);
//		Player2Panel.setBackground(Color.black);
		break;
}
		Champ11.setFont(font);
		Champ12.setFont(font);
		Champ13.setFont(font);
		Champ21.setFont(font);
		Champ22.setFont(font);
		Champ23.setFont(font);
	}
		
		
		
		
		
//		System.out.println("lol");
//		if(e.getSource()==button)
//		{
//			System.out.println("lolll");
//			switch(button.getName())
//			{
//				case "Ironman": if(firstPlayerTurn) 
//					{
//						JLabel label=new JLabel("lol");
//						label.setBounds(100,300, 100, 100);
//						Player1Panel.add(label);
//						JOptionPane.showMessageDialog(this, "dehk");
//						player1.getTeam().add(getChamp("Ironman"));
//						firstPlayerTurn=false;
//						break;
//					}
//					else 
//					{
//						player2.getTeam().add(getChamp("Ironman"));
//						firstPlayerTurn=true;
//						secondPlayerCounter++;
//						break;
//					}
//			}		
//		}
	}
