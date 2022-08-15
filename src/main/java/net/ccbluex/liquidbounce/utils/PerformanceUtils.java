package net.ccbluex.liquidbounce.utils;


import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

import static net.ccbluex.liquidbounce.utils.MinecraftInstance.mc;

public class PerformanceUtils {
    private static OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    public static int cpuLoad() {
        double cpuLoad = osmxb.getSystemCpuLoad();
        int percentCpuLoad = (int) (cpuLoad * 100);
        return percentCpuLoad;
    }
    public static int FPSLime(){
        ClientUtils.INSTANCE.displayChatMessage("CPU: "+cpuLoad());
        if(cpuLoad()>=50){
            return 120;
        }
        return mc.gameSettings.limitFramerate;
    }
}
