package com.example.android.fluentcast;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.MissingResourceException;

public class PodcastActivity extends AppCompatActivity {

    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* Find and set the custom Top App Bar */
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        String podcastName = getIntent().getStringExtra("EXTRA_PODCAST_NAME");
        if (podcastName == null) {
            throw new MissingResourceException("No podcast name", "TopicActivity.java", "EXTRA_PODCAST_NAME");
        }

        setContentView(R.layout.activity_podcast);

        this.setTitle(podcastName);
        myToolbar = findViewById(R.id.toolbar);
        myToolbar.setTitle(podcastName);

        LinearLayout playControlLayout = findViewById(R.id.podcast_play_control);
        playControlLayout.setVisibility(View.VISIBLE);

        ListView listView = findViewById(R.id.transcript_list);
        TextView transcriptsUnavailableView = findViewById(R.id.transcripts_unavailable);

        ArrayList<Transcript> transcriptsArray = new ArrayList<>();

        if (podcastName.equals("Hello! My name is Maria")) {
            transcriptsArray.add(new Transcript("Hello! My name is Mariya. What’s your name?",
                    "Здравствуйте! Меня зовут Мария. А как вас зовут?"));
            transcriptsArray.add(new Transcript("Nice to meet you! My name is Ann.",
                    "Приятно познакомиться! Меня зовут Анна"));
            transcriptsArray.add(new Transcript("Nice to meet you too!",
                    "Мне также приятно познакомиться вами!"));
            transcriptsArray.add(new Transcript("I live in Kiev. And where do you live?",
                    "Я живу в Киеве. А вы где живёте?"));
            transcriptsArray.add(new Transcript("I live in Donetsk but I study in Kiev.",
                    "Я живу в Донецке, но учусь в Киеве."));
            transcriptsArray.add(new Transcript("Are you also a student?",
                    "Вы тоже студентка?"));
            transcriptsArray.add(new Transcript("Yes, I am an economist, and you?",
                    "Да, я экономист. А вы?"));
            transcriptsArray.add(new Transcript("I study foreign languages. That’s my future profession and a hobby.",
                    "Я изучаю иностранные языки. Это моя будущая профессия и хобби."));
            transcriptsArray.add(new Transcript("Do you have a hobby?",
                    "У тебя есть хобби?"));
            transcriptsArray.add(new Transcript("I like reading books. My favourite author is Chekhov.",
                    "Я люблю читать книги. Мой любимый автор - Чехов"));
            transcriptsArray.add(new Transcript("I like him too. I have read some of his books recently.",
                    "Мне он тоже нравится. Я недавно прочитал несклько его книг"));
            transcriptsArray.add(new Transcript("I also like cooking.",
                    "Мне также нравится готовить."));
            transcriptsArray.add(new Transcript("When my friends come to me, I usually prepare something tasty for them.",
                    "Когда мои друзья приходят ко мне, я обычно готовлю что-нибудь вкусное для них."));
            transcriptsArray.add(new Transcript("They say, I cook very well.",
                    "Они говорят, я готовлю очень хорошо."));
            transcriptsArray.add(new Transcript("If you like, I may give you a recipe of my apple pie.",
                    "Если хочешь, я могу дать тебе мой рецепт яблочного пирога."));
            transcriptsArray.add(new Transcript("It is very tasty.",
                    "Он очень вкусный."));
            transcriptsArray.add(new Transcript("Thank you! It would be great!",
                    "Спасибо! Это будет здорово!"));
        }

        TranscriptAdapter transcriptAdapter;
        if (transcriptsArray.size() > 0) {
            transcriptsUnavailableView.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            transcriptAdapter = new TranscriptAdapter(this, transcriptsArray);
            listView.setAdapter(transcriptAdapter);
        } else {
            listView.setVisibility(View.GONE);
            transcriptsUnavailableView.setVisibility(View.VISIBLE);
        }

        final ImageView prevButton = findViewById(R.id.prev_button);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final ImageView nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final ImageView playButton = findViewById(R.id.control_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    playButton.setImageResource(R.drawable.stop_button);
                    isPlaying = true;
                } else {
                    playButton.setImageResource(R.drawable.play_button);
                    isPlaying = false;
                }
            }
        });

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            private int lastVisibleItem = 0;
            private int lastY = 0;
            private final LinearLayout playControlLayout = findViewById(R.id.podcast_play_control);

            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int top = 0;

                if (view.getChildAt(0) != null) {
                    top = view.getChildAt(0).getTop();
                }

                if (firstVisibleItem > lastVisibleItem) {
                    playControlLayout.setVisibility(View.INVISIBLE);
                } else if (firstVisibleItem < lastVisibleItem) {
                    playControlLayout.setVisibility(View.VISIBLE);
                } else {
                    if (top < lastY) {
                        playControlLayout.setVisibility(View.INVISIBLE);
                    } else if (top > lastY) {
                        playControlLayout.setVisibility(View.VISIBLE);
                    }
                }

                lastVisibleItem = firstVisibleItem;
                lastY = top;

            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
        });
    }
}
