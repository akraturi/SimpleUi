package org.akraturi.com.simpleui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView randomTextView;
    private ImageView contentImageView;
    private int layoutId;

    ContentHolder(LayoutInflater inflater, ViewGroup container,int resID)
    {
        super(inflater.inflate(resID,container,false));

        randomTextView = itemView.findViewById(R.id.randomTextView);
        contentImageView = itemView.findViewById(R.id.contentImage);
        layoutId = resID;
        itemView.setOnClickListener(this);
        // get reference to the views using the viewholder when the viewholders are created here


    }

    // The method binds the data to the viewholder
    public void bind(Content content)
    {
        contentImageView.setImageResource(content.imageID);
        if (layoutId!= R.layout.top_menu_row_item) {
            randomTextView.setText(content.getText());
        }

    }

    // implement the recycler view list item click action here
    @Override
    public void onClick(View view) {

        //getAdapterPosition will returns the position of the item clicked on the recycler view;

    }
}
