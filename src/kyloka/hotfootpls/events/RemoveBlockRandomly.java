package kyloka.hotfootpls.events;


import kyloka.hotfootpls.Main;
import kyloka.hotfootpls.commands.Command;
import kyloka.hotfootpls.config.Configuration;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.*;
/**
 * Created by Matthew on 10/9/2016.
 */
public class RemoveBlockRandomly {
    static YamlConfiguration dataConfig = Configuration.getDataConfig();
    static int total = 0;

    public static void justDoIt(){

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (dataConfig.getBoolean("is.On0")){
                    World loc1World,loc2World;
                    Bukkit.broadcastMessage("test:1");
                    int pos1x,pos1y,pos1z,pos2x,pos2y,pos2z,length,width,area;
                    List<Block> blockArray = new ArrayList<>();
                    Location loc1 = Command.getArena0().getLocation1();
                    Location loc2 = Command.getArena0().getLocation2();
                    loc1World = loc1.getWorld();
                    loc2World = loc2.getWorld();
                    pos1x = (int)loc1.getX();
                    pos1y = (int)loc1.getY();
                    pos1z = (int)loc1.getZ();
                    pos2x = (int)loc2.getX();
                    pos2y = (int)loc2.getY();
                    pos2z = (int)loc2.getZ();

                    Bukkit.broadcastMessage("test:2");
                    Location placeholderLoc;
                    double lessX,moreX,lessZ,moreZ;
                    if (pos1x > pos2x){
                        lessX = (double)pos2x;
                        moreX = (double)pos1x;
                    }
                    else{
                        lessX =(double)pos1x;
                        moreX = (double)pos2x;
                    }
                    if (pos1z > pos2z){
                        lessZ = (double)pos2z;
                        moreZ = (double)pos1z;
                    }
                    else{
                        lessZ =(double)pos1z;
                        moreZ = (double)pos2z;
                    }
                    length = (int)(moreX-lessX);
                    width = (int)(moreZ-lessZ);


                    area = Math.abs(length * width);
                    double x;
                    double y;
                    double z;

                    Bukkit.broadcastMessage("test:3");

                    for (int li = 0; li < length; li++){
                        for(int wi = 0; wi < width; wi++){

                            placeholderLoc = new Location(loc1World,lessX + li,pos1y,lessZ + wi);
                            Block placeholderBlock = loc1World.getBlockAt(placeholderLoc);
                            blockArray.add(placeholderBlock);

                        }

                    }
                    Bukkit.broadcastMessage("test:4");
                    Random rng = new Random();


                    Bukkit.broadcastMessage("test:5");
                    for(int i = 0; i<3; i++){
                        RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                    }

                    if (total >= (area*0.25) && total <= (area*0.5)){
                        for(int i = 0; i<5; i++){
                            RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                        }
                    }
                    if (total>=(area*0.51) && total <= (area*0.75)){
                        for(int i = 0; i<8; i++){
                            RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                        }
                    }
                    if (total <=(area*0.71)&& total <= (area*0.99)){
                        for(int i = 0; i<10; i++){
                            RemoveBlockRandomly.checkBlock(blockArray,rng.nextInt(blockArray.size()));
                        }

                    }
                    Bukkit.broadcastMessage("test:6");
                    if(total == area){
                        dataConfig.set("is.On0",false);
                        Bukkit.broadcastMessage(ChatColor.BLUE + "Hot Foot Lokkin ate all the blocks!!");
                        Configuration.saveDataConfig();
                    }
                    return;



                }
                else {

                    if(dataConfig.getBoolean("data.debug")){
                        Bukkit.broadcastMessage("off");
                    }

                }
            }
        },0,20);
    }
    public static void checkBlock(List<Block> same,int randomNumber){

        int rng = randomNumber;
        if (!(same.get(rng).getType().equals(Material.AIR))){

            same.get(rng).setType(Material.AIR);
            Bukkit.broadcastMessage(same.get(rng).getX() +" " + same.get(rng).getZ());
            total += 1;
        }
    }
}
