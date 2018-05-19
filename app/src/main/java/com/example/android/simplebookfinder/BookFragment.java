package com.example.android.simplebookfinder;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.simplebookfinder.BookModel.BookModel;
import com.example.android.simplebookfinder.BookModel.Item;
import com.squareup.picasso.Picasso;

/**
 * Created by bvmarinyak on 17.05.18.
 */

public class BookFragment extends Fragment {

    private static final String ARG_BOOK_ID = "arg_book_id";
    private Item mBook;
    private ImageView mBookImageView;
    private TextView mBookTitle;
    private TextView mBookAuthors;
    private TextView mBookPageCount;
    private TextView mBookPublishedDate;
    private TextView mBookDescription;
    private TextView mBookPublisher;
    private String authors = "";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String bookId = (String) getArguments().getSerializable(ARG_BOOK_ID);
        mBook = BookList.get().getBook(bookId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_book, container, false);


        mBookImageView = (ImageView) view.findViewById(R.id.imageView);
        if(mBook.getVolumeInfo().getImageLinks() != null) {
            Picasso.get().load(mBook.getVolumeInfo().getImageLinks().getThumbnail())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(mBookImageView);
        }else{
            mBookImageView.setImageResource(R.drawable.ic_launcher_background);
        }

        mBookTitle = (TextView) view.findViewById(R.id.book_title);
        mBookTitle.setText(mBook.getVolumeInfo().getTitle());

        mBookAuthors = (TextView) view.findViewById(R.id.book_authors);
        if(mBook.getVolumeInfo().getAuthors() != null) {
            for (String str : mBook.getVolumeInfo().getAuthors()) {
                authors += str + "\n";
            }
        }
        mBookAuthors.setText(authors);

        mBookPageCount = (TextView) view.findViewById(R.id.page_count);

        if(mBook.getVolumeInfo().getPageCount() != null) {
            mBookPageCount.setText(String.valueOf(mBook.getVolumeInfo().getPageCount()));
        }else{
            mBookPageCount.setText("");
        }

        mBookPublishedDate = (TextView) view.findViewById(R.id.published_date);

        if(mBook.getVolumeInfo().getPublishedDate() != null) {
            mBookPublishedDate.setText(mBook.getVolumeInfo().getPublishedDate());
        }else{
            mBookPublishedDate.setText("");
        }

        mBookDescription = (TextView) view.findViewById(R.id.description);

        if(mBook.getVolumeInfo().getDescription() != null) {
            mBookDescription.setText(mBook.getVolumeInfo().getDescription());
        }else{
            mBookDescription.setText("");
        }

        mBookPublisher = (TextView) view.findViewById(R.id.publisher);

        if(mBook.getVolumeInfo().getPublisher() != null) {
            mBookPublisher.setText(mBook.getVolumeInfo().getPublisher());
        }else{
            mBookPublisher.setText("");
        }

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
