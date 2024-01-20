package com.IGallinari.LastGame.service.txtToJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class BlogTxtToJson {

    @PostConstruct
    public static void init() {
        String filePath = "com/IGallinari/LastGame/doc/blog/blog1.txt";
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode json = objectMapper.createObjectNode();

            // Extracting image URL from the text
            int imgIndexStart = fileContent.indexOf("img: ");
            int imgIndexEnd = fileContent.indexOf("\n", imgIndexStart);
            String imgUrl = fileContent.substring(imgIndexStart, imgIndexEnd).trim();
            System.out.println(imgUrl);
                /*
                // Creating paragraphs array in the JSON object
                ArrayNode paragraphs=json.putArray("paragraphs");

                //Extracting and adding each paragraph to the paragraphs array.
                String[] paragraphSections=fileContext.split("Paragrafo:");

                for(String section:paragraphSections)
                {
                    if (!section.trim().isEmpty())
                    {
                        int titleIdxSt=	fileContext.lastIndexOf("Title")+7;
                        int subTitleIdxEd=fileContext.indexof("\n",subTitleIdxSt);
                        string subtitile=filecontext.subtring(subTitleIdxSt,subTitleEd).trim();




                        // Extracting content from the section
                        int contentIndexStart = section.indexOf("Contenuto:") + 10;
                        String content*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}