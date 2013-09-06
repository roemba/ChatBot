/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import org.bukkit.Location;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Roemer Hendrikx
 */
public class ProjectileThread extends BukkitRunnable {
    
    PlayerInteractEvent event;
    
    public ProjectileThread(PlayerInteractEvent event){
        this.event = event;
    }
    
    
    @Override
    public void run(){
                       
                        Player player = this.event.getPlayer();
            
                        //Spawnt net voor de player
                        Location proj = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
                        Snowball snow = player.getWorld().spawn(proj, Snowball.class);
            
                        snow.setShooter(player);
                        snow.setVelocity(player.getEyeLocation().getDirection().multiply(2));
                
                        while(true){
                            if (snow.isDead()){
                                Explosive exp = player.getWorld().spawn(snow.getLocation(), Explosive.class);
                                exp.setIsIncendiary(true);
                                exp.setYield(20);
                                break;
                            }
                        }
        
    }
    
    
    
}
