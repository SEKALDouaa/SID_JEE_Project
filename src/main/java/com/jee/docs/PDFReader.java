package com.jee.docs;

import java.io.File; 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReader {

	public static void main(String[] args) throws IOException{
		
		/*File pdf=new File("C:\\Users\\mabrchaouen\\Desktop\\S2-Salma-Log\\JAVA\\SID\\src\\main\\webapp\\livres\\dan-brown.pdf");
		
		PDDocument doc=PDDocument.load(pdf);
		
		PDFTextStripper pdfStripper=new PDFTextStripper();
		String text=pdfStripper.getText(doc);
		
		System.out.println(text);*/
		
		Map<Integer, String> m=new HashMap<Integer,String>();
		m.put(1, "salma");
		m.put(2, "salma");
		m.put(3, "salma");
		
		System.out.println("get the value by the key: "+m.get(1));
		
		System.out.println("get all the keys: "+m.keySet());
		
		System.out.println("get all the values: "+m.values());
		
		System.out.println("iterate over the keys: ");
		
		for(Entry<Integer,String> entry: m.entrySet()) {
			System.out.println("the key: "+entry.getKey());
			System.out.println("the value: "+entry.getValue());
			System.out.println("the pair: "+entry);
		}

		
		
		
	}
}
