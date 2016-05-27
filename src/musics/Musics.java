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
	public static final MediaPlayer VICTORY = MusicManager.getMediaPlayer("main/Coeur De Pirate-Victory.mp3"); 
	public static final MediaPlayer[] bgMusic = {THEME};
	public static final MediaPlayer[] effectMusic = {RAIN, CLICK, FOOTSTEP, BOW_ATTACK, SWORD_ATTACK, VICTORY}; 
	
	/*
	 * bg music
	 * 0: theme 
	 */
	public static void playBgMusic(int num){
		if(isBgMusic){
			for(int i=0;i<bgMusic.length;i++){
				bgMusic[i].stop();  
			}
			bgMusic[num].play();
			bgMusic[num].setCycleCount(MediaPlayer.INDEFINITE);
		}
	}
	
	/*
	 * effect music
	 * 0: rain
	 * 1: click
	 * 2:footstep 
	 * 3:bow_attack
	 * 4:sword_attack
	 * 5:victory 
	 */
	public static void playEffectMusic(int num){
		if(isEffectMusic){
			effectMusic[num].seek(effectMusic[num].getStartTime());
			effectMusic[num].play();
		}
	}
	
	
}
