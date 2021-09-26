package me.Baconerd.test;

import me.Baconerd.test.commands.*;
import me.Baconerd.test.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getCommand("gg").setExecutor(new GgCommand());
        getCommand("speed").setExecutor(new SpeedCommand());
        getCommand("prac").setExecutor(new PracCommand());
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("add").setExecutor(new AddCommand());
        getCommand("remove").setExecutor(new RemoveCommand());
        getCommand("set").setExecutor(new SetCommand());
        getCommand("balance").setExecutor(new BalanceCommand());
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItemListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerOnQuitListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerKillTenMobs(), this);
        getServer().getPluginManager().registerEvents(new PlayerMineDiamonds(), this);
    }
}

