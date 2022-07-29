package com.rrayy.smp.file_manage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.bukkit.ChatColor;

import com.rrayy.smp.smp;

public class text_manager {
    public static final String get_item_list = null;
    private smp plugin;
    private ObjectOutputStream oos = null;
    String file = this.plugin.getDataFolder() + "data.txt";

    public text_manager(smp plugin) {
        this.plugin = plugin;

    }

    public void save_file(ArrayList<String> data) {
        System.out.println(ChatColor.AQUA+"SMP:Saving..");
        if (oos == null) {
            try {
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(data);// 파일에 ArrayList 저장
                oos.close();
            } catch (Exception ex) {

            }
        } else {
            try {
                oos.writeObject(data);// 파일에 ArrayList 저장
                oos.close();
            } catch (Exception ex) {

            }
        }
        System.out.println(ChatColor.AQUA+"SMP:Complete");

    }

    @SuppressWarnings("unchecked")
    public  ArrayList<String> get_file(ArrayList<String> data) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            data =(ArrayList<String>) ois.readObject();
            ois.close();
        } catch (Exception ex) {

        }
        return data;
    }

    public static String getGetItemList() {
        return get_item_list;
    }

    public smp getPlugin() {
        return plugin;
    }

    public void setPlugin(smp plugin) {
        this.plugin = plugin;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}