import components.sequence.Sequence;

/**
 * {@code ColorModelKernel} enhanced with secondary methods.
 */
public interface ColorModel extends ColorModelKernel {

    /**
     * Sets the value of {@code this} to <Channel.MAX, Channel.MAX,
     * Channel.MAX>.
     *
     * @replaces this
     * @requires this != null
     * @ensures this = <255, 255, 255>
     */
    void toWhite();

    /**
     * Returns the average values of {@code this} and {@code b}.
     *
     * @param b
     *            the ColorModel to be "mixed" with {@code this}
     *
     * @return the average color between this and b
     * @requires this != null && b!= null
     * @ensures average = <(this.red + b.red) / 2, (this.green + b.green) / 2,
     *          (this.blue + b.blue) / 2>
     */
    ColorModel mix(ColorModel b);

    /**
     * Returns the complementary ColorModel of {@code this}.
     *
     * @return the complementary ColorModel of this
     * @requires this != null
     * @ensures complementary = <(Channel.MAX - this.red), (Channel.MAX -
     *          this.green), (Channel.MAX - this.blue)>
     */
    ColorModel complementary();

    /**
     * Returns a sequence of 3 ColorModels with {@code this} in the middle and
     * two monochromatic ColorModels adjacent to {@code this}.
     *
     * @param lockedChannel
     *            int value 0-2 representing one of the color Channels red,
     *            green, or blue of {@code this}, which will remain unchanged
     * @param intensity
     *            the variation between {@code this} and the two monochromatic
     *            colors
     *
     * @return a monochromatic color palette of 3 ColorModels, with this in the
     *         middle
     * @requires this.Channel - intensity >= Channel.MIN && intensity <=
     *           Channel.MAX - this.Channel for all non-locked Channels
     * @ensures this.lockedChannel = #this.lockedChannel for all returned
     *          ColorModels && this.non-lockedChannels = this.Channel +/-
     *          intensity for both monochromatic ColorModels
     */
    Sequence<ColorModel> monochromatic(int lockedChannel, int intensity);
}
