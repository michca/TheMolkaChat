package pl.TheMolka.TheMolkaChat;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TheMolkaChat extends JavaPlugin implements Listener {

	/**
	 * 
	 * @author TheMolkaPL
	 * 
	 */
	
	@Override
	public void onEnable() {
		saveDefaultConfig();		
		getServer().getPluginManager().registerEvents(new pl.TheMolka.TheMolkaChat.listener.CurseListener (this), this);

		System.out.println("========================================");
		System.out.println(" ");
		System.out.println(this.getName() + " version " + this.getDescription().getVersion() + " has been enabled!");
		System.out.println(" ");		
		System.out.println("========================================");
		
		saveDefaultConfig();
	}
}
