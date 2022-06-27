package model.world;

import java.awt.Point;
import java.util.ArrayList;

import engine.PriorityQueue;
import model.abilities.Ability;
import model.effects.Effect;

abstract public class Champion implements Damageable,Comparable<Champion>{
	private String name;
	private int maxHP;
	private int currentHP;
	private int mana;
	private int maxMana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;
	
	 public Champion(String name, int maxHP, int mana, int actions, int speed, int attackRange, int attackDamage) {
		this.name = name;
		this.maxHP = maxHP;
		this.mana = mana;
		this.currentHP = this.maxHP;
		this.maxActionPointsPerTurn = actions;
		this.speed = speed;
		this.attackRange = attackRange;
		this.attackDamage = attackDamage;
		this.condition = Condition.ACTIVE;
		this.abilities = new ArrayList<Ability>();
		this.appliedEffects = new ArrayList<Effect>();
		this.currentActionPoints=maxActionPointsPerTurn;
		this.maxMana=mana;
	}
	 
	 public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int compareTo(Champion champ)
	 {
		 if(this.getSpeed()==champ.getSpeed())
		 {
			 if(this.name.compareTo(champ.name)>0)
				 return 1;
			 else if(this.name.compareTo(champ.name)<0)
				 return -1;
			 else 
				 return 0;
		 }
		 else if(this.getSpeed()<champ.getSpeed())
			 return 1;
		 else 
			return -1;
	 }
	 
	
	 
	 abstract public void useLeaderAbility(ArrayList<Champion> targets);

	public int getMaxHP() {
		return maxHP;
	}

	public String getName() {
		return name;
	}

	public void setCurrentHP(int hp) {

		if (hp < 0) {
			currentHP = 0;
			
		} 
		else if (hp > maxHP)
			currentHP = maxHP;
		else
			currentHP = hp;

	}

//	public static void main(String [] args)
//	{
//		ArrayList<Integer> lol = new ArrayList<>();
//		lol.add(5);
//		lol.add(3);
//		lol.add(5);
//		lol.add(3);
//		lol.add(6);
//		lol.add(4);
//		int c=0;
//		while(c<lol.size())
//		{
//			System.out.println(lol.get(c));
//			if(lol.get(c)==5)
//			{
//				lol.remove(c);
//			}
//			else
//			 c++;
//		}
//	}
//	
	public int getCurrentHP() {

		return currentHP;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int currentSpeed) {
		if (currentSpeed < 0)
			this.speed = 0;
		else
			this.speed = currentSpeed;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point currentLocation) {
		this.location = currentLocation;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		if(currentActionPoints>maxActionPointsPerTurn)
			currentActionPoints=maxActionPointsPerTurn;
		else 
			if(currentActionPoints<0)
			currentActionPoints=0;
		this.currentActionPoints = currentActionPoints;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	

	
	

}
