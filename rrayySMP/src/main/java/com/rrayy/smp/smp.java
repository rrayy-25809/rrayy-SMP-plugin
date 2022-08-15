package com.rrayy.smp;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.rrayy.smp.file_manage.text_manager;
import com.rrayy.smp.cleaner.cleaner;

public class smp extends JavaPlugin implements Listener {
    @Getter private static smp instance;
    ArrayList<String> get_item_list = new ArrayList<>();
    int c_km;
    int h_km;
    boolean t = true;
    @Override
    public void onEnable() {     //플러그인 활성화 이벤트
        instance = this;
        getLogger().info("SMP on");
        get_item_list = text_list();
        cleaner.mob_clear(3);
    }

    @Override
    public void onDisable(){    //플러그인 비활성화 이벤트
        System.out.println("플러그인이 종료됩니다.");
        text_manager a = new text_manager(null);
        a.save_file(get_item_list);
        getLogger().info(ChatColor.AQUA+"서버가 실행되는 동안"+ChatColor.GOLD + Integer.toString(5)+ChatColor.GREEN+"마리의 엔티티를 삭제하였습니다.");
    }

    @EventHandler
	public void onJoin(PlayerJoinEvent p) {     //플레이어가 게임에 접속했을 때
        ((CommandSender) p).sendMessage("'/지급' 으로 기본 지급템을 받으세요"); //접속한 플레이어에게 명령어 사용법 알려주기
		p.setJoinMessage(ChatColor.AQUA+"플레이어"+ChatColor.GREEN+ p +ChatColor.AQUA +"님께서"+ChatColor.DARK_GREEN +"라이 SMP"+ChatColor.AQUA +"에 입장했습니다!");
	}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("지급")) {

            if(t) {
                sender.sendMessage(ChatColor.GREEN + "이미 기본지급 아이템을 받으셨습니다. 바꿀 수 없습니다.");
            } else if (args.length > 0) {
                if ("아머러".equalsIgnoreCase(args[0])) {
                    Player player = (Player)sender; //명령어 사용자 객체를 플레이어 객체로 변환할 수 있음
                    sender.sendMessage(ChatColor.GREEN + "기본지급 아이템을 '아머러' 로 정하셨습니다. 바꿀 수 없습니다.");
                    ItemStack helmet = new ItemStack(Material.IRON_HELMET);
                    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
                    ItemMeta meta = chestplate.getItemMeta();
                    chestplate.setItemMeta(meta);
                    chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                    chestplate.addEnchantment(Enchantment.THORNS, 1);
                    player.getInventory().addItem(helmet, chestplate);  //플레이어의 인벤토리를 가져와 아이템을 집어넣음

                }else if ("벌목꾼".equalsIgnoreCase(args[0])) {
                    Player player = (Player)sender; //명령어 사용자 객체를 플레이어 객체로 변환할 수 있음
                    sender.sendMessage(ChatColor.GREEN + "기본지급 아이템을 '벌목꾼' 로 정하셨습니다. 바꿀 수 없습니다.");
                    ItemStack axe = new ItemStack(Material.IRON_AXE);
                    ItemMeta meta = axe.getItemMeta();
                    axe.setItemMeta(meta);
                    axe.addEnchantment(Enchantment.DIG_SPEED, 1);
                    axe.addEnchantment(Enchantment.DURABILITY, 1);
                    player.getInventory().addItem(axe);
                }else if ("인첸터".equalsIgnoreCase(args[0])) {
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
                }else if ("갑부".equalsIgnoreCase(args[0])) {
                    Player player = (Player)sender; //명령어 사용자 객체를 플레이어 객체로 변환할 수 있음
                    player.sendMessage(ChatColor.GREEN + "기본지급 아이템을 '갑부' 로 정하셨습니다. 바꿀 수 없습니다.");
                    ItemStack irons = new ItemStack(Material.IRON_INGOT);
                    ItemStack golds = new ItemStack(Material.GOLD_INGOT);
                    ItemStack diamonds = new ItemStack(Material.DIAMOND);   //Itemstrack 객체에 저장
                    irons.setAmount(15);
                    golds.setAmount(10);
                    diamonds.setAmount(1);  //아이템들의 갯수를 정함
                    player.getInventory().addItem(irons, golds, diamonds);  //플레이어의 인벤토리를 가져와 아이템을 집어넣음
                } else {
                    sender.sendMessage("기본 지급 아이템을 선택합니다.'아머러, 벌목꾼, 인첸터, 갑부'");
                }
            }
        }
        if (label.equalsIgnoreCase("몹제거")) {
            sender.sendMessage(ChatColor.GREEN+"그동안 몹이"+ChatColor.GOLD + Integer.toString(5)+ChatColor.GREEN+"마리가 삭제되었습니다.");
        }
        return false;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {   //플레이어가 상호작용을 할 때 실행
        //Player player = e.getPlayer();  //상호작용한 플레이어
        Action action = e.getAction();  //플레이어가 한 상호작용
        ItemStack item = e.getItem();   //플레이어가 상호작용할 때 손에 들고 있던 아이템
        if(action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {    //플레이어가 좌클릭을 눌렀을 때
            if(item != null) {  //플레이어 손에 무언가 있으면
                switch(item.getType()) {
                    case BOW:   //그 무언가가 활이라면
                        break;
                    default:
                        break;
                }
            }
        }
    }
    public ArrayList<String> text_list(){
        text_manager a = new text_manager(null);
        return a.get_file(get_item_list);
    }
}