package com.rokkystudio.nekoland;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject
{
    public Vector2 position = new Vector2();
    public Rectangle bounds = new Rectangle();

    public abstract void render();
}
