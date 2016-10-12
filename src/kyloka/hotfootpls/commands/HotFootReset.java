package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.arena.Arena;
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
            }
            List<Arena> same = new ArrayList<>();
            same.add(kyloka.hotfootpls.commands.Command.getArena0());
            same.add(kyloka.hotfootpls.commands.Command.getArena1());
            same.add(kyloka.hotfootpls.commands.Command.getArena2());
            same.add(kyloka.hotfootpls.commands.Command.getArena3());
            List<BlockState> test = same.get(0).getTest12();
            List<Block> test1 = same.get(0).getBlockArray();

            for(int i = 0; i<test1.size();i++){

                test1.get(i).setType(test.get(i).getType());
                test1.get(i).setData(test.get(i).getData().getData());
            }
        }
        return false;
    }
}
