package ca.pokeyone.tictactoe.states;

import ca.pokeyone.tictactoe.Constants;
import ca.pokeyone.tictactoe.resources.ResourceHandler;
import ca.pokeyone.tictactoe.resources.sound.SoundPlayer;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Date;

/**
 * Simply displays logo and loads all needed assets into memory
 */
public class StateLoading extends State{

    private ArrayList<String> images = new ArrayList<>();
    private Date date;

    public StateLoading(){
        super("Loading State");
    }

    @Override
    public void onLoad(){
        date = new Date();

        images.add(Constants.IMAGE_LOGO);
        images.add(Constants.IMAGE_TITLE);
    }

    @Override
    public void onUnload(){

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        BufferedImage image = ResourceHandler.getImage(Constants.IMAGE_LOGO);
        int width = 600, height = 600;
        if(image != null) {
            g.drawImage(image, Constants.WIDTH / 2 - width / 2, Constants.HEIGHT / 2 - height / 2, width, height, null);
        }else{
            System.out.println("Logo is still null");
        }
    }

    @Override
    public void tick() {
        //load new image every tick
        if(!images.isEmpty()){
            ResourceHandler.loadImage(images.get(0));
            images.remove(0);
        }else{
            //change to to next state if longer than 5 seconds passed
            if(new Date().getTime() - date.getTime() >= 5000){
                SoundPlayer.playSound(Constants.SOUND_INIT);
                changeState(Constants.STATE_UID_MENU);
            }
        }
    }
}
