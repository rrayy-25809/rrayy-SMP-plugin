package com.rrayy.smp.event;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.rrayy.smp.function.give_item;

public class givecommand  implements CommandExecutor {   //명령어 처리 클래스는 CommandExecutor 인터페이스를 상속해야 한다.
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        give_item gt = new give_item();
        gt.getsender(sender);
        boolean getit = gt.gt();
        if(getit) {
            sender.sendMessage(ChatColor.GREEN + "이미 기본지급 아이템을 받으셨습니다. 바꿀 수 없습니다.");
        } else if (args.length > 0) {
            if (args[0].equals("어머러")) {
                gt.armorer();
            }else if (args[0].equals("벌목꾼")) {
                gt.wooder();
            }else if (args[0].equals("인첸터")) {
                gt.enchanter();
            }else if (args[0].equals("갑부")) {
                gt.money();
            } else {
                return false;
            }
        }
        return true;
    }
}
