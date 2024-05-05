package com.jee.docs;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PDFUploader {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/servlet";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public void uploadPDF(String filePath) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO pdf_files (file_name, file_data) VALUES (?, ?)")) {

            // Lire le contenu du fichier PDF
            File file = new File(filePath);
            byte[] pdfContent = new byte[(int) file.length()];
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(pdfContent);
            }

            // Préparer la requête d'insertion avec le nom du fichier et son contenu
            preparedStatement.setString(1, file.getName());
            preparedStatement.setBytes(2, pdfContent);

            // Exécuter la requête d'insertion
            preparedStatement.executeUpdate();
            System.out.println("Fichier PDF inséré avec succès dans la base de données.");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Exemple d'utilisation : spécifiez le chemin absolu du fichier PDF à insérer dans la base de données
        String filePath = "C:\\Users\\mabrchaouen\\Desktop\\S2-Salma-Log\\JAVA\\SID\\src\\main\\webapp\\livres\\dan-brown.pdf";

        // Créer une instance de PDFUploader et appeler la méthode uploadPDF
        PDFUploader pdfUploader = new PDFUploader();
        pdfUploader.uploadPDF(filePath);
    }
}

