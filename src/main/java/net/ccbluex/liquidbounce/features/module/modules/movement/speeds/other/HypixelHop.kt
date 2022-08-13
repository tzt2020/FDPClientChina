/*
 * FDPClient Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge by LiquidBounce.
 * https://github.com/UnlegitMinecraft/FDPClientChina
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other

import net.ccbluex.liquidbounce.event.MovementEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils
import net.ccbluex.liquidbounce.value.FloatValue
import net.ccbluex.liquidbounce.value.ListValue
import net.minecraft.client.settings.GameSettings


class HypixelHop : SpeedMode("HypixelHop") {

    private val bypassMode = ListValue("${valuePrefix}BypassMode", arrayOf("20220813", "OldSafe", "OldTest"), "Stable")
    private val slowdownValue = FloatValue("${valuePrefix}SlowdownValue", 0.15f, 0.01f, 0.5f)

    private var watchdogMultiplier = 1.0
    private var oldMotionX = 0.0
    private var oldMotionZ = 0.0
    private var wasOnGround = false

    override fun onUpdate() {
        if(bypassMode.get().lowercase().contains("20220813")) return
        if (!MovementUtils.isMoving()) {
            mc.thePlayer.motionX = 0.0
            mc.thePlayer.motionZ = 0.0
        }
        when (bypassMode.get().lowercase()) {
            "stable"-> {
                oldMotionX = mc.thePlayer.motionX
                oldMotionZ = mc.thePlayer.motionZ

                //MovementUtils.strafe()

                if (!mc.thePlayer.onGround) {
                    if (!wasOnGround) {
                        mc.thePlayer.motionX = (mc.thePlayer.motionX * 3 + oldMotionX) / 4
                        mc.thePlayer.motionZ = (mc.thePlayer.motionZ * 3 + oldMotionZ) / 4
                        mc.thePlayer.motionX *= 0.99
                        mc.thePlayer.motionZ *= 0.99
                    }
                    wasOnGround = false
                } else if (MovementUtils.isMoving()) {
                    wasOnGround = true
                    mc.thePlayer.jump()
                    mc.thePlayer.motionY = 0.41999998688697815
                }
            }

            "oldsafe"-> {
                if(MovementUtils.isMoving() && mc.thePlayer.onGround) {
                    watchdogMultiplier = 1.45
                    mc.thePlayer.jump()
                    mc.thePlayer.motionY = 0.41999998688697815
                }
            }

            "oldtest"-> {
                if(MovementUtils.isMoving() && mc.thePlayer.onGround) {
                    watchdogMultiplier = 1.2
                    mc.thePlayer.jump()
                    mc.thePlayer.motionY = 0.39999998688697815
                }
            }
        }
        if (watchdogMultiplier > 1) {
            when (bypassMode.get().lowercase()) {
                "oldsafe" -> watchdogMultiplier -= 0.2
                "oldtest" -> watchdogMultiplier -= 0.05
            }
        } else {
            watchdogMultiplier = 1.0
        }
    }

    private var groundTick = 0
    override fun onPreMotion() {
        if (MovementUtils.isMoving()) {
            mc.timer.timerSpeed = 1f;

            when {
                mc.thePlayer.onGround -> {
                    if (groundTick >= 0) {
                        mc.gameSettings.keyBindJump.pressed = GameSettings.isKeyDown(mc.gameSettings.keyBindJump)
                        mc.timer.timerSpeed = 1f
                        mc.thePlayer.jump()
                        MovementUtils.strafe(0.475f)
                        mc.thePlayer.motionY = 0.40404;
                    }
                    groundTick++
                }
                else -> {
                    groundTick = 0
                    //MovementUtils.move(0.475f * 0.1f)
                    mc.thePlayer.motionY += 0
                }
            }
        }
    }

    override fun onMove(event: MovementEvent) {
        when (bypassMode.get().lowercase()) {
            "oldsafe" -> MovementUtils.strafe(( 0.2875 * watchdogMultiplier.toDouble() * ( 1.081237f    - slowdownValue.get()).toDouble()).toFloat())
            "oldtest" -> MovementUtils.strafe(( 0.2875 * watchdogMultiplier.toDouble() * ( 1.0f         - slowdownValue.get()).toDouble()).toFloat())
        }
    }
}
