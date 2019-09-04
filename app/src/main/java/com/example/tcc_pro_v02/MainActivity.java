package com.example.tcc_pro_v02;

/*  Requisitos avaliação para TCC-II
*   Introdução/Revisão de literatura
*   Objetivos
*           -gerais
*           -especificos
*   Justificativa
* */

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.tcc_pro_v02.LadderMatrix;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<ImageView> slots = new ArrayList<ImageView>();
    private int statusSlot [] = new int[36];
    private LadderMatrix ladderMatrix = new LadderMatrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slots.add(0,(ImageView)findViewById(R.id.slot1));
        slots.add(1,(ImageView)findViewById(R.id.slot2));
        slots.add(2,(ImageView)findViewById(R.id.slot3));
        slots.add(3,(ImageView)findViewById(R.id.slot4));
        slots.add(4,(ImageView)findViewById(R.id.slot5));
        slots.add(5,(ImageView)findViewById(R.id.slot6));
        slots.add(6,(ImageView)findViewById(R.id.slot7));
        slots.add(7,(ImageView)findViewById(R.id.slot8));
        slots.add(8,(ImageView)findViewById(R.id.slot9));
        slots.add(9,(ImageView)findViewById(R.id.slot10));
        slots.add(10,(ImageView)findViewById(R.id.slot11));
        slots.add(11,(ImageView)findViewById(R.id.slot12));
        slots.add(12,(ImageView)findViewById(R.id.slot13));
        slots.add(13,(ImageView)findViewById(R.id.slot14));
        slots.add(14,(ImageView)findViewById(R.id.slot15));
        slots.add(15,(ImageView)findViewById(R.id.slot16));
        slots.add(16,(ImageView)findViewById(R.id.slot17));
        slots.add(17,(ImageView)findViewById(R.id.slot18));
        slots.add(18,(ImageView)findViewById(R.id.slot19));
        slots.add(19,(ImageView)findViewById(R.id.slot20));
        slots.add(20,(ImageView)findViewById(R.id.slot21));
        slots.add(21,(ImageView)findViewById(R.id.slot22));
        slots.add(22,(ImageView)findViewById(R.id.slot23));
        slots.add(23,(ImageView)findViewById(R.id.slot24));
        slots.add(24,(ImageView)findViewById(R.id.slot25));
        slots.add(25,(ImageView)findViewById(R.id.slot26));
        slots.add(26,(ImageView)findViewById(R.id.slot27));
        slots.add(27,(ImageView)findViewById(R.id.slot28));
        slots.add(28,(ImageView)findViewById(R.id.slot29));
        slots.add(29,(ImageView)findViewById(R.id.slot30));
        slots.add(30,(ImageView)findViewById(R.id.slot31));
        slots.add(31,(ImageView)findViewById(R.id.slot32));
        slots.add(32,(ImageView)findViewById(R.id.slot33));
        slots.add(33,(ImageView)findViewById(R.id.slot34));
        slots.add(34,(ImageView)findViewById(R.id.slot35));
        slots.add(35,(ImageView)findViewById(R.id.slot36));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        // Setar os OnClickListener de todos os slots
        // Estudar uma maneira para organizar os codigos
        // Talvez criar uma classe com metodos staticos
        // Criar uma matriz para guardar estados dos slots.
        slots.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(0);
            }
        });
        slots.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(1);
            }
        });
        slots.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(2);
            }
        });
        slots.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(3);
            }
        });
        slots.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(4);
            }
        });
        slots.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(5);
            }
        });
        slots.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(6);
            }
        });
        slots.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(7);
            }
        });
        slots.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(8);
            }
        });
        slots.get(9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(9);
            }
        });
        slots.get(10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(10);
            }
        });
        slots.get(11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(11);
            }
        });
        slots.get(12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(12);
            }
        });
        slots.get(13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(13);
            }
        });
        slots.get(14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(14);
            }
        });
        slots.get(15).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(15);
            }
        });
        slots.get(16).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(16);
            }
        });
        slots.get(17).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(17);
            }
        });
        slots.get(18).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(18);
            }
        });
        slots.get(19).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(19);
            }
        });
        slots.get(20).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(20);
            }
        });
        slots.get(21).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(21);
            }
        });
        slots.get(22).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(22);
            }
        });
        slots.get(23).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(23);
            }
        });
        slots.get(24).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(24);
            }
        });
        slots.get(25).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(25);
            }
        });
        slots.get(26).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(26);
            }
        });
        slots.get(27).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(27);
            }
        });
        slots.get(28).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(28);
            }
        });
        slots.get(29).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(29);
            }
        });
        slots.get(30).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(30);
            }
        });
        slots.get(31).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(31);
            }
        });
        slots.get(32).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(32);
            }
        });
        slots.get(33).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(33);
            }
        });
        slots.get(34).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(34);
            }
        });
        slots.get(35).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePosiOfSelector(35);
            }
        });
    }

    public void changePosiOfSelector(int selectorPosi) {
        int auxPosi = ladderMatrix.getSelectorPosi();
        if(auxPosi == 37) {
            switch (statusSlot[selectorPosi]) {
                case 0: {
                    slots.get(selectorPosi).setImageResource(R.drawable.no_contact_selection);
                    ladderMatrix.setSelectorPosi(selectorPosi);
                    break;
                }
                case 1: {
                    slots.get(selectorPosi).setImageResource(R.drawable.contact_selection);
                    ladderMatrix.setSelectorPosi(selectorPosi);
                    break;
                }
                case 2: {
                    slots.get(selectorPosi).setImageResource(R.drawable.contact_nc_selection);
                    ladderMatrix.setSelectorPosi(selectorPosi);
                    break;
                }
            }
            return;
        }
        else {
            // CODIGO DOS STATUS, o vetor statusSlot guarda o status de cada slot, das 36 posições
            // imageView sem contato/bobina, case 0
            // imageView com contato NA, case 1
            // imageView com contato NF, case 2
            switch (statusSlot[auxPosi]) {
                case 0: {
                    slots.get(auxPosi).setImageResource(R.drawable.no_contact);
                    break;
                }
                case 1: {
                    slots.get(auxPosi).setImageResource(R.drawable.contact);
                    break;
                }
                case 2: {
                    slots.get(auxPosi).setImageResource(R.drawable.contact_nc);
                    break;
                }
            }
            switch (statusSlot[selectorPosi]) {
                case 0: {
                    slots.get(selectorPosi).setImageResource(R.drawable.no_contact_selection);
                    ladderMatrix.setSelectorPosi(selectorPosi);
                    break;
                }
                case 1: {
                    slots.get(selectorPosi).setImageResource(R.drawable.contact_selection);
                    ladderMatrix.setSelectorPosi(selectorPosi);
                    break;
                }
                case 2: {
                    slots.get(selectorPosi).setImageResource(R.drawable.contact_nc_selection);
                    ladderMatrix.setSelectorPosi(selectorPosi);
                    break;
                }
            }
        }
    }


    public void newContact(View view) {
        //ISSO CRIA O DIALOG ALERT
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        //CONFIGURANDO O TITULO E A MENSAGEM DO DIALOG ALERT
        dialog.setTitle("Titulo");
        dialog.setMessage("Mensagem");

        //CONFIGURA O CANCELAMENTO, RETIRANDO ESSE TRECHO O DIALOG ALERT FICA TRAVADO NA TELA
        dialog.setCancelable(false);

        //CANFIGURA ICONE AO LADO DO TITULO
        //dialog.setIcon(android.R.drawable.ic_dialog_info);

        //CONFIGURA AÇÕES PARA O ALERTA
        dialog.setPositiveButton("Contato NF", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "Contato NF foi pressionado", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Contato NA", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                Toast.makeText(getApplicationContext(), "Contato NA foi pressionado", Toast.LENGTH_SHORT).show();
            }
        });

        //CRIAR E EXIBIR O ALERTDIALOG
        dialog.create();
        dialog.show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //ESSA FUNÇÃO CUIDA DOS CLICKS NA ACTION BAR
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
