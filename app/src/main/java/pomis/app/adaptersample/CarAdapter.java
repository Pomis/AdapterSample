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

        //if (convertView==null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(resource, null);

            TextView nameTextView = (TextView) convertView.findViewById(R.id.tv_car_name);
            TextView mileageTextView = (TextView) convertView.findViewById(R.id.tv_car_mileage);
            TextView costTextView = (TextView) convertView.findViewById(R.id.tv_cost);


            Car selectedCar = (Car) list.get(position);

            nameTextView.setText(selectedCar.name);
            mileageTextView.setText(selectedCar.mileage);
            costTextView.setText(String.valueOf(selectedCar.cost));
        //}

        return convertView;
    }
}
