/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.session2b;

/**
 *
 * @author Leonardo Chavez
 */
public class Empleado {
    public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
        float base = (tipo == TipoEmpleado.VENDEDOR) ? 2000f : 2500f;

        float prima = 0f;
        if (ventasMes >= 1500f) {
            prima = 200f;
        } else if (ventasMes >= 1000f) {
            prima = 100f;
        }

        float extras = horasExtra * 30f;
        return base + prima + extras;
    }

    public float calculoNominaNeta(float nominaBruta) {
        float ret = 0f;
        if (nominaBruta >= 2500f) {
            ret = 0.18f;
        } else if (nominaBruta >= 2100f) {
            ret = 0.15f;
        }
        return nominaBruta * (1f - ret);
    }

}
