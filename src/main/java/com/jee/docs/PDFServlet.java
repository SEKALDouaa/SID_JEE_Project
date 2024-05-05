package com.jee.docs;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

@WebServlet("/pdf")

public class PDFServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Spécifiez le chemin vers votre fichier PDF
        File pdfFile = new File("C:\\Users\\mabrchaouen\\Desktop\\S2-Salma-Log\\JAVA\\SID\\src\\main\\webapp\\livres\\dan-brown.pdf");
        
        try (PDDocument document = PDDocument.load(pdfFile)) {
            // Utilisez PDFTextStripper pour extraire le texte du document
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            
            // Configurez la réponse HTTP
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
          
            
            request.setAttribute("pdfText", text); // text est le texte extrait du PDF
            request.getRequestDispatcher("test.jsp").forward(request, response);

        } catch (IOException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Erreur lors de la lecture du fichier PDF.");
        }
    }
}

