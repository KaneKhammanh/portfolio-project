package components.ColorModel;

import components.standard.Standard;

/**
 * Color model Kernel component with primary methods.
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
 */

public interface ColorModelKernel extends Standard<ColorModel> {

    /**
     * A constant, with value 0, representing the minimum value of ColorModel
     * Channel.
     */
    int MIN = 0;

    /**
     * A constant, with value 255, representing the maximum value of ColorModel
     * Channel.
     */
    int MAX = 255;

    /**
     * Reports whether {@code k} is within the range of ColorModel Channel.
     *
     * @param k
     *            the {@code int} to update {@code this} to
     * @return true iff {@code 0 <= k <= 255}
     * @ensures inRange = (0 <= k <= 255)
     */
    boolean inRange(int k);

    /**
     * Sets the value of {@code this} red Channel to {@code k}, when
     * {@code 0 <= k <= 255}.
     *
     * @param k
     *            the new value of red Channel
     * @replaces this.redChannel
     * @requires 0<= k <= 255
     * @ensures this.redChannel = k
     */
    void setRed(int k);

    /**
     * Sets the value of {@code this} green Channel to {@code k}, when
     * {@code 0 <= k <= 255}.
     *
     * @param k
     *            the new value of green Channel
     * @replaces this.greenChannel
     * @requires 0<= k <= 255
     * @ensures this.greenChannel = k
     */
    void setGreen(int k);

    /**
     * Sets the value of {@code this} blue Channel to {@code k}, when
     * {@code 0 <= k <= 255}.
     *
     * @param k
     *            the new value of blue Channel
     * @replaces this.blueChannel
     * @requires 0<= k <= 255
     * @ensures this.blueChannel = k
     */
    void setBlue(int k);

    /**
     * returns the value in the red channel of {@code this}
     *
     * @return {@int red} value
     */
    int getRed();

    /**
     * returns the value in the green channel of {@code this}
     *
     * @return {@int green} value
     */
    int getGreen();

    /**
     * returns the value in the blue channel of {@code this}
     *
     * @return {@int blue} value
     */
    int getBlue();

}
