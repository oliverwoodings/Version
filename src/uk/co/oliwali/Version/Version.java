package uk.co.oliwali.Version;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.oliwali.Version.Permission;
import uk.co.oliwali.Version.Util;

public class Version extends JavaPlugin {
	
	public String name;
	public String version;
	private VersionPlayerListener listener;
	
	public void onDisable() {
		Util.info("Version " + version + " disabled!");
	}
	
	public void onEnable() {

		//Set up data and permissions
		name = this.getDescription().getName();
        version = this.getDescription().getVersion();
        new Permission(this);
        listener = new VersionPlayerListener(this);
        getServer().getPluginManager().registerEvent(Type.PLAYER_COMMAND_PREPROCESS, listener, Priority.Highest, this);
        
        Util.info("Version " + version + " enabled!");
        
	}

}
