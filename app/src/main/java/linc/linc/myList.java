package linc.linc;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mattw on 11/30/15.
 */
public class myList extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> person;
    private final ArrayList<Integer> checkmark;
    public myList(Activity context,
                  ArrayList<String> person, ArrayList<Integer> checkmark) {
        super(context, R.layout.list_item, person);
        this.context = context;
        this.person = person;
        this.checkmark = checkmark;

    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        final ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(person.get(position));

        imageView.setImageResource(checkmark.get(position));

        return rowView;
    }
}