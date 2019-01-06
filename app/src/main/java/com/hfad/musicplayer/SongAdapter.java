package com.hfad.musicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    Context context;
    ArrayList<SongList> songs;

    OnItemClickListner onItemClickListner;

    public interface OnItemClickListner {
        void onItemClick(Button b, View v, SongList obj, int position);
    }

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public SongAdapter(Context context, ArrayList<SongList> songs) {
        this.context = context;
        this.songs = songs;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View songView = LayoutInflater.from(context).inflate(R.layout.row_list, viewGroup, false);

        return new SongViewHolder(songView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SongViewHolder songViewHolder, final int i) {
        final SongList songList = songs.get(i);
        songViewHolder.songName.setText(songList.songName);
        songViewHolder.artistName.setText(songList.artistName);
        songViewHolder.btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListner!=null){
                    onItemClickListner.onItemClick(songViewHolder.btnAction, v, songList, i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {

        TextView songName, artistName;
        Button btnAction;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.songName);
            artistName = itemView.findViewById(R.id.artistName);
            btnAction = itemView.findViewById(R.id.btnAction);

        }
    }
}
