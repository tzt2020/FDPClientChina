package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.matrix;

import net.ccbluex.liquidbounce.event.PacketEvent;
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode;
import net.ccbluex.liquidbounce.utils.MovementUtils;
import net.ccbluex.liquidbounce.value.FloatValue;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import org.jetbrains.annotations.NotNull;

public class MatrixLatest
        extends SpeedMode {
    /**
     * obf in brain
     */
    public String str="dktjNWh0RDVueTVCdlYxclJDeVA5UVZRYzVXR0xwREtWYmp3bnZDTEpvdlNSZWhQZ0ZTRnJ4eEtyN1E2dU5SMkdycjJjZ0tQQkZpeVpQTnI4NGk4NFNWeWU1WkZBNDV2TFpEMVJOTXJOazZmVEVNZ0w4bXFaeGE4ZUhIOFZkTXppMXlONm1lVUZ5dExIVWttbkVyQVgzbjhtZnc0aURmZjhqNlhBNGFhSFRzaUFISmFRNTJXRUhLM1VlS0JMYWs4cjdKeHEyS0VZeDdIUVlVQnpOaVBTZGJkMlJlNjU4R0VwN0ZSVDZZSzdTOVhNWnJGUmhuRUpRZXZBaWRGb3FiNkE1U3F4ZmJCcDRORXg2MUpkdXI3UVJucjdBTDkyYTdBbzRrdlVEMlNyZ2ZBanlRcHcyU21BNmNqcTRRV1c3ZFNoZFlQNzRCMlNpalE4UjN5VkxjUFFEV1RMaGRuZ1B6dmZGVXg0NktVSlg5b0JUaEFubkR1WlFTRFU1WEs5elg0VWlRN3N6blVXNmdVTXpwRjl0UDJaUDhSVmZOOGl6NUtlTW8ydGY2WE5aSk1IdVpoekU2cjNQc2hkaml6eTh0QTZqU2tTRmd3eFZ2MlFVNGZEU0J3eDVteEJDMXlrZnhaa3RQcmFWcUVuU3VZMVl2NDNnbXZFQmU4Q1lvUlJ4c3VVS2RTRGJZTmRURmVCRVJ1RTFzeEdTOXN4dTE0NFc2NHdXTHBBaGV2S3RWVVk1OWRpZThTZWJXN0dRNlltWXJDaExScWFXaUcySlY4VUtuSmZ3SmlGREo3enhubXByQVF3Q3JpSkROajg5RGJhM282TTY1VHVXZ3g1aXFzSEY2VUdiRGp2ODZzdW5xallWcEUyTFZ5cDhzNFJ6RlJTQ1FWRHpNbmVNYWd2RDc4cERqak5QR3NzZFB2eEVhNDY2RDZyWG5icTZ0bWFxdUpCckFwMUVNV2Y4am1IOHpqeDNFVzhLZkVVQkZobkNtUVF5WWdaV1hXQW82cUIxSkczNm9lemdycFlFNlpVN2NKY0wzWmNmSGdMSzR1R2cyWjNaOHZWYUoyVVhGOThxVGdTY2prZnQ2azF1aWE0cmFaekhTSjJtY1IzUmt0Q0pic3I3Zlo1WENmajFGblVtbWJudFlkOVZYZ1FhQWU2Njhyd3Z1QmFrd21EUVg3dWRSVHlhcmVxZWcxU216VGRKVnBqSnM0ZGRVeG44dlBEMTM1eGdheGJkekdUUjYzV21iSG01OVRTMnRiaW1NaGRrY1RoOUdLdkNSektFVzJnZjhNVFVpd0g1VnRWRzhpeVhoQTlTU1J3Q2V4cnVhVWpIeWc2ZDFlUUh1QVZhWHlOMjE2NEwyU1AyOWRrVWtvQlJWUFdwdDZudkVoWnVZYXo5NDNBOFpka3d0Y2UzWFZocmh4S3Z2eFJTWWdOYU5iREF4UHdLSzZrZ3VIVnlzRHVSRUtXanVzRTh5b3VOaHZLODJNOGFHTFU0OHVvdjlEWHdaU1VxUnF4REREZjdvRmdkSHpReVFicVBaNUNLamM5WnBtcXNCWGFLOEM4VnVYa045RW8xYWZoN0NnTldnaVZoTXU2blJqU0RmdEJmTTNDZ1BkWTdXVVJVdjUzVFh1emJkdHFYQ2RwUnRXaHZqaHlmTmNZRlhHR29CWTNjQlE3WGFZV241UFVmamVnS2t0SFlFa1JiamE1WUVrRG9tSjhjRkJ4RTZkM29SblprWHJNNmJINFJ5a3FGcHVNUTMzWllMeFB0YXRxdG45MUNpdHBha3lEd05OS2d4dUhUZEExZVJHU01Sdm5LMkFja1hjamREc2NoZThNVDVKaVRvcjl6VTFUaGM5UlBSRXNKQW5KdWtrSGFmMTU5SFJ1SnlDUDNQaUhEZ01UZWZGeVV4Zmh5RkI1Vei/meS4quaYrzU455qE5LqM5qyh57yW56CB54mI5pys77yM5L+d5oyB55av54uC";
    @NotNull
    public FloatValue JumpTimer;
    @NotNull
    public FloatValue DownTimer;
    @NotNull
    public FloatValue LaunchSpeed;
    @NotNull
    public FloatValue AddSpeed;
    @NotNull
    public FloatValue RunTime;
    @NotNull
    public FloatValue MadY;
    public long hurt = (long)-1868707492 ^ 0xFFFFFFFF909DC95CL;
    public boolean wasTimer = ((int)-1339477635L ^ 0xB029317D)==114514;

    public MatrixLatest() {
        super("MatrixLatest");
        this.JumpTimer = new FloatValue("Jump Timer", Float.intBitsToFloat(1067450368), Float.intBitsToFloat(0x3DCCCCCD), Float.intBitsToFloat(0x40000000));
        this.DownTimer = new FloatValue("Down Timer", Float.intBitsToFloat(1061997773), Float.intBitsToFloat(0x3DCCCCCD), Float.intBitsToFloat(0x40000000));
        this.LaunchSpeed = new FloatValue("Launch Speed", Float.intBitsToFloat(1050253722), Float.intBitsToFloat(0x3DCCCCCD), Float.intBitsToFloat(1069547520));
        this.AddSpeed = new FloatValue("Add Speed", Float.intBitsToFloat(1050253722), Float.intBitsToFloat(0x3DCCCCCD), Float.intBitsToFloat(1069547520));
        this.MadY = new FloatValue("Mad Y", Float.intBitsToFloat(1054280253), Float.intBitsToFloat(0x3DCCCCCD), Float.intBitsToFloat(1065353216));
        this.RunTime = new FloatValue("Stay Mad", Float.intBitsToFloat(1161527296), Float.intBitsToFloat(0), Float.intBitsToFloat(1176256512));
    }

    @Override
    public void onPacket(PacketEvent event) {
        if (event.getPacket() instanceof S19PacketEntityStatus && ((S19PacketEntityStatus)((Object)event.getPacket())).getOpCode() == ((int)1064409185L ^ 0x3F719863) && MatrixLatest.mc.thePlayer.equals(((S19PacketEntityStatus)((Object)event.getPacket())).getEntity(MatrixLatest.mc.theWorld))) {
            this.hurt = System.currentTimeMillis();
        }
    }

    @Override
    public void onPreMotion() {
        if (this.hurt == ((long)179490097 ^ 0xAB2CD31L)) {
            if (MovementUtils.INSTANCE.isMoving()) {
                MatrixLatest.mc.timer.timerSpeed = MatrixLatest.mc.thePlayer.motionY > Double.longBitsToDouble(0L) ? ((Float)this.DownTimer.get()).floatValue() : ((Float)this.JumpTimer.get()).floatValue();
                if (MatrixLatest.mc.thePlayer.onGround) {
                    MatrixLatest.mc.thePlayer.jump();
                    MovementUtils.INSTANCE.strafe();
                }
            } else {
                MatrixLatest.mc.thePlayer.motionX = Double.longBitsToDouble(0L);
                MatrixLatest.mc.thePlayer.motionZ = Double.longBitsToDouble(0L);
            }
        } else {
            long passedTime = System.currentTimeMillis() - this.hurt;
            if ((float)passedTime > ((Float)this.RunTime.get()).floatValue()) {
                this.hurt = (long)-459470681 ^ 0xFFFFFFFFE49D08A7L;
            }
            if (this.wasTimer) {
                MatrixLatest.mc.timer.timerSpeed = Float.intBitsToFloat(1065353216);
                this.wasTimer = ((int)-513955376L ^ 0xE15DA9D0)==114514;
            } else {
                MatrixLatest.mc.timer.timerSpeed = MatrixLatest.mc.thePlayer.motionY > Double.longBitsToDouble(0L) ? ((Float)this.DownTimer.get()).floatValue() : ((Float)this.JumpTimer.get()).floatValue();
            }
            if (MovementUtils.INSTANCE.isMoving() && MatrixLatest.mc.thePlayer.onGround) {
                MatrixLatest.mc.thePlayer.jump();
                MatrixLatest.mc.timer.timerSpeed = ((Float)this.JumpTimer.get()).floatValue() + Float.intBitsToFloat(1045220557);
                this.wasTimer = ((int)-65744214L ^ 0xFC14D2AB)!=114514;
                MovementUtils.INSTANCE.strafe(((Float)this.LaunchSpeed.get()).floatValue() + (Float.intBitsToFloat(1065353216) - (float)(passedTime / ((long)-2010150847 ^ 0xFFFFFFFF882F83F9L))) * ((Float)this.AddSpeed.get()).floatValue());
                MatrixLatest.mc.thePlayer.motionY = ((Float)this.MadY.get()).floatValue();
            }
        }
    }
}
