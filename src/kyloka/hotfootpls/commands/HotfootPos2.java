package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.arena.Arena;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

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

            List<Arena> same = new ArrayList<>();
            same.add(kyloka.hotfootpls.commands.Command.getArena0());
            same.add(kyloka.hotfootpls.commands.Command.getArena1());
            same.add(kyloka.hotfootpls.commands.Command.getArena2());
            same.add(kyloka.hotfootpls.commands.Command.getArena3());

            Player player = (Player)sender;
            for(int i = 0; i<4;i++){
                if(args[0].equalsIgnoreCase(same.get(i).getName())){
                    Location loc = player.getLocation();

                    double x = loc.getX();
                    double y = loc.getY()-1;
                    loc.setY(y);
                    double z = loc.getZ();

                    player.sendMessage("You have selected " + x +","+y+","+z+" for Position 2 Arena " + same.get(i).getName());
                    same.get(i).setLocation2(loc);
                }
            }

        }
        return false;
    }
}
