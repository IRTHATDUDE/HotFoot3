package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/3/2016.
 */
public class HotfootLeave implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hfleave")){
            if(!(sender instanceof Player))sender.sendMessage(ChatColor.RED + "Cannot execute command in console");
            Player player = (Player) sender;

            if(args.length == 0){
                player.sendMessage(ChatColor.RED + "Please specify the arena you are in.");
                return false;
            }

            List<PlayPlayer> same = new ArrayList<>();

            same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers0());
            same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers1());
            same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers2());
            same.add(kyloka.hotfootpls.commands.Command.getPlayPlayers3());

            int f = Integer.parseInt(args[0])-1;
            if(f<0){
                player.sendMessage(ChatColor.RED + "Nah fam try again.");
            }
            try{
                player.teleport(same.get(f).getPrevCoords(player));
                same.get(f).removePlayer(player);

                player.sendMessage(ChatColor.GREEN + "You have left hotfoot!");
            }catch (Exception e){
                player.sendMessage(ChatColor.RED + "You are not in game!");
            }

        }
        return false;
    }
}
