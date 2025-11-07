import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.standard.Standard;

public abstract class ColorModelSecondary implements Standard<ColorModel> {

    private final int min = 0;
    private final int max = 255;

    @Override
    public void toWhite() {
        assert this != null : "Violation of: this is not null";

        this.setRed(this.max);
        this.setGreen(this.max);
        this.setBlue(this.max);
    }

    @Override
    public ColorModel mix(ColorModel b) {
        assert this != null : "Violation of: this is not null";
        assert b != null : "Violation of: b is not null";

        ColorModel mixed = new ColorModel1L();

        mixed.setRed((this.getRed() + b.getRed()) / 2);
        mixed.setGreen((this.getGreen() + b.getGreen()) / 2);
        mixed.setBlue((this.getBlue() + b.getBlue()) / 2);

        return mixed;
    }

    @Override
    public ColorModel complementary(ColorModel b) {
        assert this != null : "Violation of: this is not null";
        assert b != null : "Violation of: b is not null";

        ColorModel complement = new ColorModel1L();

        complement.setRed(this.max - this.getRed());
        complement.setGreen(this.max - this.getGreen());
        complement.setBlue(this.max - this.getBlue());

        return complement;
    }

    @Override
    public Sequence<ColorModel> monochromatic(int lockedChannel,
            int intensity) {
        assert this != null : "Violation of: this is not null";
        assert lockedChannel >= 0
                && lockedChannel <= 2 : "Violation of: lockedChannel is not a valid color channel";
        if (lockedChannel == 0) {
            assert this.getGreen() - intensity >= this.min
                    && intensity <= this.max - this
                            .getGreen() : "Violation of: Intensity reaches outside of range 0-255 for green channel";
            assert this.getBlue() - intensity >= this.min
                    && intensity <= this.max - this
                            .getBlue() : "Violation of: Intensity reaches outside of range 0-255 for blue channel";
        }
        if (lockedChannel == 1) {
            assert this.getRed() - intensity >= this.min
                    && intensity <= this.max - this
                            .getRed() : "Violation of: Intensity reaches outside of range 0-255 for red channel";
            assert this.getBlue() - intensity >= this.min
                    && intensity <= this.max - this
                            .getBlue() : "Violation of: Intensity reaches outside of range 0-255 for blue channel";
        }
        if (lockedChannel == 2) {
            assert this.getRed() - intensity >= this.min
                    && intensity <= this.max - this
                            .getRed() : "Violation of: Intensity reaches outside of range 0-255 for red channel";
            assert this.getGreen() - intensity >= this.min
                    && intensity <= this.max - this
                            .getGreen() : "Violation of: Intensity reaches outside of range 0-255 for green channel";
        }

        Sequence<ColorModel> palette = new Sequence1L<>();
        ColorModel color1 = new ColorModel1L();
        ColorModel color2 = new ColorModel1L();

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

    @Override
    public String toString() {
        assert this != null : "Violation of: this is not null";

        return this.getRed() + ", " + this.getGreen() + ", " + this.getBlue();
    }

    @Override
    public boolean equals(ColorModel b) {
        assert this != null : "Violation of: this is not null";
        assert b != null : "Violation of: b is not null";

        boolean isEqual = true;

        if (this.getRed() != b.getRed()) {
            isEqual = false;
        } else if (this.getGreen() != b.getGreen()) {
            isEqual = false;
        } else if (this.getBlue() != b.getBlue()) {
            isEqual = false;
        }

        return isEqual;

    }

}