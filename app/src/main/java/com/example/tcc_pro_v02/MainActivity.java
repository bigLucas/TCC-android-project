package com.example.tcc_pro_v02;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc_pro_v02.OpenActivity.OpenActivity;
import com.example.tcc_pro_v02.Compiler.Compiler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // Proximo passo é criar um metodo para salvar os diagramas na memoria do telefone
    // Uma alternativa é salvar os diagramas em txt, só salvar o estado da statusSlot
    // Depois eu acesso esse arquivo e carrego o estado do arquivo no statusSlot e ai é só
    // atualizar a tela. É que pra cada slot deve ter uma saida ou entrada associada
    // dá pra salvar statusSlot em uma linha, talvez cada slot separado por , ou outra coisa
    // e uma outra linha para cada entrada ou saida associada com o slot.

    // CODIGO DOS STATUS, o vetor statusSlot guarda o status de cada slot, das 36 posições
    // TextView sem contato/bobina, case 0
    // TextView com contato NA, case 1
    // TextView com contato NF, case 2
    // TextView com linha horizontal 3
    // TextView com bobina NA 4
    // TextView com bobina NF 5
    static final int NO_COMPONENT = 0;
    static final int CONTACT_NORMAL_OPEN = 1;
    static final int CONTACT_NORMAL_CLOSED = 2;
    static final int LINE = 3;
    static final int COIL = 4;

    private ArrayList<TextView> slots = new ArrayList<>();
    private int[] statusSlot = new int[36];
    private LadderMatrix ladderMatrix = new LadderMatrix();
    private int[] hexLogic;
    static final int NEW_CONTACT_REQUEST = 1;
    static final int NEW_COIL_REQUEST = 2;
    static final int SEND_REQUEST= 3;
    static final int OPEN_FILE_REQUEST= 4;
    static final int ACTION_CODE_NEW_CONTACT = 1;
    static final int ACTION_CODE_NEW_COIL = 2;
    static final int INSERTION_TYPE_CONTACT = 1;
    static final int INSERTION_TYPE_COIL = 2;
    static final int INSERTION_TYPE_LINE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slots.add(0,(TextView)findViewById(R.id.slot0));
        slots.add(1,(TextView)findViewById(R.id.slot1));
        slots.add(2,(TextView)findViewById(R.id.slot2));
        slots.add(3,(TextView)findViewById(R.id.slot3));
        slots.add(4,(TextView)findViewById(R.id.slot4));
        slots.add(5,(TextView)findViewById(R.id.slot5));
        slots.add(6,(TextView)findViewById(R.id.slot6));
        slots.add(7,(TextView)findViewById(R.id.slot7));
        slots.add(8,(TextView)findViewById(R.id.slot8));
        slots.add(9,(TextView)findViewById(R.id.slot9));
        slots.add(10,(TextView)findViewById(R.id.slot10));
        slots.add(11,(TextView)findViewById(R.id.slot11));
        slots.add(12,(TextView)findViewById(R.id.slot12));
        slots.add(13,(TextView)findViewById(R.id.slot13));
        slots.add(14,(TextView)findViewById(R.id.slot14));
        slots.add(15,(TextView)findViewById(R.id.slot15));
        slots.add(16,(TextView)findViewById(R.id.slot16));
        slots.add(17,(TextView)findViewById(R.id.slot17));
        slots.add(18,(TextView)findViewById(R.id.slot18));
        slots.add(19,(TextView)findViewById(R.id.slot19));
        slots.add(20,(TextView)findViewById(R.id.slot20));
        slots.add(21,(TextView)findViewById(R.id.slot21));
        slots.add(22,(TextView)findViewById(R.id.slot22));
        slots.add(23,(TextView)findViewById(R.id.slot23));
        slots.add(24,(TextView)findViewById(R.id.slot24));
        slots.add(25,(TextView)findViewById(R.id.slot25));
        slots.add(26,(TextView)findViewById(R.id.slot26));
        slots.add(27,(TextView)findViewById(R.id.slot27));
        slots.add(28,(TextView)findViewById(R.id.slot28));
        slots.add(29,(TextView)findViewById(R.id.slot29));
        slots.add(30,(TextView)findViewById(R.id.slot30));
        slots.add(31,(TextView)findViewById(R.id.slot31));
        slots.add(32,(TextView)findViewById(R.id.slot32));
        slots.add(33,(TextView)findViewById(R.id.slot33));
        slots.add(34,(TextView)findViewById(R.id.slot34));
        slots.add(35,(TextView)findViewById(R.id.slot35));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Adciona linha nova
        Button newLineButton = findViewById(R.id.btn_line);
        newLineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRightPlaceToInsert(ladderMatrix.getSelectorPosi(), INSERTION_TYPE_LINE)) {
                    insertLine(ladderMatrix.getSelectorPosi(), true);
                    changePosiOfSelector(ladderMatrix.getSelectorPosi() + 1);
                    return;
                }
                Toast.makeText(getApplicationContext(),"Impossível inserir linha", Toast.LENGTH_SHORT).show();
            }
        });

        //Inicia uma intent para a escolha de nova bobina de saida
        Button newCoilButton = findViewById(R.id.btn_out);
        newCoilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRightPlaceToInsert(ladderMatrix.getSelectorPosi(), INSERTION_TYPE_COIL)) {
                    Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                    intent.putExtra("actionCode", ACTION_CODE_NEW_COIL);
                    startActivityForResult(intent, NEW_COIL_REQUEST);
                    return;
                }
                Toast.makeText(getApplicationContext(),"Impossível inserir bobina", Toast.LENGTH_SHORT).show();
            }
        });

        //Inicia uma intent para a escolha de novo contato
        Button newContactButton = findViewById(R.id.btn_contact);
        newContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRightPlaceToInsert(ladderMatrix.getSelectorPosi(), INSERTION_TYPE_CONTACT)) {
                    Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                    intent.putExtra("actionCode", ACTION_CODE_NEW_CONTACT);
                    startActivityForResult(intent, NEW_CONTACT_REQUEST);
                    return;
                }
                Toast.makeText(getApplicationContext(),"Impossível inserir contato", Toast.LENGTH_SHORT).show();
            }
        });

        // Save button
        Button saveButton = findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManagementLogicFile managementLogicFile = new ManagementLogicFile(getApplicationContext());
                TextInputEditText filename = findViewById(R.id.txt_in_file_name);
                if (filename.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Digite um nome para o arquivo!", Toast.LENGTH_LONG).show();
                    return;
                }
                managementLogicFile.save(filename.getText().toString(), slots, statusSlot);
                Toast.makeText(getApplicationContext(), "Arquivo salvo!", Toast.LENGTH_SHORT).show();
            }
        });

        // Delete button
        Button deleteButton = findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusSlot[ladderMatrix.getSelectorPosi()] = NO_COMPONENT;
                slots.get(ladderMatrix.getSelectorPosi()).setBackgroundResource(R.drawable.no_contact);
                slots.get(ladderMatrix.getSelectorPosi()).setText("");
                changePosiOfSelector(ladderMatrix.getSelectorPosi() + 1);
            }
        });

        //Inicia posição do seletor
        changePosiOfSelector(0);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_CONTACT_REQUEST) {
            if(resultCode == RESULT_OK) {
                Bundle dados = data.getExtras();
                assert dados != null;
                int numero = dados.getInt("inputNumber");
                int contactType = dados.getInt("contactType");
                createNewContact(numero, contactType, ladderMatrix.getSelectorPosi(), true);
                changePosiOfSelector(ladderMatrix.getSelectorPosi() + 1);
            }
        }
        if(requestCode == NEW_COIL_REQUEST) {
            if(resultCode == RESULT_OK) {
                Bundle dados = data.getExtras();
                assert dados != null;
                int numero = dados.getInt("outputNumber");
                int contactType = dados.getInt("contactType");
                createNewCoil(numero, contactType, ladderMatrix.getSelectorPosi(), true);
                changePosiOfSelector(ladderMatrix.getSelectorPosi() + 1);
            }
        }
        if(requestCode == OPEN_FILE_REQUEST) {
            if(resultCode == RESULT_OK) {
                Bundle intentData = data.getExtras();
                assert intentData != null;
                String content = intentData.getString("content");
                loadDiagram(content);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void createNewContact(int inputAddress, int contactType, int position, boolean selection) {
        switch(contactType) {
            case 1: {
                if (selection) {
                    slots.get(position).setBackgroundResource(R.drawable.contact_selection);
                } else {
                    slots.get(position).setBackgroundResource(R.drawable.contact);
                }
                slots.get(position).setText("In " + inputAddress);
                statusSlot[position] = 1;
                break;
            }
            case 2: {
                if (selection) {
                    slots.get(position).setBackgroundResource(R.drawable.contact_nc_selection);
                } else {
                    slots.get(position).setBackgroundResource(R.drawable.contact_nc);
                }
                slots.get(position).setText("In " + inputAddress);
                statusSlot[position] = 2;
                break;
            }
        }
    }

    public void createNewCoil(int outputAddress, int contactType, int position, boolean selection) {
        switch(contactType) {
            case 1: {
                if (selection) {
                    slots.get(position).setBackgroundResource(R.drawable.coil_selection);
                } else {
                    slots.get(position).setBackgroundResource(R.drawable.coil);
                }
                slots.get(position).setText("Out " + outputAddress);
                statusSlot[position] = 4;
                break;
            }
            case 2: {
                if (selection) {
                    slots.get(position).setBackgroundResource(R.drawable.coil_nc_selection);
                } else {
                    slots.get(position).setBackgroundResource(R.drawable.coil_nc);
                }
                slots.get(position).setText("Out " + outputAddress);
                statusSlot[position] = 5;
                break;
            }
        }
    }

    public void changePosiOfSelector(int selectorPosi) {
        int auxPosi = ladderMatrix.getSelectorPosi();
        if(selectorPosi > 35) {
            selectorPosi = 35;
        }
        // CODIGO DOS STATUS, o vetor statusSlot guarda o status de cada slot, das 36 posições
        // TextView sem contato/bobina, case 0
        // TextView com contato NA, case 1
        // TextView com contato NF, case 2
        switch (statusSlot[auxPosi]) {
            case 0: {
                slots.get(auxPosi).setBackgroundResource(R.drawable.no_contact);
                break;
            }
            case 1: {
                slots.get(auxPosi).setBackgroundResource(R.drawable.contact);
                break;
            }
            case 2: {
                slots.get(auxPosi).setBackgroundResource(R.drawable.contact_nc);
                break;
            }
            case 3: {
                slots.get(auxPosi).setBackgroundResource(R.drawable.line_horizontal);
                break;
            }
            case 4: {
                slots.get(auxPosi).setBackgroundResource(R.drawable.coil);
                break;
            }
            case 5: {
                slots.get(auxPosi).setBackgroundResource(R.drawable.coil_nc);
                break;
            }
        }
        switch (statusSlot[selectorPosi]) {
            case 0: {
                slots.get(selectorPosi).setBackgroundResource(R.drawable.no_contact_selection);
                ladderMatrix.setSelectorPosi(selectorPosi);
                break;
            }
            case 1: {
                slots.get(selectorPosi).setBackgroundResource(R.drawable.contact_selection);
                ladderMatrix.setSelectorPosi(selectorPosi);
                break;
            }
            case 2: {
                slots.get(selectorPosi).setBackgroundResource(R.drawable.contact_nc_selection);
                ladderMatrix.setSelectorPosi(selectorPosi);
                break;
            }
            case 3: {
                slots.get(selectorPosi).setBackgroundResource(R.drawable.line_horizontal_selection);
                ladderMatrix.setSelectorPosi(selectorPosi);
                break;
            }
            case 4: {
                slots.get(selectorPosi).setBackgroundResource(R.drawable.coil_selection);
                ladderMatrix.setSelectorPosi(selectorPosi);
                break;
            }
            case 5: {
                slots.get(selectorPosi).setBackgroundResource(R.drawable.coil_nc_selection);
                ladderMatrix.setSelectorPosi(selectorPosi);
                break;
            }
        }
    }

    private void insertLine(int position, boolean selection) {
        if (selection) {
            slots.get(position).setBackgroundResource(R.drawable.line_horizontal_selection);
        } else {
            slots.get(position).setBackgroundResource(R.drawable.line_horizontal);
        }
        slots.get(position).setText("");
        statusSlot[position] = 3;
    }

    private void loadDiagram(@NonNull String content) {
        String[] points = content.split("#");
        String[] inputs = points[0].split("\n");
        String[] outputs = points[1].replaceFirst("\n", "").split("\n");
        loadInputs(inputs);
        loadOutputs(outputs);
        loadLines(points[2].replaceFirst("\n", ""));
    }
    
    private void loadInputs(@NonNull String[] inputs) {
        for (String points: inputs) {
            if (points.length()<4) {
                continue;
            }
            String[] pointsWithoutInput = points.split(":");
            String[] aux = pointsWithoutInput[1].split(",");
            for (String point : aux) {
                if(point.contains("!")) {
                    String[] auxPoint = point.split("!");
                    createNewContact(Integer.parseInt(pointsWithoutInput[0]),2, Integer.parseInt(auxPoint[1]), false);
                    continue;
                }
                createNewContact(Integer.parseInt(pointsWithoutInput[0]),1, Integer.parseInt(point), false);
            }
        }
    }

    private void loadOutputs(@NonNull String[] outputs) {
        for (String points: outputs) {
            if (points.length()<4) {
                continue;
            }
            String[] pointsWithoutOutput = points.split(":");
            String[] aux = pointsWithoutOutput[1].split(",");
            for (String point : aux) {
                if(point.contains("!")) {
                    String[] auxPoint = point.split("!");
                    createNewCoil(Integer.parseInt(pointsWithoutOutput[0]),2, Integer.parseInt(auxPoint[1]), false);
                    continue;
                }
                createNewCoil(Integer.parseInt(pointsWithoutOutput[0]),1, Integer.parseInt(point), false);
            }
        }
    }

    private void loadLines(@NonNull String lines) {
        String[] points = lines.replaceFirst("lines:", "").replaceFirst("\n", "").split(",");
        for (String point: points) {
            if(!point.matches("")) {
                insertLine(Integer.parseInt(point), false);
            }
        }
    }

    private boolean isRightPlaceToInsert(int selectorPosition, int insertionType) {
        switch (insertionType) {
            case INSERTION_TYPE_CONTACT: {
                return !(((selectorPosition+1) % 6) == 0);
            }
            case INSERTION_TYPE_COIL: {
                return (((selectorPosition+1) % 6) == 0);
            }
            case INSERTION_TYPE_LINE: {
                return !((((selectorPosition+1) % 6) == 0) || ((selectorPosition % 6) == 0));
            }
            default: {return false;}
        }
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_open) {
            Intent intent = new Intent(getApplicationContext(), OpenActivity.class);
            startActivityForResult(intent, OPEN_FILE_REQUEST);
        } else if (id == R.id.nav_compile) {
            ManagementLogicFile managementLogicFile = new ManagementLogicFile(getApplicationContext());
            String logic = managementLogicFile.getLogicalDiagramContents(this.slots, this.statusSlot);
            Compiler compiler = new Compiler(logic);
            this.hexLogic = compiler.compileLogic();
            if(this.hexLogic.length == 0) {
                Toast.makeText(getApplicationContext(),"Lógica não compilada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(),"Lógica compilada com sucesso", Toast.LENGTH_SHORT).show();
            }
        }  else if (id == R.id.nav_send) {
            Intent intent = new Intent(getApplicationContext(), SendActivity.class);
            intent.putExtra("hexLogic", this.hexLogic);
            startActivityForResult(intent, SEND_REQUEST);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
