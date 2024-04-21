package com.example.dti.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dti.databinding.RowCategoryBinding;
import com.example.dti.listeners.RvListenerCategory;
import com.example.dti.models.ModelCategory;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;

import java.util.ArrayList;
import java.util.Random;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.HolderCategory>{

    private RowCategoryBinding binding;
    private ArrayList<ModelCategory> categoryArrayList;
    private RvListenerCategory rvListenerCategory;
    private Context context;

    public AdapterCategory(Context context, ArrayList<ModelCategory> categoryArrayList, RvListenerCategory rvListenerCategory) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
        this.rvListenerCategory = rvListenerCategory;
    }

    @NonNull
    @Override
    public HolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RowCategoryBinding.inflate(LayoutInflater.from(context), parent, false);

        return new HolderCategory(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCategory holder, int position) {
        ModelCategory modelCategory = categoryArrayList.get(position);
        String category = modelCategory.getCategory();
        int icon = modelCategory.getIcon();

        Random random = new Random();
        int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));

        holder.categoryIconIv.setImageResource(icon);
        holder.categoryIconTv.setText(category);
        //holder.categoryIconIv.setBackgroundC;////////////////

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rvListenerCategory.onCategoryClick(modelCategory);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HolderCategory extends RecyclerView.ViewHolder{

        ShapeableImageView categoryIconIv;
        TextView categoryIconTv;
        public HolderCategory(View itemView){
            super(itemView);

            categoryIconIv = binding.categoryIconIv;
            categoryIconTv = binding.categoryTitleTv;
        }
    }



}

