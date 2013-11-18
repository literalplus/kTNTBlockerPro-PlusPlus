package io.github.spagt.muchtntblock;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * sup, wurld?
 *
 */
public class MTBPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onTNTPrime(ExplosionPrimeEvent evt) {
        evt.setCancelled(true);
        System.out.println("SPAGTMc was here! https://github.org/Spagt");
    }
}
