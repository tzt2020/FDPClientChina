package net.ccbluex.liquidbounce.ui.client.hud.element.elements

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.features.module.modules.client.HUD
import net.ccbluex.liquidbounce.ui.client.hud.designer.GuiHudDesigner
import net.ccbluex.liquidbounce.ui.client.hud.element.Border
import net.ccbluex.liquidbounce.ui.client.hud.element.Element
import net.ccbluex.liquidbounce.ui.client.hud.element.ElementInfo
import net.ccbluex.liquidbounce.ui.client.hud.element.Side
import net.ccbluex.liquidbounce.ui.font.Fonts
import net.ccbluex.liquidbounce.utils.render.RenderUtils
import net.minecraft.client.renderer.GlStateManager
import org.lwjgl.opengl.GL11
import skidunion.destiny.utils.render.NewRenderUtils
import java.awt.Color
import java.math.BigDecimal
import kotlin.math.pow

/**
 * CustomHUD Notification element
 */
@ElementInfo(name = "Notifications", blur = true)
class Notifications(x: Double = 0.0, y: Double = 0.0, scale: Float = 1F,
                    side: Side = Side(Side.Horizontal.RIGHT, Side.Vertical.DOWN)) : Element(x, y, scale, side) {
    /**
     * Example notification for CustomHUD designer
     */
    private val exampleNotification = Notification("Notification", "This is an example notification.", NotifyType.INFO)

    /**
     * Draw element
     */
    override fun drawElement(partialTicks: Float): Border? {
        val notifications = mutableListOf<Notification>()
        //FUCK YOU java.util.ConcurrentModificationException
        for ((index, notify) in LiquidBounce.hud.notifications.withIndex()) {
            GL11.glPushMatrix()

            if (notify.drawNotification(index)) {
                notifications.add(notify)
            }

            GL11.glPopMatrix()
        }
        for (notify in notifications) {
            LiquidBounce.hud.notifications.remove(notify)
        }

        if (mc.currentScreen is GuiHudDesigner) {
            if (!LiquidBounce.hud.notifications.contains(exampleNotification))
                LiquidBounce.hud.addNotification(exampleNotification)

            exampleNotification.fadeState = FadeState.STAY
            exampleNotification.displayTime = System.currentTimeMillis()
//            exampleNotification.x = exampleNotification.textLength + 8F

            return Border(-exampleNotification.width.toFloat() + 80, -exampleNotification.height.toFloat()-24.5f, 80F, -24.5F)
        }

        return null
    }

}

class Notification(val title: String, val content: String, val type: NotifyType, val time: Int = 2000, val animeTime: Int = 500) {
    val height = 30
    var fadeState = FadeState.IN
    var nowY = -height
    var typestring = ""
    var displayTime = System.currentTimeMillis()
    var animeXTime = System.currentTimeMillis()
    var animeYTime = System.currentTimeMillis()
    val width = Fonts.font32.getStringWidth(content) + 53


    /**
     * Draw notification
     */
    /**
     * SpaceKing OpenSource Free Share
     */
    fun drawNotification(index: Int): Boolean {
        val realY = -(index + 1) * (height + 10)
        val nowTime = System.currentTimeMillis()
        //Y-Axis Animation
        if (nowY != realY) {
            var pct = (nowTime - animeYTime) / animeTime.toDouble()
            if (pct > 1) {
                nowY = realY
                pct = 1.0
            } else {
                pct = easeOutBack(pct)
            }
            GL11.glTranslated(0.0, (realY - nowY) * pct, 0.0)
        } else {
            animeYTime = nowTime
        }
        GL11.glTranslated(0.0, nowY.toDouble(), 0.0)

        //X-Axis Animation
        var pct = (nowTime - animeXTime) / animeTime.toDouble()
        when (fadeState) {
            FadeState.IN -> {
                if (pct > 1) {
                    fadeState = FadeState.STAY
                    animeXTime = nowTime
                    pct = 1.0
                }
                pct = easeOutBack(pct)
            }

            FadeState.STAY -> {
                pct = 1.0
                if ((nowTime - animeXTime) > time) {
                    fadeState = FadeState.OUT
                    animeXTime = nowTime
                }
            }

            FadeState.OUT -> {
                if (pct > 1) {
                    fadeState = FadeState.END
                    animeXTime = nowTime
                    pct = 1.0
                }
                pct = 1 - easeInBack(pct)
            }

            FadeState.END -> {
                return true
            }
        }
        if (type.toString() == "SUCCESS") {
            typestring = "a"
        }
        if (type.toString() == "ERROR") {
            typestring = "B"
        }
        if (type.toString() == "WARNING") {
            typestring = "D"
        }
        if (type.toString() == "INFO") {
            typestring = "C"
        }
        GL11.glScaled(pct,pct,pct)
        GL11.glTranslatef(-width.toFloat()/2 , -height.toFloat()/2, 0F)
        RenderUtils.drawRect(0F, 0F, width.toFloat(), height.toFloat(), Color(63, 63, 63, 140))
        RenderUtils.drawGradientSideways(0.0, height - 1.7,
            (width * ((nowTime - displayTime) / (animeTime * 2F + time))).toDouble(), height.toDouble(), Color(HUD.redValue.get(),HUD.greenValue.get(),HUD.blueValue.get()).rgb, Color(HUD.gredValue.get(),HUD.ggreenValue.get(),HUD.gblueValue.get()).rgb)
        Fonts.font35.drawStringWithShadow("$title", 24.5F, 7F, Color.WHITE.rgb)
        Fonts.font32.drawStringWithShadow("$content" + " (" + BigDecimal(((time - time * ((nowTime - displayTime) / (animeTime * 2F + time))) / 1000).toDouble()).setScale(1, BigDecimal.ROUND_HALF_UP).toString() + "s)", 24.5F, 17.3F, Color.WHITE.rgb)
        NewRenderUtils.drawFilledCircle(13, 15, 8.5F,Color.BLACK)
        Fonts.Nicon80.drawString(typestring, 3, 8, Color.WHITE.rgb)
        NewRenderUtils.drawCircle(12.3f,15.0f,8.8f, 0,360)
        GlStateManager.resetColor()

        return false
    }

    fun easeInBack(x: Double): Double {
        val c1 = 1.70158
        val c3 = c1 + 1

        return c3 * x * x * x - c1 * x * x
    }

    fun easeOutBack(x: Double): Double {
        val c1 = 1.70158
        val c3 = c1 + 1

        return 1 + c3 * (x - 1).pow(3) + c1 * (x - 1).pow(2)
    }
}

enum class NotifyType() {
    SUCCESS(),
    ERROR(),
    WARNING(),
    INFO();
}

enum class FadeState { IN, STAY, OUT, END }