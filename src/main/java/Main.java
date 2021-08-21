import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.flush();

		String mensaje = "\nPlease use the -i argument followed by a space and the path of the file to read\n\nUse -n to filter by number of lines";

		if (args.length == 2 || args.length == 4) {

			if (args[0].equals("-i")) {

				File archivo = new File(args[1]);

				if (archivo.exists()) {

					String texto = "";

					FileReader flE = null;

					BufferedReader fE = null;

					try {

						flE = new FileReader(args[1]);

						fE = new BufferedReader(flE);

						texto = fE.readLine();

						int indice = 0;

						int contar = 0;

						if (args.length == 4) {

							contar = Integer.parseInt(args[3]);

						}

						while (texto != null) {

							if (contar == 0 || indice < contar) {

								System.out.println(texto);

								texto = fE.readLine();

								indice++;

							}

							else {

								texto = null;

							}

						}

						fE.close();

						flE.close();

					}

					catch (Exception e) {
						//
					}

					finally {

						if (fE != null) {

							try {

								fE.close();

							}

							catch (IOException e) {
								//
							}

						}

						if (flE != null) {

							try {

								flE.close();

							}

							catch (IOException e) {
								//
							}

						}

					}

				}

				else {

					throw new IOException();

				}

			}

			else {

				System.out.println(mensaje);

			}

		}

		else {

			System.out.println(mensaje);

		}

	}

}
