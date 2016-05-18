package musics;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicManager {

	public static Media getMedia(String resource) {
        return new Media(MusicManager.class.getResource(resource).toString());
    }
    
    public static MediaPlayer getMediaPlayer(String image) {
        return new MediaPlayer(getMedia(image));
    }
}
