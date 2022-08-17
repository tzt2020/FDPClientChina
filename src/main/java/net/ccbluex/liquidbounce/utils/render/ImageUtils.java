package net.ccbluex.liquidbounce.utils.render;

import net.minecraft.client.Minecraft;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ImageUtils {
    /**
     * Reads the image to a byte buffer that works with LWJGL.
     * @author func16
     */
    public static ByteBuffer readImageToBuffer(BufferedImage bufferedimage) {
        int[] aint = bufferedimage.getRGB(0, 0, bufferedimage.getWidth(), bufferedimage.getHeight(), (int[])null, 0, bufferedimage.getWidth());
        ByteBuffer bytebuffer = ByteBuffer.allocate(4 * aint.length);
        int[] var5 = aint;
        int var6 = aint.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            int i = var5[var7];
            bytebuffer.putInt(i << 8 | i >> 24 & 255);
        }

        bytebuffer.flip();
        return bytebuffer;
    }

    /**
     * Resize the image to the specified width and height.
     * @author liulihaocai
     */
    public static BufferedImage resizeImage(BufferedImage image, int width,int height) {
        BufferedImage buffImg = new BufferedImage(width,height, BufferedImage.TYPE_4BYTE_ABGR);
        buffImg.getGraphics().drawImage(image.getScaledInstance(width,height, Image.SCALE_SMOOTH), 0, 0, null);
        return buffImg;
    }
}
