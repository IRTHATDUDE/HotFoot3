package kyloka.hotfootpls.events;

import kyloka.hotfootpls.Main;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Events {
    public static void registerEvents(){
        PluginManager pm = Main.getInstance().getServer().getPluginManager();
        pm.registerEvents(new RemovePlayerEvent(),Main.getInstance());
    }
}
