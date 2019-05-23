package com.rokkystudio.nekoland;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;

public class Main extends ApplicationAdapter implements InputProcessor
{
    TiledMap mMapWorld;
    OrthographicCamera mMainCamera;
    TiledMapRenderer mMapWorldRenderer;
    Level chank = new Level();

    @Override
    public void create()
    {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        mMainCamera = new OrthographicCamera();
        mMainCamera.setToOrtho(false, width, height);
        mMainCamera.update();
        //mMapWorld = new TmxMapLoader().load("map.tmx");
        //mMapWorldRenderer = new OrthogonalTiledMapRenderer(mMapWorld);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            mMainCamera.translate(-3, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            mMainCamera.translate(3, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            mMainCamera.translate(0, -3);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            mMainCamera.translate(0, 3);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mMainCamera.update();
        chank.render();
        //mMapWorldRenderer.setView(mMainCamera);
        //mMapWorldRenderer.render();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.NUM_1)
            mMapWorld.getLayers().get(0).setVisible(!mMapWorld.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            mMapWorld.getLayers().get(1).setVisible(!mMapWorld.getLayers().get(1).isVisible());
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
