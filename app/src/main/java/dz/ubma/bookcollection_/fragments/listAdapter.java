package dz.ubma.bookcollection_.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import dz.ubma.bookcollection_.R;

public class listAdapter extends ArrayAdapter<itemBook> {
    public listAdapter(@NonNull Context context, @NonNull ArrayList<itemBook> objects) {
        super(context, R.layout.item_book, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        itemBook itb = getItem(position);

        if(convertView == null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_book,parent,false);
        }

        //récupération des réfences des composantes XML
        TextView titleView = convertView.findViewById(R.id.txtTitleXML);
        TextView yearView = convertView.findViewById(R.id.txtYearXML);
        ImageView imageView = convertView.findViewById(R.id.ICbookXML);
        ImageView startImageView = convertView.findViewById(R.id.ICStarXML);

        // Allimentation des des composantes XML par les valeurs (données) récupérées dans itb
        titleView.setText(itb.title);
        yearView.setText(itb.year);
        //imageView.setImageResource(itb.iconBook);
        startImageView.setImageResource(itb.iconStar);

        // retour de la vue
        return convertView;
    }
}



