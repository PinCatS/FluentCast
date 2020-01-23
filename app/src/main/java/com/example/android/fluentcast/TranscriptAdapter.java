package com.example.android.fluentcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

class TranscriptAdapter extends ArrayAdapter<Transcript> {

    public TranscriptAdapter(Context context, List<Transcript> transcripts) {
        super(context, 0, transcripts);
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.transcript_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.learningLanguageView = convertView.findViewById(R.id.learning_language);
            viewHolder.nativeLanguageView = convertView.findViewById(R.id.native_language);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Transcript transcript = getItem(position);

        viewHolder.learningLanguageView.setText(transcript.getLearningLanguage());
        viewHolder.nativeLanguageView.setText(transcript.getNativeLanguage());

        return convertView;
    }

    private static class ViewHolder {
        TextView learningLanguageView;
        TextView nativeLanguageView;
    }
}
