package net.ccbluex.liquidbounce.features.module.modules.client

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.ui.client.GuiSelectPerformance
import net.ccbluex.liquidbounce.utils.timer.MSTimer

@ModuleInfo(name = "PerformanceLeve", category = ModuleCategory.CLIENT)
class PerformanceLeve : Module() {
    override fun onEnable() {
        LiquidBounce.RENDERLEAVESELECTED=3;
        mc.displayGuiScreen(GuiSelectPerformance())
        state=false
    }
}