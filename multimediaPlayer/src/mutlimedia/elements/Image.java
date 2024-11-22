package mutlimedia.elements;

public class Image extends MultimediaElement {

    private int brightness;

    public Image(String title, int brightness) {
        super(title);

        this.brightness = brightness;
    }

    public void lowerBrightness() {
        if (brightness > 0) {
            brightness--;
        }
    }

    public void increaseBrightness() {
        if (brightness < 100) {
            brightness++;
        }
    }

    public void show() {
        System.out.println("Showing " + getTitle() + " with brightness:" + "*".repeat(brightness));

    }

    @Override
    public void execute() {
        show();
    }

    @Override
    public void play() {
        System.out.println("This element cannot be played.");

    }
}
