package kyloka.hotfootpls.commands;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import kyloka.hotfootpls.config.Configuration;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/4/2016.
 */
public class HotfootTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hftest")){
            if(!(sender instanceof Player)){
                sender.sendMessage("You need to be a player to activate this command");
                return false;
            }
            Player player = (Player) sender;
            player.sendMessage("bleh");


        }
        return false;
    }
}
