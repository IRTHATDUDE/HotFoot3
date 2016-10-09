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
            String test = ChatColor.BLUE +  "The Available Arenas are: ";
            List<Arena> same = new ArrayList<>();
            same.add(kyloka.hotfootpls.commands.Command.getArena0());
            same.add(kyloka.hotfootpls.commands.Command.getArena1());
            same.add(kyloka.hotfootpls.commands.Command.getArena2());
            same.add(kyloka.hotfootpls.commands.Command.getArena3());

                if(kyloka.hotfootpls.commands.Command.getArena0().isAble()){
                    test += same.get(0).getName();
                }
            if(kyloka.hotfootpls.commands.Command.getArena1().isAble()){
                test +=" " + same.get(1).getName();
            }
            if(kyloka.hotfootpls.commands.Command.getArena2().isAble()){
                test += " " + same.get(2).getName();
            }
            if(kyloka.hotfootpls.commands.Command.getArena3().isAble()){
                test += " " + same.get(3).getName();
            }
            sender.sendMessage(test);
        }
        return false;
    }
}
