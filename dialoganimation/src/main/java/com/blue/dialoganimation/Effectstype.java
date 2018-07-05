package com.blue.dialoganimation;


import com.blue.dialoganimation.effects.BaseEffects;
import com.blue.dialoganimation.effects.FadeIn;
import com.blue.dialoganimation.effects.FlipH;
import com.blue.dialoganimation.effects.FlipV;
import com.blue.dialoganimation.effects.NewsPaper;
import com.blue.dialoganimation.effects.SideFall;
import com.blue.dialoganimation.effects.SlideLeft;
import com.blue.dialoganimation.effects.SlideRight;
import com.blue.dialoganimation.effects.SlideTop;
import com.blue.dialoganimation.effects.SlideBottom;
import com.blue.dialoganimation.effects.Fall;
import com.blue.dialoganimation.effects.RotateBottom;
import com.blue.dialoganimation.effects.RotateLeft;
import com.blue.dialoganimation.effects.Slit;
import com.blue.dialoganimation.effects.Shake;

/*
 */
public enum Effectstype {

    Fadein(FadeIn.class),
    Slideleft(SlideLeft.class),
    Slidetop(SlideTop.class),
    SlideBottom(SlideBottom.class),
    Slideright(SlideRight.class),
    Fall(Fall.class),
    Newspager(NewsPaper.class),
    Fliph(FlipH.class),
    Flipv(FlipV.class),
    RotateBottom(RotateBottom.class),
    RotateLeft(RotateLeft.class),
    Slit(Slit.class),
    Shake(Shake.class),
    Sidefill(SideFall.class);
    private Class<? extends BaseEffects> effectsClazz;

    private Effectstype(Class<? extends BaseEffects> mclass) {
        effectsClazz = mclass;
    }

    public BaseEffects getAnimator() {
        BaseEffects bEffects = null;
        try {
            bEffects = effectsClazz.newInstance();
        } catch (ClassCastException e) {
            throw new Error("Can not init animatorClazz instance");
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new Error("Can not init animatorClazz instance");
        }
        return bEffects;
    }
}
