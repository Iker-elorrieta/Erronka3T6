package Controlador;

public class Array {
	/**
	 * Enseña el array
	 * @param arraya el array que quieres enseñar
	 */
	public static void erakutsi (String [] arraya) {
		for (int i=0;i<arraya.length;i++) {
			System.out.println(arraya[i]);
		}
	}
	/**
	 * Enseña el array
	 * @param arraya el array que quieres enseñar
	 */
	public static void erakutsi (int [] arraya) {
		for (int i=0;i<arraya.length;i++) {
			System.out.println(arraya[i]);
		}
	}
	/**
	 * Enseña la matriz
	 * @param arraya la matriz que quieres enseñar
	 */
	public static void erakutsi (String [][] arraya) {
		for (int i = 0; i<arraya.length;i++) {
			for (int j = 0;j<arraya[0].length;j++){
				System.out.print(arraya [i][j] + " ");
			}
			System.out.println("");
		}
	}
	/**
	 * Enseña la matriz
	 * @param arraya la matriz que quieres enseñar
	 */
	public static void erakutsi (int [][] arraya) {
		for (int i = 0; i<arraya.length;i++) {
			for (int j = 0;j<arraya[0].length;j++){
				System.out.print(arraya [i][j] + " ");
			}
			System.out.println("");
		}
	}
	/**
	 * Llena el array con numeros random
	 * @param arraya el array que quieres llenar
	 * @return el array con los numeros random
	 */
	public static int[] bete (int[] arraya){
        for(int i = 0; i < arraya.length; i++){
            arraya[i] = (int) Math.floor(Math.random()*10+1);
        }
        return arraya;
	}
	/**
	 * Ordena el array utilizando el metodo de la burbuja de menor a mayor
	 * @param ar el array a ordenar
	 * @return el array ordenado
	 */
	public static int [] burbujaMin (int [] ar) {
		for (int i=0;i<ar.length-1;i++) {
			for (int j=0;j<ar.length-i-1;j++) {
				if (ar[j]>ar[j+1]) {
					int tmp = 0;
					tmp = ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=tmp;
				}
			}
		}
		return ar;	
	}
	/**
	 * Ordena el array utilizando el metodo de la burbuja de mayor a menor
	 * @param ar el array a ordenar
	 * @return el array ordenado
	 */
	public static int [] burbujaMax (int [] ar) {
		for (int i=0;i<ar.length-1;i++) {
			for (int j=0;j<ar.length-i-1;j++) {
				if (ar[j]<ar[j+1]) {
					int tmp = 0;
					tmp = ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=tmp;
				}
			}
		}
		return ar;
	}
	/**
	 * Ordena el array utilizando el metodo seleccion de menor a mayor
	 * @param ar el array a ordenar
	 * @return el array ordenado
	 */
	public static int [] seleccionMin (int [] ar) {
		int min = 0;
		int kont = 1;
		int pos = 0;
		for (int i=0;i<ar.length-1;i++) {
			for (int j=i;j<ar.length;j++) {
				if (kont == 1) {
					min = ar[j];
					kont++;
				}
				if (ar[j]<=min) {
					min = ar[j];
					pos = j;
				}
			}
			int tmp = 0;
			tmp = ar[i];
			ar[i] = min;
			ar[pos] = tmp;
			kont = 1;
			pos = 0;	
		}
		return ar;
	}
	/**
	 * Ordena el array utilizando el metodo seleccion de mayor a menor
	 * @param ar el array a ordenar
	 * @return el array ordenado
	 */
	public static int [] seleccionMax (int [] ar) {
		int max = 0;
		int kont = 1;
		int pos = 0;
		for (int i=0;i<ar.length-1;i++) {
			for (int j=i;j<ar.length;j++) {
				if (kont == 1) {
					max = ar[j];
					kont++;
				}
				if (ar[j]>=max) {
					max = ar[j];
					pos = j;
				}
			}
			int tmp = 0;
			tmp = ar[i];
			ar[i] = max;
			ar[pos] = tmp;
			kont = 1;
			pos = 0;	
		}
		return ar;
	}
	/**
	 * Cuantas veces hay un valor en el array
	 * @param array el array
	 * @param zenbaki el numero que queremos buscar
	 * @return el numero de veces que esta el numero en el array
	 */
	public static int zenbat(int[] array, int zenbaki) {
		int kont = 0;
		int z = array.length-1;
		do {
			if (array[z] == zenbaki) {
				kont++;
			}
			z--;
		}
		while (z > 0);
		return kont;
	}
	/**
	 * Da la buelta a la matriz convirtiendo las columas en filas y las filas en columnas
	 * @param ar1 el array al que quieres dar la buelta
	 * @param ar2 el array vacio resultado
	 * @return el array ya invertido
	 */
	public static int [][]irauli (int [][] ar1, int [][] ar2) {
		for (int i = 0;i<ar1.length;i++) {
			for (int j = 0;j<ar1[0].length;j++) {
				ar1 [i][j] = ar2 [j][i];
			}
		}
		return ar2;
	}
	/**
	 * Mete un valor en la primera posicion libre del array
	 * @param array1 el array para meter el valor
	 * @param zenbaki el numero que queremos meter
	 * @return la posicion del array vacia (si esta lleno -1)
	 */
	public static int sartu (int [] array1, int zenbaki) {
		boolean aurkituta = false;
		boolean errepikatuta = false;
		int i = -1;
		while (i<array1.length-1 && !aurkituta) {
			i++;
			if (array1[i]==0) {
				aurkituta = true;
			}
			if (array1[i]==zenbaki) {
				errepikatuta = true;
			}
		}
		if (!aurkituta || errepikatuta) {
			i = -1;
		}
		return i;
		}
	/**
	 * Busca un valor en el array
	 * @param array1 el array donde lo queremos buscar
	 * @param zenbaki el valor que queremos buscar
	 * @return la posicion en la que se encuentra el valor buscado (-1 si no se encuentra)
	 */
	public static int bilatu (int [] array1, int zenbaki) {
		boolean aurkituta = false;
		int i = -1;
		while (i<array1.length-1 && !aurkituta) {
			i++;
			if (array1[i]==zenbaki) {
				aurkituta = true;
			}
		}
		if (!aurkituta) {
			i = -1;
		}
		return i;
	}
	/**
	 * borra un valor del array
	 * @param array1 el array de donde lo queremos borrar
	 * @param zenbaki el numero que queremos borrar
	 * @return el array con el valor eliminado
	 */
	public static int[] ezabatu (int [] array1, int zenbaki) {
		int [] emaitza = array1;
		int i = 0;
		while (i<array1.length-1) {
			i++;
			if (array1[i]==zenbaki) {
				array1[i] = 0;
			}
			if (array1[i]==0) {
				for (int j=i;j<array1.length-1;j++) {
					array1[i] = array1[i+1];
					i++;
				}
			}
		}
		return emaitza;
	}
	/**
	 * Compara los array 
	 * @param ar1 primer array
	 * @param ar2 array a comparar
	 * @return true si son iguales, false si no
	 */
	public static boolean komparatu (int [] ar1, int [] ar2) {
		boolean berdinak = true;
		if (ar1.length == ar2.length) {
			for (int i = 0;i<ar1.length;i++) {
				if (ar1[i] != ar2[i]) {
					berdinak = false;
					break;
				}
			}
		}else {
			berdinak = false;
		}
		return berdinak;
	}
	/**
	 * Multiplica 2 arrays
	 * @param array1 Primer array
	 * @param array2 Segundo array
	 * @return Un array con el resultado de las multiplicaciones
	 */
	public static int[] biderkatu(int[] array1, int[] array2) {
		int [] emaitza = new int [array1.length];
		for (int i=0;i<array1.length;i++) {
			emaitza[i] = array1[i]*array2[i];
		}
		return emaitza;
	}
	/**
	 * Suma 2 arrays
	 * @param array1 primer array
	 * @param array2 segundo array
	 * @return Un array con el resultado de las sumas
	 */
	public static int[] batu(int[] array1, int[] array2) {
		int [] emaitza = new int [array1.length];
		for (int i=0;i<array1.length;i++) {
			emaitza[i] = array1[i]*array2[i];
		}
		return emaitza;
	}
	/**
	 * Convierte array de string a int
	 * @param zenbakiak el array que queremos convertir
	 * @return el array en int
	 */
	public static int [] parseInt (String [] zenbakiak) {
		int [] zbk = new int [zenbakiak.length];
		for (int i = 0;i<zbk.length;i++)
			zbk [i] = Integer.parseInt(zenbakiak[i]);
		return zbk;
	}
	public static int [] utsitu (int [] ar1) {
		for (int i = 0;i<ar1.length;i++) {
			ar1[i]=0;
		}
		return ar1;
	}
}
