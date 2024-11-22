package mutlimedia.elements;

import mutlimedia.interfaces.Playable;

public abstract class MultimediaElement implements Playable {
    private String title;

    public MultimediaElement(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();
}
