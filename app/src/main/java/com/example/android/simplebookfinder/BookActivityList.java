package com.example.android.simplebookfinder;

import android.support.v4.app.Fragment;

public class BookActivityList extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new BookListFragment();
    }
}
