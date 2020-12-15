package com.app.sizzlingbites.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.sizzlingbites.Model.DynamicModel;
import com.app.sizzlingbites.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.holder>{
    Context context;
    List<DynamicModel>dynamicModelList;

    public DynamicAdapter(Context context, List<DynamicModel> dynamicModelList) {
        this.context = context;
        this.dynamicModelList = dynamicModelList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from( context ).inflate( R.layout. re_menu,parent,false);
        return new holder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
         String name=dynamicModelList.get( position ).getName();
         String description=dynamicModelList.get( position ).getDescription();
         String icon=dynamicModelList.get( position ).getIcon();
         holder.foodname.setText( name );
         holder.fooddescription.setText( description );
         Glide.with( context ).load( icon ).into( holder.foodicon );

    }

    @Override
    public int getItemCount() {
        return dynamicModelList.size();
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
