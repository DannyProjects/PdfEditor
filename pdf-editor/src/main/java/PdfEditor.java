
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
//import com.itextpdf.licensekey.LicenseKey;

public class PdfEditor {

	/** The Base URI of the HTML page. */
	public static final String BASEURI = "src/main/resources/html/";
	/** The path to the source HTML file. */
	public static final String SRC = String.format("%sform.html", BASEURI);
	public static final String SRCMOD = String.format("%sformMod.html", BASEURI);
	/** The target folder for the result. */
	public static final String TARGET = "target/results/ch07/";
	/** The path to the resulting PDF file. */
	public static final String DEST = String.format("%sform_acroformeditable.pdf", TARGET);
	
	public static void main(String args[]) throws IOException{
		
		 File file = new File(TARGET);
	        file.mkdirs();
	        //createPdf(SRC, DEST);
	        stringToPdf(DEST);
		
	}

    public static void createPdf(String src, String dest) throws IOException {
    	ConverterProperties properties = new ConverterProperties();
    	properties.setCreateAcroForm(true);
        HtmlConverter.convertToPdf(new File(src), new File(dest), properties);
    }
    
    public static void stringToPdf(String dest) throws IOException {
    	String html = "<html>\r\n" + 
    			"<head>\r\n" + 
    			"<style type=\"text/css\">\r\n" + 
    			"@font-face {\r\n" + 
    			"    font-family: 'Fira Sans';\r\n" + 
    			"    src: local('FiraSans-Regular'),\r\n" + 
    			"    url('/media/fonts/FiraSans-Regular.woff2') format('woff2');\r\n" + 
    			"}\r\n" + 
    			"\r\n" + 
    			"legend {\r\n" + 
    			"    background-color: #000;\r\n" + 
    			"    color: #fff;\r\n" + 
    			"    padding: 3px 6px;\r\n" + 
    			"}\r\n" + 
    			"\r\n" + 
    			".output {\r\n" + 
    			"    font: 1rem 'Fira Sans', sans-serif;\r\n" + 
    			"}\r\n" + 
    			"\r\n" + 
    			"input {\r\n" + 
    			"    margin: .4rem;\r\n" + 
    			"}\r\n" + 
    			"</style>\r\n" + 
    			"<title>Test</title></head>\r\n" + 
    			"<body>\r\n" + 
    			"<h1>Equifax</h1>\r\n" + 
    			"<form>\r\n" + 
    			"<!-- <fieldset>\r\n" + 
    			"Modificac�n: <input type=\"text\" name=\"place\" value=\"Pdf\"><br>\r\n" + 
    			"Din�mico: <input type=\"text\" name=\"who\" value=\"desde Html\"><br>\r\n" + 
    			"S� <input type=\"radio\" value=\"S\" name=\"test\" checked=\"checked\"  >\r\n" + 
    			"No<input type=\"radio\" value=\"N\" name=\"test\" checked=\"checked\"  >\r\n" + 
    			"</fieldset> -->\r\n" + 
    			"\r\n" + 
    			"<fieldset>\r\n" + 
    			"    <legend>Select a maintenance drone</legend>\r\n" + 
    			"\r\n" + 
    			"    <div>\r\n" + 
    			"        <input type=\"radio\" id=\"huey\" name=\"drone\" checked />\r\n" + 
    			"        <label for=\"huey\">Huey</label>\r\n" + 
    			"    </div>\r\n" + 
    			"\r\n" + 
    			"    <div>\r\n" + 
    			"        <input type=\"radio\" id=\"dewey\" name=\"drone\" />\r\n" + 
    			"        <label for=\"dewey\">Dewey</label>\r\n" + 
    			"    </div>\r\n" + 
    			"\r\n" + 
    			"    <div>\r\n" + 
    			"        <input type=\"radio\" id=\"louie\" name=\"drone\" />\r\n" + 
    			"        <label for=\"louie\">Louie</label>\r\n" + 
    			"    </div>\r\n" + 
    			"\r\n" + 
    			"</fieldset>\r\n" + 
    			"\r\n" + 
    			"</form>\r\n" + 
    			"</body>\r\n" + 
    			"</html>";
    	
    	File file = new File(SRCMOD);
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(html);
		fileWriter.flush();
		fileWriter.close();
    	
    	ConverterProperties properties = new ConverterProperties();
    	properties.setCreateAcroForm(true);
        HtmlConverter.convertToPdf(new File(SRCMOD), new File(dest), properties);
    }
	
}
