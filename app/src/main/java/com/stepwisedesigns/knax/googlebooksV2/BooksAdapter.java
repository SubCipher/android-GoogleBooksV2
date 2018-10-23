package com.stepwisedesigns.knax.googlebooksV2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {

    private List<Book> booksList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView rating, title, subtitle, author, type, ID;

        public MyViewHolder(View view) {
            super(view);
            rating = view.findViewById(R.id.rating_text_view);
            title = view.findViewById(R.id.title_text_view);
            subtitle = view.findViewById(R.id.subtitle_text_view);
            ;
            author = view.findViewById(R.id.author_text_view);
            ;
            type = view.findViewById(R.id.isbn_text_view);
            ;
            ID = view.findViewById(R.id.id_text_view);
        }
    }

    public BooksAdapter(List<Book> booksList) {

        this.booksList = booksList;
    }

    @NonNull
    @Override
    public BooksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.MyViewHolder holder, int position) {

        Book currentBook = booksList.get(position);

        String formattedRating = formatrating(currentBook.getmRating());

        holder.rating.setText(formattedRating);

        holder.title.setText(currentBook.getmBookTitle());
        holder.subtitle.setText(currentBook.getmSubtitle());

        holder.author.setText(currentBook.getmAuthor());
        holder.type.setText(currentBook.getmType());
        holder.ID.setText(currentBook.getmID());
    }

    @Override
    public int getItemCount() {
        Log.i("BooksAdapter booksList ", "bookList.size() = " + booksList.size());
        return booksList.size();
    }


//    private int getRatingColor(double readerRating ){
//        int readerRatingColorResourceId;
//        int ratingFloor = (int)Math.floor(readerRating);
//
//        switch (ratingFloor){
//            case 0:
//            case 1:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating1;
//                break;
//            case 2:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating2;
//                break;
//            case 3:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating3;
//                break;
//            case 4:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating4;
//                break;
//            case 5:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating5;
//                break;
//            case 6:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating6;
//                break;
//            case 7:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating7;
//                break;
//            case 8:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating8;
//                break;
//            case 9:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating9;
//                break;
//            default:
//                readerRatingColorResourceId = com.stepwisedesigns.knax.googlebooksV2.R.color.rating10plus;
//                break;
//        }
//
//        return ContextCompat.getColor(getContext(), readerRatingColorResourceId);
//    }

    private String formatrating(double rating) {
        DecimalFormat ratingFormat = new DecimalFormat("0.0");
        return ratingFormat.format(rating);
    }
}
