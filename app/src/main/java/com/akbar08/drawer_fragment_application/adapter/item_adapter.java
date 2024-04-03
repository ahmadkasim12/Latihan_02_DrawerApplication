package com.akbar08.drawer_fragment_application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akbar08.drawer_fragment_application.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class item_adapter extends RecyclerView.Adapter<item_adapter.layoutIdGetter> {
    Context context;
    private static ItemClickListener mClickListener;
    List<item_model> item;

    public item_adapter(Context _context, List<item_model> item) {
        this.context = _context;
        this.item = item;
    }


    @NonNull
    @Override
    public layoutIdGetter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new layoutIdGetter(LayoutInflater.from(context).inflate(R.layout.recycler_view_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull layoutIdGetter holder, int position) {
        holder.tv_header.setText(item.get(position).getTextHeader());
        holder.tv_desc.setText(item.get(position).getTextDesc());
        Glide.with(holder.itemView.getContext()).load(item.get(position).getImgUrl()).into(holder.img_url);
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public static class layoutIdGetter extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_header, tv_desc;
        ImageView img_url;
        public layoutIdGetter(@NonNull View itemView) {
            super(itemView);
            tv_header = itemView.findViewById(R.id.tv_header);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            img_url = itemView.findViewById(R.id.iv_makanan);

            itemView.setOnClickListener(this);
        }

        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
