package com.rokkystudio.nekoland;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class MapGenerator
{
    private TiledMap mTiledMap;
    private MapLayers mMapLayers;

    public MapGenerator(int hash)
    {
        TiledMapTileSet tileset = new TiledMapTileSet();
        //TmxMapLoader

        mTiledMap = new TiledMap();
        mMapLayers = mTiledMap.getLayers();

        MapLayer terrainLayer = new MapLayer();
        terrainLayer.setName("TERRAIN");

        MapObjects terrainObjects = terrainLayer.getObjects();
        //terrainObjects.add();

        mMapLayers.add(terrainLayer);
    }
}
