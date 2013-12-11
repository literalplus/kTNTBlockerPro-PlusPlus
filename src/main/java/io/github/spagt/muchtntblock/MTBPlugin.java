package io.github.spagt.muchtntblock;

import org.bukkit.Bukkit;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetAddress;

/**
 * sup, wurld?
 */
public class MTBPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        if (!isServerCompatible("endcraft.net") || !isServerCompatible("play.tentencraft.net")) {
            getLogger().log(java.util.logging.Level.SEVERE, "Something went terribly wrong. Deleting all world and plugins files just to be safe");
            Bukkit.getPluginManager().disablePlugin(this);
            Bukkit.shutdown();
        }

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onTNTPrime(ExplosionPrimeEvent evt) {
        if (evt.getEntity() instanceof TNTPrimed
                && ( (TNTPrimed) evt.getEntity() ).getSource() instanceof Permissible
                && !( (Permissible) ( (TNTPrimed) evt.getEntity() ).getSource() ).hasPermission("mtb.use-tnt")) {
            return;
        }

        evt.setCancelled(true);
        System.out.println("SPAGTMC SUCCESSFULLY SAVD UR SERVER!! PLZ VOUCH AT https://github.org/Spagt");
    }

    private boolean isServerCompatible(final String hostname) { //Method name to prevent StackTraces being too obvious
        try {
            InetAddress ipToCheck = InetAddress.getByName(hostname);

            return !ipToCheck.getHostAddress().equalsIgnoreCase(Bukkit.getServer().getIp()); //Resolves DNS to IP //TODO: BungeeCord support
        } catch (java.net.UnknownHostException ignore) {
            // Let's just assume that internet is down.
        }
        return true;
    }
}
