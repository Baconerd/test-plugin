package me.Baconerd.test.listeners;

import me.Baconerd.test.commands.PracCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerOnQuitListener implements Listener
{
    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
        if (new PracCommand().inPrac.containsKey(e.getPlayer()))
        {
            Bukkit.dispatchCommand(e.getPlayer(), "prac");

        }
    }
}
