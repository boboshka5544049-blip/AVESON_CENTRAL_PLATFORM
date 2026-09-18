package com.aveson.central;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(32, 32, 32, 32);
        root.setBackgroundColor(Color.rgb(8, 8, 18));

        TextView title = new TextView(this);
        title.setText("AVESON CENTRAL");
        title.setTextColor(Color.WHITE);
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        root.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Global Management Platform");
        subtitle.setTextColor(Color.rgb(180, 170, 220));
        subtitle.setTextSize(16);
        subtitle.setGravity(Gravity.CENTER);

        root.addView(subtitle);

        addRoom(root, "🎤  AVESON ARTIST CONTROL");
        addRoom(root, "🎵  AVESON MUSIC CONTROL");
        addRoom(root, "🌐  AVESON DISTRIBUTION CONTROL");

        setContentView(root);
    }

    private void addRoom(LinearLayout root, String text) {
        TextView room = new TextView(this);

        room.setText(text);
        room.setTextColor(Color.WHITE);
        room.setTextSize(17);
        room.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        room.setGravity(Gravity.CENTER);
        room.setPadding(20, 30, 20, 30);
        room.setBackgroundColor(Color.rgb(25, 20, 45));

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        params.topMargin = 24;

        root.addView(room, params);
    }
}
