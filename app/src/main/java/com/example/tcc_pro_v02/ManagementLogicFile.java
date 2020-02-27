package com.example.tcc_pro_v02;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ManagementLogicFile {
    private Context context;

    public ManagementLogicFile(Context context) {
        this.context = context;
    }

    public void save(@NonNull String filename, ArrayList<TextView> slots, @NonNull int[] statusSlot) {
        String fileContents = getLogicalDiagramContents(slots, statusSlot);
        try (FileOutputStream fos = context.openFileOutput(filename.concat(".txt"), Context.MODE_PRIVATE)) {
            fos.write(fileContents.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(@NonNull String filename) {
        FileInputStream fis = null;
        try {
            fis = context.openFileInput(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
            String line = reader.readLine();
//            System.out.println("DEBUG 01:");
//            System.out.println(line);
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
//                if (line != null) {
//                    // posso usar o metodo contains para verificar qual o tipo de linha
//                    // guardo onde cada entrada está sendo acionada no diagrama por linha
//                    // as saidas ficam depois do "#"
//                    if (line.contains("#")) {
//                        System.out.println("#".getBytes());
//                        System.out.println(line.getBytes());
//                        System.out.println(line == "#");
//                    }
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            String contents = stringBuilder.toString();
        }
        return stringBuilder.toString();
    }

    @NonNull private String getLogicalDiagramContents(ArrayList<TextView> slots, @NonNull int[] statusSlot) {
        String[] inputs = new String[4];
        String[] outputs = new String[2];
        String lines = "lines:";
        inputs[0] = "00:";
        inputs[1] = "01:";
        inputs[2] = "02:";
        inputs[3] = "03:";
        outputs[0] = "00:";
        outputs[1] = "01:";
        String[] textAux;

        for (int i=0; i<statusSlot.length; i++) {
            if(statusSlot[i] > 0 && statusSlot[i] < 6) {
                switch (statusSlot[i]) {
                    case 1: {
                        textAux = slots.get(i).getText().toString().split("In ");
                        inputs[Integer.parseInt(textAux[1])] = inputs[Integer.parseInt(textAux[1])].concat(i + ",");
                        break;
                    }
                    case 2: {
                        textAux = slots.get(i).getText().toString().split("In ");
                        inputs[Integer.parseInt(textAux[1])] = inputs[Integer.parseInt(textAux[1])].concat("!" + i + ",");
                        break;
                    }
                    case 3: {
                        lines = lines.concat(i + ",");
                        break;
                    }
                    case 4: {
                        textAux = slots.get(i).getText().toString().split("Out ");
                        outputs[Integer.parseInt(textAux[1])] = outputs[Integer.parseInt(textAux[1])].concat(i + ",");
                        break;
                    }
                    case 5: {
                        textAux = slots.get(i).getText().toString().split("Out ");
                        outputs[Integer.parseInt(textAux[1])] = outputs[Integer.parseInt(textAux[1])].concat("!" + i + ",");
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        }
        return inputs[0]+"\n"+
                inputs[1]+"\n"+
                inputs[2]+"\n"+
                inputs[3]+"\n#\n"+
                outputs[0]+"\n"+
                outputs[1]+"\n#\n"+
                lines;
    }
}
