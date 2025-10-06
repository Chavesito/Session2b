package com.mycompany.session2b;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Leonardo Chavez
 */
public class EmpleadoTest {
    private static final float EPS = 0.001f;
    private final Empleado emp = new Empleado();

    // --- Bruta: límites de ventas para VENDEDOR (base 2000) ---
    @Test void bruta_vendedor_999_sin_prima() {
        assertEquals(2000f, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 999f, 0f), EPS);
    }
    @Test void bruta_vendedor_1000_prima100() {
        assertEquals(2100f, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1000f, 0f), EPS);
    }
    @Test void bruta_vendedor_1499_prima100() {
        assertEquals(2100f, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1499f, 0f), EPS);
    }
    @Test void bruta_vendedor_1500_prima200() {
        assertEquals(2200f, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1500f, 0f), EPS);
    }

    // --- Bruta: límites de ventas para ENCARGADO (base 2500) ---
    @Test void bruta_encargado_999_sin_prima() {
        assertEquals(2500f, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 999f, 0f), EPS);
    }
    @Test void bruta_encargado_1000_prima100() {
        assertEquals(2600f, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1000f, 0f), EPS);
    }
    @Test void bruta_encargado_1499_prima100_y_1horaExtra() {
        assertEquals(2630f, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1499f, 1f), EPS); 
    }
    @Test void bruta_encargado_1500_prima200() {
        assertEquals(2700f, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1500f, 0f), EPS);
    }

    // --- Neta: límites de retención ---
    @Test void neta_2099_sin_retencion() {
        assertEquals(2099f, emp.calculoNominaNeta(2099f), EPS);
    }
    @Test void neta_2100_retencion_15() {
        assertEquals(1785f, emp.calculoNominaNeta(2100f), EPS); 
    }
    @Test void neta_2499_retencion_15() {
        assertEquals(2124.15f, emp.calculoNominaNeta(2499f), EPS); 
    }
    @Test void neta_2500_retencion_18() {
        assertEquals(2050f, emp.calculoNominaNeta(2500f), EPS);
    }
}
