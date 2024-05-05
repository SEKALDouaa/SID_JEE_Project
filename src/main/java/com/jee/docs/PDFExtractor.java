package com.jee.docs;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PDFExtractor {
    public List<String> extractPDFFiles(String directoryPath) {
        List<String> pdfFiles = new ArrayList<>();
        try {
            File directory = new File(directoryPath);
            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".pdf")) {
                        pdfFiles.add(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Le chemin spécifié n'existe pas ou n'est pas un répertoire valide.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdfFiles;
    }
}
