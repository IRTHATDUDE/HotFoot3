package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/10/2016.
 */
public class HotFootReset implements CommandExecutor {
    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(command.getName().equalsIgnoreCase("hfreset")){
            if(!(sender instanceof Player)){
                sender.sendMessage("Please dont use this command on console");
                return false;
            }
            if(args.length==0){
                sender.sendMessage(ChatColor.RED + "You must select an arena to reset!");
                return false;
            }
            List<Arena> same = new ArrayList<>();
            same.add(kyloka.hotfootpls.commands.Command.getArena0());
            same.add(kyloka.hotfootpls.commands.Command.getArena1());
            same.add(kyloka.hotfootpls.commands.Command.getArena2());
            same.add(kyloka.hotfootpls.commands.Command.getArena3());
            Bukkit.broadcast(ChatColor.YELLOW + "Arena " + args[0] + "is going to reset!","hf.start");



            for (int i = 0; i < same.size(); i++){
                if(same.get(i).getName().equals(args[0])){
                    List<BlockState> test = same.get(i).getTest12();
                    List<Block> test1 = same.get(i).getBlockArray();
                        for(int g = 0; g<test.size();g++){
                            test1.get(g).setType(test.get(g).getType());
                            test1.get(g).setData(test.get(g).getData().getData());
                        }
                    break;
                }

            }

        }
        return false;
    }
}
