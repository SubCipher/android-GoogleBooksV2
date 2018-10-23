package com.stepwisedesigns.knax.googlebooksV2;

import android.content.Intent;
import android.net.Uri;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity implements LoaderCallbacks<List<Book>> {

    private static final int Book_LOADER_ID = 1;
    // private BooksAdapter mBooksAdapter;
    private static final String URL_REQUEST_STRING = "https://www.googleapis.com/books/v1/volumes?q=android&maxResults=10";
    private TextView mEmptyStateTextView;

    private List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;

    private BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        // mEmptyStateTextView = findViewById(com.stepwisedesigns.knax.googlebooksV2.R.id.empty_view);


        recyclerView = findViewById(R.id.recycler_view);

        booksAdapter = new BooksAdapter(bookList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(booksAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListner(this, recyclerView, new RecyclerTouchListner.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                Book book = bookList.get(position);
                Toast.makeText(BooksActivity.this, book.getmID() + "is simply clicked", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongClick(View view, int position) {
                Book book = bookList.get(position);
                Toast.makeText(BooksActivity.this, book.getmID() + "is long clicked", Toast.LENGTH_SHORT).show();

            }
        }));

        android.app.LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(Book_LOADER_ID, null, this);

    }

    @Override
    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {

        Log.e("onLoadCreate ", "createNew BookLoader");
        return new BookLoader(this, URL_REQUEST_STRING);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> books) {

        //Log.e("onLoadFinished ","" + books);

        View loadingIndicator = findViewById(com.stepwisedesigns.knax.googlebooksV2.R.id.loading_indicator_view);
        loadingIndicator.setVisibility(View.GONE);

        bookList.clear();
        //mEmptyStateTextView.setText(R.string.no_books);

        if (books != null && !books.isEmpty()) {

            bookList.clear();
            this.bookList = books;

            Log.e("onLoadFinished", "bookList.addall " + bookList.size());

        }
    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        bookList.clear();
    }
}
