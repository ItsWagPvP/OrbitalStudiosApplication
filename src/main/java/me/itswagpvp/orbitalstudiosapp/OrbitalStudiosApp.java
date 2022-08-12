package me.itswagpvp.orbitalstudiosapp;

import me.itswagpvp.orbitalstudiosapp.commands.Explode;
import me.itswagpvp.orbitalstudiosapp.commands.Fire;
import me.itswagpvp.orbitalstudiosapp.commands.Lightning;
import org.bukkit.plugin.java.JavaPlugin;

public final class OrbitalStudiosApp extends JavaPlugin {

    private static OrbitalStudiosApp plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        getCommand("fire").setExecutor(new Fire());
        getCommand("explode").setExecutor(new Explode());
        getCommand("lightning").setExecutor(new Lightning());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static OrbitalStudiosApp getInstance() {
        return plugin;
    }

}
