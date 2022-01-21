package net.smallacademy.songslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    LayoutInflater inflater;
    List<Song> songs;
    Context ctx;
    public Adapter(Context ctx, List<Song> songs){
        this.inflater = LayoutInflater.from(ctx);
        this.songs = songs;
        this.ctx =ctx;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.ficheroId.setText(songs.get(position).getId());
        holder.ficheroDescripcion.setText(songs.get(position).getDescripcion());
        holder.ficheroFecha.setText(songs.get(position).getFecha());
        holder.ficheroUrl.setText(songs.get(position).getUrl());
        Glide.with(ctx).load(R.drawable.unknown).into(holder.FicheroPdf);

    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView ficheroId,ficheroDescripcion,ficheroFecha,ficheroUrl;
        ImageView FicheroPdf;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ficheroId = itemView.findViewById(R.id.id);
            ficheroDescripcion = itemView.findViewById(R.id.descripcion);
            ficheroFecha = itemView.findViewById(R.id.fecha);
            ficheroUrl = itemView.findViewById(R.id.url);
            FicheroPdf = itemView.findViewById(R.id.fichpdf);
            // handle onClick

        }
    }
}
