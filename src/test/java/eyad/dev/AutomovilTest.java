package eyad.dev;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutomovilTest {
    private Automovil automovil;

    @BeforeEach
    public void setUp() {
        automovil = new Automovil("Fiat", 1975, 2000, Automovil.tipoCom.Gasolina, Automovil.tipoA.SUV, 
                                  4, 5, 180, Automovil.tipoColor.Negro, true);
    }

    @Test
    public void testAcelerar() {
        automovil.acelerar(40);
        assertEquals(40, automovil.getVelocidadActual());

        automovil.acelerar(150);
        assertEquals(180, automovil.getVelocidadActual());
        assertTrue(automovil.tieneMultas());
    }

    @Test
    public void testDesacelerar() {
        automovil.acelerar(110);
        automovil.desacelerar(40);
        assertEquals(70, automovil.getVelocidadActual());

        automovil.desacelerar(80);
        assertEquals(0, automovil.getVelocidadActual());
    }

    @Test
    public void testFrenar() {
        automovil.acelerar(100);
        automovil.frenar();
        assertEquals(0, automovil.getVelocidadActual());
    }

    @Test
    public void testCalcularTiempoLlegada() {
        automovil.acelerar(70);
        assertEquals(1.0, automovil.calcularTiempoLlegada(70));

        automovil.frenar();
        assertEquals(-1, automovil.calcularTiempoLlegada(60));
    }

    @Test
    public void testMultas() {
        automovil.acelerar(220);
        assertEquals(1, automovil.multas);
        assertEquals(100, automovil.calcularTotalMultas());
    }

}