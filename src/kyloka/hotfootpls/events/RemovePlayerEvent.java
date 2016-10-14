package kyloka.hotfootpls.events;

import kyloka.hotfootpls.commands.Command;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Matthew on 10/3/2016.
 */
public class RemovePlayerEvent implements Listener {
    @EventHandler
    public void removePlayerFromEvent(PlayerMoveEvent e){
        Player player = e.getPlayer();
        List<PlayPlayer> same = new ArrayList<>();
        same.add(Command.getPlayPlayers0());
        same.add(Command.getPlayPlayers1());
        same.add(Command.getPlayPlayers2());
        same.add(Command.getPlayPlayers3());

        Location location = new Location(player.getWorld(),player.getLocation().getX(),player.getLocation().getY()-1,player.getLocation().getZ());

        for(int i =0; i < same.size(); i++){
            PlayPlayer tempVar = same.get(i);
            if(location.getBlock().getType().equals(Material.BEDROCK) && tempVar.isPlayerOnList(player)
                    && Configuration.getDataConfig().getBoolean("is.On"+i)
                    ){
                player.teleport(tempVar.getPrevCoords(player));
                tempVar.removePlayer(player);
                player.sendMessage("You are out of the game!");
                Bukkit.broadcastMessage(player.getName() + " is out of the game!");
            }
            if(tempVar.getListOfPlayers().size()==1 && Configuration.getDataConfig().getBoolean("is.On"+i)&&tempVar.getListOfPlayers().get(0).equals(player)){
                player.teleport(tempVar.getPrevCoords(player));
                Bukkit.broadcastMessage(ChatColor.GOLD + tempVar.getListOfPlayers().get(0).getName() + ChatColor.GREEN +" is the Winner!");

                tempVar.removePlayer(tempVar.getListOfPlayers().get(0));

                Configuration.getDataConfig().set("is.On"+i,false);
                Configuration.saveDataConfig();
            }
        }



    }
    @EventHandler
    public void removePlayerKick(PlayerQuitEvent e){
        Player player = e.getPlayer();
        List<PlayPlayer> same = new ArrayList<>();
        same.add(Command.getPlayPlayers0());
        same.add(Command.getPlayPlayers1());
        same.add(Command.getPlayPlayers2());
        same.add(Command.getPlayPlayers3());
        for(int i = 0; i<same.size();i++){
            if(same.get(i).isPlayerOnList(player)){
                Bukkit.broadcast(player.getName()+" has left the Arena","hf.start");
                same.get(i).removePlayer(player);
                break;
            }
        }

    }

}
