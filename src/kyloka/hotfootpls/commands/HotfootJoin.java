package kyloka.hotfootpls.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/3/2016.
 */
public class HotfootJoin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hfjoin")){
            if(!(sender instanceof Player))sender.sendMessage(ChatColor.RED + "Cannot execute command in console");
            Player player = (Player) sender;
            if(args.length==0){
                player.sendMessage("You need to select a arena first!");
                return false;
            }
            if(args.length==1){
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
            }

        }
        return false;
    }
}
