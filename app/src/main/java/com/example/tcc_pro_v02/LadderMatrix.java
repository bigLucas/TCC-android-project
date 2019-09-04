package com.example.tcc_pro_v02;

public class LadderMatrix {
    private int [] ladderMatrix =  new int [36];
    private int selectorPosi;

    public LadderMatrix() {
        // Maxima posição para seletor é 36, quando ele etá em 37, significa que é null
        selectorPosi = 37;
    }

    /**
     * Esse metodo cuida do set do seletor em uma posição da ladderMatrix,
     * que é a matriz de diagrama ladder, sempre que o seletor muda de posição, essa posição nova
     * é gaurdada aqui.
     * @param selectorCord é a posição do seletor no array list
     * */
    public void setSelectorPosi(int selectorCord) {
        this.selectorPosi = selectorCord;
    }
    public int getSelectorPosi() {
        return this.selectorPosi;
    }

    public void setStateAtPosiInLadderMatrix(int posi, int status) {
        // Adicionar verificaçẽos para evitar erros
        // proteção contra indices maiores que os limites da matriz
        // proteção contra status errados
        this.ladderMatrix[posi] = status;
    }

    public int getStateAtPosiInLadderMatrix(int posi) {
        return ladderMatrix[posi];
    }
}
