@Grapes(
        @Grab(group='org.imgscalr', module='imgscalr-lib', version='4.2')
)
import static org.imgscalr.Scalr.*;
import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import javax.imageio.IIOException;
import java.awt.image.BufferedImage;

def srcFolder = "/home/volyihin/Dropbox/blog/assets/img/full"; 
def destFolder = srcFolder + "/result/"; 

BufferedImage img = null;
def amount = 0
new File(srcFolder).eachFile() {
    f ->

        try {
            img = ImageIO.read(f);
        }
        catch (IOException e) {
            println "IOException " + f.getName()
            return;
        }
        catch (IIOException ei) {
            println "IIOException"
            return;
        }

        if (img == null) return;

        BufferedImage thumbnail = Scalr.resize(img, 1000);

        File outputfile = new File(destFolder + f.getName());

        ImageIO.write(thumbnail, "jpg", outputfile);

        println "Path " + outputfile.toURL();

        amount++;

}

println amount + " images resized"
