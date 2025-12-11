import components.ColorModel.ColorModel;

public class ChristmasLights {

    /**
     * Private members
     */
    private ColorModel[] lights;

    private boolean isOn = false;

    private int length;

    private enum Mode {
        COOL_WHITE, WARM_WHITE, RED_GREEN, MULTICOLOR
    }

    private Mode lightMode = Mode.COOL_WHITE;

    /**
     * Constructor
     */
    public ChristmasLights(int length) {
        assert (length > 0);

        this.length = length;
        this.isOn = false;
        this.lightMode = Mode.COOL_WHITE;

        this.lights = new ColorModel[length];

        for (int i = 0; i < length; i++) {
            this.lights[i] = new ColorModel(230, 230, 255);
        }
    }

    /**
     * public methods
     */
    public void togglePower() {
        if (this.isOn) {
            this.isOn = false;
            System.out.println("Lights have been turned off.");
        } else {
            this.isOn = true;
            System.out.println("Lights have been turned on!");
        }
    }

    public void toggleMode() {
        switch (this.lightMode) {

            //Sets all lights to white with a warm yellow glow
            case COOL_WHITE:
                this.lightMode = Mode.WARM_WHITE;

                for (int i = 0; i < this.length; i++) {
                    this.lights[i] = new ColorModel(255, 255, 200);
                }

                System.out.println("Switched to warm white light mode.");
                if (this.isOn) {
                    System.out
                            .println("Lights are shining a bright warm white!");
                }
                break;

            //Sets all lights to alternate between red and green
            case WARM_WHITE:
                this.lightMode = Mode.RED_GREEN;

                for (int i = 0; i < this.length; i++) {
                    if (i % 2 == 0) {
                        this.lights[i] = new ColorModel(255, 0, 0);
                    } else {
                        this.lights[i] = new ColorModel(0, 255, 0);
                    }
                }

                System.out.println("Switched to red-green light mode.");
                if (this.isOn) {
                    System.out.println(
                            "Lights are shining a bright red and green!");
                }
                break;

            //Sets all lights to a red, yellow, green, blue pattern
            case RED_GREEN:
                this.lightMode = Mode.MULTICOLOR;

                for (int i = 0; i < this.length; i++) {
                    if (i % 4 == 0) {
                        this.lights[i] = new ColorModel(255, 0, 0);
                    } else if (i % 4 == 1) {
                        this.lights[i] = new ColorModel(255, 255, 0);
                    } else if (i % 4 == 2) {
                        this.lights[i] = new ColorModel(0, 255, 0);
                    } else if (i % 4 == 3) {
                        this.lights[i] = new ColorModel(0, 0, 255);
                    }
                }

                System.out.println("Switched to multicolor light mode.");
                if (this.isOn) {
                    System.out.println(
                            "Lights are shining red, yellow, green, and blue!");
                }
                break;

            //Sets all lights to white with a cool blue glow
            case MULTICOLOR:
                this.lightMode = Mode.COOL_WHITE;

                for (int i = 0; i < this.length; i++) {
                    this.lights[i] = new ColorModel(230, 230, 255);
                }

                System.out.println("Switched to cool white light mode.");
                if (this.isOn) {
                    System.out.println("Lights are shining a cool white!");
                }
                break;
        }

    }

    public static void main(String[] args) {
        ChristmasLights test1 = new ChristmasLights(10);

        test1.togglePower();
        test1.toggleMode();
        test1.toggleMode();

        ChristmasLights test2 = new ChristmasLights(30);
        test2.toggleMode();
        test2.toggleMode();
        test2.togglePower();
        test2.toggleMode();
        test2.toggleMode();
    }
}
