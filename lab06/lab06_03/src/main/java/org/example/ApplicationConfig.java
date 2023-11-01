package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ApplicationConfig {
    @Bean
    public PlainTextWriter plainTextWriter() {
        return new PlainTextWriter();
    }

    @Bean
    public PdfTextWriter pdfTextWriter() {
        return new PdfTextWriter();
    }

    @Bean
    public TextEditor textEditor() {
        return new TextEditor(plainTextWriter());
    }
}