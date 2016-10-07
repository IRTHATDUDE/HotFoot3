package kyloka.hotfootpls.players;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by Matthew on 10/3/2016.
 */
public class PlayPlayer {
    private List<Player> listOfPlayers = new ArrayList<>();
    private List<Location> listOfPrevLocation = new ArrayList<>();
    public void addPlayer(Player player){
        listOfPlayers.add(player);
    }
    public void removePlayer(Player player){
        int tempInt = listOfPlayers.indexOf(player);
        if(tempInt != -1){
            listOfPlayers.remove(tempInt);
            return;
        }
        else{
            Bukkit.getLogger().log(Level.WARNING,player + " isn't on the list![1]");
            return;
        }
    }
    public void setPrevCoords(Player player,double x,double y,double z, World world){
        int tempInt = listOfPlayers.indexOf(player);
        if(tempInt==-1){
            Bukkit.getLogger().log(Level.WARNING,player.getName() + "isn't on the list![2]");
            return;
        }
        Player player1 = listOfPlayers.get(tempInt);
        Location tempLoc = new Location(world,x,y,z);
        listOfPrevLocation.add(tempInt,tempLoc);
    }
    public Location getPrevCoords(Player player){
        int tempInt = listOfPlayers.indexOf(player);
        if(tempInt != (-1)){
            Location tempLoc = listOfPrevLocation.get(tempInt);
            return tempLoc;
        }
        else{
            Bukkit.getLogger().log(Level.WARNING,player.getName() + "isn't on the list![3]");
            return null;
        }

    }
    public List<Player> getListOfPlayers(){
        return listOfPlayers;
    }
    public Boolean isPlayerOnList(Player player){
        int tempInt = listOfPlayers.indexOf(player);
        if(tempInt != -1){
            return true;
        }
        else{
            return false;
        }
    }

}
