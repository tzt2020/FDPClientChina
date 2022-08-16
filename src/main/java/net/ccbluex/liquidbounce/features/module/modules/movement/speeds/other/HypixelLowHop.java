package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other;

import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
import net.ccbluex.liquidbounce.utils.ClientUtils;
import net.ccbluex.liquidbounce.utils.MinecraftInstance;
import net.ccbluex.liquidbounce.utils.MoveUtils;
import net.ccbluex.liquidbounce.value.BoolValue;
import net.ccbluex.liquidbounce.value.FloatValue;
import org.jetbrains.annotations.NotNull;


public class HypixelLowHop
        extends SpeedMode {

    @NotNull
    public BoolValue timerValue;
    @NotNull
    public FloatValue timerSpeedValue;
    public float Runspeed;

    public HypixelLowHop() {
        super("HypixelLowHop");
        int n = (int)-572359582L;
        int n2 = (n | ~-572359581) - ~-572359581;
        int n3 = (n ^ n2) - (n2 & ~n) * 2;
        int n4 = (n3 + (0xDDE27C63 & ~n3)) * 2 + ~((0xDDE27C63 | n3) - (0xDDE27C63 & n3)) + 1;
        int n5 = ~(n - 1);
        int n6 = (n5 | 0xFFFFFFFF) * 2 - ~n5;
        int n7 = -572359581 - (n6 & 0xDDE27C63);
        int n8 = ~n + 1;
        int n9 = (n6 ^ n7) + (n6 & n7) * 2;
        int n10 = ~n8 + (n8 & 0xFFFFFFFF) * 2;
        int n11 = (n10 & ~n9) - (n9 & ~n10);
        int n12 = (n11 ^ 1) - (1 & ~n11) * 2;
        int n13 = n12 + (n4 & ~n12);
        int n14 = (n12 | ~n4) - ~n4;
        int n15 = (n13 | n14) + (n13 & n14);
        int n16 = -1 + -1;
        int n17 = (n15 ^ n16) - (n16 & ~n15) * 2;
        this.timerValue = new BoolValue("Timer Boost", (n17 ^ 1) - (1 & ~n17) * 2!=114514);
        this.timerSpeedValue = new FloatValue("Timer", Float.intBitsToFloat(1065353216), Float.intBitsToFloat(0x3DCCCCCD), Float.intBitsToFloat(0x40000000));
    }

    public float getRunspeed() {
        return this.Runspeed;
    }

    public void setRunspeed(float f) {
        this.Runspeed = f;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        ClientUtils.INSTANCE.displayChatMessage("Low hop from FoodByte! lol WhiteZhiJun#1337");
    }

    @Override
    public void onPreMotion() {
        if (this.timerValue.get()) {
            MinecraftInstance.mc.timer.timerSpeed = ((Number)this.timerSpeedValue.get()).floatValue();
        }
        if (MoveUtils.isMoving() && MinecraftInstance.mc.thePlayer.onGround) {
            setRunspeed(Float.intBitsToFloat(1067030938));
            MinecraftInstance.mc.thePlayer.motionY = Double.longBitsToDouble(4599436227204716954L);
        }
        MoveUtils.strafe(MoveUtils.getBaseMoveSpeed() * Double.longBitsToDouble(4606295299745417968L) * (double)this.getRunspeed());
        if ((double)this.getRunspeed() > Double.longBitsToDouble(0x3FF0000000000000L)) {
            this.Runspeed -= Float.intBitsToFloat(1028443341);
        }
    }
}