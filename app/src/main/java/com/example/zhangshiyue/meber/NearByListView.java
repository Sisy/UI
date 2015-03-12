package com.example.zhangshiyue.meber;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zhangshiyue on 15-3-10.
 */
public class NearByListView extends Activity {

    SqlDbHelper Helper;
    ListView nearByList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nearby_eventlist);

        nearByList = (ListView)findViewById(R.id.newbylistview);
        Helper = new SqlDbHelper(this);
      //  Helper.addRecord("3","Clubbing","cory night");
        ArrayList<NearByEvent> eventsListItems = Helper.getAllNotes();


        MyAdapter adapter = new MyAdapter(this,eventsListItems);

        nearByList.setAdapter(adapter);


      //  nearByList.setOnItemLongClickListener(myClickListener);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_event_option, menu);
        return true;
    }

    private class MyAdapter extends ArrayAdapter<NearByEvent>
    {
        private LayoutInflater mInflater;
        private final ArrayList<NearByEvent> values;

        public MyAdapter(Context context,ArrayList<NearByEvent> values)
        {
            super(context,0,values);
            mInflater = LayoutInflater.from(context);
            this.values = values;
        }


        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v;
            NearByEvent event = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_entity, parent, false);
            }

               // event.icon = (ImageView)v.findViewById(R.id.icon);
            TextView  description = (TextView)convertView.findViewById(R.id.description);
            TextView  location= (TextView)convertView.findViewById(R.id.location);



            description.setText(event.getDescription());
            location.setText(event.getLocation());

            return convertView;
        }

    }

}
