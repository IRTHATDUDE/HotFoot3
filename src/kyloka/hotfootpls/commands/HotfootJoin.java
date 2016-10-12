package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.arena.Arena;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        List<Arena> samex = new ArrayList<>();
        samex.add(kyloka.hotfootpls.commands.Command.getArena0());
        samex.add(kyloka.hotfootpls.commands.Command.getArena1());
        samex.add(kyloka.hotfootpls.commands.Command.getArena2());
        samex.add(kyloka.hotfootpls.commands.Command.getArena3());
        if(command.getName().equalsIgnoreCase("hfjoin")){
            Player player = (Player) sender;
            if(!(sender instanceof Player))sender.sendMessage(ChatColor.RED + "Cannot execute command in console");

            if(args.length==0){
                player.sendMessage("You need to select a arena first!");
                return false;
            }
            if(!player.hasPermission("hf.join")){
                return false;
            }


            if(args.length==1){
                int test=0;
                for(int g = 0; g< same.size();g++){
                    if(same.get(g).getListOfPlayers().indexOf(player)!=-1){
                        same.get(g).getListOfPlayers().remove(g);
                        player.teleport(same.get(g).getPrevCoords(player));
                        player.sendMessage(ChatColor.RED + "You have left Arena " + (g+1));
                    }
                    samex.get(g).setBlockArray();
                }

                for(int i = 0; i < same.size();i++){

                    if(!Configuration.getDataConfig().getBoolean("is.On"+i)){
                        if(args[0].equalsIgnoreCase(String.valueOf(i+1))){
                            List<Block> tempBlock = samex.get(i).getBlockArray();
                            Random rng = new Random();
                            int v = rng.nextInt(tempBlock.size()-1);
                            Location tempLoc = new Location(tempBlock.get(v).getWorld(),tempBlock.get(v).getX(),tempBlock.get(v).getY()+1,tempBlock.get(v).getZ());

                            same.get(i).addPlayer(player);
                            same.get(i).setPrevCoords(player,player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ(),player.getWorld());
                            player.teleport(tempLoc);
                            player.sendMessage(ChatColor.GREEN + "You have joined Arena " + (i+1) + "!");
                            test +=1;
                            Bukkit.broadcast(player.getName() + " has joined Arena " + (i+1)+"!","hf.start" );
                            break;

                        }
                    }

                }
                if(test==0){
                    sender.sendMessage(ChatColor.RED + "You cannot join the game while the game is going on!");
                }
            }

        }
        return false;
    }
}
