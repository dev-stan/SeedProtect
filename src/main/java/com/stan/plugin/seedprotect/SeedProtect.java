package com.stan.plugin.seedprotect;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class SeedProtect extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("SeedProtect plugin by dev-stan has been enabeld!");
        getServer().getPluginManager().registerEvents(this, this);


    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {

        System.out.println("Shit's working g!");

        Player player = event.getPlayer();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        String message = event.getMessage();
        Long seed = Bukkit.getWorld("world").getSeed();

        if (message.contains(seed.toString())) {

            Bukkit.getScheduler().runTask(this, new Runnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(console, "ban " + player.getName());
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
