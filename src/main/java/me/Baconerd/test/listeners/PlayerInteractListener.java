package me.Baconerd.test.listeners;

import me.Baconerd.test.commands.PracCommand;
import me.Baconerd.test.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener
{
    @EventHandler
    public void onClick(PlayerInteractEvent e)
    {
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK)
        {
            return;
        }

        if (e.getItem() == null)
        {
            return;
        }

        if (e.getItem().isSimilar(Utils.getPracItem()))
        {
            if (!(new PracCommand().inPrac.containsKey(e.getPlayer())))
            {
                return;
            }
            e.getPlayer().teleport(new PracCommand().inPrac.get(e.getPlayer()));
        }
    }
}
