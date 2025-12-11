package components.ColorModel;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code ColorModel} represented as {@code int[]} of cardinality 3, values
 * 0-255 with implementation of primary methods
 *
 * @convention <pre>
 * [$this.rep.length = 3] and
 * [all values of $this.rep are '0' through '255']
 * </pre>
 * @correspondence <pre>
 * this = [$this.rep[0] is red CHANNEL], [$this.rep[1] is green CHANNEL],
 * [$this.rep[2] is blue CHANNEL]
 * </pre>
 *
 * @mathsubtypes <pre>
 * CHANNEL is integer
 * exemplar n
 * constraints 0 <= n <= 255
 * </pre>
 * @mathmodel type ColorModelKernel is modeled by string of CHANNEL
 * @initially <pre>
 * ():
 *  ensures
 *      this = <0, 0, 0>
 * (int r):
 *  requires
 *      0 <= r <= 255
 *  ensures
 *      this = <r, 0, 0>
 * (int g):
 *  requires
 *      0 <= g <= 255
 *  ensures
 *      this = <0, g, 0>
 * (int b):
 *  requires
 *      0 <= b <= 255
 *  ensures
 *      this = <0, 0, b>
 * </pre>
 *
 * @author Kane Khammanh
 *
 */
public class ColorModel1 implements ColorModel {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private int[] rep;

    /**
     * A constant, with value 0, representing the minimum value of ColorModel
     * Channel.
     */
    private static final int MIN = 0;

    /**
     * A constant, with value 255, representing the maximum value of ColorModel
     * Channel.
     */
    private static final int MAX = 255;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        this.rep = new int[3];

    }

    /**
     * No-argument constructor.
     */
    public void ColorModel1() {
        this.createNewRep();
    }

    /**
     * Constructor from {@code int}.
     *
     * @param r
     *            {@code int} to initialize red channel from
     * @param g
     *            {@code int} to initialize green channel from
     * @param b
     *            {@code int} to initialize blue channel from
     */
    public void ColorModel1(int r, int g, int b) {
        this.createNewRep();

        this.rep[0] = r;
        this.rep[1] = g;
        this.rep[2] = b;
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final ColorModel newInstance() {
        ColorModel instance = new ColorModel1();
        return instance;
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(ColorModel source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";

        this.rep[0] = source.getRed();
        this.rep[1] = source.getGreen();
        this.rep[2] = source.getBlue();

        source.setRed(0);
        source.setGreen(0);
        source.setBlue(0);
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public boolean inRange(int k) {
        boolean isValid = true;

        if (k < 0 || k > 255) {
            isValid = false;
        }

        return isValid;
    }

    @Override
    public void setRed(int k) {
        assert this != null : "Violation of: this is not null";
        assert this.inRange(k) : "Violation of: k is in range 0-255";

        this.rep[0] = k;
    }

    @Override
    public void setGreen(int k) {
        assert this != null : "Violation of: this is not null";
        assert this.inRange(k) : "Violation of: k is in range 0-255";

        this.rep[1] = k;
    }

    @Override
    public void setBlue(int k) {
        assert this != null : "Violation of: this is not null";
        assert this.inRange(k) : "Violation of: k is in range 0-255";

        this.rep[2] = k;
    }

    @Override
    public int getRed() {
        assert this != null : "Violation of: this is not null";

        return this.rep[2];
    }

    @Override
    public int getGreen() {
        assert this != null : "Violation of: this is not null";

        return this.rep[2];
    }

    @Override
    public int getBlue() {
        assert this != null : "Violation of: this is not null";

        return this.rep[2];
    }

    /*
     * Secondary methods -------------------------------------------------------
     */
    @Override
    public void toWhite() {
        assert this != null : "Violation of: this is not null";

        this.setRed(this.MAX);
        this.setGreen(this.MAX);
        this.setBlue(this.MAX);
    }

    @Override
    public ColorModel mix(ColorModel b) {
        assert this != null : "Violation of: this is not null";
        assert b != null : "Violation of: b is not null";

        ColorModel mixed = new ColorModel1();

        mixed.setRed((this.getRed() + b.getRed()) / 2);
        mixed.setGreen((this.getGreen() + b.getGreen()) / 2);
        mixed.setBlue((this.getBlue() + b.getBlue()) / 2);

        return mixed;
    }

    @Override
    public ColorModel complementary() {
        assert this != null : "Violation of: this is not null";

        ColorModel complement = new ColorModel1();

        complement.setRed(this.MAX - this.getRed());
        complement.setGreen(this.MAX - this.getGreen());
        complement.setBlue(this.MAX - this.getBlue());

        return complement;
    }

    @Override
    public Sequence<ColorModel> monochromatic(int lockedChannel,
            int intensity) {
        assert this != null : "Violation of: this is not null";
        assert lockedChannel >= 0
                && lockedChannel <= 2 : "Violation of: lockedChannel is not a valid color channel";
        if (lockedChannel == 0) {
            assert this.getGreen() - intensity >= this.MIN
                    && intensity <= this.MAX - this
                            .getGreen() : "Violation of: Intensity reaches outside of range 0-255 for green channel";
            assert this.getBlue() - intensity >= this.MIN
                    && intensity <= this.MAX - this
                            .getBlue() : "Violation of: Intensity reaches outside of range 0-255 for blue channel";
        }
        if (lockedChannel == 1) {
            assert this.getRed() - intensity >= this.MIN
                    && intensity <= this.MAX - this
                            .getRed() : "Violation of: Intensity reaches outside of range 0-255 for red channel";
            assert this.getBlue() - intensity >= this.MIN
                    && intensity <= this.MAX - this
                            .getBlue() : "Violation of: Intensity reaches outside of range 0-255 for blue channel";
        }
        if (lockedChannel == 2) {
            assert this.getRed() - intensity >= this.MIN
                    && intensity <= this.MAX - this
                            .getRed() : "Violation of: Intensity reaches outside of range 0-255 for red channel";
            assert this.getGreen() - intensity >= this.MIN
                    && intensity <= this.MAX - this
                            .getGreen() : "Violation of: Intensity reaches outside of range 0-255 for green channel";
        }

        Sequence<ColorModel> palette = new Sequence1L<>();
        ColorModel color1 = new ColorModel1();
        ColorModel color2 = new ColorModel1();

        switch (lockedChannel) {
            case 0:
                color1.setGreen(this.getGreen() - intensity);
                color1.setBlue(this.getBlue() - intensity);

                color2.setGreen(this.getGreen() + intensity);
                color2.setBlue(this.getBlue() + intensity);
                break;

            case 1:
                color1.setRed(this.getRed() - intensity);
                color1.setBlue(this.getBlue() - intensity);

                color2.setRed(this.getRed() + intensity);
                color2.setBlue(this.getBlue() + intensity);
                break;

            case 2:
                color1.setRed(this.getRed() - intensity);
                color1.setGreen(this.getGreen() - intensity);

                color2.setRed(this.getRed() + intensity);
                color2.setGreen(this.getGreen() + intensity);
                break;

            default:
                break;
        }

        palette.add(0, color1);
        palette.add(1, this);
        palette.add(2, color2);

        return palette;
    }

}
