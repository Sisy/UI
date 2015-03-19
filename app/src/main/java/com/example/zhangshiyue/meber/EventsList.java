package com.example.zhangshiyue.meber;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by zhangshiyue on 15-3-15.
 */
public class EventsList extends TabActivity {

    private static final  String HOSTING_SPEC ="HOSTING";
    private static final  String GOING_SPEC ="GOING";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        TabHost tabHost = getTabHost();


        TabHost.TabSpec hostingSpec = tabHost.newTabSpec(HOSTING_SPEC);
        hostingSpec.setIndicator(HOSTING_SPEC);
        Intent hostingIntent = new Intent(this,NearByList.class);
        hostingSpec.setContent(hostingIntent);

        TabHost.TabSpec goingSpec = tabHost.newTabSpec(GOING_SPEC);
        goingSpec.setIndicator(GOING_SPEC);
        Intent goingIntent = new Intent(this,NearByList.class);
        goingSpec.setContent(goingIntent);

        tabHost.addTab(hostingSpec);
        tabHost.addTab(goingSpec);

    }


}
