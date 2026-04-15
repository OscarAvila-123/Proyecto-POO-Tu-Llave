# 🚇 Sistema de Transporte "Tu Llave" - Bogotá

![Java](https://img.shields.io/badge/Java-21%2B-blue)
![POO](https://img.shields.io/badge/POO-Abstract%20Classes%20%7C%20Interfaces-green)
![License](https://img.shields.io/badge/License-MIT-yellow)

## 📖 Descripción del Proyecto

Este proyecto simula el sistema de tarjetas inteligentes **"Tu Llave"**, utilizado en la red de transporte público de Bogotá (SITP - Sistema Integrado de Transporte Público). El objetivo es demostrar la aplicación de los principios fundamentales de la **Programación Orientada a Objetos (POO)**:

- **Abstracción**
- **Encapsulamiento**
- **Herencia**
- **Polimorfismo**
- **Interfaces**

El proyecto extiende un taller previo sobre herencia y polimorfismo, incorporando una interfaz (`Beneficio`) que permite agregar comportamientos comunes a clases que no comparten una misma jerarquía de herencia.

---

## 🎯 Objetivos del Taller

| # | Objetivo | Estado |
|---|----------|--------|
| 1 | Convertir la clase `Tarjeta` en **clase abstracta** | ✅ |
| 2 | Crear la interfaz `Beneficio` con métodos para descuentos/subsidios | ✅ |
| 3 | Hacer que `TarjetaPersonalizada` y `TarjetaSubsidio` implementen `Beneficio` | ✅ |
| 4 | Agregar **dos clases externas** (fuera de la jerarquía `Tarjeta`) que implementen `Beneficio` | ✅ |
| 5 | Demostrar el **tratamiento uniforme** de objetos mediante la interfaz | ✅ |

---

## 🏗️ Estructura del Proyecto

---

## 📊 Diagrama de Clases

---

## 💻 Código Destacado

### Clase Abstracta `Tarjeta`

```java
public abstract class Tarjeta {
    private String idTarjeta;
    private double saldo;
    private String usuario;
    
    public abstract void recargar(double monto);
    public abstract boolean pagarViaje();
    
    public void consultarSaldo() {
        System.out.println("Saldo: $" + saldo);
    }
}
=== SISTEMA TU LLAVE - DEMOSTRACIÓN ===

--- Operaciones con Tarjetas ---
Tarjeta: TP1001 | Usuario: Ana Gómez | Saldo: $0.0
Recarga exitosa: +$10000.0
Viaje pagado. Costo original: $2500.0 | Con descuento: $2250.0

--- Servicios externos ---
Uso de bici por 30 min. Costo original: $3000.0 | Con descuento: $2400.0
Estadía de 3 hora(s). Costo original: $6000.0 | Con descuento: $4200.0

--- Beneficios aplicados mediante interfaz ---
TarjetaPersonalizada: $5000 → $4500 (10% descuento)
TarjetaSubsidio:      $5000 → $2500 (50% subsidio)
BiciPublica:          $5000 → $4000 (20% descuento)
ParqueaderoPublico:   $5000 → $3500 (30% descuento)
