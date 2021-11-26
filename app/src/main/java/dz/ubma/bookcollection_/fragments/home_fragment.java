package dz.ubma.bookcollection_.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import dz.ubma.bookcollection_.R;

public class home_fragment extends Fragment {

    ArrayList<itemBook> alBooks;
    ListView lvBooks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // définir les données
        alBooks = new ArrayList<itemBook>();
        int bookIcon= getContext().getResources()
                .getIdentifier("book_icon","drawable",getContext().getPackageName());
        int starIcon= getContext().getResources()
                .getIdentifier("ic_star","drawable",getContext().getPackageName());

//        itemBook book1= new itemBook("titre1", "2000", bookIcon, starIcon);
//        alBooks.add(book1);
//        itemBook book2= new itemBook("titre2", "2002", bookIcon, starIcon);
//        alBooks.add(book2);
//        itemBook book3= new itemBook("titre3", "2003", bookIcon, starIcon);
//        alBooks.add(book3);
//        itemBook book4= new itemBook("titre4", "2004", bookIcon, starIcon);
//        alBooks.add(book4);
//        itemBook book5= new itemBook("titre5", "2005", bookIcon, starIcon);
//        alBooks.add(book5);

        View view= inflater.inflate(R.layout.home_fragment, container, false);

        // récupération du listView
        lvBooks = view.findViewById(R.id.lvBooks);

        // Lier la listView avec l'adapter
        listAdapter lAdapter = new listAdapter(container.getContext(),alBooks);
        lvBooks.setAdapter(lAdapter);

        lvBooks.setClickable(true);
        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),alBooks.get(position).title, Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(getContext(), details.class);
                //i.putExtra("title",alBooks.get(position).title);
                //startActivity(i);
            }
        });

        return view;
    }
}
