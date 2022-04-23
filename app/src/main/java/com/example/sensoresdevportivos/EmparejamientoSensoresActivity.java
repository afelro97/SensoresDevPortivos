/*package com.example.sensoresdevportivos;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmparejamientoSensoresActivity {
    
    BluetoothAdapter mBluetoothAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInsanceState);
        setContenView(R.layout.emparejamiento_sensores);
        Button bluetooth_btn = (Button) findViewById(R.id.bluetooth_btn);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        bluetooth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableDisableBT();
            }
        });

    }

    public void enableDisableBT(){
        if(mBluetoothAdapter == null){
            Log.d(TAG, "enableDisableBT: Does not have BT capabilities");
        }
        if(!mBluetoothAdapter.isEnabled()){

        }
    }

    private void setContenView(int emparejamiento_sensores) {
    }
}
*/