package com.rokkystudio.nekoland;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Level extends GameObject
{
    private int mLevelWidth  = 64; // tiles
    private int mLevelHeight = 64; // tiles
    private int mTileWidth   = 32; // pixels
    private int mTileHeight  = 32; // pixels

    private int[][] mTiles = new int[mLevelWidth][mLevelHeight];

    public void Chank() {

    }

    @Override
    public void render()
    {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.identity();

        //shapeRenderer.translate(20, 12, 2);

        for (int y = 0; y < mLevelHeight; y++) {
            for (int x = 0; x < mLevelWidth; x++) {
                //shapeRenderer.setColor((float) Math.random(), (float) Math.random(), (float) Math.random(), 1);
                float color = (float) Math.random();
                shapeRenderer.setColor(color, color, color, 1);
                shapeRenderer.rect(x * mTileWidth, y * mTileHeight, x * (mTileWidth + 1), y * (mTileHeight + 1));
            }
        }

        shapeRenderer.end();
    }
}
