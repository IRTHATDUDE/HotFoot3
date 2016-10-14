package kyloka.hotfootpls.config;

import kyloka.hotfootpls.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

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
                setPlayerDataConfig();
            }

            configConfig.load(configFile);
            playerDataConfig.load(playerDataFile);
            dataConfig.load(dataFile);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void setPlayerDataConfig(){
        YamlConfiguration dataConfig = getDataConfig();
        for (int i = 1; i<5;i++){
            dataConfig.set(i+".pos1.x",0);
            dataConfig.set(i+".pos1.y",0);
            dataConfig.set(i+".pos1.z",0);
            dataConfig.set(i+".pos1.world","world");
            dataConfig.set(i+".pos2.x",0);
            dataConfig.set(i+".pos2.y",0);
            dataConfig.set(i+".pos2.z",0);
            dataConfig.set(i+".pos2.world","world");
            saveDataConfig();
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
