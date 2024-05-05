package com.jee.docs;

import java.util.List;

public class Test {

	 public static void main(String[] args) {
	        // Chemin du répertoire contenant les fichiers PDF
	        String directoryPath = "C:\\Users\\mabrchaouen\\Desktop\\S2-Salma-Log\\JAVA\\SID\\src\\main\\webapp\\livres";

	        // Créer une instance de PDFExtractor
	        PDFExtractor pdfExtractor = new PDFExtractor();

	        // Extraire les fichiers PDF à partir du répertoire spécifié
	        List<String> pdfFiles = pdfExtractor.extractPDFFiles(directoryPath);

	        // Afficher les chemins des fichiers PDF extraits
	        for (String pdfFile : pdfFiles) {
	            System.out.println("Chemin du fichier PDF : " + pdfFile);
	        }
	    }
	
}
