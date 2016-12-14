package ca.pokeyone.tictactoe.resources.sound;

import ca.pokeyone.tictactoe.Constants;
import ca.pokeyone.tictactoe.resources.ResourceHandler;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Provides static methods for playing sounds. Should not be initialized
 */
public class SoundPlayer {

    /**
     * Should not be used. Warns user to not use it.
     */
    @Deprecated
    public SoundPlayer(){
        System.out.println("SoundPlayer should not be initialized. Everything is static!");
    }

    /**
     * Plays a sound based on UID provided
     * @param soundID The UID of the sound to play
     */
    public static synchronized void playSound(long soundID){
        if(soundID != Constants.SOUND_NONE) {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ResourceHandler.getAudioStream(soundID));
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
