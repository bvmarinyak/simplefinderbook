package com.example.android.simplebookfinder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by bvmarinyak on 17.05.18.
 */

public class BookActivity extends SingleFragmentActivity {

    public static final String BOOK_ID = "book_id";
    @Override
    protected Fragment createFragment() {

        String bookId = (String) getIntent().getSerializableExtra(BOOK_ID);

        return BookFragment.newInstance(bookId);
    }

    public static Intent newIntent(Context packageContext, String bookId){
        Intent intent = new Intent(packageContext, BookActivity.class);
        intent.putExtra(BOOK_ID, bookId);
        return intent;
    }
}
