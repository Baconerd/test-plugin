package me.Baconerd.test.commands;

import me.Baconerd.test.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.UUID;

public class RemoveCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (args.length != 2)
        {
            sender.sendMessage(Utils.chat("&cMust have two arguments, player and amount to be paid"));
            return true;
        }

        String npName = args[0];
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

        if (!sender.isOp())
        {
            sender.sendMessage(Utils.chat("&cYou do not have sufficient permissions"));
            return true;
        }

        double new_amount = 0.0;
        if (Utils.bank.containsKey(np))
        {
            if (amount <= Utils.bank.get(np))
            {
                new_amount = Utils.bank.get(np) - amount;
                Utils.bank.put(np, new_amount);
            }
            else
            {
                Utils.bank.put(np, 0.0);
            }
        }
        else
        {
            Utils.bank.put(np, 0.0);
        }
        sender.sendMessage(Utils.chat("&c" + npName + "'s balance is now: $" + Utils.df2.format(new_amount)));

        return true;
    }
}