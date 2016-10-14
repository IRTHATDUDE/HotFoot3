package kyloka.hotfootpls;

import kyloka.hotfootpls.commands.Command;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.events.Events;
import kyloka.hotfootpls.events.RemoveBlockRandomly;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Main extends JavaPlugin {
    private static Main instance;
    @Override
    public void onEnable() {

        instance = this;

        Configuration.loadAllConfigs();
        Command.registerCommands();
        Events.registerEvents();
        BukkitTask TaskName = new RemoveBlockRandomly().runTaskTimer(this, 0, 20);


    }


    public static Main getInstance(){
        return instance;
    }
}
