package dalton.gray.weddingphotography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer[] WeddingPhotos = {
            R.drawable.wedding1,
            R.drawable.wedding2,
            R.drawable.wedding3,
            R.drawable.wedding4,
            R.drawable.wedding5,
            R.drawable.wedding6,
            R.drawable.wedding7,
            R.drawable.wedding8,
            R.drawable.wedding9,
            R.drawable.wedding10,
    };

    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView imgLarge = (ImageView) findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                Toast.makeText(getBaseContext(), "Anthology Wedding Photo " + (index + 1), Toast.LENGTH_SHORT).show();
                imgLarge.setImageResource(WeddingPhotos[index]);
            }
        });
    }

    private class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return WeddingPhotos.length;
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
        public View getView(int index, View view, ViewGroup viewGroup) {
            pic = new ImageView(context);
            pic.setImageResource(WeddingPhotos[index]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(350, 300));
            return pic;
        }
    }
}
