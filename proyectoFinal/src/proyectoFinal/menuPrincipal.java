package proyectoFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import javax.script.ScriptException;

public class menuPrincipal {
	static int puntosRapido = 0;//esto cambiarlo
	static ArrayList<jugadores> jugadores = new ArrayList();

	public static void main(String[] args) throws ScriptException {

		menuPrincipal();

	}

	public static void menuPrincipal() throws ScriptException {

		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Hola, que deseas hacer?");
		System.out.println("-------------------------");
		System.out.println("|-----1-JUGAR PARTIDA---|");
		System.out.println("|-----2-RANKIGN---------|");
		System.out.println("|-----3-HISTÓRICO-------|");
		System.out.println("|-----4-JUGADORES-------|");
		System.out.println("|-----5-SALIR-----------|");
		System.out.println("-------------------------");

		int respuesta = teclado.nextInt();
		switch (respuesta) {
		case 1:
			jugarPartida(jugadores);
			break;
		case 2:
			ranking();
			break;
		case 3:
			historico();
			break;
		case 4:
			jugadores(jugadores);
			break;
		case 5:
			salir();
			break;
		default:
			System.out.println("No has elegido la opcion correcta, prueba otra vez");
			menuPrincipal();
			break;
		}

	}

	public static void menuPartida() throws ScriptException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Que nivel quieres jugar?");
		System.out.println("-------------------------");
		System.out.println("|-----1-PARTIDA RAPIDA---|");
		System.out.println("|-----2-PARTIDA CORTA----|");
		System.out.println("|-----3-PARTIDA NORMAL---|");
		System.out.println("|-----4-PARTIDA LARGA----|");
		System.out.println("|-----5-VOLVER-----------|");
		System.out.println("-------------------------");

		int respuesta = teclado.nextInt();
		switch (respuesta) {
		case 1:
			partidaRapida();
			break;
		case 2:
			partidaCorta();
			break;
		case 3:
			partidaNormal();
			break;
		case 4:
			partidaLarga();
			break;
		case 5:
			menuPrincipal();
			break;
		default:
			System.out.println("No has elegido la opcion correcta, prueba otra vez");
			menuPartida();
			break;
		}

	}

	public static void jugarPartida(ArrayList<jugadores> jugadores) throws ScriptException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Que quieres hacer: Practica o Jugar");
		String respuesta = teclado.nextLine().toLowerCase();
		if (respuesta.equals("practica")) {

			menuPartida();
		} else {

			System.out.println("Lista de jugadores:");
			if (jugadores.size() == 0) {
				System.out.println("Lo siento no tienes jugadores todavia ");
				menuJugadores(jugadores);
			} else {

				for (int i = 0; i < jugadores.size(); i++) {
					System.out.println(jugadores.get(i).getNombre());
				}

			}
			menuPartida();
		}

	}

	public static void generarPreguntas() throws ScriptException {
		double random = Math.random();
		if (random < 0.33) {
			preguntasLetras();
		} else if (random < 0.67) {
			preguntaIngles();
		} else {
			preguntasMates();
		}

	}

	public static void partidaRapida() throws ScriptException {

		
		

		

	}

	public static void partidaCorta() {
		System.out.println("Aqui ira la partida corta");
	}

	public static void partidaNormal() {
		System.out.println("Aqui ira la partida normal");
	}

	public static void partidaLarga() {
		System.out.println("Aqui ira la partida larga");
	}

	public static void ranking() {
		System.out.println("Aqui se va a poder ver el rankig");

	}

	public static void historico() {
		System.out.println("Aqui se va a ver el historico");

	}

	public static void preguntasMates() throws ScriptException {

		//Generar numeros aleatorios entre 2 y 12 con un rango de 4 a 8
		Random random = new Random();
		int longitud = random.nextInt(5) + 4; // número aleatorio entre 4 y 8, lo que hace es general un numero aleatorio entre 0 y 4 y le suma 4 
		ArrayList<Integer> numeros = new ArrayList<>();

		for (int i = 0; i < longitud; i++) {
		    int numero = random.nextInt(11) + 2; // número aleatorio entre 2 y 12
		    numeros.add(numero);
		}
	
		/*for (int i = 0; i < numeros.size(); i++) {
			System.out.println(numeros.get(i));
		}*/
		
		ArrayList<String> operandos = new ArrayList<>();
		
		//Ahora genero los simbolos de +,- o *
		for (int i = 0; i < longitud - 1; i++) { //longitud -1 porque los operandos tienen que ser 1 menos que los numeros
		    int operandoAleatorio = random.nextInt(3);// genero 3 numeros aleatorios 
		    if (operandoAleatorio == 0) {
		        operandos.add("+");
		    } else if (operandoAleatorio == 1) {
		        operandos.add("-");
		    } else {
		        operandos.add("*");
		    }
		}
	/*	for (int i = 0; i < operandos.size(); i++) {
			System.out.println(operandos.get(i));
		}*/
		ArrayList<String> expresion = new ArrayList<>();
		expresion.add(String.valueOf(random.nextInt(11) + 2)); // genero un primer numero entre 2 y 12 y lo agrego al ArrayList

		// Agregar los operandos y los números restantes a la expresión
		for (int i = 1; i < longitud; i++) {
		    int operandoAleatorio = random.nextInt(3);//genero operando aleatorio
		    int numeroAleatorio = random.nextInt(11) + 2;//genero numero aleatorio
		    if (operandoAleatorio == 0) {
		        expresion.add("+");
		        expresion.add(String.valueOf(numeroAleatorio));
		    } else if (operandoAleatorio == 1) {
		        expresion.add("-");
		        expresion.add(String.valueOf(numeroAleatorio));
		    } else {
		        expresion.add("*");
		        expresion.add(String.valueOf(numeroAleatorio));
		    }
		}

		
		System.out.print("La expresion es: ");

		for (int i = 0; i < expresion.size(); i++) {
			System.out.print(expresion.get(i));
		}
		System.out.println();

		if (expresion.contains("*")) {
            // Realizar primero las multiplicaciones
            for (int i = 0; i < expresion.size(); i++) {
                if (expresion.get(i).equals("*")) {
                    int num1 = Integer.parseInt(expresion.get(i-1));
                    int num2 = Integer.parseInt(expresion.get(i+1));
                    int resultado = num1 * num2;
                    expresion.set(i-1, String.valueOf(resultado)); // reemplazar el primer número por el resultado
                    expresion.remove(i); // eliminar el operando de multiplicación
                    expresion.remove(i); // eliminar el segundo número
                    i -= 2; // ajustar el índice
                }
            }
        }if (expresion.contains("+") || expresion.contains("-")) {
            // Realizar las sumas y restas
            int resultado = Integer.parseInt(expresion.get(0)); // resultado empieza en el primer número
            String operacion = ""; // la operación actual
            for (int i = 1; i < expresion.size(); i++) {
                if (i % 2 == 1) { // si el índice es impar, es un operando
                    operacion = expresion.get(i);
                } else { // si el índice es par, es un número
                    int numero = Integer.parseInt(expresion.get(i));
                    if (operacion.equals("+")) {
                        resultado += numero;
                    } else { // si la operación es "-", resta el número
                        resultado -= numero;
                    }
                }
            }
            System.out.println("El resultado es: " + resultado);
        } else { // si la expresión sólo contiene un número lo muestro
        
            System.out.println("El resultado es: " + expresion.get(0));
        }
		

    }


	public static void preguntasLetras() throws ScriptException {
		Scanner teclado = new Scanner(System.in);
		ArrayList<String> palabras = new ArrayList<>();

		try (FileReader fr = new FileReader("src/proyectoFinal/diccionario.txt");
				BufferedReader br = new BufferedReader(fr)) {
			String linea;
			while ((linea = br.readLine()) != null) {

				palabras.add(linea);
			}
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}

		Random rand = new Random();
		String palabraAleatoria = palabras.get(rand.nextInt(palabras.size()));

		System.out.println("La palabra aleatoria es: " + palabraAleatoria);

		int longitudPalabra = palabraAleatoria.length();
		int division = longitudPalabra / 3;
		int index = 0;

		char[] auxPalabra = new char[longitudPalabra + division];

		for (int i = 0; i < longitudPalabra; i++) {
			if ((i + 1) % 3 == 0) {
				auxPalabra[i] = '*';
			} else {
				auxPalabra[i] = palabraAleatoria.charAt(i);
			}
		}

		String adivina = new String(auxPalabra);
		String respuesta;
		System.out.println("La palabra es: " + adivina);
		System.out.println("¿Cual crees que es la respuesta: ?");
		respuesta = teclado.nextLine();

		if (respuesta.equals(palabraAleatoria)) {
			System.out.println("Felicidades has optenido un punto");
			puntosRapido++;
			menuPartida();
		} else {
			System.out.println("La palabra correcta era: " + palabraAleatoria);
			menuPartida();
		}

	}
	
	  

	public static void preguntaIngles() throws ScriptException {
		Scanner teclado = new Scanner(System.in);
		ArrayList<String> opciones = new ArrayList<>();
		ArrayList<String> opciones2 = new ArrayList<>();

		try (FileReader fr = new FileReader("src/proyectoFinal/ingles.txt");
				BufferedReader br = new BufferedReader(fr)) {
			int numPreguntas = 5000 / 5; // número de preguntas en el archivo
			int preguntaAleatoria = (int) (Math.random() * numPreguntas) + 1; // seleccionar una pregunta aleatoria
			int primeraLinea = (preguntaAleatoria - 1) * 5 + 1; // calcular la línea de la primera pregunta

			// Leer la pregunta
			String pregunta = null;
			for (int i = 1; i < primeraLinea; i++) {
				br.readLine(); // Saltar las líneas anteriores a la pregunta
			}
			pregunta = br.readLine();
			System.out.println(pregunta);

			// Leer las opciones
			for (int i = 0; i < 4; i++) {
				String opcion = br.readLine();
				opciones.add(opcion);
				System.out.println(opcion);
				opciones2 = opciones;
			}

			opciones2.subList(1, opciones2.size()).clear(); // eliminar todas las posiciones excepto la primera
			String respuestaVerdadera = opciones2.get(0).toLowerCase();

			Set desordenado = new HashSet();
			for (int i = 0; i < opciones.size(); i++) {
				desordenado.add(opciones.get(i));
			}
			System.out.println("*************");
			System.out.println(desordenado);

			System.out.println("Dame tu respuesta: ");
			String respuesta = teclado.nextLine().toLowerCase();

			if (respuesta.equals(respuestaVerdadera)) {
				System.out.println("Felicidades, has ganado un punto");
				puntosRapido++;
			} else {
				System.out.println("Error la respuesta correcta era: " + respuestaVerdadera.toUpperCase());
			}

		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}

		menuPartida();
	}

	public static void jugadores(ArrayList<jugadores> jugadores) throws ScriptException {
		Scanner teclado = new Scanner(System.in);

		System.out.println("¿Hola, que deseas hacer?");
		System.out.println("----------------------------");
		System.out.println("|-------VER JUGADORES------|");
		System.out.println("|-------AÑADIR JUGADORES---|");
		System.out.println("|-------ELIMINAR JUGADORES-|");
		System.out.println("|-------VOLVER-------------|");
		System.out.println("---------------------------");
		String respuesta = teclado.nextLine().toUpperCase();

		switch (respuesta) {
		case "VER JUGADORES":
			verJugadores(jugadores);
			break;
		case "AÑADIR JUGADORES":
			addJugadores(jugadores);
			break;
		case "ELIMINAR JUGADORES":
			System.out.println("Que jugador quieres eliminar ");
			String jugador = teclado.next();
			eliminarJugadores(jugadores, jugador);
			break;
		case "VOLVER":

			break;
		default:
			System.out.println("No has elegido la opcion correcta, prueba otra vez");
			menuJugadores(jugadores);

			break;
		}

	}

	public static void salir() {
		System.out.println("Se procede a salir del programa y liberar la RAM ");
		try {
			Thread.sleep(2000);// aqui le pongo un retraso de 2 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Gracias por jugar :) ");
		System.exit(0);// con esta opcion permito terminar el programa y liberar la ram

	}

	public static void menuJugadores(ArrayList<jugadores> jugadores) throws ScriptException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Vale ahora que deseas hacer?");
		System.out.println("----------------------------");
		System.out.println("|-------VER JUGADORES------|");
		System.out.println("|-------AÑADIR JUGADORES---|");
		System.out.println("|-------ELIMINAR JUGADORES-|");
		System.out.println("|-------VOLVER-------------|");
		System.out.println("---------------------------");
		String respuesta = teclado.nextLine().toUpperCase();

		switch (respuesta) {
		case "VER JUGADORES":
			verJugadores(jugadores);
			break;
		case "AÑADIR JUGADORES":
			addJugadores(jugadores);
			break;
		case "ELIMINAR JUGADORES":
			System.out.println("Que jugador quieres eliminar ");
			String jugador = teclado.next();
			eliminarJugadores(jugadores, jugador);
			break;
		case "VOLVER":
			menuPrincipal();

			break;
		default:
			System.out.println("No has elegido la opcion correcta, prueba otra vez");
			menuJugadores(jugadores);

			break;
		}
	}

	public static void addJugadores(ArrayList<jugadores> jugadores) throws ScriptException {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Qué quieres añadir, jugadores humano o jugadores CPU?");
		String respuesta2 = teclado.nextLine().toLowerCase();
		if (respuesta2.equals("humano")) {
			System.out.println("¿Cuántos jugadores deseas agregar?");
			int numJugadores = teclado.nextInt();
			teclado.nextLine();
			for (int i = 0; i < numJugadores; i++) {
				System.out.println("Ingrese el nombre del jugador " + (i + 1) + ":");
				String nombre = teclado.nextLine();
				jugadores jugador = new jugadores(nombre);
				jugadores.add(jugador);
			}
			System.out.println("Se han agregado " + numJugadores + " jugadores humanos.");
			menuJugadores(jugadores);
		} else if (respuesta2.equals("cpu")) {
			System.out.println("¿Cuántas CPUs quieres añadir?");
			int numCpus = teclado.nextInt();
			for (int i = 0; i < numCpus; i++) {
				String nombre = "CPU " + (i + 1);
				jugadores cpu = new Cpu(nombre);
				jugadores.add(cpu);
			}
			System.out.println("Se han agregado " + numCpus + " CPUs.");
			menuJugadores(jugadores);

		}
	}

	public static void verJugadores(ArrayList<jugadores> jugadores) throws ScriptException {
		if (jugadores.size() == 0) {
			System.out.println("No tienes jugadores");
		} else {

			for (int i = 0; i < jugadores.size(); i++) {
				jugadores.get(i).mostrarDatos();
			}
		}
		menuJugadores(jugadores);

	}

	public static void eliminarJugadores(ArrayList<jugadores> jugadores, String jugador) throws ScriptException {
		Scanner teclado = new Scanner(System.in);
		boolean jugadorEliminado = false;
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getNombre().equalsIgnoreCase(jugador)) {
				jugadores.remove(i);
				System.out.println("Se ha eliminado el jugador " + jugador);
				jugadorEliminado = true;
				break;
			}
		}
		if (!jugadorEliminado) {
			System.out.println("No se ha encontrado al jugador " + jugador);
		}
		menuJugadores(jugadores);

	}

}
