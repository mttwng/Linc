package linc.linc;

import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



public class MainActivity extends Activity {

//    static String currList = "Favorites";
    HashMap<String, Integer> allList = new HashMap<String, Integer>();
    ArrayList<String> discoverList;
    ArrayList<String> licnedList;
    ArrayList<Integer> alreadylincedList;
    HashMap<Integer, String> discoverHash = new HashMap<Integer, String>();
    HashMap<Integer, String> lincedHash = new HashMap<Integer, String>();

    final String highlightColor = "#4edc91";
    final String backgroundColor = "#2c3e50";
    final String white = "#ffffff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setStatusBarColor(Color.parseColor(backgroundColor));
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listView);
        final Button lincButton = (Button) findViewById(R.id.lincToButton);
        final Button discoverButton = (Button) findViewById(R.id.findButton);
        final TextView lincedLine = (TextView) findViewById(R.id.underlineLinced);
        final TextView discoverLine = (TextView) findViewById(R.id.underlineDiscover);
        ((TextView) findViewById(R.id.underlineMap)).setBackgroundColor(Color.parseColor(backgroundColor));
        ((Button) findViewById(R.id.settingsButton)).setTextColor(Color.parseColor(white));

        pressButton(lincedLine, discoverLine, discoverButton, lincButton);

        addDiscoverList();
        addLincedHash();
        listView.setAdapter(setAllStations());

        lincButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                currList = "All";
                listView.setAdapter(lincedPeople());
                pressButton(discoverLine, lincedLine, lincButton, discoverButton);

            }
        });

        discoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                currList = "Favorites";
                listView.setAdapter(setAllStations());
                pressButton(lincedLine, discoverLine, discoverButton, lincButton);

            }
        });


    }

    public void pressButton(TextView a, TextView b, Button x, Button y) {
        a.setBackgroundColor(Color.parseColor(highlightColor));
        b.setBackgroundColor(Color.parseColor(backgroundColor));
        x.setTextColor(Color.parseColor(highlightColor));
        y.setTextColor(Color.parseColor(white));
    }

    public myList setAllStations(){
        alreadylincedList = new ArrayList<Integer>(Collections.nCopies(45, R.drawable.blankcheck));
        Collections.sort(licnedList);
        int count = 0;
        for (String station: licnedList) {
            lincedHash.put(count, station);
            count++;
        }
        for (String station: lincedHash.values()) {
            alreadylincedList.set(allList.get(station), R.drawable.check);
        }
        return new myList(MainActivity.this, discoverList, alreadylincedList);
    }

    public ArrayAdapter<String> lincedPeople(){
        alreadylincedList = new ArrayList<Integer>(licnedList.size());
        Collections.sort(licnedList);
        int count = 0;
        while (count < licnedList.size()){
            alreadylincedList.add(R.drawable.check);
            count++;
        }
        count = 0;
        for (String station: licnedList) {
            lincedHash.put(count, station);
            count++;
        }
        return new myList(MainActivity.this, licnedList, alreadylincedList);
    }

    public void addDiscoverList() {
        discoverList =  new ArrayList<>(45);
        discoverList.add("Kecia Flores");
        discoverList.add("Charmain Foster");
        discoverList.add("Mariann Landey");
        discoverList.add("Jeanette Ardito");
        discoverList.add("Keesha Frier");
        discoverList.add("Jess Estabrook");
        discoverList.add("Sarah Holme");
        discoverList.add("Kristijan Jervis");
        discoverList.add("Áedán Blumstein");
        discoverList.add("Giorgos Blackwood");
        discoverList.add("Nasser Bermúdez");
        discoverList.add("Gol Meisner");
        discoverList.add("Patrice Cabrera");
        discoverList.add("Marinho Utkin");
        discoverList.add("Katrina Irvin");
        discoverList.add("Teasag Beitel");
        discoverList.add("Benedita Basurto");
        discoverList.add("Siward Fabre");
        discoverList.add("Gauthier Gelen");
        discoverList.add("Eutropius Bartoš");
        discoverList.add("Maximilianus Geary");
        discoverList.add("Borislava MacRae");
        discoverList.add("Bellona Turnbull");
        discoverList.add("Zaahir Rana");
        discoverList.add("Eliana Horn");
        discoverList.add("Tatton Bencivenni");
        Collections.sort(discoverList);
        int count = 0;
        for (String station: discoverList) {
            discoverHash.put(count, station);
            allList.put(station, count);
            count++;
        }
    }

    public void addLincedHash() {
        licnedList =  new ArrayList<>(45);
        licnedList.add("Gol Meisner");
        licnedList.add("Siward Fabre");
        licnedList.add("Mariann Landey");
        licnedList.add("Teasag Beitel");
        licnedList.add("Gauthier Gelen");
        licnedList.add("Benedita Basurto");
        licnedList.add("Patrice Cabrera");
        licnedList.add("Jeanette Ardito");
        licnedList.add("Sarah Holme");
        Collections.sort(licnedList);
        int count = 0;
        for (String station: licnedList) {
            lincedHash.put(count, station);
            count++;
        }
    }



//    public ArrayAdapter<String> clearStations(){
//        ArrayList<String> list =  new ArrayList<>(1);
//        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, list);
//        return listAdapter;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
