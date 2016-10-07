package kyloka.hotfootpls;

import kyloka.hotfootpls.commands.Command;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.events.Events;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Main extends JavaPlugin {
    static Main instance;
    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        Configuration.loadAllConfigs();
        Command.registerCommands();
        Events.registerEvents();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
    public static Main getInstance(){
        return instance;
    }
}
