package com.aveson.central;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArtistControlActivity extends AppCompatActivity {

    int BG = Color.rgb(8, 8, 18);
    int CARD = Color.rgb(20, 20, 35);
    int PURPLE = Color.rgb(145, 75, 255);
    int BLUE = Color.rgb(60, 130, 255);
    int TEXT = Color.WHITE;
    int MUTED = Color.rgb(175, 175, 195);

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(BG);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(28, 32, 28, 32);

        scroll.addView(root);
        setContentView(scroll);

        buildRoom();
    }

    TextView title(String text, int size) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(TEXT);
        t.setTextSize(size);
        t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        t.setPadding(0, 10, 0, 10);
        return t;
    }

    TextView subtitle(String text) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextColor(MUTED);
        t.setTextSize(14);
        t.setPadding(0, 0, 0, 20);
        return t;
    }

    Button roomButton(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextColor(TEXT);
        b.setTextSize(15);
        b.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        b.setAllCaps(false);
        b.setBackgroundColor(CARD);

        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, 70);

        lp.setMargins(0, 8, 0, 8);
        b.setLayoutParams(lp);

        return b;
    }

    void buildRoom() {

        TextView back = title("←  BACK TO AVESON CENTRAL", 15);
        back.setTextColor(BLUE);
        back.setOnClickListener(v -> finish());
        root.addView(back);

        root.addView(title("AVESON ARTIST CONTROL", 28));

        root.addView(subtitle(
                "Artist management • Release review • Content control"
        ));

        // Dashboard
        root.addView(title("CONTROL CENTER", 18));

        Button artists = roomButton("👤  ARTISTS\nManage AVESON artists");
        root.addView(artists);

        Button releases = roomButton(
                "🎵  RELEASE SUBMISSIONS\nReview songs submitted by artists"
        );
        root.addView(releases);

        Button videos = roomButton(
                "🎬  VIDEO & CLIPS\nReview artist video submissions"
        );
        root.addView(videos);

        Button pending = roomButton(
                "⏳  PENDING REVIEW\nContent waiting for admin decision"
        );
        root.addView(pending);

        Button approved = roomButton(
                "✅  APPROVED\nApproved content ready for next stage"
        );
        root.addView(approved);

        Button rejected = roomButton(
                "❌  REJECTED\nRejected submissions and reasons"
        );
        root.addView(rejected);

        // Demo actions
        artists.setOnClickListener(v ->
                message("ARTISTS",
                        "Artist management will appear here.\n\n" +
                        "• Artist profiles\n" +
                        "• Artist status\n" +
                        "• Releases\n" +
                        "• Video submissions"));

        releases.setOnClickListener(v ->
                message("RELEASE SUBMISSIONS",
                        "Incoming music releases will appear here.\n\n" +
                        "Admin can review and approve or reject them."));

        videos.setOnClickListener(v ->
                message("VIDEO & CLIPS",
                        "Artist video and clip submissions will appear here."));

        pending.setOnClickListener(v ->
                message("PENDING REVIEW",
                        "All submissions waiting for admin review."));

        approved.setOnClickListener(v ->
                message("APPROVED",
                        "Approved artist content will appear here."));

        rejected.setOnClickListener(v ->
                message("REJECTED",
                        "Rejected submissions will appear here."));
    }

    void message(String heading, String text) {

        root.removeAllViews();

        TextView back = title("←  BACK", 15);
        back.setTextColor(BLUE);
        back.setOnClickListener(v -> {
            root.removeAllViews();
            buildRoom();
        });

        root.addView(back);
        root.addView(title(heading, 26));
        root.addView(subtitle(text));

        Button home = roomButton("🎤  ARTIST CONTROL HOME");
        home.setOnClickListener(v -> {
            root.removeAllViews();
            buildRoom();
        });

        root.addView(home);
    }
}
