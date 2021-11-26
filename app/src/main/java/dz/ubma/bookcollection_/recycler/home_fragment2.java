package dz.ubma.bookcollection_.recycler;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dz.ubma.bookcollection_.R;
import dz.ubma.bookcollection_.fragments.itemBook;
import dz.ubma.bookcollection_.fragments.listAdapter;

public class home_fragment2 extends Fragment {

    ArrayList<itemBook> alBooks;
    RecyclerView rvBooks;
    View view2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // définir les données
        alBooks = new ArrayList<itemBook>();

        View view = inflater.inflate(R.layout.home_fragment2, container, false);

        BookControler bControler = BookControler.get_instance();
        bControler.loadData(view, getContext());
        view2=view;
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        BookControler bControler = BookControler.get_instance();
        bControler.realTimeLoadData(view2, getContext());
    }

    @Override
    public void onStop() {
        super.onStop();
        BookControler bControler = BookControler.get_instance();
        bControler.removeListener();
    }
}
