package com.uide.kradac;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;


public class ledControl extends ActionBarActivity {

    Button btnOn0, btnOn1, btnOn2, btnOn3, btnOn4, btnOn5, btnOn6, btnOn7, btnOn8,
            btnOn9, btnOn10, btnOff0, btnOff1, btnOff2, btnOff3, btnOff4, btnOff5,
            btnOff6, btnOff7, btnOff8, btnOff9, btnOff10 ,btnDis, btnApagarTodo; //Numero de botones agregarlos desde aqui
    String address = null;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");


    @Override //programar boton retroceso.
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {

            turnOffLed0();
            turnOffLed1();
            turnOffLed2();
            turnOffLed3();
            turnOffLed4();
            turnOffLed5();
            turnOffLed6();
            turnOffLed7();
            turnOffLed8();
            turnOffLed9();
            turnOffLed10();
            if (btSocket!=null)
            {
                try
                {
                    btSocket.close();
                }
                catch (IOException e)
                { msg("Error");}
            }
            finish();

        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceList.EXTRA_ADDRESS); //recivimos la mac address obtenida en la actividad anterior

        setContentView(R.layout.activity_led_control);

        //Todos los botones agregados anteriormente
        btnApagarTodo = (Button) findViewById(R.id.button25);

        btnOn0 = (Button) findViewById(R.id.button2);
        btnOn1 = (Button) findViewById(R.id.button5);
        btnOn2 = (Button) findViewById(R.id.button7);
        btnOn3 = (Button) findViewById(R.id.button9);
        btnOn4 = (Button) findViewById(R.id.button11);
        btnOn5 = (Button) findViewById(R.id.button13);
        btnOn6 = (Button) findViewById(R.id.button15);
        btnOn7 = (Button) findViewById(R.id.button17);
        btnOn8 = (Button) findViewById(R.id.button19);
        btnOn9 = (Button) findViewById(R.id.button21);
        btnOn10 = (Button) findViewById(R.id.button23);

        btnOff0 = (Button) findViewById(R.id.button3);
        btnOff1 = (Button) findViewById(R.id.button6);
        btnOff2 = (Button) findViewById(R.id.button8);
        btnOff3 = (Button) findViewById(R.id.button10);
        btnOff4 = (Button) findViewById(R.id.button12);
        btnOff5 = (Button) findViewById(R.id.button14);
        btnOff6 = (Button) findViewById(R.id.button16);
        btnOff7 = (Button) findViewById(R.id.button18);
        btnOff8 = (Button) findViewById(R.id.button20);
        btnOff9 = (Button) findViewById(R.id.button22);
        btnOff10 = (Button) findViewById(R.id.button24);

        btnDis = (Button) findViewById(R.id.button4);       //Boton desconectar bluetooth

        new ConnectBT().execute(); //Llamar a la clase para conectar

        btnApagarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed0();
                turnOffLed1();
                turnOffLed2();
                turnOffLed3();
                turnOffLed4();
                turnOffLed5();
                turnOffLed6();
                turnOffLed7();
                turnOffLed8();
                turnOffLed9();
                turnOffLed10();
            }
        });


        btnOn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed0();
            }
        });
        btnOn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed1();
            }
        });
        btnOn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed2();
            }
        });
        btnOn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed3();
            }
        });
        btnOn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed4();
            }
        });
        btnOn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed5();
            }
        });
        btnOn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed6();
            }
        });
        btnOn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed7();
            }
        });
        btnOn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed8();
            }
        });
        btnOn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed9();
            }
        });
        btnOn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOnLed10();
            }
        });



        btnOff0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed0();
            }
        });
        btnOff1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed1();
            }
        });
        btnOff2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed2();
            }
        });
        btnOff3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed3();
            }
        });
        btnOff4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed4();
            }
        });
        btnOff5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed5();
            }
        });
        btnOff6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed6();
            }
        });
        btnOff7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed7();
            }
        });
        btnOff8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed8();
            }
        });
        btnOff9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed9();
            }
        });
        btnOff10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnOffLed10();
            }
        });

        btnDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disconnect();
            }
        });
    }


    private void Disconnect()
    {
        turnOffLed0();
        turnOffLed1();
        turnOffLed2();
        turnOffLed3();
        turnOffLed4();
        turnOffLed5();
        turnOffLed6();
        turnOffLed7();
        turnOffLed8();
        turnOffLed9();
        turnOffLed10();
        if (btSocket!=null)
        {
            try
            {
                btSocket.close();
            }
            catch (IOException e)
            { msg("Error");}
        }
        finish();

    }


    //A partir de aqui se envian las señales al bluetooth para accionar los pines
    private void turnOnLed0()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("a".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("El modulo se ha desconectado inesperadamente");
            }
        }
    }
    private void turnOnLed1()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("c".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed2()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("e".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed3()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("g".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed4()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("i".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed5()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("k".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed6()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("m".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed7()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("o".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed8()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("q".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed9()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("s".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOnLed10()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("u".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }




    private void turnOffLed0()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("b".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed1()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("d".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed2()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("f".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed3()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed4()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("j".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed5()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed6()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("n".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed7()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("p".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed8()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("r".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed9()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("t".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }
    private void turnOffLed10()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("v".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }



    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_led_control, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void>  // subproceso de interfaz de usuario ui
    {
        private boolean ConnectSuccess = true;

        @Override //Mensaje conectando espere por favor
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(ledControl.this, "Conectando...", "Espere por favor...");
        }

        @Override
        protected Void doInBackground(Void... devices)
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                 myBluetooth = BluetoothAdapter.getDefaultAdapter();
                 BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//conectamos al dispositivo y chequeamos si esta disponible
                 btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
                 BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                 btSocket.connect();
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Error de conexión.");
                finish();
            }
            else
            {
                msg("Conectado!!");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }
}
