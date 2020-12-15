package com.app.sizzlingbites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.sizzlingbites.Adapter.AdapterCustom;
import com.app.sizzlingbites.Adapter.DynamicAdapter;
import com.app.sizzlingbites.Model.DynamicModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    RecyclerView recyclerView,rvItem;
    List<String>name;
    List<Integer>icon;


    List<DynamicModel>dynamicModelList;
    DynamicAdapter dynamicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );
        recyclerView=findViewById( R.id.recyclerview );
        rvItem=findViewById( R.id.rv_items );
        
        name=new ArrayList<>();
        icon=new ArrayList<>();
        name.add( "Pizza" );
        name.add( "Chicken" );
        name.add( "Burger" );
        name.add( "pizza" );
        name.add( "Burger" );
        name.add( "soup" );
        name.add( "pizza" );
        name.add( "Burger" );
        name.add( "soup" );

        icon.add( R.drawable.pizza );
        icon.add( R.drawable.chicken );
        icon.add( R.drawable.burger );
        icon.add( R.drawable.profile );
        icon.add( R.drawable.bell );
        icon.add( R.drawable.search1 );
        icon.add( R.drawable.profile );
        icon.add( R.drawable.bell );
        icon.add( R.drawable.search1 );

StaticAdapter staticAdapter=new StaticAdapter( name,icon,this );
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager( 1, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager( staggeredGridLayoutManager );
        recyclerView.setAdapter( staticAdapter );


        dynamicModelList=new ArrayList<>();
        rvItem.setLayoutManager( new LinearLayoutManager( this ) );
        Apicall();
    }

    private void Apicall() {
        String url="https://www.themealdb.com/api/json/v1/1/categories.php";
        StringRequest request=new StringRequest( Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("categories");
                            
                            for (int i=0;i<jsonArray.length(); i++) {
                                JSONObject jsonObject1 = jsonArray.getJSONObject( i );
                               String names = jsonObject1.getString( "strCategory" );
                                String descriptions = jsonObject1.getString( "strCategoryDescription" );
                                String icons = jsonObject1.getString( "strCategoryThumb" );



                                DynamicModel dynamicModel = new DynamicModel(names,descriptions,icons);
                                dynamicModelList.add(dynamicModel);
                            }

                           dynamicAdapter=new DynamicAdapter(DashboardActivity.this,dynamicModelList);
                            rvItem.setAdapter( dynamicAdapter );


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText( DashboardActivity.this, ""+error, Toast.LENGTH_SHORT ).show();

            }
        } );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add( request );
    }
}