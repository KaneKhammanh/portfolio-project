package components;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * JUnit test fixture for {@code ColorModel1}'s secondary methods.
 *
 * @author Put your name here
 *
 */
public abstract class ColorModel1Test {

    @Test
    public final void testToWhite0() {
        ColorModel s = new ColorModel1();
        ColorModel sExpected = new ColorModel1(255, 255, 255);

        s.toWhite();

        assert s != null;

        assertEquals(s, sExpected);
    }

    @Test
    public final void testToWhiteArbitrary() {
        ColorModel s = new ColorModel1(100, 50, 7);
        ColorModel sExpected = new ColorModel1(255, 255, 255);

        s.toWhite();

        assert s != null;

        assertEquals(s, sExpected);
    }

    @Test
    public final void testToWhite255() {
        ColorModel s = new ColorModel1(255, 255, 255);
        ColorModel sExpected = new ColorModel1(255, 255, 255);

        s.toWhite();

        assert s != null;

        assertEquals(s, sExpected);
    }

    @Test
    public final void testMix0() {
        ColorModel s1 = new ColorModel1(0, 0, 0);
        ColorModel s2 = new ColorModel1(0, 0, 0);
        ColorModel sExpected = new ColorModel1(0, 0, 0);

        ColorModel result = s1.mix(s2);

        assert s1 != null;
        assert s2 != null;

        assertEquals(result, sExpected);
        assertEquals(s1, sExpected);
        assertEquals(s2, sExpected);
    }

    @Test
    public final void testMix255() {
        ColorModel s1 = new ColorModel1(255, 255, 255);
        ColorModel s2 = new ColorModel1(255, 255, 255);
        ColorModel sExpected = new ColorModel1(255, 255, 255);

        ColorModel result = s1.mix(s2);

        assert s1 != null;
        assert s2 != null;

        assertEquals(result, sExpected);
        assertEquals(s1, sExpected);
        assertEquals(s2, sExpected);
    }

    @Test
    public final void testMixArbitrary() {
        ColorModel s1 = new ColorModel1(50, 90, 200);
        ColorModel s2 = new ColorModel1(30, 160, 40);
        ColorModel sExpected = new ColorModel1(40, 125, 240);

        ColorModel s1Expected = new ColorModel1(50, 90, 200);
        ColorModel s2Expected = new ColorModel1(30, 160, 40);

        ColorModel result = s1.mix(s2);

        assert s1 != null;
        assert s2 != null;

        assertEquals(result, sExpected);
        assertEquals(s1, s1Expected);
        assertEquals(s2, s2Expected);
    }

    @Test
    public final void testComplementary0() {
        ColorModel s = new ColorModel1(0, 0, 0);
        ColorModel sExpected = new ColorModel1(0, 0, 0);

        ColorModel result = s.complementary();
        ColorModel resultExpected = new ColorModel1(255, 255, 255);

        assertEquals(result, resultExpected);
        assertEquals(s, sExpected);

    }

    @Test
    public final void testComplementary255() {
        ColorModel s = new ColorModel1(255, 255, 255);
        ColorModel sExpected = new ColorModel1(255, 255, 255);

        ColorModel result = s.complementary();
        ColorModel resultExpected = new ColorModel1(0, 0, 0);

        assertEquals(result, resultExpected);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testComplementaryArbitrary() {
        ColorModel s = new ColorModel1(55, 150, 90);
        ColorModel sExpected = new ColorModel1(55, 150, 90);
        ColorModel result = s.complementary();
        ColorModel resultExpected = new ColorModel1(200, 105, 165);

        assertEquals(result, resultExpected);
        assertEquals(s, sExpected);

    }

    @Test
    public final void testMonochromaticChannel1() {
        ColorModel s = new ColorModel1(120, 120, 120);
        ColorModel sExpected = new ColorModel1(120, 120, 120);

        Sequence<ColorModel> result = s.monochromatic(0, 40);

        ColorModel lower = result.entry(0);
        ColorModel lowerExpected = new ColorModel1(120, 80, 80);

        ColorModel upper = result.entry(2);
        ColorModel upperExpected = new ColorModel1(120, 160, 160);

        assertEquals(s, sExpected);
        assertEquals(lower, lowerExpected);
        assertEquals(upper, upperExpected);

    }

    @Test
    public final void testMonochromaticChannel2() {
        ColorModel s = new ColorModel1(80, 80, 80);
        ColorModel sExpected = new ColorModel1(80, 80, 80);

        Sequence<ColorModel> result = s.monochromatic(1, 60);

        ColorModel lower = result.entry(0);
        ColorModel lowerExpected = new ColorModel1(20, 80, 20);

        ColorModel upper = result.entry(2);
        ColorModel upperExpected = new ColorModel1(140, 80, 140);

        assertEquals(s, sExpected);
        assertEquals(lower, lowerExpected);
        assertEquals(upper, upperExpected);
    }

    @Test
    public final void testMonochromaticChannel3() {
        ColorModel s = new ColorModel1(100, 100, 100);
        ColorModel sExpected = new ColorModel1(100, 100, 100);

        Sequence<ColorModel> result = s.monochromatic(2, 100);

        ColorModel lower = result.entry(0);
        ColorModel lowerExpected = new ColorModel1(0, 0, 100);

        ColorModel upper = result.entry(2);
        ColorModel upperExpected = new ColorModel1(200, 200, 100);

        assertEquals(s, sExpected);
        assertEquals(lower, lowerExpected);
        assertEquals(upper, upperExpected);
    }

    @Test
    public final void testToString() {
        ColorModel s = new ColorModel1(100, 50, 0);
        ColorModel sExpected = new ColorModel1(100, 50, 0);

        String result = s.toString();
        String expected = "100, 50, 0";

        assertEquals(s, sExpected);
        assert (result.equals(expected));
    }

    @Test
    public final void testEquals0() {
        int red = 0;
        int green = 0;
        int blue = 0;

        ColorModel s = new ColorModel1(red, green, blue);
        ColorModel sExpected = new ColorModel1(red, green, blue);

        assert (s.equals(sExpected));
        assertEquals(s.getRed(), red);
        assertEquals(s.getGreen(), green);
        assertEquals(s.getBlue(), blue);

    }

    @Test
    public final void testEquals255() {
        int red = 255;
        int green = 255;
        int blue = 255;

        ColorModel s = new ColorModel1(red, green, blue);
        ColorModel sExpected = new ColorModel1(red, green, blue);

        assert (s.equals(sExpected));
        assertEquals(s.getRed(), red);
        assertEquals(s.getGreen(), green);
        assertEquals(s.getBlue(), blue);
    }

    @Test
    public final void testEqualsArbitrary() {
        int red = 120;
        int green = 10;
        int blue = 99;

        ColorModel s = new ColorModel1(red, green, blue);
        ColorModel sExpected = new ColorModel1(red, green, blue);

        assert (s.equals(sExpected));
        assertEquals(s.getRed(), red);
        assertEquals(s.getGreen(), green);
        assertEquals(s.getBlue(), blue);
    }

}
