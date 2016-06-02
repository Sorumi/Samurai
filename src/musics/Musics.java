package musics;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Musics {
	public static boolean isBgMusic = true;
	public static boolean isEffectMusic = true; 
	
	private static final MediaPlayer THEME = MusicManager.getMediaPlayer("main/theme.mp3");
	private static final MediaPlayer BG1 = MusicManager.getMediaPlayer("main/bg1.mp3");
	private static final MediaPlayer BG2 = MusicManager.getMediaPlayer("main/bg2.mp3");
	private static final MediaPlayer BG3 = MusicManager.getMediaPlayer("main/bg3.mp3");
	private static final MediaPlayer BG4 = MusicManager.getMediaPlayer("main/bg4.mp3");
	private static final MediaPlayer BG5 = MusicManager.getMediaPlayer("main/bg5.mp3");
	private static final MediaPlayer SPEAR_ATTACK = MusicManager.getMediaPlayer("main/spear_attack.wav"); 
	private static final MediaPlayer SWORD_ATTACK = MusicManager.getMediaPlayer("main/sword_attack.mp3");
	private static final MediaPlayer BATTLEAX_ATTACK = MusicManager.getMediaPlayer("main/battleax_attack.wav");
	private static final MediaPlayer ARROW_ATTACK = MusicManager.getMediaPlayer("main/arrow_attack.wav");
	private static final MediaPlayer SHURIKEN_ATTACK = MusicManager.getMediaPlayer("main/shuriken_attack.mp3"); 
	private static final MediaPlayer CLICK = MusicManager.getMediaPlayer("main/click.wav"); 
	private static final MediaPlayer FOOTSTEP = MusicManager.getMediaPlayer("main/footstep.mp3");
	private static final MediaPlayer RAIN = MusicManager.getMediaPlayer("main/rain.mp3");
	private static final MediaPlayer VICTORY = MusicManager.getMediaPlayer("main/victory.mp3"); 
	private static final MediaPlayer ATTACKED = MusicManager.getMediaPlayer("main/attacked.wav"); 
	private static final MediaPlayer KILLED = MusicManager.getMediaPlayer("main/killed.wav");
	private static final MediaPlayer MONEY = MusicManager.getMediaPlayer("main/money.wav");
	private static final MediaPlayer[] bgMusic = {THEME, VICTORY, BG1, BG2, BG3, BG4, BG5};
	private static final MediaPlayer[] effectMusic = {RAIN, CLICK, FOOTSTEP, SPEAR_ATTACK, SWORD_ATTACK, BATTLEAX_ATTACK, SHURIKEN_ATTACK, ARROW_ATTACK, ATTACKED, KILLED, MONEY};  
	
	
	/*
	 * bg music
	 * 0: theme 
	 */ 
	public static void playBgMusic(int num){
		if(isBgMusic){
			stopBgMusic();
			bgMusic[num].play();
			bgMusic[num].setCycleCount(MediaPlayer.INDEFINITE);
		}
	}
	
	public static void stopBgMusic(){
		if(isBgMusic){
			for(int i=0;i<bgMusic.length;i++){ 
				bgMusic[i].stop();  
			}
		}
	}
	
	/*
	 * effect music
	 * 0: rain
	 * 1: click
	 * 2:footstep  
	 * 3:spear_attack
	 * 4:sword_attack
	 * 5:battleax_attack
	 * 6:shuriken_attack
	 * 7:arrow_attack
	 */
	public static void playEffectMusic(int num){
		if(isEffectMusic){
			effectMusic[num].seek(effectMusic[num].getStartTime());
			effectMusic[num].play();
		}
	}
	
	public static void stopEffectMusic(){
		if(isBgMusic){
			for(int i=0;i<effectMusic.length;i++){ 
				effectMusic[i].stop();  
			}
		}
	}
}
