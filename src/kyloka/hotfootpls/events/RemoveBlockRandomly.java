package kyloka.hotfootpls.events;


import kyloka.hotfootpls.Main;
import kyloka.hotfootpls.arena.Arena;
import kyloka.hotfootpls.commands.Command;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.concurrent.RunnableFuture;

/**
 * Created by Matthew on 10/9/2016.
 */
public class RemoveBlockRandomly extends BukkitRunnable {
    static YamlConfiguration dataConfig = Configuration.getDataConfig();
    static int total = 0;

            @Override
            public void run() {


                List<Arena> same = new ArrayList<>();
                same.add(kyloka.hotfootpls.commands.Command.getArena0());
                same.add(kyloka.hotfootpls.commands.Command.getArena1());
                same.add(kyloka.hotfootpls.commands.Command.getArena2());
                same.add(kyloka.hotfootpls.commands.Command.getArena3());

                List<PlayPlayer> same1 = new ArrayList<>();

                same1.add(kyloka.hotfootpls.commands.Command.getPlayPlayers0());
                same1.add(kyloka.hotfootpls.commands.Command.getPlayPlayers1());
                same1.add(kyloka.hotfootpls.commands.Command.getPlayPlayers2());
                same1.add(kyloka.hotfootpls.commands.Command.getPlayPlayers3());

                for(int i = 0; i<same.size();i++){
                    if (dataConfig.getBoolean("is.On"+i)){
                        List<Block> blockArray = same.get(i).getBlockArray();
                        double area = same.get(i).getArea();
                        Random rng = new Random();



                        for(int g = 0; g<3; g++){
                            RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                        }

                        if (total >= (area*0.25) && total <= (area*0.5)){
                            for(int g = 0; g<5; g++){
                                RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                            }
                        }
                        if (total>=(area*0.51) && total <= (area*0.75)){
                            for(int g = 0; g<8; g++){
                                RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                            }
                        }
                        if (total <=(area*0.71)&& total <= (area*0.99)){
                            for(int g = 0; g<10; g++){
                                RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                            }

                        }

                        if(total == area){
                            dataConfig.set("is.On0",false);
                            Bukkit.broadcastMessage(ChatColor.BLUE + "Hot Foot Lokkin ate all the blocks!!");
                            Configuration.saveDataConfig();
                        }
                        return;



                    }
                }



                    if(dataConfig.getBoolean("data.debug")){
                        Bukkit.broadcastMessage("off");
                    }


            }


    public static void checkBlock(List<Block> same,int randomNumber){

        int rng = randomNumber;
        if (!same.get(rng).getType().equals(Material.AIR)){

            same.get(rng).setType(Material.AIR);

            total += 1;
        }
    }
}
