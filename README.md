# Proyecto Matriz en Java

<img alt="Java Version" src="https://img.shields.io/badge/Java-17%2B-blue"/>
<img alt="License" src="https://img.shields.io/badge/license-MIT-green"/>

## 📋 Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Principios SOLID Aplicados](#principios-solid-aplicados)
- [Ejemplos](#ejemplos)
- [Pruebas](#pruebas)
- [Contribuir](#contribuir)
- [Licencia](#licencia)
- [Repositorio](#repositorio)

## 📝 Descripción

Este proyecto implementa una clase `Matriz` en Java que proporciona operaciones fundamentales para la manipulación de matrices numéricas. La implementación sigue principios de diseño de software sólidos para garantizar un código mantenible, extensible y robusto.

La clase permite crear matrices, acceder a sus elementos, imprimirlas en consola y realizar operaciones matemáticas como el cálculo de la transpuesta.

## ✨ Características

- **Creación de matrices**: Constructor que valida los datos de entrada
- **Consulta de elementos**: Métodos para obtener dimensiones y elementos específicos
- **Impresión formateada**: Visualización clara de la matriz en consola
- **Operaciones matriciales**: Cálculo de la transpuesta
- **Implementación inmutable**: Para prevenir efectos secundarios
- **Validación robusta**: Control de errores y excepciones
- **Código documentado**: Documentación JavaDoc completa

## 🔧 Requisitos

- Java 8 o superior
- JDK compatible
- Cualquier IDE Java (recomendado: IntelliJ IDEA, Eclipse, NetBeans)

## 📥 Instalación

1. Clona el repositorio:
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   ```

2. Importa el proyecto a tu IDE favorito

3. Compila el proyecto:
   ```bash
   javac Matriz.java MatrizTest.java
   ```

## 🚀 Uso

### Ejemplo básico

```
java
// Crear una matriz 3x3
int[][] datos = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Instanciar la clase Matriz
Matriz matriz = new Matriz(datos);

// Imprimir la matriz
System.out.println("Matriz original:");
matriz.imprimir();

// Calcular y mostrar su transpuesta
System.out.println("\nMatriz transpuesta:");
Matriz transpuesta = matriz.calcularTranspuesta();
transpuesta.imprimir();
```

### Acceso a elementos

```java
Matriz matriz = new Matriz(new int[][]{{1, 2}, {3, 4}});
int filas = matriz.getFilas();      // Retorna 2
int columnas = matriz.getColumnas(); // Retorna 2
int elemento = matriz.getElemento(0, 1); // Retorna 2
```

## 📁 Estructura del Proyecto

```
proyecto-matriz/
├── src/
│   ├── Matriz.java         # Clase principal
│   └── MatrizTest.java     # Clase con ejemplos de uso
├── doc/                    # Documentación JavaDoc
├── README.md              # Este archivo
└── LICENSE                # Licencia del proyecto
```

## 🏗️ Principios SOLID Aplicados

### 1. Principio de Responsabilidad Única (SRP)
**Definición**: Una clase debe tener una única razón para cambiar, lo que significa que debe tener una sola responsabilidad.

**Aplicación**: La clase `Matriz` tiene una única responsabilidad: representar y operar sobre una matriz de números enteros. Todas sus operaciones (creación, impresión, cálculo de transpuesta) están directamente relacionadas con esta responsabilidad.

Ejemplos concretos:
- Los métodos como `imprimir()`, `calcularTranspuesta()` y `getElemento()` están todos relacionados con la responsabilidad principal de la clase.
- Si se necesitaran operaciones más complejas o no relacionadas directamente con la manipulación de matrices (como persistencia, visualización gráfica, etc.), estas deberían estar en clases separadas.

### 2. Principio de Abierto/Cerrado (OCP)
**Definición**: Las entidades de software deben estar abiertas para su extensión, pero cerradas para su modificación.

**Aplicación**: La clase `Matriz` está diseñada para ser extensible sin necesidad de modificar su código existente:

Ejemplos concretos:
- Si queremos añadir nuevas operaciones matemáticas sobre matrices (multiplicación, determinante, etc.), podemos hacerlo extendiendo la clase actual o creando clases complementarias sin modificar el código existente.
- La matriz se instancia con un estado inmutable (se utiliza un arreglo final y se hace una copia defensiva), lo que previene modificaciones accidentales y facilita la extensión segura.

### 3. Principio de Sustitución de Liskov (LSP)
**Definición**: Los objetos de una clase derivada deben poder sustituir a los objetos de la clase base sin afectar la corrección del programa.

**Aplicación**: Aunque en este ejemplo simple no tenemos herencia, la clase `Matriz` está diseñada para ser una buena clase base:

Ejemplos concretos:
- Si creáramos subclases como `MatrizCuadrada` o `MatrizPositiva`, estas deberían poder usarse donde se espera una `Matriz` sin romper la funcionalidad.
- Los métodos están diseñados para trabajar con propiedades generales de las matrices, no con características específicas que podrían no aplicar a subclases.
- La clase utiliza validaciones en el constructor para garantizar que cualquier instancia de `Matriz` cumpla con los invariantes mínimos (no nula, filas de igual longitud).

### 4. Principio de Segregación de Interfaces (ISP)
**Definición**: Los clientes no deben ser forzados a depender de interfaces que no utilizan.

**Aplicación**: Aunque no hemos definido interfaces explícitas, la clase `Matriz` ofrece métodos coherentes y bien definidos:

Ejemplos concretos:
- Los métodos públicos (`getFilas()`, `getColumnas()`, `getElemento()`, etc.) representan operaciones bien definidas que un cliente podría querer utilizar de forma individual.
- Si fuera necesario, podríamos extraer interfaces como `ImprimibleEnConsola` o `OperacionesMatriciales` para clientes que solo necesiten partes específicas de la funcionalidad.

### 5. Principio de Inversión de Dependencias (DIP)
**Definición**: Los módulos de alto nivel no deben depender de módulos de bajo nivel. Ambos deben depender de abstracciones. Además, las abstracciones no deben depender de los detalles, sino los detalles de las abstracciones.

**Aplicación**: En esta implementación simple:

Ejemplos concretos:
- La clase `Matriz` no depende directamente de implementaciones concretas para sus operaciones.
- Si la clase utilizara servicios externos (como para persistencia o cálculos complejos), estos deberían ser inyectados a través de interfaces en lugar de ser instanciados directamente.
- La implementación actual está abierta a futuras mejoras mediante inyección de dependencias para aspectos como estrategias de cálculo o formateo personalizado.

## 📊 Ejemplos

### Crear una matriz e imprimir su transpuesta

```java
public class EjemploMatriz {
    public static void main(String[] args) {
        // Crear una matriz 2x3
        int[][] datos = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        // Instanciar y mostrar la matriz original
        Matriz original = new Matriz(datos);
        System.out.println("Matriz original:");
        original.imprimir();
        
        // Calcular y mostrar la transpuesta (ahora 3x2)
        Matriz transpuesta = original.calcularTranspuesta();
        System.out.println("\nMatriz transpuesta:");
        transpuesta.imprimir();
        
        // Salida esperada:
        // Matriz original:
        // 1 2 3
        // 4 5 6
        //
        // Matriz transpuesta:
        // 1 4
        // 2 5
        // 3 6
    }
}
```

## 🧪 Pruebas

Para ejecutar las pruebas incluidas:

```bash
java MatrizTest
```

Se recomienda crear pruebas unitarias adicionales con JUnit o framework similar para verificar el correcto funcionamiento de todas las operaciones de la clase `Matriz`.

## 🤝 Contribuir

Las contribuciones son bienvenidas. Por favor, sigue estos pasos para contribuir:

1. Haz un fork del repositorio
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`)
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva característica'`)
4. Sube tu rama (`git push origin feature/nueva-caracteristica`)
5. Abre un Pull Request

Asegúrate de seguir las convenciones de codificación y añadir pruebas para cualquier nueva funcionalidad.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## 🔗 Repositorio

El código fuente completo está disponible en:

[URL_DEL_REPOSITORIO](https://github.com/pabloloz23/matrices)

---


¿Encontraste un error o tienes una sugerencia? Abre un issue en el repositorio.