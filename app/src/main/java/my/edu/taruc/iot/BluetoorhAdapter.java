package my.edu.taruc.iot;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 5/8/2018.
 */

public class BluetoorhAdapter extends ArrayAdapter<Bluetooth> {
    private Activity context;
    private List<Bluetooth> bluetoothList;

    public BluetoorhAdapter(Activity context,List<Bluetooth>bluetoothList){
        super(context,R.layout.list_view,bluetoothList);
        this.context = context;
        this.bluetoothList = bluetoothList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list_view,null,true);

        TextView BluetoothName = (TextView)listView.findViewById(R.id.BluetoothName);
        TextView DeviceName = (TextView)listView.findViewById(R.id.DeviceName);
        TextView MacAddress = (TextView)listView.findViewById(R.id.MacAddress);
        TextView Time = (TextView)listView.findViewById(R.id.Time);

        Bluetooth bluetooth = bluetoothList.get(position);
        BluetoothName.setText(bluetooth.getBluetoothName());
        DeviceName.setText(bluetooth.getDeviceName());
        MacAddress.setText(bluetooth.getMacAddress());
        Time.setText(bluetooth.getTime());

        return listView;
    }
}
