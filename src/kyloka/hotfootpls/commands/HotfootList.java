package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.arena.Arena;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/8/2016.
 */
public class HotfootList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hflist")){
            String test = ChatColor.BLUE +  "The Available Arenas are: 1, 2, 3, 4";
            List<Arena> same = new ArrayList<>();
            same.add(kyloka.hotfootpls.commands.Command.getArena0());
            same.add(kyloka.hotfootpls.commands.Command.getArena1());
            same.add(kyloka.hotfootpls.commands.Command.getArena2());
            same.add(kyloka.hotfootpls.commands.Command.getArena3());


            sender.sendMessage(test);
        }
        return false;
    }
}
