package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.matrix

import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils
import net.minecraft.client.settings.GameSettings
import net.ccbluex.liquidbounce.value.BoolValue

class MatrixLowTest : SpeedMode("MatrixLow") {

    private val groundStrafe = BoolValue("${valuePrefix}GroundStrafe", false)

    override fun onUpdate() {
        mc.gameSettings.keyBindJump.pressed = GameSettings.isKeyDown(mc.gameSettings.keyBindJump)
        if (MovementUtils.isMoving()) {
            if (mc.thePlayer.onGround) {
                mc.timer.timerSpeed = 1.0f
                if (groundStrafe.get()) MovementUtils.strafe()
                mc.thePlayer.jump()
            }
            
             if (mc.thePlayer.motionY > 0.003) {
                mc.thePlayer.motionX *= 1.0012
                mc.thePlayer.motionZ *= 1.0012

            }

             if (mc.thePlayer.motionY > 0.4) {
                mc.timer.timerSpeed = 1.14f

            }

             if (mc.thePlayer.motionY < 0.419) {
                mc.thePlayer.motionY *= -0.11
                mc.timer.timerSpeed = 1.5f
             }

        }
       
    }
}
