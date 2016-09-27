package pomis.app.adaptersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Car> myCarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_my_cats);


        initListView();
    }

    private void initListView() {
        myCarList = new ArrayList<>();
        myCarList.add(new Car("BMW X10", "1000 миль", 123000));
        myCarList.add(new Car("BMW X8", "100 миль", 1230));
        myCarList.add(new Car("Honda Civic", "10000 миль", 123050));
        myCarList.add(new Car("Škoda Octavia", "500 миль", 77770));

        adapter = new CarAdapter(this, R.layout.item_car, myCarList);
        listView.setAdapter(adapter);
    }
}
