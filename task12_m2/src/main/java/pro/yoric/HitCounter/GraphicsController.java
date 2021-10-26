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
                200,
                70,
                BufferedImage.TYPE_INT_RGB
            );

        Graphics2D g = bufferedImage.createGraphics();

        g.setFont(new Font("Arial", Font.ITALIC, 50));
        g.setColor(Color.magenta);
        g.drawString(newImageText, 20,10);

        g.dispose();

        ImageIO.write(bufferedImage, "png", image.getImage());
        return image.getImage();
    }


//    public void paint(
//            Graphics2D g,
//            String     processedText
//        )
//    {
//        Image img = createImageWithText(processedText);
//        g.drawImage(img, 20,20, (ImageObserver) this);
//    }




//    private void doRenderingString(Graphics g)
//    {
//        Graphics2D g2d = (Graphics2D) g;
//
//        RenderingHints rh =
//                new RenderingHints(
//                        RenderingHints.KEY_ANTIALIASING,
//                        RenderingHints.VALUE_ANTIALIAS_ON
//                );
//
//        rh.put(
//                RenderingHints.KEY_RENDERING,
//                RenderingHints.VALUE_RENDER_QUALITY
//        );
//
//        g2d.setRenderingHints(rh);
//
//        g2d.setFont(
//            new Font(
//                "Purisa",
//                Font.PLAIN,
//                50
//            )
//        );
//
//        g2d.drawString("Most relationships seem so transitory",20, 30);
//
//    }
//    @Override
//    public void paintComponent(Graphics g)
//    {
//        doRenderingString(g);
//    }

}
