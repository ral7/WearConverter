package wear.rahul.wearconverter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ConverterActivity extends Activity implements WearableListView.ClickListener {

    private WearableListView convertListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                convertListView = (WearableListView) stub.findViewById(R.id.listView1);
                convertListView.setAdapter(new MyAdapter(ConverterActivity.this));
                convertListView.setClickListener(ConverterActivity.this);
            }
        });
    }


    private static ArrayList<String> listItems;
    static {
        listItems = new ArrayList<String>();
        listItems.add("Length");
        listItems.add("Temperature");
        listItems.add("Weight");


    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        System.out.println("THis was clicked " + viewHolder.getAdapterPosition());

        if(viewHolder.getAdapterPosition() == 0) {
            Intent intent = new Intent(this, LengthConvert.class);
            startActivity(intent);
        }
        if(viewHolder.getAdapterPosition() == 1) {
            Intent intent = new Intent(this, TemperatureConvert.class);
            startActivity(intent);
        }
        if(viewHolder.getAdapterPosition() == 2) {
            Intent intent = new Intent(this, WeightConvert.class);
            startActivity(intent);
        }

    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    private class MyAdapter extends WearableListView.Adapter{
        private final LayoutInflater mInflater;

        private MyAdapter(Context context){
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
