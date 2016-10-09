package kyloka.hotfootpls.events;


        import kyloka.hotfootpls.Main;
        import kyloka.hotfootpls.commands.Command;
        import kyloka.hotfootpls.config.Configuration;
        import org.bukkit.Bukkit;
        import org.bukkit.Location;
        import org.bukkit.Material;
        import org.bukkit.World;
        import org.bukkit.block.Block;
        import org.bukkit.configuration.file.YamlConfiguration;
        import org.bukkit.entity.Player;
        import org.bukkit.event.EventHandler;
        import org.bukkit.event.Listener;
        import org.bukkit.event.player.PlayerMoveEvent;

        import java.util.ArrayList;
        import java.util.List;
/**
 * Created by Matthew on 10/8/2016.
 */
public class RemoveBlockUnderPlayerEvent implements Listener {

    @EventHandler
    public void replaceBlockBelowPlayer(PlayerMoveEvent e){
        Player player = e.getPlayer();
        YamlConfiguration dataConfig =  Configuration.getDataConfig();
        Location from = player.getLocation();

        if(!Command.getPlayPlayers0().isPlayerOnList(player)){

            return;
        }

        World world = player.getWorld();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        //if (world.getBlockAt(new Location(world,x,y-1,z)).getType() == Material.WOOL){
        World loc1World,loc2World;

        int pos1x,pos1y,pos1z,pos2x,pos2y,pos2z,length,width,area;
        List<Block> blockArray = new ArrayList<Block>();
        Location loc1= Command.getArena0().getLocation1();
        Location loc2 = Command.getArena0().getLocation2();
        loc1World = loc1.getWorld();
        loc2World = loc2.getWorld();
        pos1x = (int)loc1.getX();
        pos1y = (int)loc1.getY();
        pos1z = (int)loc1.getZ();
        pos2x = (int)loc2.getX();
        pos2y = (int)loc2.getY();
        pos2z = (int)loc2.getZ();
        double lessX,moreX,lessZ,moreZ;

        if (pos1x > pos2x){
            lessX = (double)pos2x;
            moreX = (double)pos1x;
        }
        else{
            lessX =(double)pos1x;
            moreX = (double)pos2x;
        }
        if (pos1z > pos2z){
            lessZ = (double)pos2z;
            moreZ = (double)pos1z;
        }
        else{
            lessZ =(double)pos1z;
            moreZ = (double)pos2z;
        }

        if(dataConfig.getBoolean("is.On0")){

            if(x>=lessX){

                if(x<=moreX){

                    if(z>=lessZ){

                        if (z <= moreZ){

                            if(y==pos1y+1){


                                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                                    @Override
                                    public void run() {

                                        world.getBlockAt(new Location(world, x,y-1,z)).setType(Material.AIR);
                                    }
                                },20);
                            }
                        }
                    }
                }
            }

            //}


        }



        //}





    }

}
