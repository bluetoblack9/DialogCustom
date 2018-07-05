package com.blue.dialogcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blue.dialoganimation.DialogCustom;
import com.blue.dialoganimation.Effectstype;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alertShow1(View view) {
        final DialogCustom dialogBuilder = DialogCustom.getInstance(this, R.style.dialog_untran);
        dialogBuilder.isCancelableOnTouchOutside(true)
                .withDuration(700)
                .withEffect(Effectstype.Slidetop);
        dialogBuilder.show();
        dialogBuilder.setWinPaddingLeft(50);
        dialogBuilder.setWinPaddingRight(50);
        View viewId = dialogBuilder.setLayoutId(R.layout.alertext_form);
        Button leftButton = (Button) viewId.findViewById(R.id.splash_dialog_left);
        Button rightButton = (Button) viewId.findViewById(R.id.splash_dialog_right);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.dismiss();
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.dismiss();
            }
        });
    }
}
