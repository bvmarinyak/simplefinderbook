package com.example.android.simplebookfinder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.simplebookfinder.BookModel.Item;

/**
 * Created by bvmarinyak on 17.05.18.
 */

public class BookFragment extends Fragment {

    private static final String ARG_BOOK_ID = "arg_book_id";
    private Item mBook;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String bookId = (String) getArguments().getSerializable(ARG_BOOK_ID);
        BookListFragment.mBookModel.getItems().

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        return view;
    }

    public static BookFragment newInstance(String bookId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_BOOK_ID, bookId);

        BookFragment fragment = new BookFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
