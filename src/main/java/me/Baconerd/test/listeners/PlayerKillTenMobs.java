package me.Baconerd.test.listeners;

import me.Baconerd.test.utils.Utils;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class PlayerKillTenMobs implements Listener
{
    private static Map<Player, Integer> count = new HashMap<>();

    @EventHandler
    public void onKill(EntityDeathEvent e)
    {
        if (e.getEntity().getKiller() == null)
            return;
        Player p = e.getEntity().getKiller();
        if (p != null && e.getEntity() instanceof Creature)
        {
            if (count.containsKey(p))
                count.put(p, count.get(p) + 1);
            else
                count.put(p, 1);
        }
        if (p != null && count.get(p) == 10)
        {
            count.put(p,0);
            p.getInventory().addItem(new ItemStack(Material.DIAMOND));
            p.sendMessage(Utils.chat("&cCongrats on Winning"));
        }
    }
}
