package com.flappy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.GL20;
import com.flappy.game.States.GameStateManager;
import com.flappy.game.States.MenuState;

public class FlappyDemo extends ApplicationAdapter {
	public static final int WIDTH =480;
	public static final int HEIGHT =800;

	public static final String TITLE = "Flappy Bird";
	private GameStateManager gsm;

	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm =new GameStateManager();
		ScreenUtils.clear(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
