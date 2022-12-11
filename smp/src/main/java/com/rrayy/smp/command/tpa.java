package com.rrayy.smp.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tpa implements CommandExecutor {   //명령어 처리 클래스는 CommandExecutor 인터페이스를 상속해야 한다.
    public Player thatPl;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {  
        for(Player thatPlayer : Bukkit.getOnlinePlayers()) {
            if (args[0].equals(thatPlayer.getName())) {
                thatPl = thatPlayer;
                break;
            }
        }
        sender.sendMessage(ChatColor.GREEN+thatPl.getName()+ChatColor.AQUA+ "님께 tpa 요청을 보냈습니다! 수락 시 이동됩니다!");
        return false;
    }
}
