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
    private final int NOT_FOUND_ON_SAME_LINE = -1;

    public Compiler(String logic) { this.logic = logic; }

    // TODO: Compile new logic with arduino IDE, add it to Hexfiles.java and add new cases for compile diagrams in getHexFile function

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
            List<Integer> inputsPointsOnSameLineOfOutput = new ArrayList<>();
            inputsPointsOnSameLineOfOutput.add(findPointsOnSameLineOfOutput(IN_0, outPoint));
            inputsPointsOnSameLineOfOutput.add(findPointsOnSameLineOfOutput(IN_1, outPoint));
            inputsPointsOnSameLineOfOutput.add(findPointsOnSameLineOfOutput(IN_2, outPoint));
            inputsPointsOnSameLineOfOutput.add(findPointsOnSameLineOfOutput(IN_3, outPoint));
            List<Integer> linesPointsOnSameLineOfOutput = findLinesOnSameLineOfOutput(linesPoints, outPoint);
            System.out.println("DEBUG inputs on same line: " + inputsPointsOnSameLineOfOutput.toString());
            System.out.println("DEBUG lines: " + linesPointsOnSameLineOfOutput.toString());
            logicCompiled = getHexFile(0, outPoint, inputsPointsOnSameLineOfOutput, linesPointsOnSameLineOfOutput);
        }
        return logicCompiled;
    }

    private int findPointsOnSameLineOfOutput(@NonNull List<Integer> pointsOnDiagram, int outputPointOnDiagram) {
        int inputOnSameLine = NOT_FOUND_ON_SAME_LINE;
        for (int point: pointsOnDiagram) {
            if (point < outputPointOnDiagram && point > (outputPointOnDiagram - 6)) {
                inputOnSameLine = point;
                break;
            }
        }
        return inputOnSameLine;
    }

    private List<Integer> findLinesOnSameLineOfOutput(@NonNull List<Integer> pointsOnDiagram, int outputPointOnDiagram) {
        List<Integer> pointsOnSameLine = new ArrayList<>();
        for (int point: pointsOnDiagram) {
            if (point < outputPointOnDiagram && point > (outputPointOnDiagram-6)) {
                pointsOnSameLine.add(point);
            }
        }
        return pointsOnSameLine;
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

    private int[] getHexFile(int outputInPLC, int outputSlot, List<Integer> inputsPointsOnSameLineOfOutput, List<Integer> linesList) {
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
        for (int i = 0; i<inputsPointsOnSameLineOfOutput.size(); i++) {
            if (inputsPointsOnSameLineOfOutput.get(i) != NOT_FOUND_ON_SAME_LINE) {
                if (outputInPLC == OUT_0 && i == IN_0 && outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1,2,3,4))) {
                    System.out.println("DEBUG I pass for here 00");
                    return HexFiles.BASE_IN_0_OUT_0;
                }
                if (outputInPLC == OUT_0 && i == IN_1 && outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1,2,3,4))) {
                    System.out.println("DEBUG I pass for here 01");
                    return HexFiles.setNewHexFile(HexFiles.IN_1_OUT_0, HexFiles.BASE_IN_0_OUT_0);
                }
                if (outputInPLC == OUT_0 && i == IN_2 && outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1,2,3,4))) {
                    System.out.println("DEBUG I pass for here 02");
                    return HexFiles.setNewHexFile(HexFiles.IN_1_OUT_0, HexFiles.BASE_IN_0_OUT_0);
                }
                if (outputInPLC == OUT_0 && i == IN_3 && outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1,2,3,4))) {
                    System.out.println("DEBUG I pass for here 03");
                    return HexFiles.setNewHexFile(HexFiles.IN_1_OUT_0, HexFiles.BASE_IN_0_OUT_0);
                }
            }
        }
        return HexFiles.BASE_IN_0_OUT_0;
    }
}
