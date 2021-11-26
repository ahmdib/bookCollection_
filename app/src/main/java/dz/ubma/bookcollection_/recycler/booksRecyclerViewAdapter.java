package dz.ubma.bookcollection_.recycler;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import dz.ubma.bookcollection_.R;
import dz.ubma.bookcollection_.fragments.itemBook;

public class booksRecyclerViewAdapter extends RecyclerView.Adapter<booksRecyclerViewAdapter.bookHolder> {
    ArrayList<itemBook> lBooks=new ArrayList<>();
    Context context;

    public booksRecyclerViewAdapter(ArrayList<itemBook> lBooks, Context context) {
        this.lBooks = lBooks;
        this.context = context;
    }

    @NonNull
    @Override
    public bookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_book,parent,false);
        return new bookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookHolder holder, int position) {
        itemBook it = lBooks.get(position);

        holder.txtTitleXML.setText(it.getTitle());
        holder.txtYearXML.setText(it.getYear());
        Glide.with(context).load(Uri.parse(it.getIconBook())).into(holder.ICbookXML);

        int iconStar = it.getIconStar()==1 ? R.drawable.ic_f_start: R.drawable.ic_star ;
        holder.ICStarXML.setImageResource(iconStar);
        holder.ICStarXML.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idBook= it.getId();
                it.setIconStar(it.getIconStar()==0? 1 : 0);
                int iconStar = it.getIconStar()==1 ? R.drawable.ic_f_start: R.drawable.ic_star ;
                holder.ICStarXML.setImageResource(iconStar);

                BookControler bControler= BookControler.get_instance();
                bControler.updateData(idBook,it.getIconStar());
            }
        });

    }

    @Override
    public int getItemCount() {
        return lBooks.size();
    }

    public class bookHolder extends RecyclerView.ViewHolder {
        ImageView ICbookXML;
        ImageView ICStarXML;
        TextView txtTitleXML;
        TextView txtYearXML;

        public ImageView getICbookXML() {
            return ICbookXML;
        }

        public ImageView getICStarXML() {
            return ICStarXML;
        }

        public TextView getTxtTitleXML() {
            return txtTitleXML;
        }

        public TextView getTxtYearXML() {
            return txtYearXML;
        }

        public bookHolder(@NonNull View itemView) {
            super(itemView);
            this.ICbookXML = itemView.findViewById(R.id.ICbookXML);
            this.ICStarXML=itemView.findViewById(R.id.ICStarXML);
            this.txtTitleXML=itemView.findViewById(R.id.txtTitleXML);
            this.txtYearXML=itemView.findViewById(R.id.txtYearXML);
        }
    }
}
