package me.itswagpvp.orbitalstudiosapp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Explode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) {
            sender.sendMessage("§cInvalid command usage! /explode <player>");
            return true;
        }

        if (!sender.hasPermission("orbital.explode")) {
            sender.sendMessage("§cYou don't have enough permissions!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null || !target.isOnline()) {
            sender.sendMessage("§cTarget not found!");
            return true;
        }

        Location loc = target.getLocation();
        target.getWorld().createExplosion(loc, 8, false);
        sender.sendMessage("§aYou have exploded " + target.getName() + "!");

        return true;
    }
}
