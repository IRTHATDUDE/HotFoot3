package kyloka.hotfootpls.arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Arena {

    String n;
    Location loca1;
    Location loca2;
    String world1;
    String world2;
    double loca1X;
    double loca1Y;
    double loca1Z;
    double loca2X;
    double loca2Y;
    double loca2Z;
    List<Block> blockArray;
    YamlConfiguration dataConfig = kyloka.hotfootpls.config.Configuration.getDataConfig();

    public Arena(String name){
        n = name;
    }
    public void setLocation1(Location loc1){
        loca1 = loc1;
        loca1X = loca1.getX();
        loca1Y = loca1.getBlockY();
        loca1Z = loca1.getZ();
        world1 = loc1.getWorld().getName();
        dataConfig.set(n+".pos1.x",loca1X);
        dataConfig.set(n+".pos1.y",loca1Y);
        dataConfig.set(n+".pos1.z",loca1Z);
        dataConfig.set(n+".pos1.world",world1);
        kyloka.hotfootpls.config.Configuration.saveDataConfig();

    }
    public void setLocation2(Location loc2){
        loca2 = loc2;
        loca2X = loca2.getX();
        loca2Y = loca2.getBlockY();
        loca2Z = loca2.getZ();
        world2 = loca2.getWorld().getName();
        dataConfig.set(n+".pos2.x",loca2X);
        dataConfig.set(n+".pos2.y",loca2Y);
        dataConfig.set(n+".pos2.z",loca2Z);
        dataConfig.set(n+".pos2.world",world2);
        kyloka.hotfootpls.config.Configuration.saveDataConfig();
    }
    public String getName(){
        if(n==null)return null;
        return n;
    }
    public Boolean isAble(){
        if(loca1== null||loca2 == null){
            return false;
        }
        return true;
    }
    public List<Block> getBlockArray() {
        Location placeholderLoc;
        double lessX, moreX, lessZ, moreZ;
        if (loca1X > loca2X) {
            lessX = loca2X;
            moreX = loca1X;
        } else {
            lessX = loca1X;
            moreX = loca2X;
        }
        if (loca1Z > loca2Z) {
            lessZ = loca2Z;
            moreZ =  loca1Z;
        } else {
            lessZ = loca1Z;
            moreZ = loca2Z;
        }
        double length = (int) (moreX - lessX);
        double width = (int) (moreX - lessX);

        World loc1World = Bukkit.getWorld(world1);
        double area = Math.abs(length * width);
        for (int li = 0; li < length; li++) {
            for (int wi = 0; wi < width; wi++) {
                placeholderLoc = new Location(loc1World, lessX + li, loca1Y, lessZ + wi);
                Block placeholderBlock = loc1World.getBlockAt(placeholderLoc);
                blockArray.add(placeholderBlock);
            }
        }
        return blockArray;
    }








    public Location getLocation1(){
        return loca1;
    }
    public Location getLocation2(){
        return loca2;
    }
}
