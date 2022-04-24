package by.quaks.ntmnametaghide;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class main extends JavaPlugin implements Listener {
    public static Scoreboard scoreboard;
    public static Team team;

    @Override
    public void onEnable() {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        team = scoreboard.registerNewTeam("hide_nametag");
        team.setNameTagVisibility(NameTagVisibility.NEVER);
        team.setCanSeeFriendlyInvisibles(false);
        //да
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        apply(e.getPlayer());
    }

    public void apply(Player p) {
        if (team.getPlayers().contains(p)) {
            team.addPlayer(p);
            p.setScoreboard(scoreboard);
        }
    }
}
