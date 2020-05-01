package com.example.tcc_pro_v02.Compiler;

import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class HexFiles {

    public static int[] setNewHexFile(@NonNull List<FlashMemoryHex> diferences, @NonNull int[] baseHexFile) {
        int[] newHexFile = baseHexFile.clone();
        for (FlashMemoryHex diference: diferences) {
            newHexFile[diference.index] = diference.hex;
        }
        return newHexFile;
    }

    public static final int[] BASE_IN_0_OUT_0 = {
        0x0C, 0x94, 0x61, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0xFA, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x00, 0x00, 0x00, 0x00, 0x24, 0x00, 0x27, 0x00,
        0x2A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x23, 0x00, 0x26, 0x00, 0x29, 0x00, 0x00, 0x00, 0x00, 0x00,
        0x25, 0x00, 0x28, 0x00, 0x2B, 0x00, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x02, 0x02,
        0x02, 0x02, 0x02, 0x02, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20,
        0x40, 0x80, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x00, 0x00,
        0x00, 0x08, 0x00, 0x02, 0x01, 0x00, 0x00, 0x03, 0x04, 0x07, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
        0x00, 0x00, 0x11, 0x24, 0x1F, 0xBE, 0xCF, 0xEF, 0xD8, 0xE0, 0xDE, 0xBF, 0xCD, 0xBF, 0x21, 0xE0,
        0xA0, 0xE0, 0xB1, 0xE0, 0x01, 0xC0, 0x1D, 0x92, 0xA9, 0x30, 0xB2, 0x07, 0xE1, 0xF7, 0x0E, 0x94,
        0x44, 0x01, 0x0C, 0x94, 0xBE, 0x01, 0x0C, 0x94, 0x00, 0x00, 0x83, 0x30, 0x81, 0xF0, 0x28, 0xF4,
        0x81, 0x30, 0x99, 0xF0, 0x82, 0x30, 0xA9, 0xF0, 0x08, 0x95, 0x87, 0x30, 0xA9, 0xF0, 0x88, 0x30,
        0xC9, 0xF0, 0x84, 0x30, 0xB1, 0xF4, 0x80, 0x91, 0x80, 0x00, 0x8F, 0x7D, 0x03, 0xC0, 0x80, 0x91,
        0x80, 0x00, 0x8F, 0x77, 0x80, 0x93, 0x80, 0x00, 0x08, 0x95, 0x84, 0xB5, 0x8F, 0x77, 0x84, 0xBD,
        0x08, 0x95, 0x84, 0xB5, 0x8F, 0x7D, 0xFB, 0xCF, 0x80, 0x91, 0xB0, 0x00, 0x8F, 0x77, 0x80, 0x93,
        0xB0, 0x00, 0x08, 0x95, 0x80, 0x91, 0xB0, 0x00, 0x8F, 0x7D, 0xF9, 0xCF, 0x1F, 0x93, 0xCF, 0x93,
        0xDF, 0x93, 0xE0, 0xEB, 0xF0, 0xE0, 0x94, 0x91, 0xEC, 0xE9, 0xF0, 0xE0, 0xD4, 0x91, 0xE8, 0xE8,
        0xF0, 0xE0, 0xC4, 0x91, 0xCC, 0x23, 0xB9, 0xF0, 0x18, 0x2F, 0x99, 0x23, 0x19, 0xF0, 0x89, 0x2F,
        0x0E, 0x94, 0x75, 0x00, 0xEC, 0x2F, 0xF0, 0xE0, 0xEE, 0x0F, 0xFF, 0x1F, 0xE4, 0x58, 0xFF, 0x4F,
        0xA5, 0x91, 0xB4, 0x91, 0x8F, 0xB7, 0xF8, 0x94, 0xEC, 0x91, 0x11, 0x11, 0x08, 0xC0, 0xD0, 0x95,
        0xDE, 0x23, 0xDC, 0x93, 0x8F, 0xBF, 0xDF, 0x91, 0xCF, 0x91, 0x1F, 0x91, 0x08, 0x95, 0xDE, 0x2B,
        0xF8, 0xCF, 0xCF, 0x93, 0xDF, 0x93, 0x90, 0xE0, 0xFC, 0x01, 0xE6, 0x56, 0xFF, 0x4F, 0x24, 0x91,
        0x8A, 0x57, 0x9F, 0x4F, 0xFC, 0x01, 0x84, 0x91, 0x88, 0x23, 0xD1, 0xF0, 0x90, 0xE0, 0x88, 0x0F,
        0x99, 0x1F, 0xFC, 0x01, 0xE8, 0x59, 0xFF, 0x4F, 0xA5, 0x91, 0xB4, 0x91, 0xFC, 0x01, 0xE4, 0x58,
        0xFF, 0x4F, 0xC5, 0x91, 0xD4, 0x91, 0x61, 0x11, 0x0E, 0xC0, 0x9F, 0xB7, 0xF8, 0x94, 0x8C, 0x91,
        0xE2, 0x2F, 0xE0, 0x95, 0x8E, 0x23, 0x8C, 0x93, 0x28, 0x81, 0xE2, 0x23, 0xE8, 0x83, 0x9F, 0xBF,
        0xDF, 0x91, 0xCF, 0x91, 0x08, 0x95, 0x8F, 0xB7, 0xF8, 0x94, 0xEC, 0x91, 0xE2, 0x2B, 0xEC, 0x93,
        0x8F, 0xBF, 0xF6, 0xCF, 0x1F, 0x92, 0x0F, 0x92, 0x0F, 0xB6, 0x0F, 0x92, 0x11, 0x24, 0x2F, 0x93,
        0x3F, 0x93, 0x8F, 0x93, 0x9F, 0x93, 0xAF, 0x93, 0xBF, 0x93, 0x80, 0x91, 0x05, 0x01, 0x90, 0x91,
        0x06, 0x01, 0xA0, 0x91, 0x07, 0x01, 0xB0, 0x91, 0x08, 0x01, 0x30, 0x91, 0x04, 0x01, 0x23, 0xE0,
        0x23, 0x0F, 0x2D, 0x37, 0x58, 0xF5, 0x01, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0x20, 0x93, 0x04, 0x01,
        0x80, 0x93, 0x05, 0x01, 0x90, 0x93, 0x06, 0x01, 0xA0, 0x93, 0x07, 0x01, 0xB0, 0x93, 0x08, 0x01,
        0x80, 0x91, 0x00, 0x01, 0x90, 0x91, 0x01, 0x01, 0xA0, 0x91, 0x02, 0x01, 0xB0, 0x91, 0x03, 0x01,
        0x01, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0x80, 0x93, 0x00, 0x01, 0x90, 0x93, 0x01, 0x01, 0xA0, 0x93,
        0x02, 0x01, 0xB0, 0x93, 0x03, 0x01, 0xBF, 0x91, 0xAF, 0x91, 0x9F, 0x91, 0x8F, 0x91, 0x3F, 0x91,
        0x2F, 0x91, 0x0F, 0x90, 0x0F, 0xBE, 0x0F, 0x90, 0x1F, 0x90, 0x18, 0x95, 0x26, 0xE8, 0x23, 0x0F,
        0x02, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0xD2, 0xCF, 0x78, 0x94, 0x84, 0xB5, 0x82, 0x60, 0x84, 0xBD,
        0x84, 0xB5, 0x81, 0x60, 0x84, 0xBD, 0x85, 0xB5, 0x82, 0x60, 0x85, 0xBD, 0x85, 0xB5, 0x81, 0x60,
        0x85, 0xBD, 0x80, 0x91, 0x6E, 0x00, 0x81, 0x60, 0x80, 0x93, 0x6E, 0x00, 0x10, 0x92, 0x81, 0x00,
        0x80, 0x91, 0x81, 0x00, 0x82, 0x60, 0x80, 0x93, 0x81, 0x00, 0x80, 0x91, 0x81, 0x00, 0x81, 0x60,
        0x80, 0x93, 0x81, 0x00, 0x80, 0x91, 0x80, 0x00, 0x81, 0x60, 0x80, 0x93, 0x80, 0x00, 0x80, 0x91,
        0xB1, 0x00, 0x84, 0x60, 0x80, 0x93, 0xB1, 0x00, 0x80, 0x91, 0xB0, 0x00, 0x81, 0x60, 0x80, 0x93,
        0xB0, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x84, 0x60, 0x80, 0x93, 0x7A, 0x00, 0x80, 0x91, 0x7A, 0x00,
        0x82, 0x60, 0x80, 0x93, 0x7A, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x81, 0x60, 0x80, 0x93, 0x7A, 0x00,
        0x80, 0x91, 0x7A, 0x00, 0x80, 0x68, 0x80, 0x93, 0x7A, 0x00, 0x10, 0x92, 0xC1, 0x00, 0x60, 0xE0,
        0x85, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x60, 0xE0, 0x86, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x60, 0xE0,
        0x87, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x60, 0xE0, 0x88, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x61, 0xE0,
        0x82, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0xC3, 0xEB, 0xD0, 0xE0, 0x0F, 0xE9, 0x10, 0xE0, 0x9B, 0xE8,
        0xE9, 0x2E, 0x90, 0xE0, 0xF9, 0x2E, 0xFE, 0x01, 0x84, 0x91, 0xF8, 0x01, 0xC4, 0x90, 0xF7, 0x01,
        0xD4, 0x90, 0xDD, 0x20, 0x79, 0xF0, 0x81, 0x11, 0x0E, 0x94, 0x75, 0x00, 0xED, 0x2D, 0xF0, 0xE0,
        0xEE, 0x0F, 0xFF, 0x1F, 0xEE, 0x58, 0xFF, 0x4F, 0xA5, 0x91, 0xB4, 0x91, 0x8C, 0x91, 0xC8, 0x22,
        0x81, 0xE0, 0x09, 0xF4, 0x80, 0xE0, 0x0E, 0x94, 0x9E, 0x00, 0xE5, 0xCF, 0xF8, 0x94, 0xFF, 0xCF
    };

    public static final List<FlashMemoryHex> IN_1_OUT_0 = Arrays.asList(
            new FlashMemoryHex(822, 0xC4),
            new FlashMemoryHex(826, 0x00),
            new FlashMemoryHex(827, 0xEA),
            new FlashMemoryHex(830, 0x9C)
    );

    public static final List<FlashMemoryHex> IN_2_OUT_0 = Arrays.asList(
            new FlashMemoryHex(822, 0xC5),
            new FlashMemoryHex(826, 0x1),
            new FlashMemoryHex(827, 0xEA),
            new FlashMemoryHex(830, 0x9D)
    );

    public static final List<FlashMemoryHex> IN_3_OUT_0 = Arrays.asList(
            new FlashMemoryHex(822, 0xC6),
            new FlashMemoryHex(826, 0x2),
            new FlashMemoryHex(827, 0xEA),
            new FlashMemoryHex(830, 0x9E)
    );

    public static final int[] BASE_IN_0_IN_1_OUT_0 = {
        0x0C, 0x94, 0x61, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x23, 0x01, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x00, 0x00, 0x00, 0x00, 0x24, 0x00, 0x27, 0x00,
        0x2A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x23, 0x00, 0x26, 0x00, 0x29, 0x00, 0x00, 0x00, 0x00, 0x00,
        0x25, 0x00, 0x28, 0x00, 0x2B, 0x00, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x02, 0x02,
        0x02, 0x02, 0x02, 0x02, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20,
        0x40, 0x80, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x00, 0x00,
        0x00, 0x08, 0x00, 0x02, 0x01, 0x00, 0x00, 0x03, 0x04, 0x07, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
        0x00, 0x00, 0x11, 0x24, 0x1F, 0xBE, 0xCF, 0xEF, 0xD8, 0xE0, 0xDE, 0xBF, 0xCD, 0xBF, 0x21, 0xE0,
        0xA0, 0xE0, 0xB1, 0xE0, 0x01, 0xC0, 0x1D, 0x92, 0xA9, 0x30, 0xB2, 0x07, 0xE1, 0xF7, 0x0E, 0x94,
        0x6D, 0x01, 0x0C, 0x94, 0xD4, 0x01, 0x0C, 0x94, 0x00, 0x00, 0x83, 0x30, 0x81, 0xF0, 0x28, 0xF4,
        0x81, 0x30, 0x99, 0xF0, 0x82, 0x30, 0xA9, 0xF0, 0x08, 0x95, 0x87, 0x30, 0xA9, 0xF0, 0x88, 0x30,
        0xC9, 0xF0, 0x84, 0x30, 0xB1, 0xF4, 0x80, 0x91, 0x80, 0x00, 0x8F, 0x7D, 0x03, 0xC0, 0x80, 0x91,
        0x80, 0x00, 0x8F, 0x77, 0x80, 0x93, 0x80, 0x00, 0x08, 0x95, 0x84, 0xB5, 0x8F, 0x77, 0x84, 0xBD,
        0x08, 0x95, 0x84, 0xB5, 0x8F, 0x7D, 0xFB, 0xCF, 0x80, 0x91, 0xB0, 0x00, 0x8F, 0x77, 0x80, 0x93,
        0xB0, 0x00, 0x08, 0x95, 0x80, 0x91, 0xB0, 0x00, 0x8F, 0x7D, 0xF9, 0xCF, 0x1F, 0x93, 0xCF, 0x93,
        0xDF, 0x93, 0xE0, 0xEB, 0xF0, 0xE0, 0x94, 0x91, 0xEC, 0xE9, 0xF0, 0xE0, 0xD4, 0x91, 0xE8, 0xE8,
        0xF0, 0xE0, 0xC4, 0x91, 0xCC, 0x23, 0xB9, 0xF0, 0x18, 0x2F, 0x99, 0x23, 0x19, 0xF0, 0x89, 0x2F,
        0x0E, 0x94, 0x75, 0x00, 0xEC, 0x2F, 0xF0, 0xE0, 0xEE, 0x0F, 0xFF, 0x1F, 0xE4, 0x58, 0xFF, 0x4F,
        0xA5, 0x91, 0xB4, 0x91, 0x8F, 0xB7, 0xF8, 0x94, 0xEC, 0x91, 0x11, 0x11, 0x08, 0xC0, 0xD0, 0x95,
        0xDE, 0x23, 0xDC, 0x93, 0x8F, 0xBF, 0xDF, 0x91, 0xCF, 0x91, 0x1F, 0x91, 0x08, 0x95, 0xDE, 0x2B,
        0xF8, 0xCF, 0xCF, 0x93, 0xDF, 0x93, 0x28, 0x2F, 0x30, 0xE0, 0xF9, 0x01, 0xE2, 0x55, 0xFF, 0x4F,
        0x84, 0x91, 0xF9, 0x01, 0xE6, 0x56, 0xFF, 0x4F, 0xD4, 0x91, 0xF9, 0x01, 0xEA, 0x57, 0xFF, 0x4F,
        0xC4, 0x91, 0xCC, 0x23, 0xA1, 0xF0, 0x81, 0x11, 0x0E, 0x94, 0x75, 0x00, 0xEC, 0x2F, 0xF0, 0xE0,
        0xEE, 0x0F, 0xFF, 0x1F, 0xEE, 0x58, 0xFF, 0x4F, 0xA5, 0x91, 0xB4, 0x91, 0xEC, 0x91, 0xED, 0x23,
        0x81, 0xE0, 0x90, 0xE0, 0x09, 0xF4, 0x80, 0xE0, 0xDF, 0x91, 0xCF, 0x91, 0x08, 0x95, 0x80, 0xE0,
        0x90, 0xE0, 0xFA, 0xCF, 0xCF, 0x93, 0xDF, 0x93, 0x90, 0xE0, 0xFC, 0x01, 0xE6, 0x56, 0xFF, 0x4F,
        0x24, 0x91, 0x8A, 0x57, 0x9F, 0x4F, 0xFC, 0x01, 0x84, 0x91, 0x88, 0x23, 0xD1, 0xF0, 0x90, 0xE0,
        0x88, 0x0F, 0x99, 0x1F, 0xFC, 0x01, 0xE8, 0x59, 0xFF, 0x4F, 0xA5, 0x91, 0xB4, 0x91, 0xFC, 0x01,
        0xE4, 0x58, 0xFF, 0x4F, 0xC5, 0x91, 0xD4, 0x91, 0x61, 0x11, 0x0E, 0xC0, 0x9F, 0xB7, 0xF8, 0x94,
        0x8C, 0x91, 0xE2, 0x2F, 0xE0, 0x95, 0x8E, 0x23, 0x8C, 0x93, 0x28, 0x81, 0xE2, 0x23, 0xE8, 0x83,
        0x9F, 0xBF, 0xDF, 0x91, 0xCF, 0x91, 0x08, 0x95, 0x8F, 0xB7, 0xF8, 0x94, 0xEC, 0x91, 0xE2, 0x2B,
        0xEC, 0x93, 0x8F, 0xBF, 0xF6, 0xCF, 0x1F, 0x92, 0x0F, 0x92, 0x0F, 0xB6, 0x0F, 0x92, 0x11, 0x24,
        0x2F, 0x93, 0x3F, 0x93, 0x8F, 0x93, 0x9F, 0x93, 0xAF, 0x93, 0xBF, 0x93, 0x80, 0x91, 0x05, 0x01,
        0x90, 0x91, 0x06, 0x01, 0xA0, 0x91, 0x07, 0x01, 0xB0, 0x91, 0x08, 0x01, 0x30, 0x91, 0x04, 0x01,
        0x23, 0xE0, 0x23, 0x0F, 0x2D, 0x37, 0x58, 0xF5, 0x01, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0x20, 0x93,
        0x04, 0x01, 0x80, 0x93, 0x05, 0x01, 0x90, 0x93, 0x06, 0x01, 0xA0, 0x93, 0x07, 0x01, 0xB0, 0x93,
        0x08, 0x01, 0x80, 0x91, 0x00, 0x01, 0x90, 0x91, 0x01, 0x01, 0xA0, 0x91, 0x02, 0x01, 0xB0, 0x91,
        0x03, 0x01, 0x01, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0x80, 0x93, 0x00, 0x01, 0x90, 0x93, 0x01, 0x01,
        0xA0, 0x93, 0x02, 0x01, 0xB0, 0x93, 0x03, 0x01, 0xBF, 0x91, 0xAF, 0x91, 0x9F, 0x91, 0x8F, 0x91,
        0x3F, 0x91, 0x2F, 0x91, 0x0F, 0x90, 0x0F, 0xBE, 0x0F, 0x90, 0x1F, 0x90, 0x18, 0x95, 0x26, 0xE8,
        0x23, 0x0F, 0x02, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0xD2, 0xCF, 0x78, 0x94, 0x84, 0xB5, 0x82, 0x60,
        0x84, 0xBD, 0x84, 0xB5, 0x81, 0x60, 0x84, 0xBD, 0x85, 0xB5, 0x82, 0x60, 0x85, 0xBD, 0x85, 0xB5,
        0x81, 0x60, 0x85, 0xBD, 0x80, 0x91, 0x6E, 0x00, 0x81, 0x60, 0x80, 0x93, 0x6E, 0x00, 0x10, 0x92,
        0x81, 0x00, 0x80, 0x91, 0x81, 0x00, 0x82, 0x60, 0x80, 0x93, 0x81, 0x00, 0x80, 0x91, 0x81, 0x00,
        0x81, 0x60, 0x80, 0x93, 0x81, 0x00, 0x80, 0x91, 0x80, 0x00, 0x81, 0x60, 0x80, 0x93, 0x80, 0x00,
        0x80, 0x91, 0xB1, 0x00, 0x84, 0x60, 0x80, 0x93, 0xB1, 0x00, 0x80, 0x91, 0xB0, 0x00, 0x81, 0x60,
        0x80, 0x93, 0xB0, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x84, 0x60, 0x80, 0x93, 0x7A, 0x00, 0x80, 0x91,
        0x7A, 0x00, 0x82, 0x60, 0x80, 0x93, 0x7A, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x81, 0x60, 0x80, 0x93,
        0x7A, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x80, 0x68, 0x80, 0x93, 0x7A, 0x00, 0x10, 0x92, 0xC1, 0x00,
        0x60, 0xE0, 0x85, 0xE0, 0x0E, 0x94, 0xF2, 0x00, 0x60, 0xE0, 0x86, 0xE0, 0x0E, 0x94, 0xF2, 0x00,
        0x60, 0xE0, 0x87, 0xE0, 0x0E, 0x94, 0xF2, 0x00, 0x60, 0xE0, 0x88, 0xE0, 0x0E, 0x94, 0xF2, 0x00,
        0x61, 0xE0, 0x82, 0xE0, 0x0E, 0x94, 0xF2, 0x00, 0x85, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x89, 0x2B,
        0x49, 0xF4, 0x86, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x89, 0x2B, 0x21, 0xF4, 0x80, 0xE0, 0x0E, 0x94,
        0x9E, 0x00, 0xF2, 0xCF, 0x81, 0xE0, 0xFB, 0xCF, 0xF8, 0x94, 0xFF, 0xCF
    };

    public static final List<FlashMemoryHex> IN_0_IN_2_OUT_0 = Collections.singletonList(
        new FlashMemoryHex(914, 0x87)
    );

    public static final List<FlashMemoryHex> IN_0_IN_3_OUT_0 = Collections.singletonList(
        new FlashMemoryHex(914, 0x88)
    );

    public static final List<FlashMemoryHex> IN_1_IN_2_OUT_0 = Arrays.asList(
        new FlashMemoryHex(904, 0x86),
        new FlashMemoryHex(914, 0x87)
    );

    public static final List<FlashMemoryHex> IN_1_IN_3_OUT_0 = Arrays.asList(
        new FlashMemoryHex(904, 0x86),
        new FlashMemoryHex(914, 0x88)
    );

    public static final List<FlashMemoryHex> IN_2_IN_3_OUT_0 = Arrays.asList(
        new FlashMemoryHex(904, 0x87),
        new FlashMemoryHex(914, 0x88)
    );

    public static final int[] BASE_IN_0_IN_1_IN_2_OUT_0 = {
        0x0C, 0x94, 0x61, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x23, 0x01, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00,
        0x0C, 0x94, 0x73, 0x00, 0x0C, 0x94, 0x73, 0x00, 0x00, 0x00, 0x00, 0x00, 0x24, 0x00, 0x27, 0x00,
        0x2A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x23, 0x00, 0x26, 0x00, 0x29, 0x00, 0x00, 0x00, 0x00, 0x00,
        0x25, 0x00, 0x28, 0x00, 0x2B, 0x00, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x04, 0x02, 0x02,
        0x02, 0x02, 0x02, 0x02, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20,
        0x40, 0x80, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x00, 0x00,
        0x00, 0x08, 0x00, 0x02, 0x01, 0x00, 0x00, 0x03, 0x04, 0x07, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
        0x00, 0x00, 0x11, 0x24, 0x1F, 0xBE, 0xCF, 0xEF, 0xD8, 0xE0, 0xDE, 0xBF, 0xCD, 0xBF, 0x21, 0xE0,
        0xA0, 0xE0, 0xB1, 0xE0, 0x01, 0xC0, 0x1D, 0x92, 0xA9, 0x30, 0xB2, 0x07, 0xE1, 0xF7, 0x0E, 0x94,
        0x6D, 0x01, 0x0C, 0x94, 0xD9, 0x01, 0x0C, 0x94, 0x00, 0x00, 0x83, 0x30, 0x81, 0xF0, 0x28, 0xF4,
        0x81, 0x30, 0x99, 0xF0, 0x82, 0x30, 0xA9, 0xF0, 0x08, 0x95, 0x87, 0x30, 0xA9, 0xF0, 0x88, 0x30,
        0xC9, 0xF0, 0x84, 0x30, 0xB1, 0xF4, 0x80, 0x91, 0x80, 0x00, 0x8F, 0x7D, 0x03, 0xC0, 0x80, 0x91,
        0x80, 0x00, 0x8F, 0x77, 0x80, 0x93, 0x80, 0x00, 0x08, 0x95, 0x84, 0xB5, 0x8F, 0x77, 0x84, 0xBD,
        0x08, 0x95, 0x84, 0xB5, 0x8F, 0x7D, 0xFB, 0xCF, 0x80, 0x91, 0xB0, 0x00, 0x8F, 0x77, 0x80, 0x93,
        0xB0, 0x00, 0x08, 0x95, 0x80, 0x91, 0xB0, 0x00, 0x8F, 0x7D, 0xF9, 0xCF, 0x1F, 0x93, 0xCF, 0x93,
        0xDF, 0x93, 0xE0, 0xEB, 0xF0, 0xE0, 0x94, 0x91, 0xEC, 0xE9, 0xF0, 0xE0, 0xD4, 0x91, 0xE8, 0xE8,
        0xF0, 0xE0, 0xC4, 0x91, 0xCC, 0x23, 0xB9, 0xF0, 0x18, 0x2F, 0x99, 0x23, 0x19, 0xF0, 0x89, 0x2F,
        0x0E, 0x94, 0x75, 0x00, 0xEC, 0x2F, 0xF0, 0xE0, 0xEE, 0x0F, 0xFF, 0x1F, 0xE4, 0x58, 0xFF, 0x4F,
        0xA5, 0x91, 0xB4, 0x91, 0x8F, 0xB7, 0xF8, 0x94, 0xEC, 0x91, 0x11, 0x11, 0x08, 0xC0, 0xD0, 0x95,
        0xDE, 0x23, 0xDC, 0x93, 0x8F, 0xBF, 0xDF, 0x91, 0xCF, 0x91, 0x1F, 0x91, 0x08, 0x95, 0xDE, 0x2B,
        0xF8, 0xCF, 0xCF, 0x93, 0xDF, 0x93, 0x28, 0x2F, 0x30, 0xE0, 0xF9, 0x01, 0xE2, 0x55, 0xFF, 0x4F,
        0x84, 0x91, 0xF9, 0x01, 0xE6, 0x56, 0xFF, 0x4F, 0xD4, 0x91, 0xF9, 0x01, 0xEA, 0x57, 0xFF, 0x4F,
        0xC4, 0x91, 0xCC, 0x23, 0xA1, 0xF0, 0x81, 0x11, 0x0E, 0x94, 0x75, 0x00, 0xEC, 0x2F, 0xF0, 0xE0,
        0xEE, 0x0F, 0xFF, 0x1F, 0xEE, 0x58, 0xFF, 0x4F, 0xA5, 0x91, 0xB4, 0x91, 0xEC, 0x91, 0xED, 0x23,
        0x81, 0xE0, 0x90, 0xE0, 0x09, 0xF4, 0x80, 0xE0, 0xDF, 0x91, 0xCF, 0x91, 0x08, 0x95, 0x80, 0xE0,
        0x90, 0xE0, 0xFA, 0xCF, 0xCF, 0x93, 0xDF, 0x93, 0x90, 0xE0, 0xFC, 0x01, 0xE6, 0x56, 0xFF, 0x4F,
        0x24, 0x91, 0x8A, 0x57, 0x9F, 0x4F, 0xFC, 0x01, 0x84, 0x91, 0x88, 0x23, 0xD1, 0xF0, 0x90, 0xE0,
        0x88, 0x0F, 0x99, 0x1F, 0xFC, 0x01, 0xE8, 0x59, 0xFF, 0x4F, 0xA5, 0x91, 0xB4, 0x91, 0xFC, 0x01,
        0xE4, 0x58, 0xFF, 0x4F, 0xC5, 0x91, 0xD4, 0x91, 0x61, 0x11, 0x0E, 0xC0, 0x9F, 0xB7, 0xF8, 0x94,
        0x8C, 0x91, 0xE2, 0x2F, 0xE0, 0x95, 0x8E, 0x23, 0x8C, 0x93, 0x28, 0x81, 0xE2, 0x23, 0xE8, 0x83,
        0x9F, 0xBF, 0xDF, 0x91, 0xCF, 0x91, 0x08, 0x95, 0x8F, 0xB7, 0xF8, 0x94, 0xEC, 0x91, 0xE2, 0x2B,
        0xEC, 0x93, 0x8F, 0xBF, 0xF6, 0xCF, 0x1F, 0x92, 0x0F, 0x92, 0x0F, 0xB6, 0x0F, 0x92, 0x11, 0x24,
        0x2F, 0x93, 0x3F, 0x93, 0x8F, 0x93, 0x9F, 0x93, 0xAF, 0x93, 0xBF, 0x93, 0x80, 0x91, 0x05, 0x01,
        0x90, 0x91, 0x06, 0x01, 0xA0, 0x91, 0x07, 0x01, 0xB0, 0x91, 0x08, 0x01, 0x30, 0x91, 0x04, 0x01,
        0x23, 0xE0, 0x23, 0x0F, 0x2D, 0x37, 0x58, 0xF5, 0x01, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0x20, 0x93,
        0x04, 0x01, 0x80, 0x93, 0x05, 0x01, 0x90, 0x93, 0x06, 0x01, 0xA0, 0x93, 0x07, 0x01, 0xB0, 0x93,
        0x08, 0x01, 0x80, 0x91, 0x00, 0x01, 0x90, 0x91, 0x01, 0x01, 0xA0, 0x91, 0x02, 0x01, 0xB0, 0x91,
        0x03, 0x01, 0x01, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0x80, 0x93, 0x00, 0x01, 0x90, 0x93, 0x01, 0x01,
        0xA0, 0x93, 0x02, 0x01, 0xB0, 0x93, 0x03, 0x01, 0xBF, 0x91, 0xAF, 0x91, 0x9F, 0x91, 0x8F, 0x91,
        0x3F, 0x91, 0x2F, 0x91, 0x0F, 0x90, 0x0F, 0xBE, 0x0F, 0x90, 0x1F, 0x90, 0x18, 0x95, 0x26, 0xE8,
        0x23, 0x0F, 0x02, 0x96, 0xA1, 0x1D, 0xB1, 0x1D, 0xD2, 0xCF, 0x78, 0x94, 0x84, 0xB5, 0x82, 0x60,
        0x84, 0xBD, 0x84, 0xB5, 0x81, 0x60, 0x84, 0xBD, 0x85, 0xB5, 0x82, 0x60, 0x85, 0xBD, 0x85, 0xB5,
        0x81, 0x60, 0x85, 0xBD, 0x80, 0x91, 0x6E, 0x00, 0x81, 0x60, 0x80, 0x93, 0x6E, 0x00, 0x10, 0x92,
        0x81, 0x00, 0x80, 0x91, 0x81, 0x00, 0x82, 0x60, 0x80, 0x93, 0x81, 0x00, 0x80, 0x91, 0x81, 0x00,
        0x81, 0x60, 0x80, 0x93, 0x81, 0x00, 0x80, 0x91, 0x80, 0x00, 0x81, 0x60, 0x80, 0x93, 0x80, 0x00,
        0x80, 0x91, 0xB1, 0x00, 0x84, 0x60, 0x80, 0x93, 0xB1, 0x00, 0x80, 0x91, 0xB0, 0x00, 0x81, 0x60,
        0x80, 0x93, 0xB0, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x84, 0x60, 0x80, 0x93, 0x7A, 0x00, 0x80, 0x91,
        0x7A, 0x00, 0x82, 0x60, 0x80, 0x93, 0x7A, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x81, 0x60, 0x80, 0x93,
        0x7A, 0x00, 0x80, 0x91, 0x7A, 0x00, 0x80, 0x68, 0x80, 0x93, 0x7A, 0x00, 0x10, 0x92, 0xC1, 0x00,
        0x60, 0xE0, 0x85, 0xE0, 0x0E, 0x94, 0xF2, 0x00, 0x60, 0xE0, 0x86, 0xE0, 0x0E, 0x94, 0xF2, 0x00,
        0x60, 0xE0, 0x87, 0xE0, 0x0E, 0x94, 0xF2, 0x00, 0x60, 0xE0, 0x88, 0xE0, 0x0E, 0x94, 0xF2, 0x00,
        0x61, 0xE0, 0x82, 0xE0, 0x0E, 0x94, 0xF2, 0x00, 0x85, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x89, 0x2B,
        0x71, 0xF4, 0x86, 0xE0, 0x0E, 0x94, 0xC9, 0x00, 0x89, 0x2B, 0x49, 0xF4, 0x87, 0xE0, 0x0E, 0x94,
        0xC9, 0x00, 0x89, 0x2B, 0x21, 0xF4, 0x80, 0xE0, 0x0E, 0x94, 0x9E, 0x00, 0xED, 0xCF, 0x81, 0xE0,
        0xFB, 0xCF, 0xF8, 0x94, 0xFF, 0xCF
    };

    public static final List<FlashMemoryHex> IN_0_IN_1_IN_3_OUT_0 = Collections.singletonList(
        new FlashMemoryHex(924, 0x88)
    );

    public static final List<FlashMemoryHex> IN_0_IN_2_IN_3_OUT_0 = Arrays.asList(
        new FlashMemoryHex(914, 0x87),
        new FlashMemoryHex(924, 0x88)
    );

    public static final List<FlashMemoryHex> IN_1_IN_2_IN_3_OUT_0 = Arrays.asList(
        new FlashMemoryHex(904, 0x86),
        new FlashMemoryHex(914, 0x87),
        new FlashMemoryHex(924, 0x88)
    );
}
