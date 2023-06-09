public class Procesos {

    private static String[] nombres = new String[100];
    private static int[] edades = new int[100];
    private static int numeroEstudiantes = 0;

    public static void main(String[] args) {
        int opcion = 0;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    imprimirListaEstudiantes();
                    break;
                case 3:
                    calcularPromedioEdades();
                    break;
                case 4:
                    encontrarEstudiantesMayorEdad();
                    break;
                case 5:
                    encontrarEstudiantesMenorEdad();
                    break;
                case 6:
                    contarEstudiantesMayoresEdad();
                    break;
                case 7:
                    buscarEstudiantePorNombre();
                    break;
                case 8:
                    buscarEstudiantesPorEdad();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Adiós!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 9);
    }

    private static int mostrarMenu() {
        String menu = "Seleccione una opción:\n\n"
                + "1. Agregar estudiante\n"
                + "2. Imprimir lista de estudiantes\n"
                + "3. Calcular promedio de edades\n"
                + "4. Encontrar estudiantes de mayor edad\n"
                + "5. Encontrar estudiantes de menor edad\n"
                + "6. Contar estudiantes mayores de edad\n"
                + "7. Buscar estudiante por nombre\n"
                + "8. Buscar estudiantes por edad\n"
                + "9. Salir";
        String opcion = JOptionPane.showInputDialog(null, menu);
        return Integer.parseInt(opcion);
    }

    private static void agregarEstudiante() {
        String nombre = JOptionPane.showInputDialog(null, "Nombre del estudiante:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad del estudiante:"));
        nombres[numeroEstudiantes] = nombre;
        edades[numeroEstudiantes] = edad;
        numeroEstudiantes++;
    }

    private static void imprimirListaEstudiantes() {
        String lista = "Lista de estudiantes:\n\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            lista += nombres[i] + " - " + edades[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    private static void calcularPromedioEdades() {
        int sumaEdades = 0;
        for (int i = 0; i < numeroEstudiantes; i++) {
            sumaEdades += edades[i];
        }
        double promedio = (double) sumaEdades / numeroEstudiantes;
        JOptionPane.showMessageDialog(null, "El promedio de edades es: " + promedio);
    }

    private static void encontrarEstudiantesMayorEdad() {
        int maxEdad = Integer.MIN_VALUE;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] > maxEdad) {
                maxEdad = edades[i];
            }
        }
        String estudiantes = "Estudiantes de mayor edad:\n\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] == maxEdad) {
                estudiantes += nombres[i] + " - " + edades[i            ] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }

    private static void encontrarEstudiantesMenorEdad() {
        int minEdad = Integer.MAX_VALUE;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] < minEdad) {
                minEdad = edades[i];
            }
        }
        String estudiantes = "Estudiantes de menor edad:\n\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] == minEdad) {
                estudiantes += nombres[i] + " - " + edades[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }

    private static void contarEstudiantesMayoresEdad() {
        int contador = 0;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] >= 18) {
                contador++;
            }
        }
        JOptionPane.showMessageDialog(null, "Hay " + contador + " estudiantes mayores de edad.");
    }

    private static void buscarEstudiantePorNombre() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante a buscar:");
        int indice = -1;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún estudiante con ese nombre.");
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante encontrado es: " + nombres[indice] + " - " + edades[indice]);
        }
    }

    private static void buscarEstudiantesPorEdad() {
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad de los estudiantes a buscar:"));
        String estudiantes = "Estudiantes con edad " + edad + ":\n\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (edades[i] == edad) {
                estudiantes += nombres[i] + " - " + edades[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, estudiantes);
    }
}