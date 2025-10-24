import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * creates color model
 */
public final class colorModel<T> {
    /**
     * private variables for color values
     */
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private final int min = 0;
    private final int max = 255;

    /**
     * organizes colors into array
     */
    private final int[] rep = new int[3];

    SimpleWriter out = new SimpleWriter1L();

    /**
     * creates empty color model
     */
    public void colorModel() {
        this.rep[0] = this.red;
        this.rep[1] = this.green;
        this.rep[2] = this.blue;
    }

    /**
     * tests if int k is in the valid range of 0-255
     *
     * @param k
     *            value of a color channel
     * @return true is k is in range, false otherwise
     */
    public boolean inRange(int k) {
        boolean valid = false;
        if (k >= this.min && k <= this.max) {
            valid = true;
        }
        return valid;
    }

    /**
     * sets the red color channel to int k is k is in the range of 0-255
     *
     * @param k
     *            desired value of the red channel
     */
    public void setRed(int k) {
        assert this.inRange(k) : "Violation of: k is in the range of 0-255";
        if (this.inRange(k)) {
            this.red = k;
        }
    }

    /**
     * sets the green color channel to int k is k is in the range of 0-255
     *
     * @param k
     *            desired value of the green channel
     */
    public void setGreen(int k) {
        assert this.inRange(k) : "Violation of: k is in the range of 0-255";
        if (this.inRange(k)) {
            this.green = k;
        }
    }

    /**
     * sets the blue color channel to int k is k is in the range of 0-255
     *
     * @param k
     *            desired value of the blue channel
     */
    public void setBlue(int k) {
        assert this.inRange(k) : "Violation of: k is in the range of 0-255";
        if (this.inRange(k)) {
            this.blue = k;
        }
    }

    /**
     * sets all color channels to 255 as to represent the color white in RGB
     */
    public void toWhite() {
        this.red = this.max;
        this.green = this.max;
        this.blue = this.max;
    }

    /**
     * prints the values of the color channels of this
     */
    public void printColor() {
        this.out.print(this.red + ", ");
        this.out.print(this.green + ", ");
        this.out.println(this.blue);
    }

    /**
     * "mixes" this with colorModel a to create a new colorModel, which is the
     * average color between this and a
     *
     * @param a
     *            color to be mixed with this
     * @return mixed
     */
    public colorModel<Integer> mix(colorModel a) {
        colorModel<Integer> mixed = new colorModel<>();
        mixed.setRed((this.red + a.red) / 2);
        mixed.setGreen((this.green + a.green) / 2);
        mixed.setBlue((this.blue + a.blue) / 2);

        return mixed;
    }

    /**
     * finds the complementary color of this by subtracting 255 by all channel
     * values of this
     *
     * @return complement
     */
    public colorModel<Integer> complementary() {
        colorModel<Integer> complement = new colorModel<>();
        complement.setRed(this.max - this.red);
        complement.setGreen(this.max - this.green);
        complement.setBlue(this.max - this.blue);
        return complement;
    }

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        colorModel<Integer> color1 = new colorModel<>();
        color1.setRed(50);
        out.print("color 1: ");
        color1.printColor();
        out.println();

        colorModel<Integer> color2 = new colorModel<>();
        color2.setBlue(70);
        color2.setGreen(100);
        out.print("color 2: ");
        color2.printColor();
        out.println();

        colorModel<Integer> mixExample = color1.mix(color2);
        out.print("colors 1 and 2 mixed: ");
        mixExample.printColor();
        out.println();

        colorModel<Integer> white = new colorModel<>();
        white.toWhite();
        out.print("white: ");
        white.printColor();
        out.println();

        colorModel<Integer> color3 = new colorModel<>();
        color3.setRed(150);
        color3.setGreen(16);
        color3.setBlue(85);
        colorModel<Integer> complement = color3.complementary();
        out.print("color 3: ");
        color3.printColor();
        out.println();
        out.print("color 3's complement: ");
        complement.printColor();
        out.println();

    }
}
