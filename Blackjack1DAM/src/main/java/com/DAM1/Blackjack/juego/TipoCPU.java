package com.DAM1.Blackjack.juego;

public enum TipoCPU {
    PASIVO, AGRESIVO;

    public TipoCPU tipoCPU(int valor){
        switch (valor){
            case 0:
                return PASIVO;
            case 1:
                return AGRESIVO;
        }
        return null;
    }

}
