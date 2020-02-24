package edu.bradley.ebehymer.cis452mod.capabilities;

public interface IMaxHealth {

	float getBonusMaxHealth();	//current bonus
	void setBonusMaxHealth(float maxHealth);	//assign the bonus, used only by deserialization
	
	void addBonusMaxHealth(float healthToAdd);	//used w/the wand
	void synchronize();		//synch w/clients
}
