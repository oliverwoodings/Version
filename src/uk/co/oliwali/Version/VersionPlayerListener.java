package uk.co.oliwali.Version;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.Plugin;

public class VersionPlayerListener extends PlayerListener {
	
	private Version version;
	
	public VersionPlayerListener(Version instance) {
		version = instance;
	}
	
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if (event.getMessage().split(" ")[0].equalsIgnoreCase("/plugins")) {
			if (Permission.version(player)) {
				List<String> plugins = new ArrayList<String>();
				for (Plugin plugin : version.getServer().getPluginManager().getPlugins())
					plugins.add("&c" + plugin.getDescription().getName() + " v" + plugin.getDescription().getVersion());
				Util.sendMessage(player, "&7Plugins: " + Util.join(plugins, "&7, "));
			}
			event.setCancelled(true);
		}
	}
	

}
