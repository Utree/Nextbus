package kansai.k756880.nextbus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<DepartureData> departureList;

    public ListAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDepartureList(ArrayList<DepartureData> departureList) { this.departureList = departureList; }

    @Override
    public int getCount() { return departureList.size(); }

    @Override
    public Object getItem(int position) {
        return departureList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return departureList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list_row,parent,false);

//        コンテンツを設定していく
        ((TextView)convertView.findViewById(R.id.destination)).setText(departureList.get(position).getDestination());
        ((TextView)convertView.findViewById(R.id.departure_time)).setText(departureList.get(position).getDepartureTime());
        ((TextView)convertView.findViewById(R.id.remaining_time)).setText(departureList.get(position).getRemainingTime());
        ((TextView)convertView.findViewById(R.id.delay)).setText(departureList.get(position).getDelay());
        ((TextView)convertView.findViewById(R.id.where_is)).setText(departureList.get(position).getWhereIs());

        return convertView;
    }
}
