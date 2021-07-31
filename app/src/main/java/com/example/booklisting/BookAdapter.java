package com.example.booklisting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    public  BookAdapter(Context context, List<Book> books){

        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
              R.layout.book_list_item, parent, false
            );
        }

        Book book = getItem(position);

        ImageView bookImage = listItemView.findViewById(R.id.image);
        TextView bookTitle = listItemView.findViewById(R.id.book_title);
        TextView bookAuthor = listItemView.findViewById(R.id.book_author);
        TextView bookPages = listItemView.findViewById(R.id.book_pages);
        String formattedPages = formatPages(book.getPages());

        String imageURL = book.getImageUrl();
        Picasso.get().load(book.getImageUrl()).into(bookImage);

        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
        bookPages.setText(formattedPages);

        return listItemView;

    }

    private String formatPages(long pages){
        Long pgs = pages;
        return pgs.toString();
    }

}
