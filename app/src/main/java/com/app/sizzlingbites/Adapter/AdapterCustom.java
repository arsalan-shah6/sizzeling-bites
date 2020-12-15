package com.app.sizzlingbites.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.sizzlingbites.DashboardActivity;
import com.app.sizzlingbites.Model.DynamicModel;
import com.app.sizzlingbites.R;

import java.util.List;

public class AdapterCustom extends RecyclerView.Adapter<AdapterCustom.ViewHolder> {
    private List<DynamicModel> dynamicModelList;
    private  List<DynamicModel> modelList;

    public AdapterCustom(Context context,List<DynamicModel> dynamicModelList, List<DynamicModel> modelList) {
        this.dynamicModelList = dynamicModelList;
        this.modelList = modelList;
    }


    @NonNull
    @Override
    public AdapterCustom.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
  View view= LayoutInflater.from( parent.getContext() ).inflate( R.layout.re_menu,parent,false );
  return  new AdapterCustom.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCustom.ViewHolder holder, int position) {
       DynamicModel item = dynamicModelList.get( position );
       holder.name.setText( item.getName());
    }

    @Override
    public int getItemCount() {
        return dynamicModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,description;
        ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            name=itemView.findViewById( R.id.itemName );
            description=itemView.findViewById(R.id.itemDescription  );
            icon=itemView.findViewById( R.id.itemIcon );
        }
    }
}
