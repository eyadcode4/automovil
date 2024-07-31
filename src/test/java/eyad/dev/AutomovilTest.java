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
        automovil.acelerar(50);
        assertEquals(50, automovil.getVelocidadActual());

        automovil.acelerar(150);
        assertEquals(180, automovil.getVelocidadActual());
        assertTrue(automovil.tieneMultas());
    }

    @Test
    public void testDesacelerar() {
        automovil.acelerar(100);
        automovil.desacelerar(30);
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
        automovil.acelerar(60);
        assertEquals(1.0, automovil.calcularTiempoLlegada(60));

        automovil.frenar();
        assertEquals(-1, automovil.calcularTiempoLlegada(60));
    }

    @Test
    public void testMultas() {
        automovil.acelerar(200);
        assertEquals(1, automovil.multas);
        assertEquals(100, automovil.calcularTotalMultas());
    }

    @Test
    public void testGettersAndSetters() {
        automovil.setMarca("ferrari");
        assertEquals("ferrari", automovil.getMarca());

        automovil.setModelo(1900);
        assertEquals(1900, automovil.getModelo());

        automovil.setMotor(1800);
        assertEquals(1800, automovil.getMotor());

        automovil.setTipoCombustible(Automovil.tipoCom.Diesel);
        assertEquals(Automovil.tipoCom.Diesel, automovil.getTipoCombustible());

        automovil.setTipoAutomovil(Automovil.tipoA.Compacto);
        assertEquals(Automovil.tipoA.Compacto, automovil.getTipoAutomovil());

        automovil.setNumeroPuertas(4);
        assertEquals(4, automovil.getNumeroPuertas());

        automovil.setCantidadAsientos(5);
        assertEquals(5, automovil.getCantidadAsientos());

        automovil.setVelocidadMaxima(180);
        assertEquals(180, automovil.getVelocidadMaxima());

        automovil.setColor(Automovil.tipoColor.Rojo);
        assertEquals(Automovil.tipoColor.Rojo, automovil.getColor());

        automovil.setVelocidadActual(130);
        assertEquals(130, automovil.getVelocidadActual());

        automovil.setAutomatico(false);
        assertFalse(automovil.isAutomatico());
    }
}