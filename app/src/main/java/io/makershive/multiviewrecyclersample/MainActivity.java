package io.makershive.multiviewrecyclersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import io.makershive.multiviewrecyclersample.Model.DisplayModel;
import io.makershive.multiviewrecyclersample.Model.ServerModel;

public class MainActivity extends AppCompatActivity {
    ArrayList<ServerModel> serverModels = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rvMulti = findViewById(R.id.rvMulti);
        prepareServerModel();
        prepareDisplayModel();
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);
        final MultiViewAdapter multiViewAdapter = new MultiViewAdapter(this, prepareDisplayModel());
        linearLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (multiViewAdapter.getItemViewType(position)) {
                    case 3:
                        Log.e("Test", "Text is calling");
                        return 2;
                    case 2:
                        Log.e("Test", "Image is calling");
                        return 1;
                    default:
                        Log.e("Test", "Default is calling");
                        return 2;
                }
            }
        });
        rvMulti.setLayoutManager(linearLayoutManager);
        rvMulti.setAdapter(multiViewAdapter);
    }

    //TODO this logic is regarding single recyclerview with multiple view holder.
    private ArrayList<DisplayModel> prepareDisplayModel() {
        ArrayList<DisplayModel> displayModels = new ArrayList<>();
        String previousName = null;
        for (int i = 0; i < serverModels.size(); i++) {
            ServerModel serverModel = serverModels.get(i);
            String serverDate = serverModel.getReportDate();
            String[] splitStr = serverDate.split("-");
            Calendar cal = Calendar.getInstance();
            String monthStr = splitStr[1];
            SimpleDateFormat monthDate = new SimpleDateFormat("MMM");
            int monthnum = Integer.parseInt(monthStr);
            cal.set(Calendar.MONTH, monthnum - 1);
            String monthName = monthDate.format(cal.getTime());
            if (i == 0) {
                DisplayModel displayModel = new DisplayModel(Constants.TEXT_TYPE, "Latest Movies", serverModel.getReportName(), serverModel.getReportDate());
                previousName = monthName;
                displayModels.add(displayModel);
                DisplayModel ImageDisplayModel = new DisplayModel(Constants.IMAGE_TYPE, monthName, serverModel.getReportName(), serverModel.getReportDate());

                displayModels.add(ImageDisplayModel);
            } else {
                if (previousName.equals(monthName)) {
                    DisplayModel displayModel = new DisplayModel(Constants.IMAGE_TYPE, monthName, serverModel.getReportName(), serverModel.getReportDate());
                    previousName = monthName;
                    displayModels.add(displayModel);
                } else {
                    DisplayModel displayModel = new DisplayModel(Constants.TEXT_TYPE, monthName, serverModel.getReportName(), serverModel.getReportDate());
                    previousName = monthName;
                    displayModels.add(displayModel);
                    DisplayModel ImageDisplayModel = new DisplayModel(Constants.IMAGE_TYPE, monthName, serverModel.getReportName(), serverModel.getReportDate());

                    displayModels.add(ImageDisplayModel);
                }
            }

        }
        return displayModels;
    }

    private void prepareServerModel() {
        serverModels.add(new ServerModel("Avengers", "2019-02-03T10:49:16.001+0000"));
        serverModels.add(new ServerModel("IronMan 1", "2019-02-03T10:49:16.001+0000"));
        serverModels.add(new ServerModel("Thor", "2019-01-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("Captain America", "2019-01-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("IronMan 2", "2019-12-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("Winter Solider", "2019-12-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("Civil war", "2019-12-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("IronMan 3", "2019-12-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("Black Widow", "2019-11-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("Avengers Age of Ultra", "2019-11-05T10:49:16.001+0000"));
        serverModels.add(new ServerModel("Hulk", "2019-11-05T10:49:16.001+0000"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
