package com.example.android.simplebookfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.simplebookfinder.BookModel.BookModel;
import com.example.android.simplebookfinder.BookModel.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bvmarinyak on 17.05.18.
 */

public class BookListFragment extends Fragment {

    private RecyclerView mBookRecyclerView;
    public static BookModel mBookModel;
    private List<Item> mBook;
    private BookAdapter mAdapter;
    private String authors;
    private static final String API_KEY = "AIzaSyCH7Wnwn1xdLdDUlByVi-nVTxkSoxH3jF4";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        mBookRecyclerView = (RecyclerView) view.findViewById(R.id.book_recycler_view);
        mBookRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private class BookHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleTextView;
        private TextView mAuthorsTextView;
        private ImageView mBookImageView;
        private Item mBook;

        public BookHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_book, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.title_book);
            mAuthorsTextView = (TextView) itemView.findViewById(R.id.authors_book);
            mBookImageView = (ImageView) itemView.findViewById(R.id.image_book);

        }

        public void bind(Item book){
            mBook = book;

            //Заголовок
            mTitleTextView.setText(mBook.getVolumeInfo().getTitle());

            //Автор
            if(mBook.getVolumeInfo().getAuthors() != null) {
                for (String str : mBook.getVolumeInfo().getAuthors()) {
                    authors += str + "\n";
                }
            }
            mAuthorsTextView.setText(authors);
            authors = "";

            //Картинка

            Picasso.get().load(mBook.getVolumeInfo().getImageLinks().getSmallThumbnail())
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                        .into(mBookImageView);

        }

        @Override
        public void onClick(View view) {
            Intent intent = BookActivity.newIntent(getActivity(), mBook.getId());
            startActivity(intent);
        }
    }

    private class BookAdapter extends RecyclerView.Adapter<BookHolder>{

        private List<Item> mBook;

        public BookAdapter(List<Item> books){
            mBook = books;
        }

        @Override
        public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new BookHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(BookHolder holder, int position) {
            Item book = mBook.get(position);
            holder.bind(book);
        }

        @Override
        public int getItemCount() {
            return mBook.size();
        }


    }


    private void updateUI(){

        mBook = new ArrayList<>();
        mAdapter = new BookAdapter(mBook);
        mBookRecyclerView.setAdapter(mAdapter);

        MyApp.getApi().getData("witcher", API_KEY).enqueue(new Callback<BookModel>() {
            @Override
            public void onResponse(Call<BookModel> call, Response<BookModel> response) {

                if(response.isSuccessful()){
                    mBookModel = response.body();
                    mBook.addAll(mBookModel.getItems());
                    mAdapter.notifyDataSetChanged();
                }else{
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<BookModel> call, Throwable t) {
                Toast.makeText(getActivity(), "An error occurred during networking",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

}
