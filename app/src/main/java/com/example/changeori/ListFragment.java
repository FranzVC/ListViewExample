package com.example.changeori;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class ListFragment extends android.support.v4.app.ListFragment {

    private ArticleListener articleListener;

    public ListFragment() {
        // Required empty public constructor
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> list = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.article));
        setListAdapter(list);
        if (this.getActivity().findViewById(R.id.layout_default)==null)
        {
            articleListener.onArticleSelected(0);
        }
    }

    public interface ArticleListener{
        void onArticleSelected(int index);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            articleListener = (ArticleListener) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + "must implement the interface called " +
                    "ArticleListener!");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        articleListener.onArticleSelected(position);
    }
}