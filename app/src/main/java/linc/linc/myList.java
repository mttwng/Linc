package linc.linc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class myList extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> text;
    private final ArrayList<Integer> img;


    public myList(Activity context, ArrayList<String> text, ArrayList<Integer> img) {
        super(context, R.layout.list_item, text);
        this.context = context;
        this.text = text;
        this.img = img;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);
        ((TextView) rowView.findViewById(R.id.txt)).setText(text.get(position));
        try {
            ((ImageView) rowView.findViewById(R.id.img)).setImageResource(img.get(position));
        } catch (Exception e) {

        }
        return rowView;
    }
}