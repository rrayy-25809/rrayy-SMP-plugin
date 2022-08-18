package com.rrayy.smp.cleaner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
//import org.bukkit.plugin.Plugin;

import com.rrayy.smp.smp;

public class cleaner{
    private smp plugin;
    public cleaner(smp plugin) {
        this.plugin = plugin;
    }
	public static int mob_clear(int ckm) throws InterruptedException{
        int hkm = 0;
        while (true) {
            try {
                for(Player alper : Bukkit.getOnlinePlayers()) {
                    alper.sendMessage(ChatColor.GREEN+"2분 후, 모든 몹이 사라집니다");
                }
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            
            final List<World> worlds = (List<World>)Bukkit.getServer().getWorlds();
            final int wdsize = worlds.size() - 1;
            final World[] world = worlds.toArray(new World[wdsize]);
            for (int i = 0; i <= wdsize; ++i) {
                for (final Entity e : world[i].getEntities()) {
                    if (e instanceof LivingEntity) {
                        hkm = hkm + 1;
                        e.remove();
                    }
                }
            }
            ckm = ckm + hkm;
            for(Player alper : Bukkit.getOnlinePlayers()) {
                alper.sendMessage(ChatColor.GREEN+"몹"+ChatColor.GOLD + Integer.toString(hkm)+ChatColor.GREEN+"마리가 삭제되었습니다.");
            }
            return ckm;
        }
    };
        
    
    public smp getPlugin() {
        return plugin;
    }
}
