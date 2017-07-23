package develops.stud11314037.simplegridview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;

import develops.stud11314037.simplegridview.R;
import develops.stud11314037.simplegridview.adapter.ItemGridAdapter;

public class StaggeredGridActivity extends AppCompatActivity {

    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "http://pre05.deviantart.net/5a16/th/pre/f/2016/238/1/4/meowth_mirrored_by_tamberella-dafct2z.jpg",
            "http://pre02.deviantart.net/14c9/th/pre/f/2016/253/d/2/raticate_mirrored_by_tamberella-dah719e.jpg",
            "http://pre14.deviantart.net/5503/th/pre/f/2016/243/b/e/marowak_mirrored_by_tamberella-dag19zk.jpg",
            "http://pre09.deviantart.net/d317/th/pre/f/2016/289/f/0/ninetales_mirrored_by_tamberella-dal723w.jpg",
            "http://pre00.deviantart.net/f57f/th/pre/f/2016/286/c/9/raichu_mirrored_by_tamberella-dakwxsj.jpg",
            "http://pre05.deviantart.net/0282/th/pre/f/2016/233/2/8/sandslash_mirrored_by_tamberella-daet2j3.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);

        getSupportActionBar().setTitle("Pokemon");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        staggeredGridView = (StaggeredGridView) findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(StaggeredGridActivity.this, items);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(StaggeredGridActivity.this, items[position]);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void toStaggeredGridActivity(Context context) {
        context.startActivity(new Intent(context, StaggeredGridActivity.class));
    }
}
