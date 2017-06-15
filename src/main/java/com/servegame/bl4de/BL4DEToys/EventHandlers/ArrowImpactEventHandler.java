package com.servegame.bl4de.BL4DEToys.EventHandlers;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.arrow.TippedArrow;
import org.spongepowered.api.event.block.CollideBlockEvent;

import java.util.Optional;

/**
 * File: ArrowImpactEventHandler.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class ArrowImpactEventHandler {

    /**
     * This handle teleports the player to the impact location of the {@link TippedArrow}
     * @param event - {@link CollideBlockEvent.Impact} - events that do not root a {@link TippedArrow} do not get here
     */
    public static void handle(CollideBlockEvent.Impact event) {
        Optional<Player> playerOptional = event.getCause().get("Name", Player.class);
        if (playerOptional.isPresent()){
            Player player = playerOptional.get();
            player.setLocation(event.getImpactPoint());
        }
    }
}
