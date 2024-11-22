package mutlimedia.elements;

public class AudioRecording extends MultimediaElement {
    private int duration;
    private int volume;

    public AudioRecording(String title, int duration, int volume) {
        super(title);
        this.duration = duration;
        this.volume = volume;
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

    @Override
    public void play() {
        for (int i = 1; i <= duration; i++) {
            System.out.println("Playing " + getTitle() + " [Second " + i + "]: " + "!".repeat(volume));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void execute() {
        play();
    }
}
