package my.edu.taruc.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.ValueEventListener;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    DatabaseReference Ref;
    private Button button;
    ListView listView;
    private Firebase mRef;
    List<Bluetooth> bluetoothList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRef = new Firebase("https://iot-assignment-93af3.firebaseio.com/");


        listView= (ListView)findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button2);
        Ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://iot-assignment-93af3.firebaseio.com/");
        Ref = FirebaseDatabase.getInstance().getReference("IoT");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot bluetoothSnapshot : dataSnapshot.getChildren()) {

                    Bluetooth bluetooth = bluetoothSnapshot.getValue(Bluetooth.class);
                    bluetoothList.add(bluetooth);
                }
                BluetoorhAdapter bluetoothAdapter = new BluetoorhAdapter(MainActivity.this, bluetoothList);
                listView.setAdapter(bluetoothAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
