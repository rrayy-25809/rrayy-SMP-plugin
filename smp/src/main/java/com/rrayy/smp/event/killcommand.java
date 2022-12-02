package com.rrayy.smp.event;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.rrayy.smp.function.cleaner;

public class killcommand  implements CommandExecutor {   //명령어 처리 클래스는 CommandExecutor 인터페이스를 상속해야 한다.
    cleaner cl = new cleaner();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args[0].equals("제거수")) {
            sender.sendMessage(ChatColor.GREEN+"그동안 몹이"+ChatColor.GOLD + Integer.toString(cl.count)+ChatColor.GREEN+"마리가 삭제되었습니다.");
        }else if (args[0].equals("제거")) {
            cl.remove();
        }else if (args[0].equals("제거시작")) {
            cl.mob_clear();
        }else{
            return false;
        }
        return true;
    }
}
