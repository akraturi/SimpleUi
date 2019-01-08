package org.akraturi.com.simpleui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class ContentAdapter extends RecyclerView.Adapter<ContentHolder> {


    private List mContents;
    private Context mContext;
    private int rowLayoutId;

    public ContentAdapter(List<Content> contents,Context context,int id)
    {
        mContents =  contents;
        mContext =   context;
        rowLayoutId = id;
        mContents = contents;
    }

    // second method that will be called
    @NonNull
    @Override
    public ContentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new ContentHolder(layoutInflater,parent,rowLayoutId);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentHolder holder, int position) {
        Content content = (Content)mContents.get(position);
        holder.bind(content);

    }

    // first this method will  call
    @Override
    public int getItemCount() {
        return mContents.size();
    }
}
