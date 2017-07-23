package develops.stud11314037.simplegridview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import develops.stud11314037.simplegridview.R;
import develops.stud11314037.simplegridview.adapter.ItemGridAdapter;

public class MainActivity extends AppCompatActivity {

    private String[] images = new String[]{
            "http://orig15.deviantart.net/c473/f/2016/282/6/8/tahm_kench_card_by_pixelcard-dajjh91.png",
            "http://img00.deviantart.net/8918/i/2016/292/0/e/thresh_card_by_pixelcard-dalebrz.png",
            "http://orig14.deviantart.net/9bcb/f/2016/283/8/1/karthus_card_by_pixelcard-dakbrj2.png",
            "http://orig01.deviantart.net/4646/f/2016/283/0/f/lil_devil_teemo_card_by_pixelcard-dak1eri.png",
            "http://orig10.deviantart.net/8412/f/2016/286/5/2/meep_cannon_by_pixelcard-dakxj0c.png",
            "http://orig10.deviantart.net/04a1/f/2017/086/e/d/genjitrans_by_pixelcard-db3setx.png",
            "http://orig09.deviantart.net/e262/f/2016/290/6/c/ahri__p__by_pixelcard-dakq37p.png",
            "http://orig00.deviantart.net/a14b/f/2016/283/f/c/mastery_card_by_pixelcard-dajx65c.png",
            "http://orig13.deviantart.net/ab2b/f/2016/283/9/f/irelia_card_by_pixelcard-dajjgpk.png",
            "http://orig14.deviantart.net/6ad4/f/2016/283/7/c/fragment_card_by_pixelcard-dajjg7r.png"
    };
    private GridView gvItem;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("PixelCard");
        gvItem = (GridView) findViewById(R.id.gv_item);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(MainActivity.this, images);
        gvItem.setAdapter(itemGridAdapter);
        gvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView parent, View view,
                                    int position, long id) {
                DetailImageActivity.toDetailImageActivity(MainActivity.this,

                        images[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_staggered) {
            StaggeredGridActivity.toStaggeredGridActivity(MainActivity.this);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}