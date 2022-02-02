package com.stan.plugin.seedprotect.events;

import com.stan.plugin.seedprotect.SeedProtect;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class onChatEvent implements Listener {

    private final SeedProtect plugin;
    public onChatEvent(SeedProtect plugin) {

        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        Player player = event.getPlayer();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        String message = event.getMessage();
        Long seed = Bukkit.getWorld("world").getSeed();

        if (message.contains(seed.toString())) {

            Bukkit.getScheduler().runTask(plugin, new Runnable() {
                @Override
                public void run() {

                    if (plugin.getCustomConfig().getBoolean("banplayer")) {

                        Bukkit.dispatchCommand(console, "ban " + player.getName() + " " + plugin.getCustomConfig().getString("ban-time"));
                    }

                    if (plugin.getCustomConfig().getBoolean("banipplayer")) {

                        Bukkit.dispatchCommand(console, "banip " + player.getName() + " " + plugin.getCustomConfig().getString("ban-time"));
                    }

                    if (plugin.getCustomConfig().getBoolean("muteplayer")) {

                        Bukkit.dispatchCommand(console, "ban " + player.getName() + " " + plugin.getCustomConfig().getString("mute-time"));
                    }

                    //Bukkit.dispatchCommand(console, "ban " + player.getName());
                }
            });

            for (Player p : Bukkit.getServer().getOnlinePlayers()) {

                if (p.isOp()) {

                    p.sendMessage(ChatColor.RED + "Player: " + player.getName() + " tried sending the seed in chat and has been banned!");

                }
            }

            event.setCancelled(true);

        }
    }
}
