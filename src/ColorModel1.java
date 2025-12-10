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

        this.rep[0] = source.rep[0];
        this.rep[1] = source.rep[1];
        this.rep[2] = source.rep[2];
        source.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    boolean inRange(int k) {
        boolean isValid = true;

        if (k < 0 || k > 255) {
            isValid = false;
        }

        return isValid;
    }

    @Override
    void setRed(int k) {
        assert this != null : "Violation of: this is not null";
        assert this.inRange(k) : "Violation of: k is in range 0-255";

        this.rep[0] = k;
    }

    @Override
    void setGreen(int k) {
        assert this != null : "Violation of: this is not null";
        assert this.inRange(k) : "Violation of: k is in range 0-255";

        this.rep[1] = k;
    }

    @Override
    void setBlue(int k) {
        assert this != null : "Violation of: this is not null";
        assert this.inRange(k) : "Violation of: k is in range 0-255";

        this.rep[2] = k;
    }

}
