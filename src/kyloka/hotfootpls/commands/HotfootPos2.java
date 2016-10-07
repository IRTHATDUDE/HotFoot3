package kyloka.hotfootpls.commands;

import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 10/4/2016.
 */
public class HotfootPos2 implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hfpos2")){
            if(!(sender instanceof Player)){
                sender.sendMessage("You cannot execute this command on console");
                return false;
            }
            if(args.length==0){
                sender.sendMessage("You need to have a name for the position you are marking");
            }

        }
        return false;
    }
}
