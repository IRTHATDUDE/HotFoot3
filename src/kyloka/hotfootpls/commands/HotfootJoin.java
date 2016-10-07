package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/3/2016.
 */
public class HotfootJoin implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        List<PlayPlayer> same = new ArrayList<>();
        same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers0());
        same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers1());
        same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers2());
        same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers3());
        if(command.getName().equalsIgnoreCase("hfjoin")){
            if(!(sender instanceof Player))sender.sendMessage(ChatColor.RED + "Cannot execute command in console");
            Player player = (Player) sender;
            if(args.length==0){
                player.sendMessage("You need to select a arena first!");
                return false;
            }
            if(args.length==1){

                for(int i = 0; i < same.size();i++){
                    if(args[0].equalsIgnoreCase(String.valueOf(i+1))){
                        same.get(i).addPlayer(player);
                        same.get(i).setPrevCoords(player,player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(),player.getWorld());
                        player.sendMessage(ChatColor.GREEN + "You have joined Arena " + (i+1) + "!");
                        break;

                    }
                }
                /*
                if(args[0].equalsIgnoreCase("1")){
                    kyloka.hotfootpls.commands.Command.players0.addPlayer(player);
                    kyloka.hotfootpls.commands.Command.players0.setPrevCoords(player,player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(),player.getWorld());
                    player.sendMessage(ChatColor.GREEN + "You have joined Arena 1!");
                }
                if(args[0].equalsIgnoreCase("2")){
                    kyloka.hotfootpls.commands.Command.players1.addPlayer(player);
                    kyloka.hotfootpls.commands.Command.players1.setPrevCoords(player,player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(),player.getWorld());
                    player.sendMessage(ChatColor.GREEN + "You have joined Arena 2!");
                }
                if(args[0].equalsIgnoreCase("3")){
                    kyloka.hotfootpls.commands.Command.players2.addPlayer(player);
                    kyloka.hotfootpls.commands.Command.players2.setPrevCoords(player,player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(),player.getWorld());
                    player.sendMessage(ChatColor.GREEN + "You have joined Arena 3!");
                }
                if(args[0].equalsIgnoreCase("4")){
                    kyloka.hotfootpls.commands.Command.players3.addPlayer(player);
                    kyloka.hotfootpls.commands.Command.players3.setPrevCoords(player,player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(),player.getWorld());
                    player.sendMessage(ChatColor.GREEN + "You have joined Arena 4!");
                }
                */
            }

        }
        return false;
    }
}
