package com.akbar08.drawer_fragment_application.fragments;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akbar08.drawer_fragment_application.R;
import com.akbar08.drawer_fragment_application.adapter.item_adapter;
import com.akbar08.drawer_fragment_application.adapter.item_model;

import java.util.ArrayList;
import java.util.List;


public class fragment_food_list extends Fragment implements item_adapter.ItemClickListener{

    RecyclerView row;
    item_adapter adapter;
    List<item_model> row_title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_food_list, container, false);
        row = root.findViewById(R.id.rv_frg_food_list);
        row.setLayoutManager(new LinearLayoutManager(getContext()));
        row.setHasFixedSize(true);
        row_title = new ArrayList<item_model>();

        adapter = new item_adapter(getContext(), row_title);
        adapter.setClickListener(this);
        row.setAdapter(adapter);

        row_title.add(new item_model("Lumpia Semarang", "Makanan ini adalah camilan gurih yang terbuat dari rebung, telur, dan daging ayam atau udang yang dibungkus dengan kulit lumpia tipis dan renyah. Biasanya disajikan dengan saus tauco dan cabai rawit.", "https://img.kurio.network/IYfNVUtjTkrn17yJ3qakb_g2uaI=/440x440/filters:quality(80)/https://kurio-img.kurioapps.com/20/10/13/29a1a2bc-7a57-4997-8121-7c2ce9855a05.jpeg"));
        row_title.add(new item_model("Tahu Gimbal", "Hidangan ini terdiri dari tahu goreng, bakwan udang, kol, lontong, dan disiram dengan kuah kacang yang gurih dan kental. Biasanya ditaburi dengan kerupuk udang dan bawang goreng.", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Tahu_gimbal_in_Semarang.jpg/1280px-Tahu_gimbal_in_Semarang.jpg"));
        row_title.add(new item_model("Soto Semarang", "Soto ini memiliki ciri khas kuah bening yang gurih dan segar. Biasanya berisi suwiran ayam, tauge, bihun, dan telur rebus. Disajikan dengan sambal dan jeruk nipis untuk menambah cita rasa.", "https://img.kurio.network/tDrPs4bJiUrcR5YYrLNT-LtvTCE=/440x440/filters:quality(80)/https://kurio-img.kurioapps.com/21/03/02/4b39cdbb-c85c-4d0a-8861-bfd01a3fd88b.jpe"));
        row_title.add(new item_model("Babat Gongso", "Hidangan ini terbuat dari babat sapi yang dimasak dengan bumbu rempah-rempah dan cabai, menghasilkan rasa pedas dan gurih yang khas. Biasanya disajikan dengan nasi putih hangat dan sambal.", "https://paxelmarket.co/wp-content/uploads/2021/09/Babat-Gongso-Warung-Pak-Sukarmin.jpg"));
        row_title.add(new item_model("Mie Kopyok", "Mie kopyok adalah makanan khas Semarang yang terbuat dari mie kuning, tauge, kol, dan taoge yang disiram dengan kuah kaldu sapi yang gurih. Mie kopyok biasanya disajikan dengan kerupuk gendar dan jeruk nipis.", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Mie_Kopyok_Semarang.jpg/800px-Mie_Kopyok_Semarang.jpg"));

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onItemClick(@NonNull View view, int position) {
        view.performHapticFeedback(HapticFeedbackConstants.CONFIRM);}
}