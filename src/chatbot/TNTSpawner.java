/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;


/**
 *
 * @author Roemer Hendrikx
 */
public class TNTSpawner{
    
    public Integer timerid;
    
    public TNTSpawner(){
        
    }
    
    public void TNT_Timer(){
        timerid = Bukkit.getScheduler().scheduleSyncRepeatingTask(ChatBot.chatbot, new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    if (p.getItemInHand().getType().equals(Material.TNT)){
                        World world = Bukkit.getServer().getWorld("world");
                        world.spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
                    }
                }
            }
        }, 0L, 20L);
    }
    
}
