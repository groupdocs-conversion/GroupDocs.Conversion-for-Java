package com.groupdocs.ui.conversion;

import com.google.gson.Gson;
import com.groupdocs.ui.model.request.ConversionPostedData;
import com.groupdocs.ui.model.request.FileTreeRequest;
import org.apache.commons.io.FilenameUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConversionControllerTest {

    MockMvc mvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    ConversionController controller;



    @Before
    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        this.mvc = standaloneSetup(this.controller).setViewResolvers(viewResolver).build();

        File resourcesDirectory = new File("src/test/resources");
        controller.conversionService.getConversionConfiguration().setFilesDirectory(resourcesDirectory.getAbsolutePath());
        controller.conversionService.getConversionConfiguration().setResultDirectory(FilenameUtils.concat(resourcesDirectory.getAbsolutePath(),"Converted"));
    }

    @Test
    public void getView()  throws Exception {
        mvc.perform(get("/conversion")).andExpect(status().isOk()).andExpect(view().name("conversion"));
    }

    @Test
    public void loadFileTree() throws Exception {
        FileTreeRequest fileTreeRequest = new FileTreeRequest();
        fileTreeRequest.setPath("");
        mvc.perform(post("/conversion/loadFileTree")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(fileTreeRequest))
        ).andExpect(status().isOk());
    }

    @Test
    public void convertDocxToPng() throws Exception {
        new File("src/test/resources/Converted/calibre-page1.png").delete();
        new File("src/test/resources/Converted/calibre-page2.png").delete();
        new File("src/test/resources/Converted/calibre-page3.png").delete();

        File testFile = new File("src/test/resources/calibre.docx");

        ConversionPostedData conversionRequest = new ConversionPostedData();
        conversionRequest.setGuid(testFile.getAbsolutePath());
        conversionRequest.setDestinationType("png");

        mvc.perform(post("/conversion/convert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(conversionRequest))
        ).andExpect(status().isOk());

        assertTrue(new File("src/test/resources/Converted/calibre-page1.png").exists());
        assertTrue(new File("src/test/resources/Converted/calibre-page2.png").exists());
        assertTrue(new File("src/test/resources/Converted/calibre-page3.png").exists());

    }

    @Test
    public void convertDocxToXls() throws Exception {
        new File("src/test/resources/Converted/calibre.xls").delete();

        File testFile = new File("src/test/resources/calibre.docx");

        ConversionPostedData conversionRequest = new ConversionPostedData();
        conversionRequest.setGuid(testFile.getAbsolutePath());
        conversionRequest.setDestinationType("xls");

        mvc.perform(post("/conversion/convert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(conversionRequest))
        ).andExpect(status().isOk());

        assertTrue(new File("src/test/resources/Converted/calibre.xls").exists());

    }

    @Test
    public void downloadDocumentAsZipIfConvertedToImages() throws Exception {
        new File("src/test/resources/Converted/calibre-page1.png").delete();
        new File("src/test/resources/Converted/calibre-page2.png").delete();
        new File("src/test/resources/Converted/calibre-page3.png").delete();

        File testFile = new File("src/test/resources/calibre.docx");

        ConversionPostedData conversionRequest = new ConversionPostedData();
        conversionRequest.setGuid(testFile.getAbsolutePath());
        conversionRequest.setDestinationType("png");

        mvc.perform(post("/conversion/convert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Gson().toJson(conversionRequest))
        ).andExpect(status().isOk());

        assertTrue(new File("src/test/resources/Converted/calibre-page1.png").exists());
        assertTrue(new File("src/test/resources/Converted/calibre-page2.png").exists());
        assertTrue(new File("src/test/resources/Converted/calibre-page3.png").exists());

        mvc.perform(get("/conversion/downloadDocument/?path=calibre.png"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Disposition","attachment; filename=calibre.zip"));
    }
}