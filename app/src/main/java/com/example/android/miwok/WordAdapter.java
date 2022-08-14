package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    /** Resource id for background color for this list of words  */
    private int mColorResourceId;
    private int mPosition;
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            mPosition = position;

        }

        Word currentWord = getItem(position);

        TextView mivokTextView = (TextView) listItemView.findViewById(R.id.mivok_text_view);
        mivokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());


        ImageView img = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            img.setImageResource(currentWord.getImageResourceId());
            img.setVisibility(View.VISIBLE);
        }
        else{
            img.setVisibility(View.GONE);
        }

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        //Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        //Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
    public int getPosition(){
        return mPosition;
    }
}
