package com.example.dti.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dti.R;
import com.example.dti.activities.ModelImagePicked;
import com.example.dti.databinding.RowImagesPickedBinding;

import java.util.ArrayList;

public class AdapterImagesPicked extends RecyclerView.Adapter<AdapterImagesPicked.HolderImagesPicked>{
    private RowImagesPickedBinding binding;
    private static final String TAG = "IMAGES_TAG";
    private Context context;
    private ArrayList<ModelImagePicked> imagePickedArrayList;

    public AdapterImagesPicked(Context context, ArrayList<ModelImagePicked> imagePickedArrayList) {
        this.context = context;
        this.imagePickedArrayList = imagePickedArrayList;
    }

    @NonNull
    @Override
    public HolderImagesPicked onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RowImagesPickedBinding.inflate(LayoutInflater.from(context), parent, false);

        return new HolderImagesPicked(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HolderImagesPicked holder, int position) {

        ModelImagePicked model = imagePickedArrayList.get(position);
        Uri imageUri = model.getImageUri();

        try {
            Glide.with(context)
                    .load(imageUri)
                    .placeholder(R.drawable.ic_image_gray)
                    .into(holder.imageTv);
        } catch (Exception e){
            Log.e(TAG, "onBindViewHolder: ", e);
        }

        holder.closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePickedArrayList.remove(model);
                notifyItemRemoved(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return imagePickedArrayList.size();
    }

    class HolderImagesPicked extends RecyclerView.ViewHolder{

        ImageView imageTv;
        ImageButton closeBtn;
        public HolderImagesPicked(View itemView){
            super(itemView);

            imageTv = binding.imageTv;
            closeBtn = binding.clodeBtn;
        }

    }
}
