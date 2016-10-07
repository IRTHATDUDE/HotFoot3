package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.Main;
import kyloka.hotfootpls.arena.Arena;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.events.Editor;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.Location;
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
    static List<Arena> sas = new ArrayList<>();



    public static void registerCommands(){

        instance.getCommand("hfjoin").setExecutor(new HotfootJoin());
        instance.getCommand("hfleave").setExecutor(new HotfootLeave());
        instance.getCommand("hfcreate").setExecutor(new HotfootCreate());
        instance.getCommand("hfstart").setExecutor(new HotfootStart());
        instance.getCommand("hftest").setExecutor(new HotfootTest());
        instance.getCommand("hfstop").setExecutor(new HotfootStop());
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
    public static List<Arena> getSas(){
        return sas;
    }
    public static void return2Default(){
        Configuration.getDataConfig().set("is.On0",false);
        Configuration.getDataConfig().set("is.On1",false);
        Configuration.getDataConfig().set("is.On2",false);
        Configuration.getDataConfig().set("is.On3",false);
        Configuration.saveDataConfig();
    }
}
