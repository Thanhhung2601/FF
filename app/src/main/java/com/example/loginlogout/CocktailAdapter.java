package com.example.loginlogout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CocktailAdapter extends BaseAdapter {
    private Context context ;
    private int layout ;
    private List<Cocktail> cocktailList ;
    public CocktailAdapter(Context context , int layout ,List<Cocktail> cocktailList ){
        this.context = context ;
        this.layout = layout ;
        this.cocktailList = cocktailList ;
    }

    @Override
    public int getCount() {
        return cocktailList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout , null);

        TextView name = view.findViewById(R.id.name);
        TextView classs = view.findViewById(R.id.classs);


        Cocktail cocktail = cocktailList.get(i);

        name.setText(cocktail.getName());
        classs.setText(cocktail.getClasss());


        return view;
    }
}
