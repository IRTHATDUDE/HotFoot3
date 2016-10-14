package kyloka.hotfootpls.arena;

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

    private String n;
    private Location loca1;
    private Location loca2;
    private List<Block> blockList;
    private YamlConfiguration dataConfig = kyloka.hotfootpls.config.Configuration.getDataConfig();
    private double a;
    private List<BlockState> test12;

    public Arena(String name){
        n = name;
    }
    public void setLocation1(Location loc1){
        loca1 = loc1;
        dataConfig.set(n+".pos1.x",loca1.getX());
        dataConfig.set(n+".pos1.y",loca1.getY());
        dataConfig.set(n+".pos1.z",loca1.getZ());
        dataConfig.set(n+".pos1.world",loca1.getWorld().getName());
        kyloka.hotfootpls.config.Configuration.saveDataConfig();
    }

    public void setLocation2(Location loc2){
        loca2 = loc2;
        dataConfig.set(n+".pos2.x",loca2.getX());
        dataConfig.set(n+".pos2.y",loca2.getY());
        dataConfig.set(n+".pos2.z",loca2.getZ());
        dataConfig.set(n+".pos2.world",loca2.getWorld().getName());
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
    public List<Block> getBlockArray() {
        return blockList;
    }
    public void setBlockArray(){
        Location placeholderLoc;
        List<Block> blockArray = new ArrayList<>();
        List<BlockState> test = new ArrayList<>();

        // Use Math.min to get the smaller of the two - moreX isn't really needed because you can use Math.abs to calculate length and width without
        double lessX = Math.min(loca1.getX(), loca2.getX());
        double lessZ = Math.min(loca1.getZ(), loca2.getZ());


        double length = Math.abs(loca1.getX() - loca2.getX());
        double width = Math.abs(loca1.getZ() - loca2.getZ());  // Bug was here

        World loc1World = loca1.getWorld();
        double area = Math.abs(length * width);
        a = area;
        for (int li = 0; li < length; li++) {
            for (int wi = 0; wi < width; wi++) {
                placeholderLoc = new Location(loc1World, lessX + li, loca1.getY(), lessZ + wi);
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
