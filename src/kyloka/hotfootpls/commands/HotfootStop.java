package kyloka.hotfootpls.commands;

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
                sender.sendMessage("no");
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
            List<PlayPlayer> derp = new ArrayList<>();
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers0());
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers1());
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers2());
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers3());

            
        }
        return false;
    }
}
