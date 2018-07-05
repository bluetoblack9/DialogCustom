package com.blue.dialoganimation;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blue.dialoganimation.effects.BaseEffects;

/**
 * Created by liujing on 2018/7/4.
 * (*^▽^*)
 */
public class DialogCustom extends Dialog implements DialogInterface {

    private int mDuration = -1;
    private RelativeLayout mRelativeLayoutView;
    private Context mContext;
    private int winPaddingLeft = 25;
    private int winPaddingRight = 25;
    private int winPaddingTop =0;
    private int winPaddingBottom =0;

    private View mDialogView;
    private int layoutId;
    private boolean isCancelable = true;

    private Effectstype type = null;


    public DialogCustom(@NonNull Context context) {
        super(context);
    }

    public DialogCustom(Context context, int theme) {
        super(context, theme);
        mContext = context;
        initCustom();
    }

    public static DialogCustom getInstance(Context context, int theme) {
        return new DialogCustom(context, theme);
    }

    private View initCustom() {
        mDialogView = View.inflate(mContext, R.layout.dialong_custom, null);
        setContentView(mDialogView);
        mRelativeLayoutView = (RelativeLayout) mDialogView.findViewById(R.id.rl_custom);
        mRelativeLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCancelable) dismiss();
            }
        });
        mRelativeLayoutView.setPadding(winPaddingLeft,winPaddingTop,winPaddingRight,winPaddingBottom);
        this.setOnShowListener(new OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
//                mLinearLayoutView.setVisibility(View.VISIBLE);
                if (type == null) {
                    type = Effectstype.Slidetop;
                }
                start(type);
            }
        });

        return mDialogView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private void start(Effectstype type) {
        BaseEffects animator = type.getAnimator();
        if (mDuration != -1) {
            animator.setDuration(Math.abs(mDuration));
        }
        animator.start(mRelativeLayoutView);
    }

    public View setLayoutId(int layoutId) {
        this.layoutId = layoutId;
        View sub = getLayoutInflater().inflate(layoutId, null);
        mRelativeLayoutView.addView(sub);
        return mDialogView;
    }

    public DialogCustom isCancelableOnTouchOutside(boolean cancelable) {
        this.isCancelable = cancelable;
        this.setCanceledOnTouchOutside(cancelable);
        return this;
    }
    public DialogCustom withDuration(int duration) {
        this.mDuration = duration;
        return this;
    }


    public DialogCustom withEffect(Effectstype effect) {
        this.type = effect;
        return this;
    }

    public void setWinPaddingBottom(int winPaddingBottom) {
        this.winPaddingBottom = winPaddingBottom;
    }

    public void setWinPaddingLeft(int winPaddingLeft) {
        this.winPaddingLeft = winPaddingLeft;
    }

    public void setWinPaddingRight(int winPaddingRight) {
        this.winPaddingRight = winPaddingRight;
    }

    public void setWinPaddingTop(int winPaddingTop) {
        this.winPaddingTop = winPaddingTop;
    }

    public RelativeLayout getWinOutView() {
        return mRelativeLayoutView;
    }
}
