package me.Baconerd.test.listeners;

import me.Baconerd.test.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItemListener implements Listener
{
    @EventHandler
    public void onDrop(PlayerDropItemEvent e)
    {
        if (e.getItemDrop().getItemStack().isSimilar(Utils.getPracItem()))
        {
            e.setCancelled(true);
        }
    }
}
