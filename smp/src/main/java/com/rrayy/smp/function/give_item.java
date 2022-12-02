package com.rrayy.smp.function;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class give_item {
    public CommandSender sender;
    Player[] item_Player;
    public void getsender(CommandSender s){
        sender = s;
        item_Player[0] = (Player) sender;
    }
    public void armorer(){
        Player player = (Player)sender; //명령어 사용자 객체를 플레이어 객체로 변환할 수 있음
        sender.sendMessage(ChatColor.GREEN + "기본지급 아이템을 '아머러' 로 정하셨습니다. 바꿀 수 없습니다.");
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta meta = chestplate.getItemMeta();
        chestplate.setItemMeta(meta);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        chestplate.addEnchantment(Enchantment.THORNS, 1);
        player.getInventory().addItem(helmet, chestplate);  //플레이어의 인벤토리를 가져와 아이템을 집어넣음
    }
    public void wooder(){
        Player player = (Player)sender; //명령어 사용자 객체를 플레이어 객체로 변환할 수 있음
        sender.sendMessage(ChatColor.GREEN + "기본지급 아이템을 '벌목꾼' 로 정하셨습니다. 바꿀 수 없습니다.");
        ItemStack axe = new ItemStack(Material.IRON_AXE);
        ItemMeta meta = axe.getItemMeta();
        axe.setItemMeta(meta);
        axe.addEnchantment(Enchantment.DIG_SPEED, 1);
        axe.addEnchantment(Enchantment.DURABILITY, 1);
        player.getInventory().addItem(axe);
    }
    public void enchanter(){
        Player player = (Player)sender; //명령어 사용자 객체를 플레이어 객체로 변환할 수 있음
        sender.sendMessage(ChatColor.GREEN + "기본지급 아이템을 '인첸터' 로 정하셨습니다. 바꿀 수 없습니다.");
        ItemStack anvil = new ItemStack(Material.DAMAGED_ANVIL);
        ItemStack enchant1 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemStack enchant2 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemStack book = new ItemStack(Material.BOOK);
        ItemMeta encht1 = enchant1.getItemMeta();
        enchant1.setItemMeta(encht1);
        enchant1.addEnchantment(Enchantment.MENDING, 1);
        enchant1.addEnchantment(Enchantment.VANISHING_CURSE, 1);
        ItemMeta encht2 = enchant2.getItemMeta();
        enchant2.setItemMeta(encht2);
        enchant2.addEnchantment(Enchantment.DURABILITY, 2);
        enchant2.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        enchant2.addEnchantment(Enchantment.DAMAGE_ALL, 4);
        book.setAmount(5);
        player.getInventory().addItem(anvil, enchant1, enchant2, book);  //플레이어의 인벤토리를 가져와 아이템을 집어넣음
    }
    public void moneyman(){
        Player player = (Player)sender; //명령어 사용자 객체를 플레이어 객체로 변환할 수 있음
        player.sendMessage(ChatColor.GREEN + "기본지급 아이템을 '갑부' 로 정하셨습니다. 바꿀 수 없습니다.");
        ItemStack irons = new ItemStack(Material.IRON_INGOT);
        ItemStack golds = new ItemStack(Material.GOLD_INGOT);
        ItemStack diamonds = new ItemStack(Material.DIAMOND);   //Itemstrack 객체에 저장
        irons.setAmount(15);
        golds.setAmount(10);
        diamonds.setAmount(1);  //아이템들의 갯수를 정함
        player.getInventory().addItem(irons, golds, diamonds);  //플레이어의 인벤토리를 가져와 아이템을 집어넣음
    }
    public boolean item_true(){
        boolean r = true;
        for(Player str : item_Player) {
            if(str.equals((Player)sender)) {
                r = false;
            }else{
                r = true;
            }
        }
        return r;
    }
}
