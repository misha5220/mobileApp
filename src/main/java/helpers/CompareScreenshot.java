package helpers;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CompareScreenshot {

    public static boolean screenComparator(String screenA,String screenB) throws IOException {
        File actualImageFile = new File("screenshot/a.png");
        File expectedImageFile = new File("screenshot/c.png");
        BufferedImage actualImage = ImageIO.read(actualImageFile);
        BufferedImage expectedImage = ImageIO.read(expectedImageFile);

        ImageDiffer imageDiffer = new ImageDiffer();
        ImageDiff diff = imageDiffer.makeDiff(expectedImage,actualImage);
        if(diff.hasDiff())  {
            System.out.println("Images are different");
            File diffImageFile  = new File("screenshot/diff.png");
            ImageIO.write(diff.getMarkedImage(),"PNG",diffImageFile);
            return false;
        }else {
            System.out.println("Images are the same");
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(screenComparator("sad","dfs"));
    }
}
