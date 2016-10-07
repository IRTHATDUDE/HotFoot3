package kyloka.hotfootpls.events;

import kyloka.hotfootpls.commands.Command;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

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
            if(tempVar.getListOfPlayers().size()==1 && Configuration.getDataConfig().getBoolean("is.On"+i)){
                Bukkit.broadcastMessage(ChatColor.GOLD + tempVar.getListOfPlayers().get(0).getName() + ChatColor.GREEN +" is the Winner!");
                tempVar.removePlayer(tempVar.getListOfPlayers().get(0));
                Configuration.getDataConfig().set("is.On"+i,false);
                Configuration.saveDataConfig();
            }
        }
        /*
        if(location.getBlock().getType().equals(Material.BEDROCK) && Command.getPlayPlayers0().isPlayerOnList(player)
                && Configuration.getDataConfig().getBoolean("is.On0")
                    ){
            player.teleport(Command.getPlayPlayers0().getPrevCoords(player));
            Command.getPlayPlayers0().removePlayer(player);
            player.sendMessage("You are out of the game!");
            Bukkit.broadcastMessage(player.getName() + " is out of the game!");
        }
        if(Command.getPlayPlayers0().getListOfPlayers().size()==1 && Configuration.getDataConfig().getBoolean("is.On0")){
            Bukkit.broadcastMessage(ChatColor.GOLD + Command.getPlayPlayers0().getListOfPlayers().get(0).getName() + ChatColor.GREEN +" is the Winner!");
            Command.getPlayPlayers0().removePlayer(Command.getPlayPlayers0().getListOfPlayers().get(0));
            Configuration.getDataConfig().set("is.On0",false);
            Configuration.saveDataConfig();
        }
        //ARENA 1

        if(location.getBlock().getType().equals(Material.BEDROCK) && Command.getPlayPlayers1().isPlayerOnList(player)
                && Configuration.getDataConfig().getBoolean("is.On1")
                ){
            player.teleport(Command.getPlayPlayers1().getPrevCoords(player));
            Command.getPlayPlayers1().removePlayer(player);
            player.sendMessage("You are out of the game!");
            Bukkit.broadcastMessage(player.getName() + " is out of the game!");
        }
        if(Command.getPlayPlayers1().getListOfPlayers().size()==1 && Configuration.getDataConfig().getBoolean("is.On1")){
            Bukkit.broadcastMessage(ChatColor.GOLD + Command.getPlayPlayers1().getListOfPlayers().get(0).getName() + ChatColor.GREEN +" is the Winner!");
            Command.getPlayPlayers1().removePlayer(Command.getPlayPlayers1().getListOfPlayers().get(0));
            Configuration.getDataConfig().set("is.On1",false);
            Configuration.saveDataConfig();
        }
        //ARENA 2
        if(location.getBlock().getType().equals(Material.BEDROCK) && Command.getPlayPlayers2().isPlayerOnList(player)
                && Configuration.getDataConfig().getBoolean("is.On2")
                ){
            player.teleport(Command.getPlayPlayers2().getPrevCoords(player));
            Command.getPlayPlayers2().removePlayer(player);
            player.sendMessage("You are out of the game!");
            Bukkit.broadcastMessage(player.getName() + " is out of the game!");
        }
        if(Command.getPlayPlayers2().getListOfPlayers().size()==1 && Configuration.getDataConfig().getBoolean("is.On2")){
            Bukkit.broadcastMessage(ChatColor.GOLD + Command.getPlayPlayers2().getListOfPlayers().get(0).getName() + ChatColor.GREEN +" is the Winner!");
            Command.getPlayPlayers2().removePlayer(Command.getPlayPlayers2().getListOfPlayers().get(0));
            Configuration.getDataConfig().set("is.On2",false);
            Configuration.saveDataConfig();
        }
        //ARENA 3
        if(location.getBlock().getType().equals(Material.BEDROCK) && Command.getPlayPlayers3().isPlayerOnList(player)
                && Configuration.getDataConfig().getBoolean("is.On3")
                ){
            player.teleport(Command.getPlayPlayers3().getPrevCoords(player));
            Command.getPlayPlayers3().removePlayer(player);
            player.sendMessage("You are out of the game!");
            Bukkit.broadcastMessage(player.getName() + " is out of the game!");
        }
        if(Command.getPlayPlayers3().getListOfPlayers().size()==1 && Configuration.getDataConfig().getBoolean("is.On3")){
            Bukkit.broadcastMessage(ChatColor.GOLD + Command.getPlayPlayers3().getListOfPlayers().get(0).getName() + ChatColor.GREEN +" is the Winner!");
            Command.getPlayPlayers3().removePlayer(Command.getPlayPlayers3().getListOfPlayers().get(0));
            Configuration.getDataConfig().set("is.On3",false);
            Configuration.saveDataConfig();
        }
        //ARENA 1

*/


    }
}
