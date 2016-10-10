package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.Main;
import kyloka.hotfootpls.arena.Arena;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.events.Editor;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Command {
    static Main instance  = Main.getInstance();
    static PlayPlayer players0 = new PlayPlayer();
    static PlayPlayer players1 = new PlayPlayer();
    static PlayPlayer players2 = new PlayPlayer();
    static PlayPlayer players3 = new PlayPlayer();
    static Editor editor = new Editor();
    static Location loc1;
    static Location loc2;
    static Arena arena0 = new Arena("1");
    static Arena arena1 = new Arena("2");
    static Arena arena2 = new Arena("3");
    static Arena arena3 = new Arena("4");






    public static void registerCommands(){



        instance.getCommand("hfjoin").setExecutor(new HotfootJoin());
        instance.getCommand("hfleave").setExecutor(new HotfootLeave());
        //instance.getCommand("hfcreate").setExecutor(new HotfootCreate());
        instance.getCommand("hfstart").setExecutor(new HotfootStart());
        instance.getCommand("hftest").setExecutor(new HotfootTest());
        instance.getCommand("hfstop").setExecutor(new HotfootStop());
        instance.getCommand("hfpos1").setExecutor(new HotfootPos1());
        instance.getCommand("hfpos2").setExecutor(new HotfootPos2());
        instance.getCommand("hflist").setExecutor(new HotfootList());
        Configuration.getDataConfig().set("is.On0",false);

        Configuration.getDataConfig().set("is.On1",false);

        Configuration.getDataConfig().set("is.On2",false);

        Configuration.getDataConfig().set("is.On3",false);
        Configuration.saveDataConfig();
        registerArena();
    }
    public static void registerArena(){
        YamlConfiguration dataConfig = Configuration.getDataConfig();
        List<Arena> same = new ArrayList<>();
        same.add(kyloka.hotfootpls.commands.Command.getArena0());
        same.add(kyloka.hotfootpls.commands.Command.getArena1());
        same.add(kyloka.hotfootpls.commands.Command.getArena2());
        same.add(kyloka.hotfootpls.commands.Command.getArena3());
        for(int i = 1; i < 5; i++){
            if((!(dataConfig.getInt(i+".pos1.x") == 0))||(!(dataConfig.getInt(i+".pos2.x")==0))){

                double loc1X = dataConfig.getDouble(i+".pos1.x");
                double loc1Y= dataConfig.getDouble(i+".pos1.y");
                double loc1Z= dataConfig.getDouble(i+".pos1.z");
                String loc1World = dataConfig.getString(i+".pos1.world");
                String loc2World = dataConfig.getString(i+".pos1.world");
                double loc2X = dataConfig.getDouble(i+".pos2.x");
                double loc2Y= dataConfig.getDouble(i+".pos2.y");
                double loc2Z= dataConfig.getDouble(i+".pos2.z");
                Location tempLoc1 = new Location(Bukkit.getWorld(loc1World),loc1X,loc1Y,loc1Z);
                Location tempLoc2 = new Location(Bukkit.getWorld(loc2World),loc2X,loc2Y,loc2Z);

                if(!loc1World.equalsIgnoreCase(loc2World)){
                    return;
                }


                same.get(i-1).setLocation1(tempLoc1);
                same.get(i-1).setLocation2(tempLoc2);
            }
        }


    }
    public static PlayPlayer getPlayPlayers0(){
        return players0;
    }
    public static PlayPlayer getPlayPlayers1(){
        return players1;
    }
    public static PlayPlayer getPlayPlayers2(){
        return players2;
    }
    public static PlayPlayer getPlayPlayers3(){
        return players3;
    }

    public static Editor getEditor() {
        return editor;
    }
    public static void setloc1(Location loc){
        loc1 = loc;
    }
    public static void setloc2(Location loc){
        loc2 = loc;
    }
    public Location getloc1(){
        return loc1;
    }
    public Location getLoc2(){
        return loc2;
    }
    public static Arena getArena0(){return arena0;};
    public static Arena getArena1(){return arena1;};
    public static Arena getArena2(){return arena2;};
    public static Arena getArena3(){return arena3;};


}
