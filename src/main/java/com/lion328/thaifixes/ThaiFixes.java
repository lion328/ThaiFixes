package com.lion328.thaifixes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dimdev.riftloader.listener.InitializationListener;
import org.spongepowered.asm.mixin.Mixins;

public class ThaiFixes implements InitializationListener
{

    private static Logger logger;

    @Override
    public void onInitialization()
    {
        Mixins.addConfiguration("mixins.thaifixes.json");

        try
        {
            HangingThaiCharacterTexturedGlyph.initialize();
        }
        catch (NoSuchFieldException | IllegalAccessException e)
        {
            getLogger().error("Failed to initialize HangingThaiCharacterTexturedGlyph clone methods", e);
        }
    }

    public static Logger getLogger()
    {
        if (logger == null)
        {
            logger = LogManager.getLogger("ThaiFixes");
        }

        return logger;
    }
}
