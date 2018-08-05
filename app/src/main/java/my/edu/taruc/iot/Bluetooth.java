package my.edu.taruc.iot;

/**
 * Created by User on 5/8/2018.
 */

public class Bluetooth {
    private String BluetoothName;
    private String DeviceName;
    private String MacAddress;
    private String Time;

    public Bluetooth(String BluetoothName,String DeviceName,String MacAddress,String Time){
        this.BluetoothName = BluetoothName;
        this.DeviceName = DeviceName;
        this.MacAddress = MacAddress;
        this.Time = Time;

    }
    public String getBluetoothName(){return BluetoothName;}
    public String getDeviceName(){return DeviceName;}

    public String getMacAddress() {
        return MacAddress;
    }

    public String getTime() {
        return Time;
    }
}
