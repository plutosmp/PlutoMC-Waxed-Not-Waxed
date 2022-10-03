package top.plutomc.plugin.waxednotwaxed;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public final class EventListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("plutomc.waxednotwaxed.check"))
            return;
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        Block block = event.getClickedBlock();
        if (!itemInMainHand.getType().name().toLowerCase().contains("shovel") || block == null)
            return;
        String blockType = block.getType().name().toLowerCase();
        if (!blockType.contains("copper"))
            return;
        if (blockType.startsWith("waxed_")) {
            player.sendActionBar(MiniMessage.miniMessage().deserialize("<green>这个方块被打蜡了"));
            Location location = block.getLocation();
            player.playSound(location, Sound.BLOCK_BEEHIVE_WORK, 0.5f, 1.0f);
            location.getWorld().spawnParticle(Particle.WAX_ON, location.add(.5,.5,.5), 25, 0.3, 0.3, 0.3);
        } else {
            player.sendActionBar(MiniMessage.miniMessage().deserialize("<red>这个方块没有被打蜡"));
            Location location = block.getLocation();
            player.playSound(location, Sound.BLOCK_BEEHIVE_WORK, 0.5f, 1.0f);
            location.getWorld().spawnParticle(Particle.WAX_OFF, location.add(.5,.5,.5), 25, 0.3, 0.3, 0.3);
        }
    }

}
