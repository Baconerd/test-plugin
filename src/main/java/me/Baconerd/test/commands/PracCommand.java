package me.Baconerd.test.commands;

import me.Baconerd.test.utils.Utils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PracCommand implements CommandExecutor
{
    public static Map<Player, Location> inPrac = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(Utils.chat("&cConsole not allowed"));
            return true;
        }
        Player p = (Player) sender;

        if (! ((Entity) p).isOnGround())
        {
            sender.sendMessage(Utils.chat("&cYou must be on the ground"));
            return true;
        }
        if (inPrac.containsKey(p))
        {
            sender.sendMessage(Utils.chat("&cYou have stopped practicing"));
            p.teleport(inPrac.get(p));
            inPrac.remove(p);
            p.getInventory().removeItem(Utils.getPracItem());
            p.getInventory().removeItem(Utils.getPracItem());
        }
        else
        {
            sender.sendMessage(Utils.chat("&cYou are now practicing"));
            inPrac.put(p, p.getLocation().clone());
            p.getInventory().addItem(Utils.getPracItem());
        }
        return true;
    }
}
