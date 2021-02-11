package com.flappy.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappy.game.FlappyDemo;

public class MenuState extends state {


    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {

        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playBtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
               gsm.set(new PlayState(gsm));
               dispose();
        }

    }

    @Override
    public void update(float dt) {
     handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0,0, FlappyDemo.WIDTH, FlappyDemo.HEIGHT);
        sb.draw(playBtn, (FlappyDemo.WIDTH/2) - (playBtn.getWidth()/2),FlappyDemo.HEIGHT/2 );
        sb.end();

    }
    @Override
    public void dispose() {
    background.dispose();
    playBtn.dispose();
    }
}
