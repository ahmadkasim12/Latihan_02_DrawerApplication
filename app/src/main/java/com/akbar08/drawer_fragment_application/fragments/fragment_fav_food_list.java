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


public class fragment_fav_food_list extends Fragment implements item_adapter.ItemClickListener{

    RecyclerView row;
    item_adapter adapter;
    List<item_model> row_title;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_fav_food_list() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_fav_food_list.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_fav_food_list newInstance(String param1, String param2) {
        fragment_fav_food_list fragment = new fragment_fav_food_list();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_fav_food_list, container, false);
        row = root.findViewById(R.id.rv_frg_fav_food_list);
        row.setLayoutManager(new LinearLayoutManager(getContext()));
        row.setHasFixedSize(true);
        row_title = new ArrayList<item_model>();

        adapter = new item_adapter(getContext(), row_title);
        adapter.setClickListener(this);
        row.setAdapter(adapter);

        row_title.add(new item_model("Nasi Goreng Ayam Oriental khas Lek Budi",
                "Nasi goreng ayam oriental khas Lek Budi adalah nasi goreng yang dimasak dengan bumbu khas oriental dan ayam yang dipotong kecil-kecil. Nasi goreng ini biasanya disajikan dengan telur ceplok, acar, dan kerupuk.",
                "https://awsimages.detik.net.id/community/media/visual/2022/06/02/resep-nasi-goreng-oriental_43.jpeg?w=1200"));
        row_title.add(new item_model("Ramen",
                "Ramen adalah mie kuah khas Jepang yang terbuat dari mie gandum, kaldu, dan berbagai macam topping, seperti daging babi, telur rebus, dan narutomaki.",
                "https://s23209.pcdn.co/wp-content/uploads/2014/10/220602_DD_Homemade-Ramen_572-1024x1536.jpg"));
        row_title.add(new item_model("Chicken Katsu",
                "Chicken katsu adalah ayam goreng tepung khas Jepang yang dilapisi dengan tepung roti dan digoreng hingga keemasan. Chicken katsu biasanya disajikan dengan nasi putih, saus tonkatsu, dan kubis iris.",
                "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2021/03/18/0/FNK_CHICKEN_KATSU_H_f_s4x3.jpg.rend.hgtvcom.826.620.suffix/1616083203181.jpeg"));
        row_title.add(new item_model("Ricebowl Chicken Blackpepper",
                "Ricebowl chicken blackpepper adalah nasi putih yang disajikan dengan ayam yang dimasak dengan saus lada hitam. Ayam ini biasanya digoreng terlebih dahulu sebelum dimasak dengan saus lada hitam.",
                "https://img-global.cpcdn.com/recipes/f9bfa07aedd92470/680x482cq70/chicken-black-pepper-rice-bowl-foto-resep-utama.webp"));
        row_title.add(new item_model("Nasi Pecel Lele Ibu Sri",
                "Nasi pecel lele Ibu Sri adalah nasi putih yang disajikan dengan lele goreng, sambal terasi, dan lalapan. Lele goreng biasanya dibumbui dengan bumbu kuning dan digoreng hingga renyah.",
                "https://i.gojekapi.com/darkroom/gofood-indonesia/v2/images/uploads/4c7c2614-a975-43ae-aa53-df7d109ab480_256585d6-a18c-4435-978e-495e8bee2f52_Go-Biz_20200301_182629.jpeg"));


        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public void onItemClick(@NonNull View view, int position) {
        view.performHapticFeedback(HapticFeedbackConstants.CONFIRM);}
}