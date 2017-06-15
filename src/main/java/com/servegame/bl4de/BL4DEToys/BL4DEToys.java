package com.servegame.bl4de.BL4DEToys;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.arrow.TippedArrow;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.game.state.GameLoadCompleteEvent;
import org.spongepowered.api.plugin.Plugin;

import java.util.Optional;

/**
 * File: BL4DEToys.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
@Plugin(id = "bl4detoys", name = "BL4DEToys", version = "0.0.1",
        authors = {"TheCahyag"},
        url = "https://github.com/TheCahyag/BL4DEToys")
public class BL4DEToys {

    @Inject
    Game game;

    @Inject
    Logger logger;

    @Listener
    public void onLoad(GameLoadCompleteEvent event){
        this.logger.info("BL4DEToys has been loaded");
    }

    /**
     * onCollideBlockEventImpact listens for a CollideBlockEvent.Impact and
     * teleports the player who shot the arrow to it's impact position
     * event only when it's root is a {@link TippedArrow}
     * @param event {@link CollideBlockEvent.Impact}
     * @param arrow - Not actually used, just included to weed out other events
     */
    @Listener
    public void onCollideBlockEventImpact(CollideBlockEvent.Impact event, @Root TippedArrow arrow){

        Optional<Player> playerOptional = event.getCause().get("Name", Player.class);
        if (playerOptional.isPresent()){
            Player player = playerOptional.get();
            player.setLocation(event.getImpactPoint());
        }
    }
}
