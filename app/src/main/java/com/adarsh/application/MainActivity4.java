package com.adarsh.application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;


public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void increaseLikeCount(View view) {
        TextView likeCountTextView = null;
        int viewId = view.getId();

        if (viewId == R.id.btnLike1) {
            likeCountTextView = findViewById(R.id.likeCount1);
        } else if (viewId == R.id.btnLike2) {
            likeCountTextView = findViewById(R.id.likeCount2);
        }else if (viewId == R.id.btnLike3) {
            likeCountTextView = findViewById(R.id.likeCount3);
        }else if (viewId == R.id.btnLike4) {
            likeCountTextView = findViewById(R.id.likeCount4);
        }else if (viewId == R.id.btnLike5) {
            likeCountTextView = findViewById(R.id.likeCount5);
        }

        if (likeCountTextView != null) {
            int currentLikes = Integer.parseInt(likeCountTextView.getText().toString());
            likeCountTextView.setText(String.valueOf(currentLikes + 1));
        }
    }

    public void expandComments(View view) {
        LinearLayout parentLayout = findViewById(R.id.photosLayout);

        ScrollView existingScrollView = parentLayout.findViewById(R.id.commentsScrollView);
        if (existingScrollView != null) {
            parentLayout.removeView(existingScrollView);
            return;
        }

        ScrollView scrollView = new ScrollView(this);
        scrollView.setId(R.id.commentsScrollView);
        LinearLayout.LayoutParams scrollViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        scrollView.setLayoutParams(scrollViewParams);

        LinearLayout commentsLayout = new LinearLayout(this);
        commentsLayout.setOrientation(LinearLayout.VERTICAL);
        commentsLayout.setId(R.id.commentsLayout);
        scrollView.addView(commentsLayout);

        int numComments = 5; // Replace with actual comment count
        for (int i = 1; i <= numComments; i++) {
            TextView commentTextView = new TextView(this);
            commentTextView.setText("Comment " + i);
            commentsLayout.addView(commentTextView);
        }

        parentLayout.addView(scrollView);

        TextView commentCountTextView = findViewById(R.id.commentCount);
        commentCountTextView.setText("(" + numComments + ")");

        TextView commentCountTextView1 = findViewById(R.id.commentCount1);
        commentCountTextView1.setText("(" + numComments + ")");

        TextView commentCountTextView2 = findViewById(R.id.commentCount2);
        commentCountTextView2.setText("(" + numComments + ")");
        TextView commentCountTextView3 = findViewById(R.id.commentCount3);
        commentCountTextView3.setText("(" + numComments + ")");
        TextView commentCountTextView4 = findViewById(R.id.commentCount4);
        commentCountTextView4.setText("(" + numComments + ")");
    }

    public void submitComment(View view) {
        EditText commentBox = findViewById(R.id.commentBox);
        String comment = commentBox.getText().toString();

        TextView commentTextView = new TextView(this);
        commentTextView.setText(comment);

        LinearLayout commentsLayout = findViewById(R.id.commentsLayout);
        commentsLayout.addView(commentTextView);

        commentBox.setText("");
    }
}
