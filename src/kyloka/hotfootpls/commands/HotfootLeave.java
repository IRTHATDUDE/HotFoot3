package kyloka.hotfootpls.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/3/2016.
 */
public class HotfootLeave implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hfleave")){
            if(!(sender instanceof Player))sender.sendMessage(ChatColor.RED + "Cannot execute command in console");
            Player player = (Player) sender;
            try{
                player.teleport(kyloka.hotfootpls.commands.Command.players.getPrevCoords(player));
                kyloka.hotfootpls.commands.Command.players.removePlayer(player);

                player.sendMessage(ChatColor.GREEN + "You have left hotfoot!");
            }catch (Exception e){
                player.sendMessage(ChatColor.RED + "You are not in game!");
            }

        }
        return false;
    }
}
