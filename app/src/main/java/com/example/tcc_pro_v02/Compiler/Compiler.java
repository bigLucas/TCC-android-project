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
    private final int OUT_0_IN_PLC = 0;
    private final int OUT_1_IN_PLC = 1;
    private final int IN_0_IN_PLC = 0;
    private final int IN_1_IN_PLC = 1;
    private final int IN_2_IN_PLC = 2;
    private final int IN_3_IN_PLC = 3;

    public Compiler(String logic) { this.logic = logic; }

    // TODO: Compile new logic with arduino IDE, add it to Hexfiles.java and add new cases for compile diagrams in getHexFile function
    // TODO: falta lógica pra 4 entradas
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
        final int quantityOfInputsOnSameLineOfOutput = quantityOfInputsOnSameLine(inputsPointsOnSameLineOfOutput);
        final List<Integer> index = getIndexOfInputsOnSameLine(inputsPointsOnSameLineOfOutput);
        int[] newHexFile = new int[]{};
        final int SLOT_OUT_5 = 5;
        final int SLOT_OUT_11 = 11;
        final int SLOT_OUT_17 = 17;
        final int SLOT_OUT_23 = 23;
        final int SLOT_OUT_29 = 29;
        if ((quantityOfInputsOnSameLineOfOutput == 1) && (index.size() == 1)) {
            for (int i = 0; i<inputsPointsOnSameLineOfOutput.size(); i++) {
                // 1 INPUT
                // TODO: verificar a possibilidade de retirar a checagem por inputsPointsOnSameLineOfOutput.get(i) == 0
                // nessa checagem eu verificao se o ponto de input está no slot 0,
                // a entrada não precisa estar no slot 0, pode estar em outros slot, desde que tenha linhas completando
                // TODO: verificar a quantiade de linhas, mudar a interface para não compilar logica com linhas incompletas
                if (inputsPointsOnSameLineOfOutput.get(i) != NOT_FOUND_ON_SAME_LINE) {
                    if (outputInPLC == OUT_0_IN_PLC && i == IN_0_IN_PLC && outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1, 2, 3, 4))) {
                        System.out.println("DEBUG I pass for here 00");
                        newHexFile = HexFiles.BASE_IN_0_OUT_0;
                    }
                    if (outputInPLC == OUT_0_IN_PLC && i == IN_1_IN_PLC&& outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1, 2, 3, 4))) {
                        System.out.println("DEBUG I pass for here 01");
                        newHexFile = HexFiles.setNewHexFile(HexFiles.IN_1_OUT_0, HexFiles.BASE_IN_0_OUT_0);
                    }
                    if (outputInPLC == OUT_0_IN_PLC && i == IN_2_IN_PLC && outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1, 2, 3, 4))) {
                        System.out.println("DEBUG I pass for here 02");
                        newHexFile = HexFiles.setNewHexFile(HexFiles.IN_2_OUT_0, HexFiles.BASE_IN_0_OUT_0);
                    }
                    if (outputInPLC == OUT_0_IN_PLC && i == IN_3_IN_PLC && outputSlot == SLOT_OUT_5 && inputsPointsOnSameLineOfOutput.get(i) == 0 && linesList.containsAll(Arrays.asList(1, 2, 3, 4))) {
                        System.out.println("DEBUG I pass for here 03");
                        newHexFile = HexFiles.setNewHexFile(HexFiles.IN_3_OUT_0, HexFiles.BASE_IN_0_OUT_0);
                    }
                }
            }
        } else if ((quantityOfInputsOnSameLineOfOutput == 2) && (index.size() == 2)) {
            System.out.println("DEBUG qty 2");
            newHexFile = findHexFileForTwoInputsAndOneOutput(index);
        } else if ((quantityOfInputsOnSameLineOfOutput == 3) && (index.size() == 3)) {
            System.out.println("DEBUG qty 3");
            newHexFile = findHexFileForThreeInputsAndOneOutput(index);
        } else if ((quantityOfInputsOnSameLineOfOutput == 4) && (index.size() == 4)) {
            System.out.println("DEBUG qty 4");
        }
        return newHexFile;
    }

    private int quantityOfInputsOnSameLine(@NonNull List<Integer> inputsPointsOnSameLineOfOutput) {
        int quantity = 0;
        for (int point: inputsPointsOnSameLineOfOutput) {
            if(point != NOT_FOUND_ON_SAME_LINE) {
                quantity++;
            }
        }
        return quantity;
    }

    private List<Integer> getIndexOfInputsOnSameLine(@NonNull List<Integer> inputsPointsOnSameLineOfOutput) {
        List<Integer> index = new ArrayList<>();
        for(int i=0; i<inputsPointsOnSameLineOfOutput.size(); i++) {
            if(inputsPointsOnSameLineOfOutput.get(i) != NOT_FOUND_ON_SAME_LINE) {
                index.add(i);
            }
        }
        return index;
    }

    private int[] findHexFileForTwoInputsAndOneOutput(@NonNull List<Integer> indexOfInputs) {
        if(indexOfInputs.get(0) == IN_0_IN_PLC && indexOfInputs.get(1) == IN_1_IN_PLC) {
            System.out.println("DEBUG IN_0 and IN_1");
            return HexFiles.BASE_IN_0_IN_1_OUT_0;
        } if(indexOfInputs.get(0) == IN_0_IN_PLC && indexOfInputs.get(1) == IN_2_IN_PLC) {
            System.out.println("DEBUG IN_0 and IN_2");
            return HexFiles.setNewHexFile(HexFiles.IN_0_IN_2_OUT_0, HexFiles.BASE_IN_0_IN_1_OUT_0);
        } if(indexOfInputs.get(0) == IN_0_IN_PLC && indexOfInputs.get(1) == IN_3_IN_PLC) {
            System.out.println("DEBUG IN_0 and IN_3");
            return HexFiles.setNewHexFile(HexFiles.IN_0_IN_3_OUT_0, HexFiles.BASE_IN_0_IN_1_OUT_0);
        } if(indexOfInputs.get(0) == IN_1_IN_PLC && indexOfInputs.get(1) == IN_2_IN_PLC) {
            System.out.println("DEBUG IN_1 and IN_2");
            return HexFiles.setNewHexFile(HexFiles.IN_1_IN_2_OUT_0, HexFiles.BASE_IN_0_IN_1_OUT_0);
        } if(indexOfInputs.get(0) == IN_1_IN_PLC && indexOfInputs.get(1) == IN_3_IN_PLC) {
            System.out.println("DEBUG IN_1 and IN_3");
            return HexFiles.setNewHexFile(HexFiles.IN_1_IN_3_OUT_0, HexFiles.BASE_IN_0_IN_1_OUT_0);
        } if(indexOfInputs.get(0) == IN_2_IN_PLC && indexOfInputs.get(1) == IN_3_IN_PLC) {
            System.out.println("DEBUG IN_2 and IN_3");
            return HexFiles.setNewHexFile(HexFiles.IN_2_IN_3_OUT_0, HexFiles.BASE_IN_0_IN_1_OUT_0);
        }
        return new int[]{};
    }

    private int[] findHexFileForThreeInputsAndOneOutput(@NonNull List<Integer> indexOfInputs) {
        if(indexOfInputs.get(0) == IN_0_IN_PLC && indexOfInputs.get(1) == IN_1_IN_PLC && indexOfInputs.get(2) == IN_2_IN_PLC) {
            System.out.println("DEBUG IN_0, IN_1 and IN_2");
            return HexFiles.BASE_IN_0_IN_1_IN_2_OUT_0;
        } if(indexOfInputs.get(0) == IN_0_IN_PLC && indexOfInputs.get(1) == IN_1_IN_PLC && indexOfInputs.get(2) == IN_3_IN_PLC) {
            System.out.println("DEBUG IN_0, IN_1 and IN_3");
            return HexFiles.setNewHexFile(HexFiles.IN_0_IN_1_IN_3_OUT_0, HexFiles.BASE_IN_0_IN_1_IN_2_OUT_0);
        } if(indexOfInputs.get(0) == IN_0_IN_PLC && indexOfInputs.get(1) == IN_2_IN_PLC && indexOfInputs.get(2) == IN_3_IN_PLC) {
            System.out.println("DEBUG IN_0, IN_2 and IN_3");
            return HexFiles.setNewHexFile(HexFiles.IN_0_IN_2_IN_3_OUT_0, HexFiles.BASE_IN_0_IN_1_IN_2_OUT_0);
        } if(indexOfInputs.get(0) == IN_1_IN_PLC && indexOfInputs.get(1) == IN_2_IN_PLC && indexOfInputs.get(2) == IN_3_IN_PLC) {
            System.out.println("DEBUG IN_1, IN_2 and IN_3");
            return HexFiles.setNewHexFile(HexFiles.IN_1_IN_2_IN_3_OUT_0, HexFiles.BASE_IN_0_IN_1_IN_2_OUT_0);
        }
        return new int[]{};
    }
}
