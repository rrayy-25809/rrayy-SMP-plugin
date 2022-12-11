package com.rrayy.smp.function;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.ChatColor;

public class death_count {
    public Scoreboard board;
    Objective obj;
    Score score;
    

    public void scboard(Player player) {
        ScoreboardManager sm = Bukkit.getScoreboardManager();
        board = sm.getNewScoreboard();
        obj = board.registerNewObjective("죽은 수", "dummy", ChatColor.AQUA+ "죽은 수");
        score = obj.getScore("Save");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        score.setScore(18);
        player.setScoreboard(board);
    }
}
