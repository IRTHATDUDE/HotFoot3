package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.config.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.command.Command;

/**
 * Created by Matthew on 10/7/2016.
 */
public class HotfootStop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("hfstop")){
            Bukkit.broadcastMessage("Hotfoot stop!");
            Configuration.getDataConfig().set("is.On0",false);
            Configuration.getDataConfig().set("is.On1",false);
            Configuration.getDataConfig().set("is.On2",false);
            Configuration.getDataConfig().set("is.On3",false);
            Configuration.saveDataConfig();
        }
        return false;
    }
}
