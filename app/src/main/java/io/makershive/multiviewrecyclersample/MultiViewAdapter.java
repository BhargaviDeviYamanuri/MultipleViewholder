package io.makershive.multiviewrecyclersample;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.makershive.multiviewrecyclersample.Model.DisplayModel;

public class MultiViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<DisplayModel> dataModels = new ArrayList<>();

    public MultiViewAdapter(Context context, ArrayList<DisplayModel> dataModels) {
        this.context = context;
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        switch (i) {
            case 3:
                View view = layoutInflater.inflate(R.layout.item_text_layout, viewGroup, false);
                return new TextViewHolder(view);
            case 2:
                View imageView = layoutInflater.inflate(R.layout.item_image_layout, viewGroup, false);
                return new ImageViewholder(imageView);
        }
        View view = layoutInflater.inflate(R.layout.item_image_layout, viewGroup, false);
        return new ImageViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == Constants.IMAGE_TYPE) {
            ((ImageViewholder) viewHolder).setTitle(dataModels.get(i).getReportName());
            //((ImageViewholder) viewHolder).setImage(dataModels.get(i).getImageLoc());
        } else if (viewHolder.getItemViewType() == Constants.TEXT_TYPE) {
            ((TextViewHolder) viewHolder).setTvMonth(dataModels.get(i).getMonthName());
        }
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataModels.get(position).getViewType();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        TextView tvMonth = itemView.findViewById(R.id.tvMonth);

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setTvMonth(String month) {
            tvMonth.setText(month);
        }
    }

    public class ImageViewholder extends RecyclerView.ViewHolder {
        TextView tvTitle = itemView.findViewById(R.id.tvTitle);
        ImageView ivProfile = itemView.findViewById(R.id.ivProfile);

        public ImageViewholder(@NonNull View itemView) {
            super(itemView);
        }

        public void setImage(String imgLoc) {
            ivProfile.setImageURI(Uri.parse(imgLoc));
        }

        public void setTitle(String title) {
            tvTitle.setText(title);
        }
    }
}
