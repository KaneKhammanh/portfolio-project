import java.util.Random;

import components.ColorModel.ColorModel;
import components.sequence.Sequence;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class ColorPaletteGenerator {

        public static void main(String[] args) {
                SimpleReader in = new SimpleReader1L();
                SimpleWriter out = new SimpleWriter1L();

                out.println("Would you like to generate a new color palette? Enter Y to continue: ");
                while (in.nextLine().equals("Y")) {
                        Random randomVal = new Random();

                        int red = randomVal.nextInt(255);
                        int green = randomVal.nextInt(255);
                        int blue = randomVal.nextInt(255);

                        ColorModel randomColor = new ColorModel(red, green,
                                        blue);

                        int intensity = Math.min(255 - randomColor.getGreen(),
                                        255 - randomColor.getBlue());

                        Sequence<ColorModel> palette = randomColor
                                        .monochromatic(0, intensity);

                        out.println("<" + palette.entry(0).toString() + ">, "
                                        + "<" + palette.entry(1).toString()
                                        + ">, " + "<"
                                        + palette.entry(2).toString() + ">, ");

                }
        }
}
