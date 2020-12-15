package com.app.sizzlingbites.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.sizzlingbites.R;

import java.lang.reflect.Array;
import java.util.List;

public class sam extends RecyclerView.Adapter<sam.holder> {
    Context context;
    List<String> name;
    List<String> description;
    List<Integer> icon;
    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from( context ).inflate( R.layout.re_menu ,parent,false);
        return new holder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.foodname.setText( name.get( position ) );
        holder.fooddescription.setText( description.get( position ) );

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView foodname,fooddescription;
        ImageView foodicon;
        public holder(@NonNull View itemView) {
            super( itemView );
            foodname=itemView.findViewById( R.id.itemName );
            fooddescription=itemView.findViewById( R.id.itemDescription );
            foodicon=itemView.findViewById( R.id.itemIcon );
        }
    }
}
