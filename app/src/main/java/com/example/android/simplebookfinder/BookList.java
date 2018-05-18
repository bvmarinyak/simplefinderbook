package com.example.android.simplebookfinder;

import com.example.android.simplebookfinder.BookModel.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bvmarinyak on 18.05.18.
 */

public class BookList {
    private static BookList sBookList;
    private List<Item> mBook;

    public static BookList get(){
        if(sBookList == null){
            sBookList = new BookList();
        }
        return sBookList;
    }

    private BookList(){
        mBook = new ArrayList<>();
    }

    public void setBookList(List<Item> book){
        mBook.addAll(book);
    }

    public Item getBook(String id){
        for(Item book: mBook){
            if(book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }
}
