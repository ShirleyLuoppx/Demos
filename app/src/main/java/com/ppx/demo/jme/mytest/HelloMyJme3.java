package com.ppx.demo.jme.mytest;

import com.jme3.app.SimpleApplication;
import com.ppx.demo.jme.jme3test.helloworld.HelloJME3;

/**
 * @Author Shirley
 * @Date：2023/11/3
 * @Desc：
 */
public class HelloMyJme3 extends SimpleApplication {

    @Override
    public void simpleInitApp() {

    }

    public static void main(String[] args) {
        // 启动jME3程序
        HelloJME3 app = new HelloJME3();
        app.start();

    }
}

