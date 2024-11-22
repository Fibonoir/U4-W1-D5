package mutlimedia.elements;

public class Video extends MultimediaElement {
    private int duration;
    private int volume;
    private int brightness;

    public Video(String title, int duration, int volume, int brightness) {
        super(title);
        this.duration = duration;
        this.volume = volume;
        this.brightness = brightness;
    }

    public void lowerVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    public void increaseVolume() {
        if (volume < 100) {
            volume++;
        }
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

    @Override
    public void play() {
        for (int i = 1; i <= duration; i++) {
            System.out.println("Playing " + getTitle() + " [Second " + i + "]: " +
                    "!".repeat(volume) + " " + "*".repeat(brightness));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void execute() {
        play();
    }

}
