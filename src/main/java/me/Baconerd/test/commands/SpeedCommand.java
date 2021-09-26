package me.Baconerd.test.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Console not allowed");
            return true;
        }

        Player p = (Player) sender;
        float speed;

        if (args.length != 1)
        {
            p.sendMessage(ChatColor.RED + "Must have a number argument");
            return true;
        }

        try
        {
            speed = Float.parseFloat(args[0]);
        }
        catch (NumberFormatException e)
        {
            p.sendMessage(ChatColor.RED + "Must be a number between 1 and 10");
            return true;
        }

        if (speed < 1.0 || speed > 10.0)
        {
            p.sendMessage(ChatColor.RED + "Must be a number between 1 and 10");
            return true;
        }

        if (p.isFlying())
            p.setFlySpeed(speed / 10);
        else
            p.setWalkSpeed(speed / 10);

        p.sendMessage(ChatColor.GREEN + "Your speed has been set to " + speed);

        return true;
    }
}
