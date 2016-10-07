package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.config.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Created by Matthew on 10/7/2016.
 */
public class HotfootStart implements CommandExecutor {
    YamlConfiguration dataConfig = Configuration.getDataConfig();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("hfstart")){
            if(args.length == 0){
                commandSender.sendMessage("no");
                return false;
            }
            if (args[0].equalsIgnoreCase("1")){
                dataConfig.set("is.On0",true);
                Bukkit.broadcastMessage("Hotfoot Arena 1 started!");
                Configuration.saveDataConfig();
                return true;

            }
            if (args[0].equalsIgnoreCase("2")){
                dataConfig.set("is.On1",true);
                Bukkit.broadcastMessage("Hotfoot Arena 2 started!");
                Configuration.saveDataConfig();
                return true;

            }
            if (args[0].equalsIgnoreCase("3")){
                dataConfig.set("is.On2",true);
                Bukkit.broadcastMessage("Hotfoot Arena 3 started!");
                Configuration.saveDataConfig();
                return true;

            }
            if (args[0].equalsIgnoreCase("4")){
                dataConfig.set("is.On3",true);
                Bukkit.broadcastMessage("Hotfoot Arena 4 started!");
                Configuration.saveDataConfig();
                return true;

            }

            return true;
        }
        return false;
    }
}
