package kyloka.hotfootpls.commands;

import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.Formatter;

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
                return false;
            }
            Player player = (Player)sender;
            if(args[0].equalsIgnoreCase(kyloka.hotfootpls.commands.Command.getArena0().getName())){
                Location loc = player.getLocation();
                Formatter fmt = new Formatter();
                // Format 4 decimal places.

                double x = loc.getX();
                double y = loc.getY()-1;
                loc.setY(y);
                double z = loc.getZ();
                player.sendMessage("You have selected " + x +","+y+","+z+" for Position 2 Arena 1");
                kyloka.hotfootpls.commands.Command.getArena0().setLocation2(loc);
            }

        }
        return false;
    }
}
