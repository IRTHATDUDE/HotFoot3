package kyloka.hotfootpls.config;

import kyloka.hotfootpls.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by Matthew on 10/3/2016.
 */
public class Configuration {
    static File pluginFolder;
    static File configFile;
    static File playerDataFile;
    static File dataFile;

    static File indivFile;
    static YamlConfiguration indivConfig;
    static YamlConfiguration configConfig;
    static YamlConfiguration playerDataConfig;
    static YamlConfiguration dataConfig;
    public static void loadAllConfigs(){
        pluginFolder = Main.getInstance().getDataFolder();
        configFile = new File(pluginFolder, "config.yml");
        playerDataFile = new File(pluginFolder,"playerData.yml");
        dataFile = new File(pluginFolder,"data.yml");
        configConfig = new YamlConfiguration();
        playerDataConfig = new YamlConfiguration();
        dataConfig = new YamlConfiguration();
        try{
            if(!configFile.exists()){
                if (!pluginFolder.exists()){
                    pluginFolder.mkdir();
                }

                configFile.createNewFile();
                configConfig.load(configFile);
            }
            if(!playerDataFile.exists()){
                playerDataFile.createNewFile();
                playerDataConfig.load(playerDataFile);
            }
            if(!dataFile.exists()){
                dataFile.createNewFile();
                dataConfig.load(dataFile);
            }

            configConfig.load(configFile);
            playerDataConfig.load(playerDataFile);
            dataConfig.load(dataFile);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static YamlConfiguration getPlayerDataConfig(){
        try{
            playerDataConfig.load(configFile);
        }catch(Exception e){
            e.printStackTrace();
        }


        return playerDataConfig;
    }
    public static void savePlayerDataConfig(){
        try{
            playerDataConfig.save(playerDataFile);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static YamlConfiguration getDataConfig(){
        try{
            dataConfig.load(dataFile);
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return dataConfig;
    }
    public static void saveDataConfig(){
        try{
            dataConfig.save(dataFile);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
