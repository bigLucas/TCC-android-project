package com.example.tcc_pro_v02.Compiler;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Compiler {
    private String logic;
    private String[] inputs;
    private String[] outputs;
    private String lines;

    public Compiler(String logic) {
        this.logic = logic;
    }

    // TODO: terminar o compilador, ainda estou enviando um hex mocado
    // posso partir do mock e criar outros aqrquivos só mudando
    // a entrada que aciona a saída

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
            List<Integer> aux = new ArrayList<>();
            aux.add(1);
            aux.add(2);
            aux.add(3);
            aux.add(4);
            if (auxInPoints.contains(0) && auxLinePoints.containsAll(aux)) {
                logicCompiled = HexFiles.IN_0_OUT_0;
            }
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

//    private void findConnections(String[] out) {
//        if(out.length > 0) {
//            for (String point: out) {
//
//            }
//        }
//    }
}
