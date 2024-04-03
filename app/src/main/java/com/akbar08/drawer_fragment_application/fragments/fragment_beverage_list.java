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

public class fragment_beverage_list extends Fragment implements item_adapter.ItemClickListener{

    RecyclerView row;
    item_adapter adapter;
    List<item_model> row_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_beverage_list, container, false);
        row = root.findViewById(R.id.rv_frg_beverage_list);
        row.setLayoutManager(new LinearLayoutManager(getContext()));
        row.setHasFixedSize(true);
        row_title = new ArrayList<item_model>();

        adapter = new item_adapter(getContext(), row_title);
        adapter.setClickListener(this);
        row.setAdapter(adapter);

        row_title.add(new item_model("Es Cong Lik",
                "Es Cong Lik adalah minuman khas Semarang yang terbuat dari campuran berbagai macam buah-buahan, seperti nangka, alpukat, kelapa muda, dan kolang-kaling. Minuman ini disiram dengan susu kental manis dan sirup merah. Es Cong Lik biasanya disajikan dengan es serut.",
                "https://media-cdn.tripadvisor.com/media/photo-s/1a/57/e6/51/es-puter-cong-lik-simpang.jpg"));
        row_title.add(new item_model("Es Puter Cong Lik",
                "Es Puter Cong Lik adalah minuman khas Semarang yang terbuat dari santan, gula, dan tepung beras yang diputar dengan mesin tradisional. Es puter biasanya disajikan dengan berbagai macam rasa, seperti durian, kelapa muda, dan cokelat.",
                "https://warakngendog.com/wp-content/uploads/2023/04/Es-Puter-Cong-Lik.jpg"));
        row_title.add(new item_model("Wedang Tahu",
                "Wedang tahu adalah minuman khas Semarang yang terbuat dari tahu goreng, jahe, dan gula merah. Minuman ini disajikan hangat dan cocok untuk dinikmati saat musim hujan.",
                "https://img.kurio.network/LwGteLO3gfxqIso0vSoZtEDVkvQ=/440x440/filters:quality(80)/https://kurio-img.kurioapps.com/20/05/26/acfc7245-3f28-4033-9ff4-2a9c9f45a86e.jpg"));
        row_title.add(new item_model("Wedang Kacang Tanah",
                "Wedang kacang tanah adalah minuman khas Semarang yang terbuat dari kacang tanah, jahe, dan gula merah. Minuman ini disajikan hangat dan cocok untuk dinikmati saat musim hujan.",
                "https://cdn.yummy.co.id/content-images/images/20200501/q8FXVKHZhwe7H6XnntbQqmHzSdJS1Qi1-31353838323731323237d41d8cd98f00b204e9800998ecf8427e.jpg?x-oss-process=image/resize,w_388,h_388,m_fixed,x-oss-process=image/format,webp"));
        row_title.add(new item_model("Kopi Luwak",
                "Kopi luwak adalah kopi khas Indonesia yang terkenal di seluruh dunia. Kopi luwak terbuat dari biji kopi yang dimakan dan difermentasi oleh luwak, binatang mamalia yang mirip musang. Kopi luwak memiliki rasa yang unik dan khas.",
                "https://cdn.britannica.com/24/183324-050-CC7789D7/Coffee-beans-feces-palm-civet-Asian.jpg"));

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onItemClick(@NonNull View view, int position) {
        view.performHapticFeedback(HapticFeedbackConstants.CONFIRM);}
}