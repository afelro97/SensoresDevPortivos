package com.example.sensoresdevportivos;



import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import android.bluetooth.BluetoothAdapter;

import com.wahoofitness.connector.HardwareConnector;
import com.wahoofitness.connector.HardwareConnectorEnums;
import com.wahoofitness.connector.HardwareConnectorTypes;
import com.wahoofitness.connector.capabilities.Capability;
import com.wahoofitness.connector.capabilities.Heartrate;
import com.wahoofitness.connector.conn.connections.SensorConnection;
import com.wahoofitness.connector.conn.connections.params.ConnectionParams;
import com.wahoofitness.connector.listeners.discovery.DiscoveryListener;

import java.util.ArrayList;
import java.util.List;

public class SensorService extends Service implements DiscoveryListener, SensorConnection.Listener, Heartrate.Listener {

    private HardwareConnector mHardwareConnector;
    private final HardwareConnector.Listener mHardwareConnectorListener = new WahooListener();
    private static final String TAG = "WahooService";
    private List<WahooServiceListener> listenerList;
    public void SensorService(){ //no esta claro
        listenerList = new ArrayList<WahooServiceListener>();
    }
    private static SensorService instance_;
    public void addListener( WahooServiceListener aListener) {
        listenerList.add(aListener);
        Log.i(TAG,"AddListener: " + aListener+ " " + listenerList.size());
    }
    public static SensorService getInstance_(){
        return instance_;
    }




    @Override
    public void onCreate(){
        updateListeners("onCreate");
        super.onCreate();
        instance_ = this;
    }

    public void startDiscovery(){
        mHardwareConnector = new HardwareConnector(this, mHardwareConnectorListener);

        mHardwareConnector.startDiscovery(this);
        updateListeners("started discovery");
    }

    @Override
    public void onDeviceDiscovered(ConnectionParams connectionParams) {
        mHardwareConnector.requestSensorConnection(connectionParams,this);
        updateListeners("onDeviceDiscovered: "+ connectionParams.getName());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mHardwareConnector.shutdown();
    }

    public SensorService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onHeartrateData(Heartrate.Data data) {

    }

    @Override
    public void onHeartrateDataReset() {

    }

    @Override
    public void onNewCapabilityDetected(SensorConnection sensorConnection, Capability.CapabilityType capabilityType) {

    }

    @Override
    public void onSensorConnectionStateChanged(SensorConnection sensorConnection, HardwareConnectorEnums.SensorConnectionState sensorConnectionState) {

    }

    @Override
    public void onSensorConnectionError(SensorConnection sensorConnection, HardwareConnectorEnums.SensorConnectionError sensorConnectionError) {

    }



    @Override
    public void onDiscoveredDeviceLost(ConnectionParams connectionParams) {

    }

    @Override
    public void onDiscoveredDeviceRssiChanged(ConnectionParams connectionParams, int i) {

    }
}