package pl.TheMolka.TheMolkaChat.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import pl.TheMolka.TheMolkaChat.TheMolkaChat;

public class CurseListener implements Listener {
	
	/**
	 * 
	 * @author TheMolkaPL
	 * 
	 */
	
	private TheMolkaChat plugin;
	
	public CurseListener(TheMolkaChat theMolkaChat) {
		plugin=theMolkaChat;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		String curse = e.getMessage().toLowerCase();
		String curse_sender = plugin.getConfig().getString("curse.messages.to-sender");
		String curse_admin = plugin.getConfig().getString("curse.messages.to-admin");
		
		for (String curse_word : plugin.getConfig().getStringList("curse.words")) {
			if (!e.getPlayer().isOp()) {
				if (curse.contains(curse_word)) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(ChatColor.GOLD + "[TheMolkaChat] " + ChatColor.RED + curse_sender);
					
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(p.isOp()) {
							curse_admin.replaceAll("{PLAYER}", e.getPlayer().getName());
							p.sendMessage(ChatColor.YELLOW + "* " + curse_admin);							
						}
					}
				}
			}
		}

	}

}
