package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.arena.Arena;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/7/2016.
 */
public class HotfootStop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("hfstop")){
            if(args.length == 0){
                sender.sendMessage(ChatColor.RED + "You need to select an arena!");
                return false;
            }
            if(!(sender instanceof Player)){
                sender.sendMessage(ChatColor.RED  + "Cannot execute command in console!");
                return false;
            }
            Player player = (Player) sender;
            if(!player.hasPermission("hf.start")){
                return false;
            }

            List<Arena> derp = new ArrayList<>();
            derp.add(kyloka.hotfootpls.commands.Command.getArena0());
            derp.add(kyloka.hotfootpls.commands.Command.getArena1());
            derp.add(kyloka.hotfootpls.commands.Command.getArena2());
            derp.add(kyloka.hotfootpls.commands.Command.getArena3());
            for(int i = 0; i < derp.size(); i++){
                if(args[0].equals(derp.get(i).getName())){
                    Bukkit.broadcastMessage(ChatColor.GOLD + "Hotfoot Arena " + (i+1) + " has been stopped");
                    Bukkit.broadcast("Hotfoot Arena " + (i+1) + " has been stopped by " + player.getName(),"hf.start");
                    Configuration.getDataConfig().set("is.On"+i,false);
                    Configuration.saveDataConfig();
                }


            }

        }
        return false;
    }
}
