package eyad.dev;

public class Automovil {
    String marca;
    int modelo;
    int motor;
    enum tipoCom{Gasolina, Bioetanol, Diesel, Biodiesel, Gasnatural}
    tipoCom tipoCombustible;
    enum tipoA {Cuidad, Subcompacto, Compacto, Familiar, Ejecutivo, SUV}
    tipoA tipoAutomovil;
    int numeroPuertas;
    int cantidadAsientos;
    int velocidadMaxima;
    enum tipoColor {Blanco, Negro, Rojo, Naranja, Amarillo, Verde, Azul, Violeta}
    tipoColor color;
    int velocidadActual = 0;
    boolean automatico;
    int multas = 0;
    final int VALOR_MULTA = 100;

    public Automovil(String marca, int modelo, int motor, tipoCom tipoCombustible, tipoA tipoAutomovil,
                     int numeroPuertas, int cantidadAsientos, int velocidadMaxima, tipoColor color, boolean automatico) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.tipoCombustible = tipoCombustible;
        this.tipoAutomovil = tipoAutomovil;
        this.numeroPuertas = numeroPuertas;
        this.cantidadAsientos = cantidadAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.color = color;
        this.automatico = automatico;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getModelo() {
        return modelo;
    }
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
    public int getMotor() {
        return motor;
    }
    public void setMotor(int motor) {
        this.motor = motor;
    }
    public tipoCom getTipoCombustible() {
        return tipoCombustible;
    }
    public void setTipoCombustible(tipoCom tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    public tipoA getTipoAutomovil() {
        return tipoAutomovil;
    }
    public void setTipoAutomovil(tipoA tipoAutomovil) {
        this.tipoAutomovil = tipoAutomovil;
    }
    public int getNumeroPuertas() {
        return numeroPuertas;
    }
    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
    public int getCantidadAsientos() {
        return cantidadAsientos;
    }
    public void setCantidadAsientos(int cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    public tipoColor getColor() {
        return color;
    }
    public void setColor(tipoColor color) {
        this.color = color;
    }
    public int getVelocidadActual() {
        return velocidadActual;
    }
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }
    public boolean isAutomatico() {
        return automatico;
    }
    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    public void acelerar(int incrementoVelocidad) {
        if (velocidadActual + incrementoVelocidad <= velocidadMaxima) {
            velocidadActual += incrementoVelocidad;
        } else {
            System.out.println("si pasa la velocidad maxima del automovil se genera una multa.");
            velocidadActual = velocidadMaxima;
            multas++;
        }
    }

    public void desacelerar(int decrementoVelocidad) {
        if (velocidadActual - decrementoVelocidad >= 0) {
            velocidadActual -= decrementoVelocidad;
        } else {
            System.out.println("no se puede ir a velocidad inferior a 0");
            velocidadActual = 0;
        }
    }

    public void frenar() {
        velocidadActual = 0;
    }

    public double calcularTiempoLlegada(int distancia) {
        if (velocidadActual > 0) {
            return (double) distancia / velocidadActual;
        } else {
            System.out.println("El automovil esta parado no se puede calcular el tiempo de la llegada.");
            return -1;
        }
    }

    public boolean tieneMultas() {
        return multas > 0;
    }

    public int calcularTotalMultas() {
        return multas * VALOR_MULTA;
    }

    void imprimir() {
        System.out.println("Marca = " + marca);
        System.out.println("Modelo = " + modelo);
        System.out.println("Motor = " + motor);
        System.out.println("Tipo de combustible = " + tipoCombustible);
        System.out.println("Tipo de automóvil = " + tipoAutomovil);
        System.out.println("Número de puertas = " + numeroPuertas);
        System.out.println("Cantidad de asientos = " + cantidadAsientos);
        System.out.println("Velocidad máxima = " + velocidadMaxima);
        System.out.println("Color = " + color);
        System.out.println("Velocidad actual = " + velocidadActual);
        System.out.println("Automático = " + (automatico ? "Sí" : "No"));
        System.out.println("Multas = " + multas);
    }
    
}
