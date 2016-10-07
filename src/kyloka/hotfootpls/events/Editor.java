package kyloka.hotfootpls.events;

import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Editor {
    private Player player;
    public void setEditor(Player player1){
        player = player1;
    }
    public Player getEditor(){
        return player;
    }
    public boolean isEditor(Player player1){
        if(player.equals(player1)){return true;}
        else {return false;}
    }

}
