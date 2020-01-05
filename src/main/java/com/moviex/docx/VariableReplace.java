package com.moviex.docx;

import org.docx4j.Docx4J;
import org.docx4j.XmlUtils;
import org.docx4j.jaxb.Context;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ObjectFactory;

import java.io.File;
import java.util.HashMap;
import java.util.StringTokenizer;

public class VariableReplace {
    public static void main(String[] args) throws Exception {

        // Exclude context init from timing
        ObjectFactory foo = Context.getWmlObjectFactory();

        // Input docx has variables in it: ${colour}, ${icecream}
        String inputfilepath = "D:/demo.docx";

        boolean save = true;
        String outputfilepath = "D:/demo_out.docx";

        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                .load(new java.io.File(inputfilepath));

        VariablePrepare.prepare(wordMLPackage);

        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

        HashMap<String, String> mappings = new HashMap<>();
        mappings.put("colour", "aaaaaa");
        mappings.put("colour1", "Số bảo hành");
//        mappings.put("icecream", newlineToBreakHack("chocolate\nor strawberry"));

        long start = System.currentTimeMillis();

        documentPart.variableReplace(mappings);

        long end = System.currentTimeMillis();
        long total = end - start;
        System.out.println("Time: " + total);

        // Save it
        if (save) {
            Docx4J.save(wordMLPackage, new File(outputfilepath));
        } else {
            System.out.println(XmlUtils.marshaltoString(documentPart.getJaxbElement(), true,
                    true));
        }
    }

    /**
     * Hack to convert a new line character into w:br.
     * If you need this sort of thing, consider using
     * OpenDoPE content control data binding instead.
     *
     * @param r
     * @return
     */
    private static String newlineToBreakHack(String r) {

        StringTokenizer st = new StringTokenizer(r, "\n\r\f"); // tokenize on the newline character, the carriage-return character, and the form-feed character
        StringBuilder sb = new StringBuilder();

        boolean firsttoken = true;
        while (st.hasMoreTokens()) {
            String line = (String) st.nextToken();
            if (firsttoken) {
                firsttoken = false;
            } else {
                sb.append("</w:t><w:br/><w:t>");
            }
            sb.append(line);
        }
        return sb.toString();
    }
}
