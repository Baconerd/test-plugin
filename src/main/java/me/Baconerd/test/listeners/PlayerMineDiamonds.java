package me.Baconerd.test.listeners;

import me.Baconerd.test.utils.Utils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerMineDiamonds implements Listener
{
    @EventHandler
    public void onMine(BlockBreakEvent e)
    {
        if(e.getBlock().getType() == Material.DIAMOND_ORE
                && e.getPlayer().getItemInHand().getType() == Material.DIAMOND_PICKAXE)
        {
            e.getPlayer().sendMessage(Utils.chat("&cGG!!!!!!! You got DIAMONDS"));
            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.DONKEY_ANGRY, 1F, 2F);
        }
    }
}
