package com.demo;

import com.badlogic.gdx.ApplicationAdapter;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class DemoApplication extends ApplicationAdapter {
    @Override
    public void create() {
        try {
            WarpController warpController=new WarpController();
            warpController.connect("12345");
        }catch (Exception e){

        }

    }
}