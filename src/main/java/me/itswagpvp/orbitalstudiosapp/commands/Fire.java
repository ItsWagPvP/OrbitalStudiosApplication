package me.itswagpvp.orbitalstudiosapp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fire implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 1) {
            sender.sendMessage("§cInvalid command usage! /fire <player>");
            return true;
        }

        if (!sender.hasPermission("orbital.fire")) {
            sender.sendMessage("§cYou don't have enough permissions!");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null || !target.isOnline()) {
            sender.sendMessage("§cTarget not found!");
            return true;
        }

        target.setFireTicks(60);
        sender.sendMessage("§aYou have fired " + target.getName() + " for 3 seconds!");

        return true;
    }
}
