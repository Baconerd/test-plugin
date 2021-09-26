package me.Baconerd.test.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Utils
{
    public static Map<UUID, Double> bank = new HashMap<>();
    public static DecimalFormat df2 = new DecimalFormat("0.##");
    public static String chat(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    public static ItemStack getPracItem()
    {
        ItemStack pracItem = new ItemStack(Material.EMERALD);
        ItemMeta meta = pracItem.getItemMeta();
        meta.setDisplayName(chat("&cPrac Item"));
        pracItem.setItemMeta(meta);
        return pracItem;
    }
}
