package com.example.tcc_pro_v02.Compiler;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compiler {
    private String logic;
    private String[] inputs;
    private String[] outputs;
    private String lines;

    public Compiler(String logic) {
        this.logic = logic;
    }

    // TODO: terminar o compilador, continuar debug, algo de errado no hexafiles

    public int[] compileLogic() {
        int[] logicCompiled = new int[]{};
        setIOsByLogicalDiagram();
        List<Integer> IN_0 = extractPoints(this.inputs[0]);
        List<Integer> IN_1 = extractPoints(this.inputs[1]);
        List<Integer> IN_2 = extractPoints(this.inputs[2]);
        List<Integer> IN_3 = extractPoints(this.inputs[3]);
        List<Integer> OUT_0 = extractPoints(this.outputs[0]);
        List<Integer> OUT_1 = extractPoints(this.outputs[1]);
        List<Integer> linesPoints = extractLinePoints(this.lines);
        for (int outPoint: OUT_0) {
            List<Integer> auxInPoints = new ArrayList<>();
            List<Integer> auxLinePoints = new ArrayList<>();
            for (int inPoint: IN_0) {
                if (inPoint < outPoint && inPoint > (outPoint-6)) {
                    auxInPoints.add(inPoint);
                }
            }
            for (int line: linesPoints) {
                if (line < outPoint && line > (outPoint-6)) {
                    auxLinePoints.add(line);
                }
            }
            System.out.println("DEBUG " + auxInPoints.toString());
            System.out.println("DEBUG " + auxLinePoints.toString());
            logicCompiled = getHexFile(0,0, outPoint, auxInPoints.get(0), auxLinePoints);
            int[] logic = getHexFile(1,0, outPoint, auxInPoints.get(0), auxLinePoints);
            System.out.println("DEBUG " + logic.length);
            System.out.println("DEBUG " + Arrays.equals(logicCompiled, logic));
        }
        return logicCompiled;
    }

    private void setIOsByLogicalDiagram() {
        String[] points = this.logic.split("#");
        this.inputs = points[0].split("\n");
        this.outputs = points[1].replaceFirst("\n", "").split("\n");
        this.lines = points[2].replaceFirst("\n", "");
    }

    private List<Integer> extractPoints(@NonNull String ioLines) {
        List<Integer> points = new ArrayList<>();
        if (ioLines.length()<4) {
            return points;
        }
        String[] aux = ioLines.split(":")[1].split(",");
        for (String point: aux) {
            points.add(Integer.parseInt(point));
        }
        return points;
    }

    private List<Integer> extractLinePoints(@NonNull String lines) {
        List<Integer> points = new ArrayList<>();
        String[] aux = lines.replaceFirst("lines:", "").replaceFirst("\n", "").split(",");
        for (String point: aux) {
            points.add(Integer.parseInt(point));
        }
        return points;
    }

    private int[] getHexFile(int outputPointInPLC, int inputPointInPLC, int outputSlot, int inputSlot, List<Integer> linesList) {
        final int OUT_0 = 0;
        final int OUT_1 = 1;
        final int IN_0 = 0;
        final int IN_1 = 1;
        final int IN_2 = 2;
        final int IN_3 = 3;
        final int SLOT_OUT_5 = 5;
        final int SLOT_OUT_11 = 11;
        final int SLOT_OUT_17 = 17;
        final int SLOT_OUT_23 = 23;
        final int SLOT_OUT_29 = 29;
        if (outputPointInPLC == OUT_0 && inputPointInPLC == IN_0 && outputSlot == SLOT_OUT_5 && inputSlot == 0 && linesList.containsAll(Arrays.asList(1,2,3,4))) {
            return HexFiles.BASE_IN_0_OUT_0;
        }
        if (outputPointInPLC == OUT_1 && inputPointInPLC == IN_0 && outputSlot == SLOT_OUT_5 && inputSlot == 0 && linesList.containsAll(Arrays.asList(1,2,3,4))) {
            return HexFiles.setNewHexFile(HexFiles.IN_1_OUT_0, HexFiles.BASE_IN_0_OUT_0);
        }
        return HexFiles.BASE_IN_0_OUT_0;
    }
}
