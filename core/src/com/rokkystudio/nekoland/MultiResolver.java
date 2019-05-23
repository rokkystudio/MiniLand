package com.rokkystudio.nekoland;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.assets.loaders.PixmapLoader;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.assets.loaders.SoundLoader;
import com.badlogic.gdx.assets.loaders.TextureAtlasLoader;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

class MultiResolver extends InternalFileHandleResolver implements AssetErrorListener
{
    private AssetManager manager;

    public MultiResolver() {
        manager = new AssetManager();
        manager.setErrorListener(this);
        //manager.setLoader(BitmapFont.class, new BitmapFontLoader(new MultiResolver()));
        //manager.setLoader(Music.class, new MusicLoader(new MultiResolver()));
        //manager.setLoader(Pixmap.class, new PixmapLoader(new MultiResolver()));
        //manager.setLoader(Sound.class, new SoundLoader(new MultiResolver()));
        //manager.setLoader(TextureAtlas.class, new TextureAtlasLoader(new MultiResolver()));
        manager.setLoader(Texture.class, new TextureLoader(new MultiResolver()));
        manager.setLoader(Skin.class, new SkinLoader(new MultiResolver()));
        //manager.setLoader(OrthogonalTiledMapRenderer.class, new TilesetLoader(new MultiResolver()));
    }

    @Override
    public FileHandle resolve (String fileName)
    {
        if (Gdx.app.getType() != Application.ApplicationType.Android) {
            if (!fileName.startsWith("assets/")) {
                fileName = "assets/" + fileName;
            }
        }
        return super.resolve(fileName);
    }

    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        //Gdx.app.error("RESOURCE", "Problem with file " + fileName + " class " + type + " " + throwable);
    }
}