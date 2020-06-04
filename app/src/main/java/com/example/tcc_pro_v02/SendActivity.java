package com.example.tcc_pro_v02;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SendActivity extends AppCompatActivity {

    public static int ENABLE_BLUETOOTH = 1;
    public static int SELECT_PAIRED_DEVICE = 2;
    public static int SELECT_DISCOVERED_DEVICE = 3;

    static TextView statusMessage;
    static TextView textSpace;
    ConnectionThread connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle dataFromMainActivity = getIntent().getExtras();
        assert dataFromMainActivity != null;
        final int[] hexLogic = dataFromMainActivity.getIntArray("hexLogic");

        setContentView(R.layout.activity_send_data);

        statusMessage = findViewById(R.id.textView3);
        textSpace = findViewById(R.id.textView4);
        Button find = findViewById(R.id.button_find);
        Button list = findViewById(R.id.button_list);
        Button send = findViewById(R.id.button_send);


        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            statusMessage.setText("Que pena! Hardware Bluetooth não está funcionando");
        } else {
            statusMessage.setText("Ótimo! Hardware Bluetooth está funcionando");
            if(!btAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, ENABLE_BLUETOOTH);
                statusMessage.setText("Solicitando ativação do Bluetooth...");

            } else {
                statusMessage.setText("Bluetooth já ativado");
            }
        }

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                discoverDevices(v);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchPairedDevices(v);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v, hexLogic);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == ENABLE_BLUETOOTH) {
            if(resultCode == RESULT_OK) {
                statusMessage.setText("Bluetooth ativado");
            }
            else {
                statusMessage.setText("Bluetooth não ativado");
            }
        }
        else if(requestCode == SELECT_PAIRED_DEVICE || requestCode == SELECT_DISCOVERED_DEVICE) {
            if(resultCode == RESULT_OK) {
                statusMessage.setText("Você selecionou " + data.getStringExtra("btDevName") + "\n"
                        + data.getStringExtra("btDevAddress"));

                connect = new ConnectionThread(data.getStringExtra("btDevAddress"));
                connect.start();
            }
            else {
                statusMessage.setText("Nenhum dispositivo selecionado");
            }
        }
    }

    public void searchPairedDevices(View view) {
        Intent searchPairedDevicesIntent = new Intent(this, PairedDevices.class);
        startActivityForResult(searchPairedDevicesIntent, SELECT_PAIRED_DEVICE);
    }

    public void discoverDevices(View view) {
        Intent searchPairedDevicesIntent = new Intent(this, DiscoveredDevices.class);
        startActivityForResult(searchPairedDevicesIntent, SELECT_DISCOVERED_DEVICE);
    }

    public void sendMessage(View view, int[] hexLogic) {
        ArrayList<Integer> firstData = new ArrayList<>();
        ArrayList<Integer> secondData = new ArrayList<>();
        ArrayList<Integer> thirdData = new ArrayList<>();
        final byte[] firstDataBatch;
        final byte[] secondDataBatch;
        final byte[] thirdDataBatch;
        if (hexLogic.length > 400 && hexLogic.length <= 1200) {
            for (int i=0; i<hexLogic.length; i++) {
                if (i < 400) {
                    firstData.add(hexLogic[i]);
                } else if (i < 800) {
                    secondData.add(hexLogic[i]);
                } else {
                    thirdData.add(hexLogic[i]);
                }
            }
            firstDataBatch = this.intToByte(integersListToIntArray(firstData));
            secondDataBatch = this.intToByte(integersListToIntArray(secondData));
            thirdDataBatch = this.intToByte(integersListToIntArray(thirdData));
            connect.write(firstDataBatch);
            Handler handler = new Handler();
            if(secondDataBatch.length > 0) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        connect.write(secondDataBatch);
                    }
                }, 5000);
            }
            if(thirdDataBatch.length > 0) {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        connect.write(thirdDataBatch);
                    }
                }, 5000);
            }
        } else {
            firstDataBatch = this.intToByte(hexLogic);
            connect.write(firstDataBatch);
        }
    }

    private byte[] intToByte(@NonNull int[] data) {
        byte[] bytes = new byte[data.length];
        for (int i=0; i<data.length; i++) {
            bytes[i] = (byte)data[i];
        }
        return bytes;
    }

    private int[] integersListToIntArray(@NonNull List<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {

            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            String dataString= new String(data);

            if(dataString.equals("---N")) {
                statusMessage.setText("Ocorreu um erro durante a conexão");
            } else if(dataString.equals("---S")) {
                statusMessage.setText("Conectado");
            }
            else {
                textSpace.setText(new String(data));
            }
        }
    };
}
