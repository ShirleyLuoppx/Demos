package com.ppx.demo.rajawali;

import com.ppx.demo.BaseActivity;
import com.ppx.demo.R;

/**
 * @Author Shirley
 * @Date：2023/10/20
 * @Desc：
 */
public class RajawaliActivity extends BaseActivity {

    @Override
    public void initView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_rajawali, new SkeletalAnimationBlendingFragment()).commit();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_rajawali;
    }
}

