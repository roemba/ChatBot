/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author Roemer Hendrikx
 */
public final class ChatBot extends JavaPlugin {

    //Variables and objects
    public static Plugin chatbot;
    TNTSpawner TNTSpawner = new TNTSpawner();
    
    //What to do when plugin starts
    @Override
    public void onEnable(){
        
        getLogger().info("ChatBot is enabled");
        chatbot = this;
        getServer().getPluginManager().registerEvents(new EventHandlers(),this);
        
        TNTSpawner.TNT_Timer();
    }
    
    //What to do when plugin is disabled
    @Override
    public void onDisable(){
        Bukkit.getScheduler().cancelTask(TNTSpawner.timerid);
        getLogger().info("ChatBot is disabled");
        
    }
    
    //What to do when the plugin receives a command (has to be registered in plugin.yml)
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (cmd.getName().equalsIgnoreCase("Appelflap")){
            sender.sendMessage("Secret appelflap extra is initiated");
            AppelflapBuilder Appelflap = new AppelflapBuilder();
            Appelflap.Appelflap_Builder(sender);
            return true;
        }
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    
}
