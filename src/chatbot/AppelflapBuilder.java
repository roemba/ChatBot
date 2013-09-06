/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Roemer Hendrikx
 */
public class AppelflapBuilder {
    
    public AppelflapBuilder(){
        
    }
    
    public void Appelflap_Builder(CommandSender sender){
                Bukkit.getServer().getLogger().info("Appelflap-Builder method initiated");
        Player Sender = Bukkit.getServer().getPlayer(sender.getName());
        Block target_block = Sender.getTargetBlock(null, 25);
        Location target_block_location = target_block.getLocation();
        int x = target_block_location.getBlockX();
        int y = target_block_location.getBlockY();
        int z = target_block_location.getBlockZ();
        
                
        final int[][] ala = new int[][]{
            new int[] {x, y+1, z},
            new int[] {x+1, y+1, z},
            new int[] {x+2, y+1, z},
            new int[] {x, y+1, z+1},
            new int[] {x+1, y+1, z+1},
            new int[] {x+2, y+1, z+1},
            new int[] {x, y+1, z+2},
            new int[] {x+1, y+1, z+2},
            new int[] {x+2, y+1, z+2},
            new int[] {x, y+1, z+4},
            new int[] {x+1, y+1, z+4},
            new int[] {x+2, y+1, z+4},
            new int[] {x, y+1, z+5},
            new int[] {x+1, y+1, z+5},
            new int[] {x+2, y+1, z+5},
            new int[] {x, y+1, z+6},
            new int[] {x+1, y+1, z+6},
            new int[] {x+2, y+1, z+6},
            new int[] {x+3, y+1, z+2},
            new int[] {x+4, y+1, z+2},
            new int[] {x+5, y+1, z+2},
            new int[] {x+6, y+1, z+2},
            new int[] {x+7, y+1, z+2},
            new int[] {x+8, y+1, z+2},
            new int[] {x+9, y+1, z+2},
            new int[] {x+10, y+1, z+2},
            new int[] {x+11, y+1, z+2},
            new int[] {x+3, y+1, z+3},
            new int[] {x+4, y+1, z+3},
            new int[] {x+5, y+1, z+3},
            new int[] {x+6, y+1, z+3},
            new int[] {x+7, y+1, z+3},
            new int[] {x+8, y+1, z+3},
            new int[] {x+9, y+1, z+3},
            new int[] {x+10, y+1, z+3},
            new int[] {x+11, y+1, z+3},
            new int[] {x+12, y+1, z+3},
            new int[] {x+13, y+1, z+3},
            new int[] {x+3, y+1, z+4},
            new int[] {x+4, y+1, z+4},
            new int[] {x+5, y+1, z+4},
            new int[] {x+6, y+1, z+4},
            new int[] {x+7, y+1, z+4},
            new int[] {x+8, y+1, z+4},
            new int[] {x+9, y+1, z+4},
            new int[] {x+10, y+1, z+4},
            new int[] {x+11, y+1, z+4},
            new int[] {x+11, y+1, z+4},
        };
         Integer timeride = Bukkit.getScheduler().scheduleSyncDelayedTask(ChatBot.chatbot, new Runnable() {
            @Override
            public void run() {
                            Bukkit.getServer().getLogger().info("Appelflap-Builder loop gestart");
                for (int i = 0;i<ala.length;i++) {
                     for (int j = 0;j<ala[i].length;j++) {
                            Bukkit.getServer().getWorld("world").getBlockAt(ala[i][0], ala[i][1], ala[i][2]).setTypeIdAndData(35, (byte)6, true);
                     }
                }
            }
        });
    }
    
}
