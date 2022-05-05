package net.ccbluex.liquidbounce.injection.loader;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

public class Loader {
    public static void load(){
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.fdpclient.json");
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
    }
}
