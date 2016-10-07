package kyloka.hotfootpls.events;

import kyloka.hotfootpls.commands.Command;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Matthew on 10/3/2016.
 */
public class CreateSelectionEvent implements Listener {
    double pos1x;
    double pos1y;
    double pos1z;
    double pos2x;
    double pos2y;
    double pos2z;
   /* @EventHandler
    public void createArena(PlayerInteractEvent e){
        Player player = e.getPlayer();
        Action action = e.getAction();

        if (action.equals(Action.LEFT_CLICK_BLOCK)
                && player.getInventory().getItemInMainHand().getType().equals(Material.BONE)&& Command.getEditor().isEditor(e.getPlayer())){
            pos1x = e.getClickedBlock().getX();
            pos1y = e.getClickedBlock().getY();
            pos1z = e.getClickedBlock().getZ();
            player.sendMessage(ChatColor.LIGHT_PURPLE + "Position 1 at " + pos1x + ", " + pos1y + ", " + pos1z);
            Location tempLoc1 = new Location(player.getWorld(),pos1x,pos1y,pos1z);
            Command.setloc1(tempLoc1);
            e.setCancelled(true);

            return;

        }
            if (action.equals(Action.RIGHT_CLICK_BLOCK)&&player.getInventory().getItemInMainHand().getType().equals(Material.BONE)&& Command.getEditor().isEditor(e.getPlayer())){
                pos2x = e.getClickedBlock().getX();
                pos2y = e.getClickedBlock().getY();
                pos2z = e.getClickedBlock().getZ();
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Position 2 at " + pos2x + ", " + pos2y + ", " + pos2z);
                Location tempLoc2 = new Location(player.getWorld(),pos2x,pos2y,pos2z);
                Command.setloc2(tempLoc2);
                e.setCancelled(true);
            }
            if(player.getInventory().getItemInMainHand().getType().equals(Material.BONE)&&pos1y==pos2y&&(Math.signum(pos2x)!=-1 && Math.signum(pos2z)!=-1) &&(Math.signum(pos1x)!=-1 && Math.signum(pos1z)!=-1)&& Command.getEditor().isEditor(e.getPlayer())){
                player.sendMessage("If you are ready to create the arena, do /hfcreate <name>");

            }
        }
        catch(Exception ex){

        }
    }
*/
}
