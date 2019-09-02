package com.example.changeori;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import es.dmoral.toasty.Toasty;


public class MainActivity extends AppCompatActivity implements ListFragment.ArticleListener{

    TextView tvDetails;
    ImageView ivDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails =findViewById(R.id.tvDetails);
        ivDetails = findViewById(R.id.ivDetails);
        if (findViewById(R.id.layout_default)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();
            Toasty.success(this, "Portrait!", Toast.LENGTH_LONG, true).show();

        }
        if (findViewById(R.id.layout_land)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.listFragment))
                    .commit();
            Toasty.success(this, "Landscape!", Toast.LENGTH_SHORT, true).show();
        }
    }

    public void onArticleSelected(int index) {
        if (findViewById(R.id.layout_default)!=null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFragment))
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .addToBackStack(null)
                    .commit();
        }
        Toasty.info(this, "article selected", Toast.LENGTH_SHORT, true).show();
        String [] News = getResources().getStringArray(R.array.News);
        String [] Images = getResources().getStringArray(R.array.images);
        //Picasso.get().load("https://image.shutterstock.com/image-photo/mountains-during-sunset-beautiful-natural-260nw-407021107.jpg")
              //  .resize(500,500).into(ivDetails);
        tvDetails.setText(News[index]);
    }
}
