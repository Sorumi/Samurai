package musics;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Musics {
	private static boolean isBgMusic = true;
	private static boolean isEffectMusic = true;  
	public static final MediaPlayer THEME = MusicManager.getMediaPlayer("main/theme.mp3");
	public static final MediaPlayer BOW_ATTACK = MusicManager.getMediaPlayer("main/bow_attack.mp3");
	public static final MediaPlayer SWORD_ATTACK = MusicManager.getMediaPlayer("main/sword_attack.mp3");
	public static final MediaPlayer CLICK = MusicManager.getMediaPlayer("main/click.mp3");
	public static final MediaPlayer FOOTSTEP = MusicManager.getMediaPlayer("main/footstep.mp3");
	public static final MediaPlayer RAIN = MusicManager.getMediaPlayer("main/rain.mp3"); 
	public static final MediaPlayer[] bgMusic = {THEME};
	public static final MediaPlayer[] effectMusic = {RAIN, CLICK}; 
	
	//0是雨声，1是按键声
	public static void playBgMusic(int num){
		if(isBgMusic){
			for(int i=0;i<bgMusic.length;i++){
				bgMusic[i].stop();  
			}
			bgMusic[num].play();
			bgMusic[num].setCycleCount(MediaPlayer.INDEFINITE);
		}
	}
	
	public static void playEffectMusic(int num){
		if(isEffectMusic){
			effectMusic[num].play(); 
		}
	}
	
	
}
