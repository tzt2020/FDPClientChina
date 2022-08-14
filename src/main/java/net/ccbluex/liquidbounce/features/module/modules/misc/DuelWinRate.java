package net.ccbluex.liquidbounce.features.module.modules.misc;

import net.ccbluex.liquidbounce.event.AttackEvent;
import net.ccbluex.liquidbounce.event.EventTarget;
import net.ccbluex.liquidbounce.event.Render2DEvent;
import net.ccbluex.liquidbounce.features.module.Module;
import net.ccbluex.liquidbounce.features.module.ModuleCategory;
import net.ccbluex.liquidbounce.features.module.ModuleInfo;
import net.ccbluex.liquidbounce.font.FontLoaders;
import net.ccbluex.liquidbounce.utils.PlayerUtils;
import net.ccbluex.liquidbounce.utils.render.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;

import java.awt.*;


@ModuleInfo(name = "DuelWinRate", category = ModuleCategory.MISC)
public class DuelWinRate extends Module {
    public static Minecraft mc = Minecraft.getMinecraft();
    public static EntityLivingBase player = null;

    public static double rate = 0;

    @EventTarget
    public void onAttack(AttackEvent event) {
        player = (EntityLivingBase) event.getTargetEntity();
    }

    @EventTarget
    public void onUpdate(Render2DEvent event) {
        ScaledResolution scaledResolution = new ScaledResolution(mc);
        FontLoaders.C16.drawStringWithShadow("Your winrate:",scaledResolution.getScaledWidth() - 80, scaledResolution.getScaledHeight() - 14, rate >= 1 ? new Color(84, 157, 108).getRGB() : new Color(214, 116, 125).getRGB());
        RenderUtils.drawCircle(scaledResolution.getScaledWidth() - 20, scaledResolution.getScaledHeight() - 11, 4, rate >= 1 ? new Color(84, 157, 108).getRGB() : new Color(214, 116, 125).getRGB());
        try {
            double Ar1 = PlayerUtils.INSTANCE.getAr(player);
            double Ar2 = PlayerUtils.INSTANCE.getAr(mc.thePlayer);
            double Hp1 = PlayerUtils.INSTANCE.getHp(player);
            double Hp2 = PlayerUtils.INSTANCE.getHp(mc.thePlayer);
            double Damage1 = player.getEquipmentInSlot(0).getItemDamage();
            double Damage2 = mc.thePlayer.inventory.getCurrentItem().getItemDamage();
            if (Damage1 >= 20) return;
            if (Damage2 >= 20) return;
            if (Hp1 == Hp2) {
                if (Ar1 == Ar2) {
                    if (Damage2 == Damage1) {
                        rate = 1;
                    } else if (Damage1 > Damage2) {
                        rate = 1;
                    }
                } else if (Ar1 > Ar2) {
                    rate = 0;
                }
            } else if (Hp1 == 0.0 || Hp1 <= Damage2) {
                rate = 1;
            } else {
                rate = ((Hp2 - Hp1) > 0) ? 1 : 0;
            }

        } catch (Exception e) {

        }
    }

    @Override
    public void onEnable() {

    }
}