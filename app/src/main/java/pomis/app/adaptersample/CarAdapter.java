package pomis.app.adaptersample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by romanismagilov on 27.09.16.
 */

public class CarAdapter extends ArrayAdapter{

    Activity activity;
    int resource;
    List list;

    public CarAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Car selectedCar = (Car) list.get(position);

        if (convertView==null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(resource, null);

            viewHolder = new ViewHolder();

            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.tv_car_name);
            viewHolder.mileageTextView = (TextView) convertView.findViewById(R.id.tv_car_mileage);
            viewHolder.costTextView = (TextView) convertView.findViewById(R.id.tv_cost);




            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.nameTextView.setText(selectedCar.name);
        viewHolder.mileageTextView.setText(selectedCar.mileage);
        viewHolder.costTextView.setText(String.valueOf(selectedCar.cost));

        return convertView;
    }

    class ViewHolder{
        TextView nameTextView;
        TextView mileageTextView;
        TextView costTextView;
    }
}
