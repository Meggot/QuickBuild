package me.meggot.QuickBuild;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.avaje.ebean.validation.Length;
import com.avaje.ebean.validation.NotEmpty;
import com.avaje.ebean.validation.NotNull;


@Entity()
@Table(name="qb_duel")
public class Duel {
	
    @Id
    private int id;

    @NotNull
    private String challengeName;

    @Length(max=30)
    @NotEmpty
    private String ChallengerName;

    @NotEmpty
    private String typeName;
    
    @NotEmpty
    private String OpponentName;
    
    public int getId()
    {
    	return id;
    }
    
    public String getChallengeName()
    {
    	return challengeName;
    }
    
    public String getChallengerName()
    {
    	return ChallengerName;
    }
    
    public String getTypeName()
    {
    	return typeName;
    }
    
    public String getOpponentName()
    {
    	return OpponentName;
    }
    
    public void setId(int id)
    {
    	this.id = id;
    }
    
    public void setChallengeName(String challengename)
    {
    	this.challengeName = challengename;
    }
    
    public void setChallengerName(String challenger)
    {
    	this.ChallengerName = challenger;
    }
    
    public void setTypeName(String typename)
    {
    	this.typeName = typename;
    }
    
    public void setOpponentName(String opponent)
    {
    	this.OpponentName = opponent;
    }
    
    //Now comes the BUKKIT player retrievers.
    
    @SuppressWarnings("deprecation")
	public Player getOpponent()
    {
    	return Bukkit.getServer().getPlayer(this.OpponentName);
    }
    
    @SuppressWarnings("deprecation")
	public Player getChallenger()
    {
    	return Bukkit.getServer().getPlayer(this.ChallengerName);
    }
}
