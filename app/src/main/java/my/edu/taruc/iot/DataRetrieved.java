package my.edu.taruc.iot;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataRetrieved extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    List<Bluetooth>bluetoothList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_retrieved);
        listView = (ListView) findViewById(R.id.listView);

        databaseReference = FirebaseDatabase.getInstance().getReference("IoT");

        bluetoothList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot bluetoothSnapshot: dataSnapshot.getChildren()) {

                    Bluetooth bluetooth = bluetoothSnapshot.getValue(Bluetooth.class);
                    bluetoothList.add(bluetooth);
                }
                BluetoorhAdapter bluetoothAdapter = new BluetoorhAdapter(DataRetrieved.this,bluetoothList);
                listView.setAdapter(bluetoothAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
