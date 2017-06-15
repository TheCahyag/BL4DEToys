package com.servegame.bl4de.BL4DEToys.EventHandlers;

import com.servegame.bl4de.BL4DEToys.BL4DEToys;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.block.CollideBlockEvent;

/**
 * File: BL4DEEventHandler.java
 * @author Brandon Bires-Navel (brandonnavel@outlook.com)
 */
public class BL4DEEventHandler {
    private BL4DEToys toys;

    /**
     * Default constructor
     * @param toys - {@link BL4DEToys} - to reference logger
     */
    public BL4DEEventHandler(BL4DEToys toys){
        this.toys = toys;
    }

    /**
     * handleEvent will distribute events based on what type of event it is
     * @param event - {@link Event} - current event at hand
     * @return - boolean - whether the event was handled or not
     */
    public boolean handleEvent(Event event){
        if (event instanceof CollideBlockEvent.Impact){
            return ArrowImpactEventHandler.handle((CollideBlockEvent.Impact) event);
        }
        this.toys.getLogger().info("Instance not found.");
        new Throwable().printStackTrace();
        return false;
    }

}
