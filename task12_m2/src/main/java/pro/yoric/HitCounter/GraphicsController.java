package pro.yoric.HitCounter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsController
    implements IGraphicsController
{
    IImageBlankInstance image = ImageBlankInstance.getInstance();

    @Override
    public File changeImageText(String newImageText)
        throws IOException
    {
        BufferedImage bufferedImage =
            new BufferedImage(
                70,
                65,
                BufferedImage.TYPE_INT_ARGB
            );

        Graphics2D g = bufferedImage.createGraphics();
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        g.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );

        g.setFont(new Font("Purisa", Font.ITALIC, 50));
        g.setBackground(new Color(245, 245, 245, 0));
        g.setColor(Color.magenta);
        g.drawString(newImageText, 5,50);

        g.dispose();

        ImageIO.write(bufferedImage, "png", image.getImage());
        return image.getImage();
    }
}
