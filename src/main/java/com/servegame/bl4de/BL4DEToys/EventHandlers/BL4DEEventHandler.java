package com.servegame.bl4de.BL4DEToys.EventHandlers;

import org.spongepowered.api.Game;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.block.CollideBlockEvent;

/**
 * File: BL4DEEventHandler.java
 *
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BL4DEEventHandler {

    private Game game;

    /**
     * Default constructor
     * @param game - {@link Game} - Current game instance
     */
    public BL4DEEventHandler(Game game){
        this.game = game;
    }

    public static boolean handleEvent(Event event){
        if (event instanceof CollideBlockEvent.Impact){
            ArrowImpactEventHandler.handle((CollideBlockEvent.Impact) event);
        }
        return false;
    }

}
