package kyloka.hotfootpls.arena;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Arena {

    String n;
    Location loca1;
    Location loca2;

    YamlConfiguration dataConfig = kyloka.hotfootpls.config.Configuration.getDataConfig();

    public Arena(String name){
        n = name;
    }
    public void setLocation1(Location loc1){
        loca1 = loc1;
        loca1.setY(loca1.getY()-1);
    }
    public void setLocation2(Location loc2){
        loca2 = loc2;
    }






    public Location getLocation1(){
        return loca1;
    }
    public Location getLocation2(){
        return loca2;
    }
}
