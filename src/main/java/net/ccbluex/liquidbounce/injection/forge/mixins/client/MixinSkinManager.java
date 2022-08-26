package net.ccbluex.liquidbounce.injection.forge.mixins.client;

import com.google.common.cache.LoadingCache;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.resources.SkinManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.util.Map;

@Mixin(SkinManager.class)
public class MixinSkinManager {
    @Inject(method = "loadSkinFromCache", at = @At(value = "HEAD"),cancellable = true)
    public Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> loadSkinFromCache(GameProfile p_loadSkinFromCache_1_,CallbackInfo callbackInfo) {
        try {
            Field skinCacheLoader = MixinSkinManager.class.getDeclaredField("skinCacheLoader");
            return (Map)((LoadingCache<GameProfile, Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>>)skinCacheLoader.get(null)).getUnchecked(p_loadSkinFromCache_1_);
        }catch (Exception e){

        }
        return null;
    }
}
