package com.shajidurrahman.gmailclone;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EmailStar {
    public void run(ImageView target, ImageView com1, ImageView com2){
        ImageView co1 = com1;
        target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (target == com1){
//                    target.setBackgroundResource(R.id);
                }
            }
        });
    }
}
