package kyloka.hotfootpls.commands;

import kyloka.hotfootpls.Main;
import kyloka.hotfootpls.config.Configuration;
import kyloka.hotfootpls.players.PlayPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.command.Command;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 10/7/2016.
 */
public class HotfootStart implements CommandExecutor {
    YamlConfiguration dataConfig = Configuration.getDataConfig();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("hfstart")){
            if(args.length == 0){
                commandSender.sendMessage("no");
                return false;
            }
            if(!(commandSender instanceof Player)){
                commandSender.sendMessage(ChatColor.RED  + "Cannot execute command in console!");
                return false;
            }
            Player player = (Player) commandSender;
            if(!player.hasPermission("hf.start")){
                return false;
            }
            int test = 0;
            List<PlayPlayer> derp = new ArrayList<>();
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers0());
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers1());
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers2());
            derp.add(kyloka.hotfootpls.commands.Command.getPlayPlayers3());

            for(int i = 0; i<derp.size();i++){
                commandSender.sendMessage(String.valueOf(i+1));
                if (args[0].equalsIgnoreCase(String.valueOf(i+1))&& (!derp.get(i).getListOfPlayers().isEmpty())){

                    final int d = i;
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Bukkit.broadcastMessage(ChatColor.GOLD + "Hotfoot Arena " + (d+1) +" is starting in 3...");
                        }
                    },20);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Bukkit.broadcastMessage(ChatColor.GOLD + "Hotfoot Arena " + (d+1) +" is starting in 2...");
                        }
                    },40);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            Bukkit.broadcastMessage(ChatColor.GOLD + "Hotfoot Arena " + (d+1) +" is starting in 1...");
                        }
                    },60);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            dataConfig.set("is.On"+ d,true);
                            Bukkit.broadcastMessage("Hotfoot Arena" + (d+1) + "started!");
                            Configuration.saveDataConfig();
                        }
                    },80);

                    test+=1;
                    return true;

                }
            }



            if(test==0){
                commandSender.sendMessage(ChatColor.RED + "No player joined the game");
            }



            return true;
        }
        return false;
    }
}
