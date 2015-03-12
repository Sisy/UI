package com.example.zhangshiyue.meber;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.Objects;


public class MyActivity extends Activity {
    public Integer[] imageIDs ={
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"pic"+(position+1)+"select",Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        Intent intent = new Intent(MyActivity.this, NearByListView.class);
                        startActivity(intent);
                    case 1:;
                    case 2:;
                    case 3:;
                    case 4:;
                    case 5:;
                    case 6:;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
    public class ImageAdapter extends BaseAdapter{
        private Context context;

        public ImageAdapter(Context c){
            context =c;
        }

        public int getCount(){
            return  imageIDs.length;
        }
        public Object getItem(int position){
            return  position;
        }
        public long getItemId(int position){
            return position;
        }

        public View getView(int position,View convertView,ViewGroup parent){
            ImageView imageView;
            if(convertView ==null){
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(85,85));
               imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(2,2,2,2);
            }else{
                imageView = (ImageView)convertView;
            }
            imageView.setImageResource(imageIDs[position]);
            return imageView;
        }
    }
}


