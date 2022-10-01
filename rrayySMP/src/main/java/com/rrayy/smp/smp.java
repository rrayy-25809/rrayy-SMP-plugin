package com.rrayy.smp;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.rrayy.smp.event.event;
import com.rrayy.smp.event.givecommand;

public class smp extends JavaPlugin{
    @Override
    public void onEnable() {     //플러그인 활성화 이벤트
        getLogger().info("SMP on");
        getServer().getPluginManager().registerEvents(new event(), this);
        getCommand("지급").setExecutor(new givecommand());
    }

    @Override
    public void onDisable(){    //플러그인 비활성화 이벤트
        System.out.println("플러그인이 종료됩니다.");
        getLogger().info(ChatColor.AQUA+"서버가 실행되는 동안"+ChatColor.GOLD + Integer.toString(5)+ChatColor.GREEN+"마리의 엔티티를 삭제하였습니다.");
    }
}