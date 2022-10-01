package com.rrayy.smp.function;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class cleaner{
    public int count = 0;
	public void mob_clear() {
        boolean whiles = false;
        if (whiles) {
            try {
                for(Player alper : Bukkit.getOnlinePlayers()) {
                    alper.sendMessage(ChatColor.GREEN+"2분 후, 모든 몹이 사라집니다");
                }
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException error) {
                // TODO Auto-generated catch block
                error.printStackTrace();
            }
            whiles = true;
            mob_clear();
        }else{
            remove();
            for(Player alper : Bukkit.getOnlinePlayers()) {
                alper.sendMessage(ChatColor.GREEN+"몹"+ChatColor.GOLD + Integer.toString(count)+ChatColor.GREEN+" 마리가 삭제되었습니다.");
            }
        }
        
    }

    public void remove(){
        final List<World> worlds = (List<World>)Bukkit.getServer().getWorlds();
        final int wdsize = worlds.size() - 1;
        final World[] world = worlds.toArray(new World[wdsize]);
        for (int i = 0; i <= wdsize; ++i) {
            for (final Entity e : world[i].getEntities()) {
                if (e instanceof LivingEntity) {
                    count = count + 1;
                    e.remove();
                }
            }
        }
    }
}
