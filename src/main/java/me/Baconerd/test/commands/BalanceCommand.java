package me.Baconerd.test.commands;

import me.Baconerd.test.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BalanceCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (args.length == 1)
        {
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

            double amount = 0.0;
            if (Utils.bank.containsKey(np))
            {
                amount = Utils.bank.get(np);
            }
            else
            {
                Utils.bank.put(np, 0.0);
            }

            sender.sendMessage(Utils.chat("&c" + npName + "'s balance is: $" + Utils.df2.format(amount)));
            return true;
        }
        else if (args.length != 0)
        {
            sender.sendMessage(Utils.chat("&cMust have zero or one argument (name of player)"));
            return true;

        }
        else if (!(sender instanceof Player))
        {
            sender.sendMessage(Utils.chat("&cConsole must provide name of player"));
            return true;
        }

        UUID p = ((Player) sender).getUniqueId();

        double amount = 0.0;
        if (Utils.bank.containsKey(p))
        {
            amount = Utils.bank.get(p);
        }
        else
        {
            Utils.bank.put(p, 0.0);
        }

        sender.sendMessage(Utils.chat("&cYour balance is: $" + Utils.df2.format(amount)));
        return true;
    }
}
