package me.Baconerd.test.commands;

import me.Baconerd.test.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PayCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage(Utils.chat("&cConsole not allowed"));
            return true;
        }

        UUID p = ((Player) sender).getUniqueId();

        if (args.length != 2)
        {
            sender.sendMessage(Utils.chat("&cMust have two arguments, player and amount to be paid"));
            return true;
        }

        UUID np;
        try
        {
            np = Bukkit.getOfflinePlayer(args[0]).getUniqueId();
        }
        catch (NullPointerException e)
        {
            sender.sendMessage(Utils.chat("&cFirst argument must be that of a player"));
            return true;
        }

        double amount;
        try
        {
            amount = Double.parseDouble(args[1]);
        }
        catch (NumberFormatException e)
        {
            sender.sendMessage(Utils.chat("&cSecond argument must be the amount to be paid"));
            return true;
        }

        if (Utils.bank.containsKey(p))
        {

            if (amount > Utils.bank.get(p))
            {
                sender.sendMessage(Utils.chat("&cYou do not have enough money"));
                return true;
            }

            double new_amount;
            if (Utils.bank.containsKey(np))
            {
                new_amount = amount + Utils.bank.get(np);
                Utils.bank.put(np, new_amount);
            }
            else
            {
                Utils.bank.put(np, amount);
            }
            new_amount = Utils.bank.get(p) - amount;
            Utils.bank.put(p, new_amount);
            sender.sendMessage(Utils.chat("&cYour balance is now: $" + Utils.df2.format(new_amount)));
        }
        else
        {
            Utils.bank.put(p, 0.0);
            sender.sendMessage(Utils.chat("&cYou do not have enough money"));
        }
        return true;
    }
}
