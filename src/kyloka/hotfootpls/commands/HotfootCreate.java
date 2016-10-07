package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/3/2016.
 */
public class HotfootCreate implements CommandExecutor {
    Location loc1;
    Location loc2;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hfcreate")){
            if(args.length==0){
                sender.sendMessage(ChatColor.RED + "Please have a name for the region that is going to be created!");
                return false;
            }
            else{
                Player player = (Player) sender;
                player.sendMessage(ChatColor.GREEN + "You have sucessfully created "+ args[0] + ". To make the arena, do /hfpos1 or /hfpos2 "+ args[0]+ "");
            }



        }
        return false;
    }

}
