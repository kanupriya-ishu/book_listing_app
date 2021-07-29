package com.example.booklisting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
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
        TextView bookPrice = listItemView.findViewById(R.id.book_price);
        String formattedPrice = formatPrice(book.getPrice());

        String imageURL = book.getImageUrl();
        try {
            URL url = new URL(imageURL);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            bookImage.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bookTitle.setText(book.getTitle());
        bookAuthor.setText(book.getAuthor());
        bookPrice.setText(formattedPrice);

        return listItemView;

    }

    private String formatPrice(double price){
        DecimalFormat priceFormat = new DecimalFormat("0.00");
        return priceFormat.format(price);
    }

}
