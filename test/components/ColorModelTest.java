package components;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code ColorModel}'s constructor and kernel methods.
 *
 * @author Put your name here
 *
 */
public abstract class ColorModel1Test {

    @Test
    public final void testConstructor() {
        ColorModel s = new ColorModel1L();

        assert s != null;

        assertEquals(s.getRed(), 0);
        assertEquals(s.getGreen(), 0);
        assertEquals(s.getBlue(), 0);
    }

    @Test
    public final void testConstructorFromArgs0() {
        ColorModel s = new ColorModel1(0, 0, 0);
        ColorModel sExpected = new ColorModel1();

        assert s != null;

        assertEquals(s, sExpected);
    }

    @Test
    public final void testConstructorFromArgs10_20_30() {
        ColorModel s = new ColorModel1(10, 20, 30);
        ColorModel sExpected = new ColorModel1();

        sExpected.setRed(10);
        sExpected.setGreen(20);
        sExpected.setBlue(30);

        assert s != null;

        assertEquals(s, sExpected);
    }

    @Test
    public final void testInRange0() {
        int value = 0;
        ColorModel s = new ColorModel1();
        boolean isInRange = s.inRange(value);

        assertEquals(isInRange, true);
    }

    @Test
    public final void testInRangeTrue() {
        int value = 50;
        ColorModel s = new ColorModel1();
        boolean isInRange = s.inRange(value);

        assertEquals(isInRange, true);
    }

    @Test
    public final void testInRange255() {
        int value = 255;
        ColorModel s = new ColorModel1();
        boolean isInRange = s.inRange(value);

        assertEquals(isInRange, true);
    }

    @Test
    public final void testInRangeFalse() {
        int value = 256;
        ColorModel s = new ColorModel1();
        boolean isInRange = s.inRange(value);

        ColorModel sExpected = new ColorModel1();

        assertEquals(isInRange, true);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testGetRed() {
        int value = 30;
        ColorModel s = new ColorModel1(value, 0, 0);
        ColorModel sExpected = new ColorModel1(value, 0, 0);

        int redVal = s.getRed();

        assertEquals(redVal, value);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testGetGreen() {
        int value = 30;
        ColorModel s = new ColorModel1(0, value, 0);
        ColorModel sExpected = new ColorModel1(0, value, 0);

        int greenVal = s.getGreen();

        assertEquals(greenVal, value);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testGetBlue() {
        int value = 30;
        ColorModel s = new ColorModel1(0, 0, value);
        ColorModel sExpected = new ColorModel1(0, 0, value);

        int blueVal = s.getRed();

        assertEquals(blueVal, value);
        assertEquals(s, sExpected);
    }

    @Test
    public final void testSetRed() {
        int value = 30;
        ColorModel s = new ColorModel1();
        ColorModel sExpected = new ColorModel1(value, 0, 0);

        s.setRed(value);

        assertEquals(s.getRed(), sExpected.getRed());
        assertEquals(s, sExpected);
    }

    @Test
    public final void testSetGreen() {
        int value = 30;
        ColorModel s = new ColorModel1();
        ColorModel sExpected = new ColorModel1(0, value, 0);

        s.setGreen(value);

        assertEquals(s.getGreen(), sExpected.getGreen());
        assertEquals(s, sExpected);
    }

    @Test
    public final void testSetBlue() {
        int value = 30;
        ColorModel s = new ColorModel1();
        ColorModel sExpected = new ColorModel1(0, 0, value);

        s.setBlue(value);

        assertEquals(s.getBlue(), sExpected.getBlue());
        assertEquals(s, sExpected);
    }

}
