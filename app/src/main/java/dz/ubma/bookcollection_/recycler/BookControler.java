package dz.ubma.bookcollection_.recycler;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;

import dz.ubma.bookcollection_.R;
import dz.ubma.bookcollection_.fragments.itemBook;

public class BookControler {

    private static final String TAG = "BookControler";
    static BookControler _instance;
    String COLLECTION_KEY = "book";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    ListenerRegistration listenerRegistration;

    public ArrayList<itemBook> getlBook() {
        return lBook;
    }

    ArrayList<itemBook> lBook = new ArrayList<>();

    public static BookControler get_instance() {
        if (_instance == null) {
            return new BookControler();
        } else
            return _instance;
    }

    public BookControler() {
        lBook = new ArrayList<>();
    }

    public void loadData(View view, Context context) {
        RecyclerView rvBooks = view.findViewById(R.id.rvBooks);
        lBook.clear();

        db.collection(COLLECTION_KEY)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                itemBook it = document.toObject(itemBook.class);
                                lBook.add(it);
                                Log.d(TAG, "ID Book => " + it.getId());
                            }
                            // Lier la listView avec l'adapter
                            rvBooks.setAdapter(new booksRecyclerViewAdapter(lBook, context));
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void realTimeLoadData(View view, Context context) {
        listenerRegistration= db.collection(COLLECTION_KEY)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot snapshots,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            System.err.println("Listen failed: " + e.getMessage());
                            return;
                        }
                        for (DocumentChange dc : snapshots.getDocumentChanges()) {
                            switch (dc.getType()) {
                                case ADDED:
                                    System.out.println("New city: " + dc.getDocument().getData());
                                    break;
                                case MODIFIED:
                                    loadData(view, context);
                                    System.out.println("Modified city: " + dc.getDocument().getData());
                                    break;
                                case REMOVED:
                                    System.out.println("Removed city: " + dc.getDocument().getData());
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                });
    }

    public void updateData(String idBook, int iconStar) {
        db.collection(COLLECTION_KEY).document(idBook)
                .update("iconStar", iconStar);
    }

    public void removeListener(){
        listenerRegistration.remove();
    }
}

