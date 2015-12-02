package linc.linc;

import android.view.ViewGroup;
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

    HashMap<String, Integer> allList = new HashMap<String, Integer>();
    ArrayList<String> discoverList;
    ArrayList<String> licnedList;
    ArrayList<String> settingsList;
    ArrayList<String> toggleList;
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
        final ListView toggleView = (ListView) findViewById(R.id.toggleView);
        final Button lincButton = (Button) findViewById(R.id.lincToButton);
        final Button discoverButton = (Button) findViewById(R.id.findButton);
        final Button settingsButton = (Button) findViewById(R.id.settingsButton);
        final TextView lineDiscover = (TextView) findViewById(R.id.discoverUnderline);
        final TextView lineLinced = (TextView) findViewById(R.id.lincedUnderline);
        final TextView lineSettings = (TextView) findViewById(R.id.underlineMap);
        lineSettings.setBackgroundColor(Color.parseColor(backgroundColor));
        settingsButton.setTextColor(Color.parseColor(white));
        pressButton(lineDiscover, lineLinced, discoverButton, lincButton, settingsButton);

        addDiscoverList();
        addLincedHash();
        addSettingsList();

        toggleList = new ArrayList<>(1);
        toggleList.add("Discoverable");

        toggleView.setAdapter(toggleSet());
        listView.setAdapter(discoverPeopleSet());

        lincButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleView.setAdapter(null);
                listView.setAdapter(lincedPeople());
                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) listView.getLayoutParams();
                mlp.setMargins(12, 85, 12, 0);
                pressButton(lineLinced, lineDiscover, lincButton, discoverButton, settingsButton);

            }
        });

        discoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleView.setAdapter(null);
                listView.setAdapter(discoverPeopleSet());
                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) listView.getLayoutParams();
                mlp.setMargins(12, 85, 12, 0);
                pressButton(lineDiscover, lineLinced, discoverButton, lincButton, settingsButton);

            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleView.setAdapter(null);
                listView.setAdapter(settingsList());
                ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) listView.getLayoutParams();
                mlp.setMargins(12, 85, 12, 0);
                lineDiscover.setBackgroundColor(Color.parseColor(backgroundColor));
                lineLinced.setBackgroundColor(Color.parseColor(backgroundColor));
                settingsButton.setTextColor(Color.parseColor(highlightColor));
                lincButton.setTextColor(Color.parseColor(white));
                discoverButton.setTextColor(Color.parseColor(white));

            }
        });


    }

    public void pressButton(TextView a, TextView b, Button x, Button y, Button z) {
        a.setBackgroundColor(Color.parseColor(highlightColor));
        b.setBackgroundColor(Color.parseColor(backgroundColor));
        x.setTextColor(Color.parseColor(highlightColor));
        y.setTextColor(Color.parseColor(white));
        z.setTextColor(Color.parseColor(white));

    }

    public myList discoverPeopleSet(){
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

    public myList settingsList() {
        alreadylincedList = new ArrayList<Integer>(settingsList.size());
        return new myList(MainActivity.this, settingsList, alreadylincedList);
    }

    public myList toggleSet() {
        alreadylincedList = new ArrayList<Integer>(settingsList.size());
        return new myList(MainActivity.this, toggleList, alreadylincedList);
    }

    public void addDiscoverList() {
        discoverList = new ArrayList<>(45);
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
        for (String person : discoverList) {
            discoverHash.put(count, person);
            allList.put(person, count);
            count++;
        }
    }

    public void addLincedHash() {
        licnedList = new ArrayList<>(45);
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
        for (String person : licnedList) {
            lincedHash.put(count, person);
            count++;
        }
    }

    public void addSettingsList() {
        settingsList = new ArrayList<>(45);
        settingsList.add("Linkedin");
        settingsList.add("Facebook");
        settingsList.add("Google");
        settingsList.add("Phone");
        settingsList.add("Email");
        settingsList.add("Toggle");

    }


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
