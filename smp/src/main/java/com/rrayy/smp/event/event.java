package com.rrayy.smp.event;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class event implements Listener{
    @EventHandler
    public void onJoin(PlayerJoinEvent pe) {     //플레이어가 게임에 접속했을 때
        Player pl = pe.getPlayer();
		pe.setJoinMessage(ChatColor.AQUA+"플레이어 "+ChatColor.GREEN+ pl.getDisplayName() +ChatColor.AQUA +" 님께서"+ChatColor.GREEN +" 라이 SMP"+ChatColor.AQUA +" 에 입장했습니다!");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {   //플레이어가 상호작용을 할 때 실행
        Player player = e.getPlayer();  //상호작용 한 플레이어
        Action action = e.getAction();  //플레이어가 한 상호작용
        ItemStack item = e.getItem();   //플레이어가 상호작용할 때 손에 들고 있던 아이템
        if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {    //플레이어가 좌클릭을 눌렀을 때
            if(item != null && item.getType() == Material.COMPASS) { //플레이어가 나침반을 들었다면
                System.out.println(player.getName()+"가 나침반을 눌렀따!");
            }
        }
    }
}
