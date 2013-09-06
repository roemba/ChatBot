/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author Roemer Hendrikx
 */
public class EventHandlers implements Listener {
    
    public static boolean TNT_SpawnBoolean;
    public static Location Player_location;
    public Integer timerid;
    
    @EventHandler
    public void WhiteList(PlayerLoginEvent event){
        if ("roemba".equals(event.getPlayer().getName())){
            event.allow();
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "op roemba");
        } 
        else{
            Bukkit.getServer().broadcastMessage("Kicked " + event.getPlayer().getName() + " because player was not on ChatBot whitelist");
            Bukkit.getServer().getLogger().info("Kicked " + event.getPlayer().getName() + " because player was not on ChatBot whitelist");
            //event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "You're not on the ChatBot whitelist");
        }
    }
    
    @EventHandler
    public void PlayerInteract(PlayerInteractEvent event){
           
        if (event.getPlayer().getItemInHand().getType().equals(Material.BLAZE_ROD)){
            
            Player player = event.getPlayer();
            
            //Spawnt net voor de player
            Location proj = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
            Snowball snow = player.getWorld().spawn(proj, Snowball.class);
            
            snow.setShooter(player);
            snow.setVelocity(player.getEyeLocation().getDirection().multiply(2));
            player.getWorld().playEffect(proj, Effect.SMOKE, 2);
            
            
        }
    }
    
    @EventHandler
    public void ProjectileHit(ProjectileHitEvent event){
        if (event.getEntityType().equals(EntityType.SNOWBALL)){
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4F, true);
            event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
        
    }
    
    
    }
}

