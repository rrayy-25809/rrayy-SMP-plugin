package com.rrayy.smp;

import org.bukkit.plugin.java.JavaPlugin;
import com.rrayy.smp.event.event;
import com.rrayy.smp.command.tpa;

public class smp extends JavaPlugin{

    @Override
    public void onEnable() {
        getLogger().info("라이 smp plugin이 활성화 되었습니다");
        getServer().getPluginManager().registerEvents(new event(), this);
        getCommand("tpa").setExecutor(new tpa());
    }
}
