package com.ppx.demo.jme.mytest;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import com.jme3.scene.plugins.fbx.FbxLoader;
import com.jme3.texture.Texture;

/**
 * @Author Shirley
 * @Date：2023/11/4
 * @Desc：
 */
public class AsheFbxDemo extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        //FBX model isn't using meters for world units. Scale could be incorrect.



        //    com.jme3.asset.AssetLoadException: No loader registered for type "fbx"  直接加载fbx文件会报错
        assetManager.registerLoader(FbxLoader.class, ".fbx");
        // 加载FBX文件
//        Spatial fbxModel = assetManager.loadModel("Models/Ashe/mesh_sshe_beautyshot.fbx");// 这个fbx文件只有200多k
        Spatial fbxModel = assetManager.loadModel("car/Five_Wheeler.fbx");

        // 创建一个带有纹理的材质
        Material material = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        //加了这两句场景会变暗，并且地板还是ashe的图
//        Texture textureGround = assetManager.loadTexture("Models/Ashe/ashe_grnd.png");
//        material.setTexture("NormalMap", textureGround);

        Texture texture = assetManager.loadTexture("car/Shuttle_Outside_Col.jpg");
        material.setTexture("DiffuseMap", texture);
        fbxModel.setMaterial(material);



        // 设置抗锯齿属性--不过看起来没得用
        material.getAdditionalRenderState().setFaceCullMode(RenderState.FaceCullMode.Off);
        material.getAdditionalRenderState().setWireframe(false);
        material.getAdditionalRenderState().setPolyOffset(1, 1);

        // 将模型添加到场景中   FBX model isn't using correct forward axis sign. Orientation could be incorrect
        rootNode.attachChild(fbxModel);
        fbxModel.scale(0.03f);
        fbxModel.center();

        cam.setLocation(new Vector3f(0.41600543f, 3.2057908f, 6.6927643f));
        cam.setRotation(new Quaternion(-0.00414816f, 0.9817784f, -0.18875499f, -0.021575727f));

        flyCam.setMoveSpeed(10);
        viewPort.setBackgroundColor(ColorRGBA.LightGray);

        // #1 导入模型
//        Spatial model = assetManager.loadModel("Models/Ashe/freigther_bi_export_obj.obj");
//        model.scale(0.3f);// 按比例缩小
//        model.center();// 将模型的中心移到原点

        // #2 创造光源

        // 定向光
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-1, -2, -3));

        // 环境光
        AmbientLight ambient = new AmbientLight();

        // 调整光照亮度
        ColorRGBA lightColor = new ColorRGBA();
        sun.setColor(lightColor.mult(0.6f));
        ambient.setColor(lightColor.mult(0.4f));

        // #3 将模型和光源添加到场景图中
//        rootNode.attachChild(model);
        rootNode.addLight(sun);
        rootNode.addLight(ambient);

        //TODO  加入fbx动画，按照vsCode中的步骤
        // Retrieve the AnimControl.
//        AnimControl animCtrl = fbxModel.getControl(AnimControl.class);
//        // Create an animation channel, by default assigned to all bones.
//        AnimChannel animChan = animCtrl.createChannel();
//        // Play an animation
//        animChan.setAnim("MyAnim");


        //警告 N-gon encountered, ignoring. The mesh may not appear correctly. Triangulate your model prior to export.
    }


}

