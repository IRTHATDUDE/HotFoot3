package kyloka.hotfootpls.arena;

import kyloka.hotfootpls.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Arena {

    String n;
    Location loca1,loca2;
    String world1,world2;
    double loca1X,loca1Y,loca1Z;
    double loca2X,loca2Y,loca2Z;

    List<Block> blockList;
    YamlConfiguration dataConfig = kyloka.hotfootpls.config.Configuration.getDataConfig();

    double a;

    List<BlockState> test12;

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
        return n;
    }
    public Boolean isAble(){
        if(loca1== null||loca2 == null){
            return false;
        }
        return true;
    }

    public Boolean isAblexx(){
        if(loca1== null||loca2 == null){
            return false;
        }
        return true;
    }
    public List<Block> getBlockArray() {
        return blockList;
    }
    public void setBlockArray(){
        Location placeholderLoc;
        List<Block> blockArray = new ArrayList<>();
        List<BlockState> test = new ArrayList<>();
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
        double width = (int) (moreZ - lessZ);

        World loc1World = Bukkit.getWorld(world1);
        double area = Math.abs(length * width);
        a = area;
        for (int li = 0; li < length; li++) {
            for (int wi = 0; wi < width; wi++) {
                placeholderLoc = new Location(loc1World, lessX + li, loca1Y, lessZ + wi);
                Block placeholderBlock = loc1World.getBlockAt(placeholderLoc);
                BlockState samed = loc1World.getBlockAt(placeholderLoc).getState();
                blockArray.add(placeholderBlock);
                test.add(samed);
            }
        }
        test12 = test;
        blockList = blockArray;

    }
    public double getArea(){
        return a;
    }
    public List<BlockState> getTest12(){
        return test12;
    }








    public Location getLocation1(){
        return loca1;
    }
    public Location getLocation2(){
        return loca2;
    }
}