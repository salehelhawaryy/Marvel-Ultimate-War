package GUI2.copy;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

import org.junit.internal.builders.JUnit3Builder;

import engine.Game;import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.EffectType;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class Gameplay extends JPanel implements ActionListener,KeyListener{
Game game;
JFrame theFrame;
JPanel Current;
JPanel Arena;
Background turnorder;
JButton Ability1;
JButton Ability2;
JButton Ability3;
JButton punch;
JButton endturn;
JButton moveup;
JButton movedown;
JButton moveleft;
JButton moveright;
JButton Attack;
JButton icon;
JButton ArrayButton[][];
JButton Ab1;
JButton Ab2;
JButton Ab3;
JButton Ab4;
JButton pause;
JButton howto;
JButton end;
JButton iconselect;
JButton leaderAb;
JLabel iconname;
JLabel Health;
JLabel Mana;
JLabel ActionPoints;
Font font;
ArrayList<Champion> all;
ArrayList<JButton>iconbutton;
boolean isAttackedPressed=false;
boolean isCastDirectionalPressed=false;
boolean isCastSinglePressed=false;
int AbilityPostion;
String firstname;
String secondname;
JLabel transactionbar;


//Action upAction;
//downAction;
//leftAction;

public Gameplay(JFrame frame,Game game,String firstname,String secondname)
{
//	System.out.println(game.getFirstPlayer().getTeam().size());
//	System.out.println(game.getFirstPlayer().getLeader().getName()+"LEADER");
//	System.out.println(game.getSecondPlayer().getLeader().getName()+"LEADER");
//	System.out.println(game.getSecondPlayer().getTeam().size());
//	System.out.println(game.getFirstPlayer().getName());
//	System.out.println(game.getSecondPlayer().getName());
	this.firstname=firstname;
	this.secondname=secondname;
	theFrame=frame;
	this.game=game;
	new JPanel();
	font=new Font("SansSerif",Font.ITALIC,9);
	

	
	setLayout(new BorderLayout());
	
	
	game.prepareChampionTurns();
	game.placeChampions();
	game.placeCovers();
	
	
	//System.out.println(game.getFirstPlayer().getTeam().get(0).getAbilities().get(0).getBaseCooldown()+" BASE");
	

	
	
	Background status=new Background();
	status.setPreferredSize(new Dimension(1000,70));
	status.setLayout(null);
	status.setBackground(Color.yellow);
	add(status,BorderLayout.NORTH);
	
	//status
	
//	for(int i=0;i<game.getFirstPlayer().getTeam().size();i++) {
//		all.add(game.getFirstPlayer().getTeam().get(i));
//	}
//	
//	for(int i=0;i<game.getSecondPlayer().getTeam().size();i++) {
//		all.add(game.getSecondPlayer().getTeam().get(i));
//	}
	
	//FirstPlayer north
	for(int i=0;i<game.getFirstPlayer().getTeam().size();i++) {
		iconselect=new JButton();
		iconname=new JLabel();
		iconname.setFont(font);
		iconname.setForeground(Color.white);
		if(game.getFirstPlayer().getTeam().get(i) instanceof Hero) {
			iconname.setText("    Hero");
		}
		if(game.getFirstPlayer().getTeam().get(i) instanceof Villain) {
			iconname.setText("  Villain");
		}
		if(game.getFirstPlayer().getTeam().get(i) instanceof AntiHero) {
			iconname.setText("Anti-Hero");
		}
		
		//iconselect.setPreferredSize(new Dimension(100,90));
		iconselect.setName(game.getFirstPlayer().getTeam().get(i).getName());
		iconselect.setBackground(Color.white);
		iconselect.setFocusable(false);
		iconselect.setOpaque(false);
		iconselect.setBorder(BorderFactory.createLineBorder(Color.red,2));
		if(game.getFirstPlayer().getTeam().get(i)==game.getFirstPlayer().getLeader()) {
			iconselect.setBorder(BorderFactory.createBevelBorder(1, Color.red,new Color(192,135,1)));
		}
		iconselect.setForeground(Color.black);
		iconselect.addActionListener(this);
		switch(iconselect.getName())
		{
		case "Loki":
			ImageIcon loki= new ImageIcon(this.getClass().getResource("lokiffn.png"));
			ImageIcon scaledloki=new ImageIcon(loki.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledloki);
			break;
			
		case "Hela":
			ImageIcon hela= new ImageIcon(this.getClass().getResource("hela 2.png"));
			ImageIcon scaledhela=new ImageIcon(hela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledhela);
			break;
		case "Ghost Rider":
			ImageIcon ghost= new ImageIcon(this.getClass().getResource("ghost but.png"));
			ImageIcon scaledghost=new ImageIcon(ghost.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledghost);
			break;
		case "Quicksilver":
			ImageIcon quick= new ImageIcon(this.getClass().getResource("quicksilver final.png"));
			ImageIcon scaledquick=new ImageIcon(quick.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledquick);
			break;
		case "Ironman":
				ImageIcon Ironman= new ImageIcon(this.getClass().getResource("iron but.png"));
				ImageIcon scaledIronman=new ImageIcon(Ironman.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				iconselect.setIcon(scaledIronman);
				break;
				
		case "Deadpool":
			ImageIcon Deadpool= new ImageIcon(this.getClass().getResource("deadpoolicon.png"));
			ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledDeadpool);
			break;
			
		case "Venom":
			ImageIcon venom= new ImageIcon(this.getClass().getResource("VenomIcon.png"));
			ImageIcon scaledVenom=new ImageIcon(venom.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledVenom);
			break;
		case "Captain America":
			ImageIcon Captain= new ImageIcon(this.getClass().getResource("ca.png"));
			ImageIcon scaledCaptain=new ImageIcon(Captain.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledCaptain);
			break;
		case "Hulk":
			ImageIcon Hulk= new ImageIcon(this.getClass().getResource("hulk.png"));
			ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledHulk);
			break;
			
		case "Thor":
			ImageIcon Thor= new ImageIcon(this.getClass().getResource("thorffn.png"));
			ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledThor);
			break;
		
		case "Spiderman":
			ImageIcon spider= new ImageIcon(this.getClass().getResource("spidey.png"));
			ImageIcon scaledspider=new ImageIcon(spider.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledspider);
			break;
			
		case "Yellow Jacket":
			ImageIcon yellow= new ImageIcon(this.getClass().getResource("yellow jacket final.png"));
			ImageIcon scaledyellow=new ImageIcon(yellow.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledyellow);
			break;
		
		case "Electro":
			ImageIcon electro= new ImageIcon(this.getClass().getResource("electrolo.png"));
			ImageIcon scaledelectro=new ImageIcon(electro.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledelectro);
			break;
			
		case "Dr Strange":
			ImageIcon dr= new ImageIcon(this.getClass().getResource("dr but.png"));
			ImageIcon scaleddr=new ImageIcon(dr.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			
			iconselect.setIcon(scaleddr);
			break;
			
		case "Iceman":
			ImageIcon ice= new ImageIcon(this.getClass().getResource("ice man final.png"));
			ImageIcon scaledice=new ImageIcon(ice.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledice);
			break;
		}
		//iconbutton.add(iconselect);
		iconselect.setBounds(45+(i*71),19,40,40);
		iconname.setBounds(45+(i*71),45,46,40);
		status.add(iconselect);
		status.add(iconname);
	}
	//LEADERABILITY
	JLabel labt1=new JLabel();
	labt1.setFont(font);
	labt1.setForeground(Color.red);
	labt1.setText("LeaderAbility");
	
	//LEADERABILITY
	
	
	JLabel firname=new JLabel();
	firname.setText(firstname);
	firname.setBounds(250,9,100,13);
	firname.setForeground(Color.white);
	status.add(firname);
	
	
	JLabel secname=new JLabel();
	secname.setText(secondname);
	secname.setBounds(683,9,100,13);
	secname.setForeground(Color.white);
	status.add(secname);
	
		JLabel labt2=new JLabel();
		labt2.setFont(font);
		labt2.setForeground(Color.blue);
		labt2.setText("LeaderAbility");
	ImageIcon ability= new ImageIcon(this.getClass().getResource("ability.png"));
	ImageIcon scaledability=new ImageIcon(ability.getImage().getScaledInstance(24,29, Image.SCALE_DEFAULT));
	JButton lab1=new JButton();
	lab1.setContentAreaFilled(false);
	lab1.setFocusable(false);
    lab1.setOpaque(false);
	lab1.setBorder(null);
	lab1.setBorderPainted(false);
	lab1.setIcon(scaledability);
	lab1.setBounds(301,20,28,33);
	labt1.setBounds(287,48,61,10);
	
	status.add(labt1);
	
	status.add(lab1);
	
	
	JButton lab2=new JButton();
	lab2.setContentAreaFilled(false);
	lab2.setFocusable(false);
    lab2.setOpaque(false);
	lab2.setBorder(null);
	lab2.setBorderPainted(false);
	lab2.setIcon(scaledability);
	lab2.setBounds(663,20,28,33);
	labt2.setBounds(652,48,61,10);
	status.add(labt2);
	status.add(lab2);
	//Transaction panel
	 transactionbar=new JLabel();
	ImageIcon trans= new ImageIcon(this.getClass().getResource("bar.png"));
	ImageIcon scaledtrans=new ImageIcon(trans.getImage().getScaledInstance(300,81, Image.SCALE_DEFAULT));
	transactionbar.setIcon(scaledtrans);
	transactionbar.setBounds(346,5,320,65);
	transactionbar.setFont(new Font("SansSerif",Font.BOLD,9));
	transactionbar.setVerticalTextPosition(SwingConstants.CENTER);
	transactionbar.setHorizontalTextPosition(SwingConstants.CENTER);
	transactionbar.setForeground(Color.white);
	status.add(transactionbar);
	
	
	
	
	//Secondplayer north
	for(int i=0;i<game.getSecondPlayer().getTeam().size();i++) {
		iconselect=new JButton();
		iconname=new JLabel();
		iconname.setFont(font);
		iconname.setForeground(Color.white);
		if(game.getSecondPlayer().getTeam().get(i) instanceof Hero) {
			iconname.setText("    Hero");
		}
		if(game.getSecondPlayer().getTeam().get(i) instanceof Villain) {
			iconname.setText("  Villain");
		}
		if(game.getSecondPlayer().getTeam().get(i) instanceof AntiHero) {
			iconname.setText("Anti-Hero");
		}
		
		//iconselect.setPreferredSize(new Dimension(100,90));
		iconselect.setName(game.getSecondPlayer().getTeam().get(i).getName());
		iconselect.setBackground(Color.white);
		iconselect.setFocusable(false);
		iconselect.setOpaque(false);
		iconselect.setBorder(BorderFactory.createLineBorder(Color.blue,2));
		if(game.getSecondPlayer().getTeam().get(i)==game.getSecondPlayer().getLeader()) {
			iconselect.setBorder(BorderFactory.createBevelBorder(1, Color.blue,new Color(192,135,1)));
		}
		iconselect.setForeground(Color.black);
		iconselect.addActionListener(this);
		switch(iconselect.getName())
		{
		case "Loki":
			ImageIcon loki= new ImageIcon(this.getClass().getResource("lokiffn.png"));
			ImageIcon scaledloki=new ImageIcon(loki.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledloki);
			break;
			
		case "Hela":
			ImageIcon hela= new ImageIcon(this.getClass().getResource("hela 2.png"));
			ImageIcon scaledhela=new ImageIcon(hela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledhela);
			break;
		case "Ghost Rider":
			ImageIcon ghost= new ImageIcon(this.getClass().getResource("ghost but.png"));
			ImageIcon scaledghost=new ImageIcon(ghost.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledghost);
			break;
		case "Quicksilver":
			ImageIcon quick= new ImageIcon(this.getClass().getResource("quicksilver final.png"));
			ImageIcon scaledquick=new ImageIcon(quick.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledquick);
			break;
		case "Ironman":
				ImageIcon Ironman= new ImageIcon(this.getClass().getResource("iron but.png"));
				ImageIcon scaledIronman=new ImageIcon(Ironman.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				iconselect.setIcon(scaledIronman);
				break;
				
		case "Deadpool":
			ImageIcon Deadpool= new ImageIcon(this.getClass().getResource("deadpoolicon.png"));
			ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledDeadpool);
			break;
			
		case "Venom":
			ImageIcon venom= new ImageIcon(this.getClass().getResource("VenomIcon.png"));
			ImageIcon scaledVenom=new ImageIcon(venom.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledVenom);
			break;
		case "Captain America":
			ImageIcon Captain= new ImageIcon(this.getClass().getResource("ca.png"));
			ImageIcon scaledCaptain=new ImageIcon(Captain.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledCaptain);
			break;
		case "Hulk":
			ImageIcon Hulk= new ImageIcon(this.getClass().getResource("hulk.png"));
			ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledHulk);
			break;
			
		case "Thor":
			ImageIcon Thor= new ImageIcon(this.getClass().getResource("thorffn.png"));
			ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledThor);
			break;
		
		case "Spiderman":
			ImageIcon spider= new ImageIcon(this.getClass().getResource("spidey.png"));
			ImageIcon scaledspider=new ImageIcon(spider.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledspider);
			break;
			
		case "Yellow Jacket":
			ImageIcon yellow= new ImageIcon(this.getClass().getResource("yellow jacket final.png"));
			ImageIcon scaledyellow=new ImageIcon(yellow.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledyellow);
			break;
		
		case "Electro":
			ImageIcon electro= new ImageIcon(this.getClass().getResource("electrolo.png"));
			ImageIcon scaledelectro=new ImageIcon(electro.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledelectro);
			break;
			
		case "Dr Strange":
			ImageIcon dr= new ImageIcon(this.getClass().getResource("dr but.png"));
			ImageIcon scaleddr=new ImageIcon(dr.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
			
			iconselect.setIcon(scaleddr);
			break;
			
		case "Iceman":
			ImageIcon ice= new ImageIcon(this.getClass().getResource("ice man final.png"));
			ImageIcon scaledice=new ImageIcon(ice.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT));
			iconselect.setIcon(scaledice);
			break;
		}
		//iconbutton.add(iconselect);
		iconselect.setBounds(755+(i*71),19,40,40);
		iconname.setBounds(755+(i*71),45,46,40);
		status.add(iconselect);
		status.add(iconname);
	}
	
	
	
	
	
		
	
	
	
	
	// END of status
	
	
	lava Lava=new lava();
	Lava.setPreferredSize(new Dimension(780,410));
	Lava.setLayout(null);
	Lava.setBackground(Color.red);
	add(Lava,BorderLayout.CENTER);
	
	Arena=new JPanel();
	Arena.setBounds(31,29, 700, 320);
	Arena.setLayout(new GridLayout(5,5));
	Arena.setBackground(Color.black);
	Lava.add(Arena);
	Lava.revalidate();
	Lava.repaint();
	
	
	
	 ArrayButton =new JButton[5][5];
	
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			JButton button1=new JButton();
			button1.addActionListener(this);
			button1.setPreferredSize(new Dimension(140,64));
			//button1.setBorderPainted(fal);
			Arena.add(button1);
			if(game.getBoard()[i][j] instanceof Champion)
			{
				Champion c =(Champion)  game.getBoard()[i][j];
				button1.setName(c.getName());
 			}
			else if(game.getBoard()[i][j] instanceof Cover)
			{
				Cover c =(Cover)  game.getBoard()[i][j];
				button1.setName(c.getCurrentHP()+"");
			}
			else 
				button1.setName("lolz");
			ArrayButton[i][j]=button1;
		}
	}
	
	
	
	
//	for(int i=0;i<5;i++)
//	{
//		for(int j=0;j<5;j++)
//		{
//			System.out.println(ArrayButton[i][j].getName());
//		}
//	}
	
	
	
	
	
	 turnorder = new Background();
	turnorder.setBackground(Color.green);
	turnorder.setPreferredSize(new Dimension(110,1000));
	turnorder.setLayout(new FlowLayout(FlowLayout.CENTER));
	add(turnorder,BorderLayout.EAST);
	PriorityQueue temp = new PriorityQueue(game.getTurnOrder().size());
	boolean first=true;
	Champion teamChamp1 = (Champion)game.getTurnOrder().peekMin();
	String currentChamp = teamChamp1.getName(); 
	
	JLabel fasel=new JLabel();
	ImageIcon faselb= new ImageIcon(this.getClass().getResource("barsep.png"));
	ImageIcon scaledfaselb=new ImageIcon(faselb.getImage().getScaledInstance(110, 28, Image.SCALE_DEFAULT));
	fasel.setPreferredSize(new Dimension(100,17));
	fasel.setIcon(scaledfaselb);
	turnorder.add(fasel);
while(!game.getTurnOrder().isEmpty()){
		
		JLabel champIcon = new JLabel();
		champIcon.setPreferredSize(new Dimension(80,50));
		champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),4));
		Champion teamChamp = (Champion)game.getTurnOrder().peekMin();
		
		temp.insert(game.getTurnOrder().remove());
		switch(teamChamp.getName())
		{
		case "Loki":
			ImageIcon loki= new ImageIcon(this.getClass().getResource("lokiffn.png"));
			ImageIcon scaledloki=new ImageIcon(loki.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledloki);
			if(currentChamp.equals("Loki")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));		
			
			break;
			
		case "Ghost Rider":
			ImageIcon ghost= new ImageIcon(this.getClass().getResource("ghost but.png"));
			ImageIcon scaledghost=new ImageIcon(ghost.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledghost);
			if(currentChamp.equals("Ghost Rider")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Quicksilver":
			ImageIcon quick= new ImageIcon(this.getClass().getResource("quicksilver final.png"));
			ImageIcon scaledquick=new ImageIcon(quick.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledquick);
			if(currentChamp.equals("Quicksilver")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Ironman":
			ImageIcon Ironman= new ImageIcon(this.getClass().getResource("iron but.png"));
			ImageIcon scaledIronman=new ImageIcon(Ironman.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledIronman);
			if(currentChamp.equals("Ironman")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Deadpool":
			ImageIcon Deadpool= new ImageIcon(this.getClass().getResource("deadpoolicon.png"));
			ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledDeadpool);
			if(currentChamp.equals("Deadpool")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Venom":
			ImageIcon venom= new ImageIcon(this.getClass().getResource("VenomIcon.png"));
			ImageIcon scaledVenom=new ImageIcon(venom.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledVenom);
			if(currentChamp.equals("Venom")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Captain America":
			ImageIcon Captain= new ImageIcon(this.getClass().getResource("ca.png"));
			ImageIcon scaledCaptain=new ImageIcon(Captain.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledCaptain);
			if(currentChamp.equals("Captain America")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Hulk":
			ImageIcon Hulk= new ImageIcon(this.getClass().getResource("hulk.png"));
			ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledHulk);
			if(currentChamp.equals("Hulk")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Thor":
			ImageIcon Thor= new ImageIcon(this.getClass().getResource("thorffn.png"));
			ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledThor);
			if(currentChamp.equals("Thor")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
		
		case "Spiderman":
			ImageIcon spider= new ImageIcon(this.getClass().getResource("spidey.png"));
			ImageIcon scaledspider=new ImageIcon(spider.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledspider);
			if(currentChamp.equals("Spiderman")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Yellow Jacket":
			ImageIcon yellow= new ImageIcon(this.getClass().getResource("yellow jacket final.png"));
			ImageIcon scaledyellow=new ImageIcon(yellow.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledyellow);
			if(currentChamp.equals("Yellow Jacket")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
		
		case "Electro":
			ImageIcon electro= new ImageIcon(this.getClass().getResource("electrolo.png"));
			ImageIcon scaledelectro=new ImageIcon(electro.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledelectro);
			if(currentChamp.equals("Electro")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Dr Strange":
			ImageIcon dr= new ImageIcon(this.getClass().getResource("dr but.png"));
			ImageIcon scaleddr=new ImageIcon(dr.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaleddr);
			if(currentChamp.equals("Dr Strange")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Iceman":
			ImageIcon ice= new ImageIcon(this.getClass().getResource("ice man final.png"));
			ImageIcon scaledice=new ImageIcon(ice.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledice);
			if(currentChamp.equals( "Iceman")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			break;
		case "Hela":
			ImageIcon hel= new ImageIcon(this.getClass().getResource("helahela.png"));
			ImageIcon scaledhela=new ImageIcon(hel.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledhela);
			if(currentChamp.equals( "Hela")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			break;
		}
		turnorder.add(champIcon);
		
	
		
	}
	while (!temp.isEmpty()) {
		game.getTurnOrder().insert(temp.remove());
	}

	
	updateTile();
	
	Background Settings=new Background();
	Settings.setPreferredSize(new Dimension(110,1000));
	Settings.setLayout(null);
	Settings.setBackground(Color.darkGray);
	add(Settings,BorderLayout.WEST);
	 howto=new JButton();
    howto.setBounds(13,100,29,25);
    ImageIcon how=new ImageIcon(this.getClass().getResource("what.png"));
    ImageIcon scaledhow=new ImageIcon(how.getImage().getScaledInstance(80, 57, Image.SCALE_DEFAULT));
    howto.setIcon(scaledhow);
	howto.addActionListener(this);
	Settings.add(howto);
	
	pause=new JButton();
    pause.setBounds(13,139,29,25);
    ImageIcon pausei=new ImageIcon(this.getClass().getResource("pp.png"));
    ImageIcon scaledpause=new ImageIcon(pausei.getImage().getScaledInstance(75, 46, Image.SCALE_DEFAULT));
    pause.setIcon(scaledpause);
	pause.addActionListener(this);
	Settings.add(pause);
	
	
	JLabel ins=new JLabel(//"X-> attack"+"\n"
			//+ "C->cast ability 1"+"\n"
			//+ "V->cast ability 2"+"\n"
			//+ "B-> cast ablity 3"+"\n"
			//+ "F-> show current ap effects"
			"X: Attack"+"\n"+"C:Cast Ability1"+"\n"+"V:Cast Ability2"+"\n"+"B:Cast Ability3"+"\n"+"F:Show current HP");
	ins.setForeground(Color.white);
	ins.setBounds(6,210,100,90);
	//Settings.add(ins);
	
	
	
	theFrame.add(this);
	loadCurrent();
	
//	this.setFocusable(true);
//	this.addKeyListener(keyH);
	
}
public void UpdateTrans(String s)
{
	transactionbar.setText(s);
}

public void updateTurn()
{
	
	this.remove(turnorder);
	Background turnorder = new Background();
	turnorder.setBackground(Color.green);
	turnorder.setPreferredSize(new Dimension(110,1000));
	turnorder.setLayout(new FlowLayout(FlowLayout.CENTER));
	add(turnorder,BorderLayout.EAST);
	PriorityQueue temp = new PriorityQueue(game.getTurnOrder().size());
	boolean first=true;
	Champion teamChamp1 = (Champion)game.getTurnOrder().peekMin();
	String currentChamp = teamChamp1.getName(); 
	
	JLabel fasel=new JLabel();
	ImageIcon faselb= new ImageIcon(this.getClass().getResource("barsep.png"));
	ImageIcon scaledfaselb=new ImageIcon(faselb.getImage().getScaledInstance(110, 28, Image.SCALE_DEFAULT));
	fasel.setPreferredSize(new Dimension(100,17));
	fasel.setIcon(scaledfaselb);
	turnorder.add(fasel);
	while(!game.getTurnOrder().isEmpty()){
		
		JLabel champIcon = new JLabel();
		champIcon.setPreferredSize(new Dimension(80,50));
		champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),4));
		Champion teamChamp = (Champion)game.getTurnOrder().peekMin();
		
		temp.insert(game.getTurnOrder().remove());
		switch(teamChamp.getName())
		{
		case "Loki":
			ImageIcon loki= new ImageIcon(this.getClass().getResource("lokiffn.png"));
			ImageIcon scaledloki=new ImageIcon(loki.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledloki);
			if(currentChamp.equals("Loki")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));		
			
			break;
			
		case "Ghost Rider":
			ImageIcon ghost= new ImageIcon(this.getClass().getResource("ghost but.png"));
			ImageIcon scaledghost=new ImageIcon(ghost.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledghost);
			if(currentChamp.equals("Ghost Rider")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Quicksilver":
			ImageIcon quick= new ImageIcon(this.getClass().getResource("quicksilver final.png"));
			ImageIcon scaledquick=new ImageIcon(quick.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledquick);
			if(currentChamp.equals("Quicksilver")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Ironman":
			ImageIcon Ironman= new ImageIcon(this.getClass().getResource("iron but.png"));
			ImageIcon scaledIronman=new ImageIcon(Ironman.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledIronman);
			if(currentChamp.equals("Ironman")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Deadpool":
			ImageIcon Deadpool= new ImageIcon(this.getClass().getResource("deadpoolicon.png"));
			ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledDeadpool);
			if(currentChamp.equals("Deadpool")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Venom":
			ImageIcon venom= new ImageIcon(this.getClass().getResource("VenomIcon.png"));
			ImageIcon scaledVenom=new ImageIcon(venom.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledVenom);
			if(currentChamp.equals("Venom")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Captain America":
			ImageIcon Captain= new ImageIcon(this.getClass().getResource("ca.png"));
			ImageIcon scaledCaptain=new ImageIcon(Captain.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledCaptain);
			if(currentChamp.equals("Captain America")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Hulk":
			ImageIcon Hulk= new ImageIcon(this.getClass().getResource("hulk.png"));
			ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledHulk);
			if(currentChamp.equals("Hulk")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Thor":
			ImageIcon Thor= new ImageIcon(this.getClass().getResource("thorffn.png"));
			ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledThor);
			if(currentChamp.equals("Thor")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
		
		case "Spiderman":
			ImageIcon spider= new ImageIcon(this.getClass().getResource("spidey.png"));
			ImageIcon scaledspider=new ImageIcon(spider.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledspider);
			if(currentChamp.equals("Spiderman")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Yellow Jacket":
			ImageIcon yellow= new ImageIcon(this.getClass().getResource("yellow jacket final.png"));
			ImageIcon scaledyellow=new ImageIcon(yellow.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledyellow);
			if(currentChamp.equals("Yellow Jacket")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
		
		case "Electro":
			ImageIcon electro= new ImageIcon(this.getClass().getResource("electrolo.png"));
			ImageIcon scaledelectro=new ImageIcon(electro.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledelectro);
			if(currentChamp.equals("Electro")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Dr Strange":
			ImageIcon dr= new ImageIcon(this.getClass().getResource("dr but.png"));
			ImageIcon scaleddr=new ImageIcon(dr.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaleddr);
			if(currentChamp.equals("Dr Strange")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			
			break;
			
		case "Iceman":
			ImageIcon ice= new ImageIcon(this.getClass().getResource("ice man final.png"));
			ImageIcon scaledice=new ImageIcon(ice.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledice);
			if(currentChamp.equals( "Iceman")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			break;
		case "Hela":
			ImageIcon hel= new ImageIcon(this.getClass().getResource("helahela.png"));
			ImageIcon scaledhela=new ImageIcon(hel.getImage().getScaledInstance(50, 40, Image.SCALE_DEFAULT));
			champIcon.setIcon(scaledhela);
			if(currentChamp.equals( "Hela")) 
				champIcon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));	
			break;
		}
		turnorder.add(champIcon);
		
	
		
	}
	while (!temp.isEmpty()) {
		game.getTurnOrder().insert(temp.remove());
	}
	this.add(turnorder,BorderLayout.EAST);
}


public void loadCurrent()
{
	Current=new Background();
	Current.setPreferredSize(new Dimension(1000,120));
	Current.setBackground(Color.black);
	Current.setLayout(null);
	add(Current,BorderLayout.SOUTH);
	Champion c=game.getCurrentChampion();
	 icon=new JButton();
	 icon.addActionListener(this);
	icon.setForeground(Color.white);
	icon.setBounds(5,0,110,100);
	icon.setContentAreaFilled(false);
	icon.setFocusable(true);
	icon.setOpaque(false);
	icon.setBorder(BorderFactory.createLineBorder(new Color(255,204,51),4));
	
	
	
	Background Information=new Background();
	Information.setLayout(new BoxLayout(Information, BoxLayout.Y_AXIS));
 	Information.setBounds(116,0, 230, 125);
 	Information.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
 	Current.add(Information);
	
 	
 	//layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Health).addComponent(Mana).addComponent(ActionPoints);
 	
 	
	
	JLabel Name=new JLabel(c.getName());
	Name.setBounds(5, 101,110, 13);
	Name.setFont(new Font("SansSerif",Font.BOLD,13));
	Name.setForeground(Color.white);
	Name.setHorizontalAlignment(JLabel.CENTER);
	
    Health=new JLabel();
 	Health.setPreferredSize(new Dimension(220,39));
 	Health.setText(c.getCurrentHP()+"/"+c.getMaxHP());
	Health.setForeground(Color.white);
	Health.setFont(new Font("SansSerif",Font.BOLD,13));
	Health.setHorizontalAlignment(JLabel.RIGHT);
	Health.setAlignmentX(Component.LEFT_ALIGNMENT);
 	
 	
 	
	
	Mana=new JLabel();
	Mana.setPreferredSize(new Dimension(220,39));
 	Mana.setText(c.getMana()+"/"+c.getMaxMana());
	Mana.setForeground(Color.white);
	Mana.setFont(new Font("SansSerif",Font.BOLD,13));
	Mana.setHorizontalAlignment(JLabel.RIGHT);
	Mana.setAlignmentX(Component.LEFT_ALIGNMENT);
	
	
    ActionPoints=new JLabel();
 	ActionPoints.setPreferredSize(new Dimension(220, 39));
 	ActionPoints.setText(c.getCurrentActionPoints()+"/"+c.getMaxActionPointsPerTurn());
	ActionPoints.setForeground(Color.white);
	ActionPoints.setFont(new Font("SansSerif",Font.BOLD,13));
	ActionPoints.setHorizontalAlignment(JLabel.RIGHT);
	ActionPoints.setAlignmentX(Component.LEFT_ALIGNMENT);
	
	
	
	
	
	
 	
	
	
	switch(game.getCurrentChampion().getName())
	{
	case "Quicksilver":
		ImageIcon quick= new ImageIcon(this.getClass().getResource("quicksilver final.png"));
		ImageIcon scaledquick=new ImageIcon(quick.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledquick);
		icon.setVisible(true);
		break;
	case "Loki":
		ImageIcon loki= new ImageIcon(this.getClass().getResource("lokiffn.png"));
		ImageIcon scaledloki=new ImageIcon(loki.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledloki);
		icon.setVisible(true);
		break;
		
	case "Ghost Rider":
		ImageIcon ghost= new ImageIcon(this.getClass().getResource("ghost but.png"));
		ImageIcon scaledghost=new ImageIcon(ghost.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledghost);
		icon.setVisible(true);
		break;
	case "Ironman":
		ImageIcon Ironman= new ImageIcon(this.getClass().getResource("iron but.png"));
		ImageIcon scaledIronman=new ImageIcon(Ironman.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledIronman);
		icon.setVisible(true);
		break;
		
	case "Deadpool":
		ImageIcon Deadpool= new ImageIcon(this.getClass().getResource("deadpoolicon.png"));
		ImageIcon scaledDeadpool=new ImageIcon(Deadpool.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledDeadpool);
		icon.setVisible(true);
		break;
		
	case "Venom":
		ImageIcon venom= new ImageIcon(this.getClass().getResource("VenomIcon.png"));
		ImageIcon scaledVenom=new ImageIcon(venom.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledVenom);
		icon.setVisible(true);
		break;
		
	case "Captain America":
		ImageIcon Captain= new ImageIcon(this.getClass().getResource("ca.png"));
		ImageIcon scaledCaptain=new ImageIcon(Captain.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledCaptain);
		icon.setVisible(true);
		break;
	case "Hulk":
		ImageIcon Hulk= new ImageIcon(this.getClass().getResource("hulk.png"));
		ImageIcon scaledHulk=new ImageIcon(Hulk.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledHulk);
		icon.setVisible(true);
		break;
		
	case "Thor":
		ImageIcon Thor= new ImageIcon(this.getClass().getResource("thorffn.png"));
		ImageIcon scaledThor=new ImageIcon(Thor.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledThor);
		icon.setVisible(true);
		break;
	
	case "Spiderman":
		ImageIcon spider= new ImageIcon(this.getClass().getResource("spidey.png"));
		ImageIcon scaledspider=new ImageIcon(spider.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledspider);
		icon.setVisible(true);
		break;
		
	case "Yellow Jacket":
		ImageIcon yellow= new ImageIcon(this.getClass().getResource("yellow jacket final.png"));
		ImageIcon scaledyellow=new ImageIcon(yellow.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledyellow);
		icon.setVisible(true);
		break;
	
	case "Electro":
		ImageIcon electro= new ImageIcon(this.getClass().getResource("electrolo.png"));
		ImageIcon scaledelectro=new ImageIcon(electro.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledelectro);
		icon.setVisible(true);
		break;
		
	case "Dr Strange":
		ImageIcon dr= new ImageIcon(this.getClass().getResource("dr but.png"));
		ImageIcon scaleddr=new ImageIcon(dr.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaleddr);
		icon.setVisible(true);
		break;
		
	case "Iceman":
		ImageIcon ice= new ImageIcon(this.getClass().getResource("ice man final.png"));
		ImageIcon scaledice=new ImageIcon(ice.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledice);
		icon.setVisible(true);
		break;
	case "Hela":
		ImageIcon hel= new ImageIcon(this.getClass().getResource("hela 2.png"));
		ImageIcon scaledhela=new ImageIcon(hel.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT));
		icon.setIcon(scaledhela);
		icon.setVisible(true);
		break;
	}

	if(c.getCurrentHP()>c.getMaxHP()*0.75)
	{
		ImageIcon HealthIcon= new ImageIcon(this.getClass().getResource("actionpoints100.png"));
		ImageIcon scaledhealth=new ImageIcon(HealthIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Health.setIcon(scaledhealth);
		Health.setVisible(true);
	}
	else if(c.getCurrentHP()>c.getMaxHP()*0.5)
	{
		ImageIcon HealthIcon= new ImageIcon(this.getClass().getResource("actionpoints50.png"));
		ImageIcon scaledhealth=new ImageIcon(HealthIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Health.setIcon(scaledhealth);
		Health.setVisible(true);
	}
	else 
	{
		ImageIcon HealthIcon= new ImageIcon(this.getClass().getResource("actionpoints45.png"));
		ImageIcon scaledhealth=new ImageIcon(HealthIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Health.setIcon(scaledhealth);
		Health.setVisible(true);
	}
	
	if(c.getMana()>c.getMaxMana()*0.75)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana100.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	else if(c.getMana()>c.getMaxMana()*0.5)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana50.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	else if(c.getMana()>c.getMaxMana()*0.25)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana45.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	else if(c.getMana()==0)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana0.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	
	if(c.getCurrentActionPoints()>c.getMaxActionPointsPerTurn()*0.75)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health100.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	else if(c.getCurrentActionPoints()>c.getMaxActionPointsPerTurn()*0.5)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health50.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	else if(c.getCurrentActionPoints()>c.getMaxActionPointsPerTurn()*0.25)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health45.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	else if(c.getCurrentActionPoints()==0)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health0.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	
	
	
	
	
	
	
	end=new JButton();
	end.setBounds(890, 95, 50, 20);
	ImageIcon endIcon= new ImageIcon(this.getClass().getResource("endturnbutt.png"));
	ImageIcon endsc=new ImageIcon(endIcon.getImage().getScaledInstance(64, 76, Image.SCALE_DEFAULT));
	end.setIcon(endsc);
	end.addKeyListener(this);
	
	
	
	leaderAb = new JButton();
	leaderAb.setBounds(890, 50, 80, 30);
	ImageIcon ledIcon= new ImageIcon(this.getClass().getResource("leaderbutt.png"));
	ImageIcon endled=new ImageIcon(ledIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	leaderAb.setIcon(endled);
	leaderAb.addKeyListener(this);
	
	if(!game.getFirstPlayer().getLeader().equals(c)&& !game.getSecondPlayer().getLeader().equals(c))
		leaderAb.setEnabled(false);
	else
	{
		if(game.getFirstPlayer().getTeam().contains(c))
		{
			if(game.isFirstLeaderAbilityUsed())
				leaderAb.setEnabled(false);
		}
		else
		{
			if(game.isSecondLeaderAbilityUsed())
				leaderAb.setEnabled(false);
		}
	}
	
	
	
	JLabel AttackLabel=new JLabel("<html>Damage: "+c.getAttackDamage()+"<br/>Range: "+c.getAttackRange()+"<br/>Cost: 2 A<html>",JLabel.CENTER);
	Font abFont = new Font("SansSerif",Font.BOLD,8);
	AttackLabel.setFont(abFont);
	AttackLabel.setBounds(360, 80, 80, 38);
	AttackLabel.setBorder(BorderFactory.createLineBorder(Color.white,2));
	AttackLabel.setForeground(Color.white);
	Attack=new JButton();
	Attack.setContentAreaFilled(false);
	Attack.setFocusable(true);
	Attack.setOpaque(false);
	Attack.setBorder(BorderFactory.createLineBorder(Color.white,2));
	Attack.setBounds(360,0,80,80);
	Attack.addActionListener(this);
	ImageIcon attIcon= new ImageIcon(this.getClass().getResource("attackcon.png"));
	ImageIcon attsc=new ImageIcon(attIcon.getImage().getScaledInstance(80, 60, Image.SCALE_DEFAULT));
	Attack.setIcon(attsc);
	Attack.addKeyListener(this);
	
	
	
	Ability1=new JButton();
	Ability1.setContentAreaFilled(false);
	Ability1.setFocusable(true);
	Ability1.setOpaque(false);
	Ability1.setBorder(BorderFactory.createLineBorder(Color.white,2));
	Ability1.addActionListener(this);
	
	if(c.getAbilities().get(0) instanceof DamagingAbility )
	{
		DamagingAbility a=(DamagingAbility)c.getAbilities().get(0);
		 Ab1=new JButton("<html>"+a.getName()+"<br/>Damage: "+a.getDamageAmount()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab1.setFont(abFont);
		Ab1.setBounds(440, 80, 80, 38);
		Ab1.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab1.setForeground(Color.white);
		Ab1.setOpaque(false);
		Ab1.setContentAreaFilled(false);
		Ab1.setFocusable(false);
	}
	else if(c.getAbilities().get(0) instanceof HealingAbility)
	{
	HealingAbility a=(HealingAbility)c.getAbilities().get(0);
	Ab1=new JButton("<html>"+a.getName()+"<br/>Heal: "+a.getHealAmount()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab1.setFont(abFont);
		Ab1.setBounds(440, 80, 80, 38);
		Ab1.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab1.setForeground(Color.white);	
		Ab1.setOpaque(false);
		Ab1.setContentAreaFilled(false);
		Ab1.setFocusable(false);
	}
	else 
	{
		CrowdControlAbility a=(CrowdControlAbility)c.getAbilities().get(0);
		Ab1=new JButton("<html>"+a.getName()+"<br/>Effect: "+a.getEffect().getName()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab1.setFont(abFont);
		Ab1.setBounds(440, 80, 80, 38);
		Ab1.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab1.setForeground(Color.white);
		Ab1.setOpaque(false);
		Ab1.setContentAreaFilled(false);
		Ab1.setFocusable(false);
	}
	
	
	
	
	Ability2=new JButton();
	Ability2.setContentAreaFilled(false);
	Ability2.setFocusable(true);
	Ability2.setOpaque(false);
	Ability2.setBorder(BorderFactory.createLineBorder(Color.white,2));
	Ability2.addActionListener(this);
	
	
	if(c.getAbilities().get(1) instanceof DamagingAbility )
	{
		DamagingAbility a=(DamagingAbility)c.getAbilities().get(1);
		 Ab2=new JButton("<html>"+a.getName()+"<br/>Damage: "+a.getDamageAmount()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab2.setFont(abFont);
		Ab2.setBounds(520, 80, 80, 38);
		Ab2.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab2.setForeground(Color.white);
		Ab2.setOpaque(false);
		Ab2.setContentAreaFilled(false);
		Ab2.setFocusable(false);
	}
	else if(c.getAbilities().get(1) instanceof HealingAbility)
	{
	HealingAbility a=(HealingAbility)c.getAbilities().get(1);
	Ab2=new JButton("<html>"+a.getName()+"<br/>Heal: "+a.getHealAmount()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab2.setFont(abFont);
		Ab2.setBounds(520, 80, 80, 38);
		Ab2.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab2.setForeground(Color.white);	
		Ab2.setOpaque(false);
		Ab2.setContentAreaFilled(false);
		Ab2.setFocusable(false);
	}
	else if(c.getAbilities().get(1) instanceof CrowdControlAbility)
	{
		CrowdControlAbility a=(CrowdControlAbility)c.getAbilities().get(1);
		Ab2=new JButton("<html>"+a.getName()+"<br/>Effect: "+a.getEffect().getName()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab2.setFont(abFont);
		Ab2.setBounds(520, 80, 80, 38);
		Ab2.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab2.setForeground(Color.white);
		Ab2.setOpaque(false);
		Ab2.setContentAreaFilled(false);
		Ab2.setFocusable(false);
	}
	
	
	
	Ability3=new JButton();
	Ability3.setContentAreaFilled(false);
	Ability3.setFocusable(true);
	Ability3.setOpaque(false);
	Ability3.setBorder(BorderFactory.createLineBorder(Color.white,2));
	Ability3.addActionListener(this);
	
	
	if(c.getAbilities().get(2) instanceof DamagingAbility )
	{
		DamagingAbility a=(DamagingAbility)c.getAbilities().get(2);
		 Ab3=new JButton("<html>"+a.getName()+"<br/>Damage: "+a.getDamageAmount()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab3.setFont(abFont);
		Ab3.setBounds(600, 80, 80, 38);
		Ab3.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab3.setForeground(Color.white);
		Ab3.setOpaque(false);
		Ab3.setContentAreaFilled(false);
		Ab3.setFocusable(false);
	}
	else if(c.getAbilities().get(2) instanceof HealingAbility)
	{
	HealingAbility a=(HealingAbility)c.getAbilities().get(2);
	    Ab3=new JButton("<html>"+a.getName()+"<br/>Heal: "+a.getHealAmount()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab3.setFont(abFont);
		Ab3.setBounds(600, 80, 80, 38);
		Ab3.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab3.setForeground(Color.white);	
		Ab3.setOpaque(false);
		Ab3.setContentAreaFilled(false);
		Ab3.setFocusable(false);
	}
	else if(c.getAbilities().get(2) instanceof CrowdControlAbility)
	{
		CrowdControlAbility a=(CrowdControlAbility)c.getAbilities().get(2);
		Ab3=new JButton("<html>"+a.getName()+"<br/>Effect: "+a.getEffect().getName()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
		Ab3.setFont(abFont);
		Ab3.setBounds(600, 80, 80, 38);
		Ab3.setBorder(BorderFactory.createLineBorder(Color.white,2));
		Ab3.setForeground(Color.white);
		Ab3.setOpaque(false);
		Ab3.setContentAreaFilled(false);
		Ab3.setFocusable(false);
	}
	
	Ab4=new JButton();
	Ab4.setFont(abFont);
	Ab4.setBounds(680, 80, 80, 38);
	Ab4.setBorder(BorderFactory.createLineBorder(Color.white,2));
	Ab4.setForeground(Color.white);
	Ab4.setOpaque(false);
	Ab4.setContentAreaFilled(false);
	Ab4.setFocusable(false);
	Ab4.setName("Fady");
	
	if(c.getAbilities().size()<4)
	{
		Ab4.setEnabled(false);
		punch=new JButton();
		//punch.setEnabled(false);
	}
	else
	{
		punch=new JButton();
		punch.addActionListener(this);
	}
	punch.setContentAreaFilled(false);
	punch.setFocusable(true);
	punch.setOpaque(false);
	punch.setBorder(BorderFactory.createLineBorder(Color.white,2));
	
	
	
	for(int i=0;i<4;i++)
	{
		switch(i)
		{
			case 0:
			 setAbilityIcon(Ability1, c.getAbilities().get(i));
			 Ability1.setBounds(440,0,80,80);
			 Current.add(Ability1);
			case 1:
			setAbilityIcon(Ability2, c.getAbilities().get(i));
			 Ability2.setBounds(520,0,80,80);
			 Current.add(Ability2);
			case 2:
			setAbilityIcon(Ability3, c.getAbilities().get(i));
			 Ability3.setBounds(600,0,80,80);
			 Current.add(Ability3);
			case 3:
				if(c.getAbilities().size()>3 && game.hasEffect(c, "Disarm") )
				{
					setAbilityIcon(punch, c.getAbilities().get(i));
					DamagingAbility a=(DamagingAbility)c.getAbilities().get(3);
					Ab4.setText("<html>"+a.getName()+"<br/>Damage: "+a.getDamageAmount()+"<br/>Cost:"+a.getManaCost()+" M, "+a.getRequiredActionPoints()+" A<html>");
					Ab4.setName("lol");
				}
		}
	}
	
	leaderAb.addActionListener(this);
	Ab1.addActionListener(this);
	Ab2.addActionListener(this);
	Ab3.addActionListener(this);
	Ab4.addActionListener(this);
	
	moveleft=new JButton();
	moveleft.setBounds(770,32,40,40);
	moveleft.setBorderPainted(false);
	moveleft.setContentAreaFilled(false);
	moveleft.setFocusable(true);
	moveleft.setOpaque(false);
	moveleft.addActionListener(this);
	ImageIcon left= new ImageIcon(this.getClass().getResource("leftcon.png"));
	ImageIcon scaleleft=new ImageIcon(left.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	moveleft.setIcon(scaleleft);
	
	
	moveright=new JButton();
	moveright.setBounds(835,32,40,40);
	moveright.setContentAreaFilled(false);
	moveright.setFocusable(true);
	moveright.setBorderPainted(false);
	moveright.setOpaque(false);
	moveright.addActionListener(this);
	ImageIcon right= new ImageIcon(this.getClass().getResource("rightcon.png"));
	ImageIcon scaleright=new ImageIcon(right.getImage().getScaledInstance(47, 50, Image.SCALE_DEFAULT));
	moveright.setIcon(scaleright);
	
	moveup=new JButton();
	moveup.setBounds(805,2,40,40);
	moveup.setContentAreaFilled(false);
	moveup.setFocusable(true);
	moveup.setOpaque(false);
	moveup.addActionListener(this);
	moveup.setBorderPainted(false);
	ImageIcon up= new ImageIcon(this.getClass().getResource("up.png"));
	ImageIcon scaleup=new ImageIcon(up.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	moveup.setIcon(scaleup);
	
	
	movedown=new JButton();
	movedown.setBounds(805,62,40,40);
	movedown.setContentAreaFilled(false);
	movedown.setFocusable(true);
	movedown.setOpaque(false);
	movedown.setBorderPainted(false);
	movedown.addActionListener(this);
	ImageIcon down= new ImageIcon(this.getClass().getResource("down.png"));
	ImageIcon scaledown=new ImageIcon(down.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	movedown.setIcon(scaledown);
	

	
	
	Health.setText(c.getCurrentHP()+"/"+c.getMaxHP());
	Mana.setText(c.getMana()+"/"+c.getMaxMana());
	ActionPoints.setText(c.getCurrentActionPoints()+"/"+c.getMaxActionPointsPerTurn());
	
	if(c.getAbilities().get(0).getCurrentCooldown()>0 || c.getAbilities().get(0).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(0).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
		Ability1.setEnabled(false);
	if(c.getAbilities().get(1).getCurrentCooldown()>0 || c.getAbilities().get(1).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(1).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
		Ability2.setEnabled(false);
	if(c.getAbilities().get(2).getCurrentCooldown()>0 || c.getAbilities().get(2).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(2).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
		Ability3.setEnabled(false);
	if(c.getAbilities().size()>3)
	{
		if(c.getAbilities().get(3).getCurrentCooldown()>0 || c.getAbilities().get(3).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(3).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
			punch.setEnabled(false);
	}
	if(c.getCurrentActionPoints()<2 || game.hasEffect(c, "Disarm"))
		Attack.setEnabled(false);
	
	
	
//	layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(Health).addComponent(Mana).addComponent(ActionPoints);
	
	
	end.addActionListener(this);
	
	Current.add(leaderAb);
	Current.add(end);
	
	//if(Ab4 !=null)
		Current.add(Ab4);
	Current.add(Ab3);
	Current.add(Ab2);
	Current.add(Ab1);
	Current.add(moveright);
	Current.add(moveup);
	Current.add(movedown);
	Current.add(moveleft);
	punch.setBounds(680,0,80,80);
	Current.add(punch);
	Current.add(AttackLabel);
	Current.add(Attack);
	Current.add(Name);
	Current.add(icon);
	Information.add(Health);
	Information.add(Mana);
	Information.add(ActionPoints);
	
	moveleft.requestFocusInWindow();
	moveright.requestFocusInWindow();
	movedown.requestFocusInWindow();
	moveup.requestFocusInWindow();
	end.requestFocusInWindow();
	icon.requestFocusInWindow();
	Attack.requestFocusInWindow();
	leaderAb.requestFocusInWindow();
	
	Ability1.requestFocusInWindow();
	Ability2.requestFocusInWindow();
	Ability3.requestFocusInWindow();
	punch.requestFocusInWindow();
	
	icon.addKeyListener(this);
	moveleft.addKeyListener(this);
	moveright.addKeyListener(this);
	movedown.addKeyListener(this);
	moveup.addKeyListener(this);
	
	Ability1.addKeyListener(this);
	Ability2.addKeyListener(this);
	Ability3.addKeyListener(this);
	punch.addKeyListener(this);
	
	
	
	
	Current.revalidate();
	Current.repaint();
}


public void updateCurrent()
{
	
	Champion c=(Champion)game.getCurrentChampion();
	Health.setText(c.getCurrentHP()+"/"+c.getMaxHP());
	Mana.setText(c.getMana()+"/"+c.getMaxMana());
	ActionPoints.setText(c.getCurrentActionPoints()+"/"+c.getMaxActionPointsPerTurn());
	
	if(!game.getFirstPlayer().getLeader().equals(c)&& !game.getSecondPlayer().getLeader().equals(c))
	{
		leaderAb.setEnabled(false);
	}
	else
	{
		if(game.getFirstPlayer().getTeam().contains(c))
		{
			if(game.isFirstLeaderAbilityUsed())
				leaderAb.setEnabled(false);
		}
		else
		{
			if(game.isSecondLeaderAbilityUsed())
				leaderAb.setEnabled(false);
		}
	}
	
	
	
	if(c.getAbilities().get(0).getCurrentCooldown()>0 || c.getAbilities().get(0).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(0).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
		Ability1.setEnabled(false);
	if(c.getAbilities().get(1).getCurrentCooldown()>0 || c.getAbilities().get(1).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(1).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
		Ability2.setEnabled(false);
	if(c.getAbilities().get(2).getCurrentCooldown()>0 || c.getAbilities().get(2).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(2).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
		Ability3.setEnabled(false);
	if(c.getAbilities().size()>3)
	{
		if(c.getAbilities().get(3).getCurrentCooldown()>0 || c.getAbilities().get(3).getRequiredActionPoints()>c.getCurrentActionPoints()|| c.getAbilities().get(3).getManaCost()>c.getMana() || game.hasEffect(c, "Silence"))
		{
			punch.setEnabled(false);
	//		punch.setIcon(null);
//			Ab4.setText(null);
//			Ab4.setEnabled(false);
		}
		if(!game.hasEffect(c, "Disarm"))
		{
			punch.setEnabled(false);
				punch.setIcon(null);
			Ab4.setText(null);
			Ab4.setEnabled(false);
		}
	}
	
	
	if(c.getCurrentActionPoints()<2 || game.hasEffect(c, "Disarm"))
		Attack.setEnabled(false);
	else
		Attack.setEnabled(true);
	
	if(c.getCurrentHP()>c.getMaxHP()*0.75)
	{
		ImageIcon HealthIcon= new ImageIcon(this.getClass().getResource("actionpoints100.png"));
		ImageIcon scaledhealth=new ImageIcon(HealthIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Health.setIcon(scaledhealth);
		Health.setVisible(true);
	}
	else if(c.getCurrentHP()>c.getMaxHP()*0.5)
	{
		ImageIcon HealthIcon= new ImageIcon(this.getClass().getResource("actionpoints50.png"));
		ImageIcon scaledhealth=new ImageIcon(HealthIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Health.setIcon(scaledhealth);
		Health.setVisible(true);
	}
	else if(c.getCurrentHP()<c.getMaxHP()*0.25)
	{
		ImageIcon HealthIcon= new ImageIcon(this.getClass().getResource("actionpoints45.png"));
		ImageIcon scaledhealth=new ImageIcon(HealthIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Health.setIcon(scaledhealth);
		Health.setVisible(true);
	}
	
	if(c.getMana()>c.getMaxMana()*0.75)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana100.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	else if(c.getMana()>c.getMaxMana()*0.5)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana50.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	else if(c.getMana()>0)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana45.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	else 
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("mana0.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		Mana.setIcon(Manahealth);
		Mana.setVisible(true);
	}
	
	if(c.getCurrentActionPoints()>c.getMaxActionPointsPerTurn()*0.75)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health100.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	else if(c.getCurrentActionPoints()>c.getMaxActionPointsPerTurn()*0.5)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health50.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	else if(c.getCurrentActionPoints()>c.getMaxActionPointsPerTurn()*0.25)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health45.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	else if(c.getCurrentActionPoints()==0)
	{
		ImageIcon ManaIcon= new ImageIcon(this.getClass().getResource("health0.png"));
		ImageIcon Manahealth=new ImageIcon(ManaIcon.getImage().getScaledInstance(150, 40, Image.SCALE_DEFAULT));
		ActionPoints.setIcon(Manahealth);
		ActionPoints.setVisible(true);
	}
	Current.requestFocusInWindow();
	moveleft.requestFocusInWindow();
	moveright.requestFocusInWindow();
	movedown.requestFocusInWindow();
	moveup.requestFocusInWindow();
	end.requestFocusInWindow();
	icon.requestFocusInWindow();
	Attack.requestFocusInWindow();
	Ability1.requestFocusInWindow();
	Ability2.requestFocusInWindow();
	Ability3.requestFocusInWindow();
	punch.requestFocusInWindow();
	
}

//public void updatenorth(ArrayList<Champion> all) {
//	for(int i=0;i<all.size();i++) {
//		int h=all.get(i).getCurrentHP();
//		String name=all.get(i).getName();
//		if(h<=0) {
//			for(int j=0;j<iconbutton.size();j++) {
//				if(name==iconbutton.get(j).getName()) {
//					iconbutton.get(j).setEnabled(false);
//				}
//			}
//			
//		}
//	}
//}

public void setAbilityIcon(JButton Ability1,Ability a)
{
	if(a instanceof DamagingAbility)
	 {
		 ImageIcon Dam= new ImageIcon(this.getClass().getResource("debuff.png"));
		 ImageIcon scaleDam=new ImageIcon(Dam.getImage().getScaledInstance(80, 75, Image.SCALE_DEFAULT));
		 Ability1.setIcon(scaleDam);
	 }
	 else if(a instanceof HealingAbility)
	 {
		 ImageIcon Dam= new ImageIcon(this.getClass().getResource("healbutt.png"));
		 ImageIcon scaleDam=new ImageIcon(Dam.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		 Ability1.setIcon(scaleDam);
	 }
	 else
	 {
		 CrowdControlAbility ccA=(CrowdControlAbility) a;
		 if(ccA.getEffect().getType()==EffectType.BUFF)
		 {
			 ImageIcon Dam= new ImageIcon(this.getClass().getResource("Buff.png"));
			 ImageIcon scaleDam=new ImageIcon(Dam.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			 Ability1.setIcon(scaleDam);
		 }
		 else
		 {
			 ImageIcon Dam= new ImageIcon(this.getClass().getResource("debuff.png"));
			 ImageIcon scaleDam=new ImageIcon(Dam.getImage().getScaledInstance(80, 75, Image.SCALE_DEFAULT));
			 Ability1.setIcon(scaleDam);
		 }
	 }
}





public void updateTile(int[][] affected)
{
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			if(affected[i][j]==1)
			{
				if(game.getBoard()[i][j] instanceof Champion)
				{
					ImageIcon main;
					ImageIcon scaledM;
					Champion c=(Champion) game.getBoard()[i][j];
					switch(c.getName())
					{
					
					case  "Spiderman":
						
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("SpiderTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("SpiderTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					case "Thor":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("ThorTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("ThorTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					
					case "Iceman":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("IceTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("IceTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					case "Electro":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("ElectroTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("ElectroTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					case "Hela":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("HelaTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("HelaTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					
					case "Ghost Rider":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("GhostTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("GhostTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					
					case "Dr Strange":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("DrTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("DrTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					
					case "Loki":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("LokiTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("LokiTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					case "Hulk":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("HulkTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("HulkTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					case "Captain America":
						ImageIcon capBlue;
						if(game.getFirstPlayer().getTeam().contains(c))
							capBlue=new ImageIcon(this.getClass().getResource("CapTileBlue1.png"));
						else
							capBlue=new ImageIcon(this.getClass().getResource("CapTileBlue2.png"));
						 ImageIcon scaledCap=new ImageIcon(capBlue.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledCap);
						ArrayButton[i][j].setName(c.getName());
						break;
					case "Deadpool":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("DeadTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("DeadTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
						break;
					case "Ironman":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("IronTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("IronTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
//						if(game.isOpponent(c))
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//						else 
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
						break;
					case "Venom":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("VenomTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("VenomTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
//					    if(game.isOpponent(c))
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//						else 
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
						break;
					case "Quicksilver":
						if(game.getFirstPlayer().getTeam().contains(c))
							main=new ImageIcon(this.getClass().getResource("QuickTileBlue1.png"));
						else
							main=new ImageIcon(this.getClass().getResource("QuickTileBlue2.png"));
						   scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
						 ArrayButton[i][j].setIcon(scaledM);
						ArrayButton[i][j].setName(c.getName());
//					    if(game.isOpponent(c))
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//						else 
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
						break;
					default:
						ImageIcon Venom2=new ImageIcon(this.getClass().getResource("BlueTest.png"));
					    ImageIcon scaledVenom2=new ImageIcon(Venom2.getImage().getScaledInstance(175, 80, Image.SCALE_DEFAULT));
						ArrayButton[i][j].setIcon(scaledVenom2);
						ArrayButton[i][j].setText(c.getName());
						ArrayButton[i][j].setName(c.getName());
//						if(game.isOpponent(c))
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//						else 
//							ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
					}
				}
				else if(game.getBoard()[i][j] instanceof Cover)
				{
					ImageIcon earth=new ImageIcon(this.getClass().getResource("Cover22Blue.png"));
				    ImageIcon scaledspider=new ImageIcon(earth.getImage().getScaledInstance(175, 68, Image.SCALE_DEFAULT));
				    ArrayButton[i][j].setIcon(scaledspider);
				}
				else 
				{
					ArrayButton[i][j].setName("lolz");
					//ArrayButton[i][j].setBorder(UIManager.getBorder("Button.border"));
					ImageIcon earth=new ImageIcon(this.getClass().getResource("tileearth2Blue.png"));
				    ImageIcon scaledspider=new ImageIcon(earth.getImage().getScaledInstance(175, 80, Image.SCALE_DEFAULT));
				    
				    ArrayButton[i][j].setIcon(scaledspider);
				}
			}
		}
	}

}






public void updateTile()
{
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			
			if(game.getBoard()[i][j] instanceof Champion)
			{
				ImageIcon main;
				ImageIcon scaledM;
				Champion c=(Champion) game.getBoard()[i][j];
				switch(c.getName())
				{
				
				case "Spiderman":
					
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("SpiderTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("SpiderTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Thor":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("ThorTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("ThorTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Iceman":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("IceTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("IceTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Electro":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("ElectroTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("ElectroTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Hela":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("HelaTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("HelaTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				
				case "Ghost Rider":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("GhostTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("GhostTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
 				
				case "Dr Strange":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("DrTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("DrTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Loki":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("LokiTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("LokiTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Hulk":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("HulkTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("HulkTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Deadpool":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("DeadTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("DeadTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
					break;
				case "Ironman":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("IronTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("IronTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
//					if(game.isOpponent(c))
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//					else 
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
					break;
				case "Venom":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("VenomTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("VenomTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
//				    if(game.isOpponent(c))
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//					else 
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
					break;
				case "Quicksilver":
					if(game.getFirstPlayer().getTeam().contains(c))
						  main=new ImageIcon(this.getClass().getResource("QuickTile1.png"));
						else 
					      main=new ImageIcon(this.getClass().getResource("QuickTile2.png"));
					scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
					ArrayButton[i][j].setIcon(scaledM);
					ArrayButton[i][j].setName(c.getName());
//				    if(game.isOpponent(c))
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//					else 
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
					break;
				case "Captain America":
					if(game.getFirstPlayer().getTeam().contains(c))
					  main=new ImageIcon(this.getClass().getResource("CapTile1.png"));
					else 
						 main=new ImageIcon(this.getClass().getResource("CapTile2.png"));
				     scaledM=new ImageIcon(main.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
				    ArrayButton[i][j].setIcon(scaledM);
				    ArrayButton[i][j].setName(c.getName());
				    break;
				default:
					ArrayButton[i][j].setIcon(null);
					ArrayButton[i][j].setText(c.getName());
					ArrayButton[i][j].setName(c.getName());
//					if(game.isOpponent(c))
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.red,2));
//					else 
//						ArrayButton[i][j].setBorder(BorderFactory.createLineBorder(Color.green,2));
				}
			}
			else if(game.getBoard()[i][j] instanceof Cover)
			{
				ImageIcon earth=new ImageIcon(this.getClass().getResource("Cover22.png"));
			    ImageIcon scaledspider=new ImageIcon(earth.getImage().getScaledInstance(175, 68, Image.SCALE_DEFAULT));
			    ArrayButton[i][j].setIcon(scaledspider);
			}
			else 
			{
				ArrayButton[i][j].setName("lolz");
				//ArrayButton[i][j].setBorder(UIManager.getBorder("Button.border"));
				ImageIcon earth=new ImageIcon(this.getClass().getResource("tileearth2.png"));
			    ImageIcon scaledspider=new ImageIcon(earth.getImage().getScaledInstance(175, 73, Image.SCALE_DEFAULT));
			    
			    ArrayButton[i][j].setIcon(scaledspider);
			}
		}
	}

}





@Override
public void actionPerformed(ActionEvent e) {
	Champion current=game.getCurrentChampion();
	String[] second= {"OK"};
	
	if(e.getSource()==howto) {
		JOptionPane.showMessageDialog(this,"How to play:\r\n"
				+ "The goal of the game is to eliminate the all of the opposing player’s champions"+"\n"
				+" Each champion takes turns to to perform their action on the board."+"\n"
				+" A champion could move,attack or cast an ability."+"\n"
				+ " To perform an attack or cast a directional ability,"+" \n"+
				"you first must select the action and then provide a direction for it."+"\n"
				+" To perform a single target ability, after clicking on it’s icon, select a cell on the board by clicking on it."+"\n"
				+" To display any champion or cover information, click on their cell.");
		return;
	}
	
	if(e.getSource()==pause) {
		JOptionPane.showMessageDialog(this,"Game Paused");
		return;
	}
	if(e.getSource()==end)
	{
		game.endTurn();
	//	System.out.println(game.getFirstPlayer().getTeam().get(0).getAbilities().get(0).getCurrentCooldown());
		updateTurn();
		updateTile();
		this.remove(Current);
		loadCurrent();
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		return;
	}
		
	if(e.getSource()==leaderAb)
	{
		try {
			System.out.println("dehk");
			game.useLeaderAbility();
			updateTurn();
			updateTile();
			updateCurrent();
			moveleft.requestFocusInWindow();
			moveright.requestFocusInWindow();
			movedown.requestFocusInWindow();
			moveup.requestFocusInWindow();
			end.requestFocusInWindow();
			icon.requestFocusInWindow();
			Attack.requestFocusInWindow();
			
			Ability1.requestFocusInWindow();
			Ability2.requestFocusInWindow();
			Ability3.requestFocusInWindow();
			punch.requestFocusInWindow();
			return;
		} catch (LeaderNotCurrentException | LeaderAbilityAlreadyUsedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	
	if(e.getSource()==icon)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		String s="Applied Efffects on "+current.getName()+":\n";
		for(int i=0;i<current.getAppliedEffects().size();i++)
			s+=current.getAppliedEffects().get(i).getName()+" for "+current.getAppliedEffects().get(i).getDuration()+" turn/s.\n";
		JOptionPane.showMessageDialog(this, s);//Remember Later , Shows Applied Effect on Champ
		
		return;
	}
	if(e.getSource()==Attack)
	{
		
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		int two =JOptionPane.showOptionDialog(this, "Select a Direction to Attack", "Attack", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
		
		if(two!=-1)
		{
			isAttackedPressed=true;
			updateTile(game.GetAffected());
			
			AbilityPostion=0;
		}
		else
			isAttackedPressed=false;
		return;
	}
	if(e.getSource()==Ability1)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		Ability a=current.getAbilities().get(0);
		if(a.getCastArea() == AreaOfEffect.DIRECTIONAL)
		{
			int two =JOptionPane.showOptionDialog(this, "Select a Direction to Cast Ability", "Directional Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
			if(two!=-1)
			{
				isCastDirectionalPressed=true;
				AbilityPostion=0;
				updateTile(game.GetAffected(current.getAbilities().get(AbilityPostion)));
				
			}
			else
				isCastDirectionalPressed=false;
		
		}
		else if(a.getCastArea() == AreaOfEffect.SINGLETARGET)
		{
				int two =JOptionPane.showOptionDialog(this, "Select a Cell to Cast Ability on", "Single Target Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
				if(two!=-1)
				{
					isCastSinglePressed=true;
					AbilityPostion=0;
					updateTile(game.getSingleAffected(current.getAbilities().get(AbilityPostion)));
					
				}
				else
					isCastSinglePressed=false;
		}
		
		else 
		{
			try {
				UpdateTrans(game.castAbility(a));
				updateTile();
				updateCurrent();
				updateTurn();
//				for(int i=0;i<all.size();i++) {
//					int h=all.get(i).getCurrentHP();
//					String name=all.get(i).getName();
//					if(h<=0) {
//						for(int j=0;j<iconbutton.size();j++) {
//							if(name==iconbutton.get(j).getName()) {
//								iconbutton.get(j).setEnabled(false);
//							}
//						}
//						
//					}
//				}
				
				if(game.checkGameOver()!=null) {
					win n=new win(game.checkGameOver().getName(),theFrame);
					this.setVisible(false);
					
				}
					
					//JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			}
		}
		
		return;
	}
	if(e.getSource()==Ability2)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		
		Ability a=current.getAbilities().get(1);
		if(a.getCastArea() == AreaOfEffect.DIRECTIONAL)
		{
			int two =JOptionPane.showOptionDialog(this, "Select a Direction to Cast Ability", "Directional Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
			if(two!=-1)
			{
				isCastDirectionalPressed=true;
				AbilityPostion=1;
				updateTile(game.GetAffected(current.getAbilities().get(AbilityPostion)));
				
			}
			else
				isCastDirectionalPressed=false;
		
		}
		else if(a.getCastArea() == AreaOfEffect.SINGLETARGET)//
		{
				int two =JOptionPane.showOptionDialog(this, "Select a Cell to Cast Ability on", "Single Target Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
				if(two!=-1)
				{
					isCastSinglePressed=true;
					AbilityPostion=1;
					updateTile(game.getSingleAffected(current.getAbilities().get(AbilityPostion)));
					
				}
				else
					isCastSinglePressed=false;
	
		}
		
		else 
		{
			try {
				UpdateTrans(game.castAbility(a));
				updateTile();
				updateCurrent();
				
				updateTurn();
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			}
		}
		return;
	}
	if(e.getSource()==Ability3)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		Ability a=current.getAbilities().get(2);
		if(a.getCastArea() == AreaOfEffect.DIRECTIONAL)
		{
			int two =JOptionPane.showOptionDialog(this, "Select a Direction to Cast Ability", "Directional Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
			if(two!=-1)
			{
				isCastDirectionalPressed=true;
				AbilityPostion=2;
				updateTile(game.GetAffected(current.getAbilities().get(AbilityPostion)));
			
			}
			else
				isCastDirectionalPressed=false;
		
		}
		else if(a.getCastArea() == AreaOfEffect.SINGLETARGET)//
		{
				int two =JOptionPane.showOptionDialog(this, "Select a Cell to Cast Ability on", "Single Target Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
				if(two!=-1)
				{
					isCastSinglePressed=true;
					AbilityPostion=2;
					updateTile(game.getSingleAffected(current.getAbilities().get(AbilityPostion)));
					
				}
				else
					isCastSinglePressed=false;
		}
		
		else 
		{
			try {
				UpdateTrans(game.castAbility(a));
				updateTile();
				updateCurrent();
				updateTurn();
				
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			}
		}
		return;
	}
	
	if(e.getSource()==Ability3)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		Ability a=current.getAbilities().get(2);
		if(a.getCastArea() == AreaOfEffect.DIRECTIONAL)
		{
			moveleft.requestFocusInWindow();
			moveright.requestFocusInWindow();
			movedown.requestFocusInWindow();
			moveup.requestFocusInWindow();
			end.requestFocusInWindow();
			icon.requestFocusInWindow();
			Attack.requestFocusInWindow();
			
			Ability1.requestFocusInWindow();
			Ability2.requestFocusInWindow();
			Ability3.requestFocusInWindow();
			punch.requestFocusInWindow();
			int two =JOptionPane.showOptionDialog(this, "Select a Direction to Cast Ability", "Directional Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
			if(two!=-1)
			{
				isCastDirectionalPressed=true;
				AbilityPostion=2;
				updateTile(game.GetAffected(current.getAbilities().get(AbilityPostion)));
				
			}
			else
				isCastDirectionalPressed=false;
		
		}
		else if(a.getCastArea() == AreaOfEffect.SINGLETARGET)//
		{
		
				int two =JOptionPane.showOptionDialog(this, "Select a Cell to Cast Ability on", "Single Target Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
				if(two!=-1)
				{
					isCastSinglePressed=true;
					AbilityPostion=2;
					updateTile(game.getSingleAffected(current.getAbilities().get(AbilityPostion)));
					
				}
				else
					isCastSinglePressed=false;
		}
		
		else 
		{
			try {
				UpdateTrans(game.castAbility(a));
				updateTile();
				updateCurrent();
				
				updateTurn();
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
			} catch (AbilityUseException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			} catch (CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this,e1.getMessage());
			}
		}
	return;
	}
	
	
	
	if(e.getSource()==Ab1)
	{
		Ability a=current.getAbilities().get(0);
		String s="Name: "+a.getName()+"\nArea of Effect: "+a.getCastArea()+"\nCurrent Cooldown: "+a.getCurrentCooldown()+"\nBase Cooldown: "+a.getBaseCooldown()+"\nRange: "+a.getCastRange();
		JOptionPane.showMessageDialog(this, s);
		return;
	}
	if(e.getSource()==Ab2)
	{
		Ability a=current.getAbilities().get(1);
		String s="Name: "+a.getName()+"\nArea of Effect: "+a.getCastArea()+"\nCurrent Cooldown: "+a.getCurrentCooldown()+"\nBase Cooldown: "+a.getBaseCooldown()+"\nRange: "+a.getCastRange();
		JOptionPane.showMessageDialog(this, s);
		return;
	}
	if(e.getSource()==Ab3)
	{
		Ability a=current.getAbilities().get(2);
		String s="Name: "+a.getName()+"\nArea of Effect: "+a.getCastArea()+"\nCurrent Cooldown: "+a.getCurrentCooldown()+"\nBase Cooldown: "+a.getBaseCooldown()+"\nRange: "+a.getCastRange();
		JOptionPane.showMessageDialog(this, s);
		return;
	}
	if(e.getSource()==Ab4)
	{
		Ability a=current.getAbilities().get(3);
		String s="Name: "+a.getName()+"\nArea of Effect: "+a.getCastArea()+"\nCurrent Cooldown: "+a.getCurrentCooldown()+"\nBase Cooldown: "+a.getBaseCooldown()+"\nRange: "+a.getCastRange();
		JOptionPane.showMessageDialog(this, s);
		return;
	}
	
	
	
	
	
	if(e.getSource()==punch)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		Ability a=current.getAbilities().get(3);
		
		 if(a.getCastArea() == AreaOfEffect.SINGLETARGET)
		{
			 moveleft.requestFocusInWindow();
				moveright.requestFocusInWindow();
				movedown.requestFocusInWindow();
				moveup.requestFocusInWindow();
				end.requestFocusInWindow();
				icon.requestFocusInWindow();
				Attack.requestFocusInWindow();
				Ability1.requestFocusInWindow();
				Ability2.requestFocusInWindow();
				Ability3.requestFocusInWindow();
				punch.requestFocusInWindow();
				
				
		
				int two =JOptionPane.showOptionDialog(this, "Select a Cell to Cast Ability on", "Single Target Ability", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, second, 0);
				if(two!=-1)
				{
					isCastSinglePressed=true;
					AbilityPostion=3;
					updateTile(game.getSingleAffected(current.getAbilities().get(AbilityPostion)));
					
				}
				else
					isCastSinglePressed=false;
		}
	return;
	}
	
	
	
	
	if(e.getSource()==moveleft)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
			if(isAttackedPressed)
			{
				try {
					String s= game.attack(Direction.LEFT);
					UpdateTrans(s);
					updateTile();
					updateTurn();
					updateCurrent();
					
					isAttackedPressed=false;
					if(game.checkGameOver()!=null)
						JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
				} catch (ChampionDisarmedException | InvalidTargetException | NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
			}
			else if(isCastDirectionalPressed)
			{
				try {
					String s= game.castAbility(current.getAbilities().get(AbilityPostion),Direction.LEFT);
					UpdateTrans(s);
					updateTile();
					updateTurn();
					updateCurrent();
					
					if(game.checkGameOver()!=null)
						JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
					isCastDirectionalPressed=false;
				} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
			}
			else 
			{
				try {
					UpdateTrans(game.move(Direction.LEFT));
					updateTile();
					updateCurrent();
					
				} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(this, e1.getMessage());
				}
			}
			return;
	}
	if(e.getSource()==moveright)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		if(isAttackedPressed)
		{
			try {
				String s= game.attack(Direction.RIGHT);
				UpdateTrans(s);
				updateTile();
				updateTurn();
				updateCurrent();
				isAttackedPressed=false;
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
			} catch (ChampionDisarmedException | InvalidTargetException | NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		else if(isCastDirectionalPressed)
		{
			try {
				String s= game.castAbility(current.getAbilities().get(AbilityPostion),Direction.RIGHT);
				UpdateTrans(s);
				updateTurn();
				updateTile();
				updateCurrent();
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
				isCastDirectionalPressed=false;
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		else 
		{
			try {
				UpdateTrans(game.move(Direction.RIGHT));
				updateTile();
				updateCurrent();
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		return;
	}
	if(e.getSource()==moveup)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		if(isAttackedPressed)
		{
			try {
				String s= game.attack(Direction.DOWN);
				UpdateTrans(s);
				updateTile();
				updateTurn();
				updateCurrent();
				isAttackedPressed=false;
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
			} catch (ChampionDisarmedException | InvalidTargetException | NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		else if(isCastDirectionalPressed)
		{
			try {
				String s= game.castAbility(current.getAbilities().get(AbilityPostion),Direction.DOWN);
				UpdateTrans(s);
				updateTurn();
				updateTile();
				updateCurrent();
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
				isCastDirectionalPressed=false;
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		else 
		{
			try {
				UpdateTrans(game.move(Direction.DOWN));
				updateTile();
				updateCurrent();
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		return;
	}
	if(e.getSource()==movedown)
	{
		moveleft.requestFocusInWindow();
		moveright.requestFocusInWindow();
		movedown.requestFocusInWindow();
		moveup.requestFocusInWindow();
		end.requestFocusInWindow();
		icon.requestFocusInWindow();
		Attack.requestFocusInWindow();
		
		Ability1.requestFocusInWindow();
		Ability2.requestFocusInWindow();
		Ability3.requestFocusInWindow();
		punch.requestFocusInWindow();
		if(isAttackedPressed)
		{
			try {
				String s= game.attack(Direction.UP);
				UpdateTrans(s);
				updateTile();
				updateTurn();
				updateCurrent();
				
				isAttackedPressed=false;
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
			} catch (ChampionDisarmedException | InvalidTargetException | NotEnoughResourcesException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		else if(isCastDirectionalPressed)
		{
			try {
				String s= game.castAbility(current.getAbilities().get(AbilityPostion),Direction.UP);
				UpdateTrans(s);
				updateTurn();
				updateTile();
				updateCurrent();
			
				if(game.checkGameOver()!=null)
					JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
				isCastDirectionalPressed=false;
			} catch (NotEnoughResourcesException | AbilityUseException | CloneNotSupportedException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		else 
		{
			try {
				UpdateTrans(game.move(Direction.UP));
				updateTile();
				updateCurrent();
			
			} catch (NotEnoughResourcesException | UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}
		}
		return;
	}
	
	
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			JButton curr=(JButton)e.getSource();
			String st=ArrayButton[i][j].getName().toString();
			if(curr.getName().equals(st))
			{
				if(isCastSinglePressed)
				{
					moveleft.requestFocusInWindow();
					moveright.requestFocusInWindow();
					movedown.requestFocusInWindow();
					moveup.requestFocusInWindow();
					end.requestFocusInWindow();
					icon.requestFocusInWindow();
					Attack.requestFocusInWindow();
					Ability1.requestFocusInWindow();
					Ability2.requestFocusInWindow();
					Ability3.requestFocusInWindow();
					punch.requestFocusInWindow();
					try {
						UpdateTrans(game.castAbility(current.getAbilities().get(AbilityPostion), i, j));
						updateTile();
						updateCurrent();
						updateTurn();
					
						isCastSinglePressed=false;
						if(game.checkGameOver()!=null)
							JOptionPane.showMessageDialog(this,game.checkGameOver().getName()+" Won!");
					} catch (AbilityUseException | NotEnoughResourcesException | InvalidTargetException
							| CloneNotSupportedException e1) {
						JOptionPane.showMessageDialog(this, e1.getMessage());
						updateTile();
						isCastSinglePressed=false;
					}
				}
				else if(!curr.getName().equals("lolz"))
				{
					
					if(game.getBoard()[i][j] instanceof Champion)
					{
						Champion c=(Champion) game.getBoard()[i][j];
						String s=c.getName()+"'s Current HP: "+c.getCurrentHP()+"\nApplied Effects:";
						for(int x=0;x<c.getAppliedEffects().size();x++)
							s+="\n-"+c.getAppliedEffects().get(x).getName()+" For "+c.getAppliedEffects().get(x).getDuration()+" turn/s";
						JOptionPane.showMessageDialog(this, s);
					}
					else if(game.getBoard()[i][j] instanceof Cover)
					{
						Cover c=(Cover) game.getBoard()[i][j];
						String s="Cover's Current HP: "+c.getCurrentHP();
						JOptionPane.showMessageDialog(this, s);
					}
				}
			}
		}
	}
	
	
	moveleft.requestFocusInWindow();
	moveright.requestFocusInWindow();
	movedown.requestFocusInWindow();
	moveup.requestFocusInWindow();
	end.requestFocusInWindow();
	icon.requestFocusInWindow();
	Attack.requestFocusInWindow();
	Ability1.requestFocusInWindow();
	Ability2.requestFocusInWindow();
	Ability3.requestFocusInWindow();
	punch.requestFocusInWindow();
	
	
	
}



public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_A)
	{
		moveleft.doClick();
	}
	if(e.getKeyCode()==KeyEvent.VK_D)
	{
		moveright.doClick();
	}
	if(e.getKeyCode()==KeyEvent.VK_S)
	{
		movedown.doClick();
	}
	if(e.getKeyCode()==KeyEvent.VK_W)
	{
		moveup.doClick();
	}
	if(e.getKeyCode()==KeyEvent.VK_ENTER)
		end.doClick();
	if(e.getKeyCode()==KeyEvent.VK_F)
		icon.doClick();
	if(e.getKeyCode()==KeyEvent.VK_X)
		Attack.doClick();
	if(e.getKeyCode()==KeyEvent.VK_C)
		Ability1.doClick();
	if(e.getKeyCode()==KeyEvent.VK_V)
		Ability2.doClick();
	if(e.getKeyCode()==KeyEvent.VK_B)
		Ability3.doClick();
	if(e.getKeyCode()==KeyEvent.VK_G)
		punch.doClick();
//	if(e.getKeyCode()==KeyEvent.VK_E);
//	{
//		System.out.println("kooo");
//		leaderAb.doClick();
//	}
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}




























//JButton button2=new JButton("Button2");
//button2.setPreferredSize(new Dimension(175,80));
//Arena.add(button2);
//
//JButton button3=new JButton("Button3");
//button3.setPreferredSize(new Dimension(175,80));
//Arena.add(button3);
//
//JButton button4=new JButton("Button4");
//button4.setPreferredSize(new Dimension(175,80));
//Arena.add(button4);
//
//JButton button5=new JButton("Button5");
//button5.setPreferredSize(new Dimension(175,80));
//Arena.add(button5);
//
//JButton button6=new JButton("Button6");
//button6.setPreferredSize(new Dimension(175,80));
//Arena.add(button6);
//
//JButton button7=new JButton("Button7");
//button7.setPreferredSize(new Dimension(175,80));
//Arena.add(button7);
//
//JButton button8=new JButton("Button8");
//button8.setPreferredSize(new Dimension(175,80));
//Arena.add(button8);
//
//JButton button9=new JButton("Button9");
//button9.setPreferredSize(new Dimension(175,80));
//Arena.add(button9);
//
//JButton button10=new JButton("Button10");
//button10.setPreferredSize(new Dimension(175,80));
//Arena.add(button10);
//
//JButton button11=new JButton("Button11");
//button11.setPreferredSize(new Dimension(175,80));
//Arena.add(button11);
//
//JButton button12=new JButton("Button12");
//button12.setPreferredSize(new Dimension(175,80));
//Arena.add(button12);
//
//JButton button13=new JButton("Button13");
//button13.setPreferredSize(new Dimension(175,80));
//Arena.add(button13);
//
//JButton button14=new JButton("Button14");
//button14.setPreferredSize(new Dimension(175,80));
//Arena.add(button14);
//
//JButton button15=new JButton("Button15");
//button15.setPreferredSize(new Dimension(175,80));
//Arena.add(button15);
//
//JButton button16=new JButton("Button16");
//button16.setPreferredSize(new Dimension(175,80));
//Arena.add(button16);
















//public static void main(String [] args) throws AbilityUseException, NotEnoughResourcesException, InvalidTargetException, ChampionDisarmedException, IOException
//{
//	
//	new Gameplay(new MainFrame(), new Game(new Player("Saleh"), new Player("lol")));
//}
}
