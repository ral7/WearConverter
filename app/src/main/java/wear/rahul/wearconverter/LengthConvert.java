package wear.rahul.wearconverter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class LengthConvert extends Activity implements WearableListView.ClickListener {

    private WearableListView lenghtListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_convert);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                lenghtListView = (WearableListView) stub.findViewById(R.id.listViewLength);
                lenghtListView.setAdapter(new MyAdapter(LengthConvert.this));
                lenghtListView.setClickListener(LengthConvert.this);
            }
        });
    }

    private static ArrayList<String> listItems;
    static {
        listItems = new ArrayList<String>();
        listItems.add("Inch");
        listItems.add("Foot");
        listItems.add("Mile");
        listItems.add("Meter");
        listItems.add("Kilometer");
        listItems.add("Yard");
        listItems.add("Centimeter");
        listItems.add("Millimeter");



    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {

    }

    @Override
    public void onTopEmptyRegionClick() {

    }


    private class MyAdapter extends WearableListView.Adapter {
        private final LayoutInflater mInflater;

        private MyAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new WearableListView.ViewHolder(mInflater.inflate(R.layout.convertviewcell, null));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder viewHolder, int i) {

            TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.textView);
            textView.setText(listItems.get(i).toString());
            viewHolder.itemView.setTag(i);
        }

        @Override
        public int getItemCount() {
            return listItems.size();
        }
    }
}
