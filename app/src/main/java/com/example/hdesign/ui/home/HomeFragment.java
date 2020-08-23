package com.example.hdesign.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.hdesign.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ImageView avatar;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView image1 = view.findViewById(R.id.picture1);
        ImageView image2 = view.findViewById(R.id.picture2);
        ImageView image3 = view.findViewById(R.id.picture3);
        ImageView image4 = view.findViewById(R.id.picture4);
        ImageView image5 = view.findViewById(R.id.picture5);
        ImageView image6 = view.findViewById(R.id.picture6);
        ImageView image7 = view.findViewById(R.id.picture7);
        ImageView image8 = view.findViewById(R.id.picture8);
        ImageView image9 = view.findViewById(R.id.picture9);

        avatar = view.findViewById(R.id.avatar);

        glide(image1,R.drawable.picture1);
        glide(image2,R.drawable.picture2);
        glide(image3,R.drawable.picture3);
        glide(image4,R.drawable.picture4);
        glide(image5,R.drawable.picture5);
        glide(image6,R.drawable.picture6);
        glide(image7,R.drawable.picture7);
        glide(image8,R.drawable.picture8);
        glide(image9,R.drawable.picture9);

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageIntent = new Intent(Intent.ACTION_PICK);
                imageIntent.setType("image/*");
                startActivityForResult(imageIntent,42);
            }
        });
    }

    public void glide(ImageView imageView, int drawable){
        Glide
                .with(this)
                .load(drawable)
                .transform(new RoundedCorners(16))
                .into(imageView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null && requestCode == 42){
            Uri selectedImage = data.getData();
            Glide.with(this).load(selectedImage).circleCrop().into(avatar);
        }
    }
}