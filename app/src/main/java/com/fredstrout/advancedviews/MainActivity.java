package com.fredstrout.advancedviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set variables
        ListView lv = (ListView) findViewById(R.id.states_ListView);
        Spinner sv = (Spinner) findViewById(R.id.states_SpinnerView);
        boolean landscape = getResources().getBoolean(R.bool.isLandscape);

        // create ArrayList - This type of array is not really needed unless I want to add and subtract items to it.
        ArrayList <States> states = new ArrayList<States>();
        states.add(new States("California", "Sacramento", "CA"));
        states.add(new States("Louisiana", "Baton Rouge", "LA"));
        states.add(new States("Texas", "Austin", "TX"));

        // check screen orientation and do something specific based off of the result
        if (landscape) { // screen is in landscape
            lv.setOnItemClickListener(rowTapped);
            StateAdapter adapter1 = new StateAdapter(this, states);
            lv.setAdapter(adapter1);

        } else { // screen is in portrait
            sv.setOnItemSelectedListener(rowSelected);
            ArrayAdapter <States> adapter = new ArrayAdapter<States>(this, android.R.layout.simple_spinner_dropdown_item, states);
            sv.setAdapter(adapter);
        }
    } // End onCreate

    // space
    // Do this when an item is clicked in the ListView (only available in landscape)
    AdapterView.OnItemClickListener rowTapped = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

            Object obj = adapterView.getAdapter().getItem(position);
            if (obj instanceof States) {
                States state = (States) obj;
                displayToast(state.getName(),state.getCapital(), state.getsAbbreviation());
            }
        }
    }; // End OnItemClickListener

    // space
    // Do this when an item is selected from the spinner (only available in portrait)
    AdapterView.OnItemSelectedListener rowSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
            Object obj = adapterView.getAdapter().getItem(position);
            if (obj instanceof States) {
                States state = (States) obj;
                displayToast(state.getName(), state.getCapital(), state.getsAbbreviation());
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }; // End OnItemSelectedListener

    // space
    // create a Toast shared by both event listeners
    private void displayToast (String stateName, String capitalName, String stateAbbrev) {
        String displayText = (String) (capitalName + ", " + stateAbbrev + " is the capital of " + stateName + ".");
        Toast toast = Toast.makeText(getApplicationContext(), displayText, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.show();
    } // End displayToast

}