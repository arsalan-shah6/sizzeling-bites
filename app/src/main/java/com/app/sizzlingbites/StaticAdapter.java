package com.app.sizzlingbites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StaticAdapter extends RecyclerView.Adapter<StaticAdapter.StaticHolder> {
    List<String>name;
    List<Integer>icon;
    Context context;


    public StaticAdapter(List<String> name, List<Integer> icon, Context context) {
        this.name = name;
        this.icon = icon;
        this.context = context;
    }

    @NonNull
    @Override
    public StaticHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate( R.layout.row_item,parent,false );
        return new StaticHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull StaticHolder holder, int position) {
        holder.name.setText( name.get( position ) );
        holder.item.setImageResource( icon.get( position ) );


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class StaticHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView item;
        public StaticHolder(@NonNull View itemView) {
            super( itemView );
            name=itemView.findViewById( R.id.name );
            item=itemView.findViewById( R.id.image );
        }
    }
}
