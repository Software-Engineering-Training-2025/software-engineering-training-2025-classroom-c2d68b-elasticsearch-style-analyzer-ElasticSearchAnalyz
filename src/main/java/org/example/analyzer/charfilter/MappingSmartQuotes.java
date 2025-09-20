package org.example.analyzer.charfilter;

public class MappingSmartQuotes implements CharFilter{
    @Override
    public String filter(String text) {
        return text.replace("’", "'")
                .replace("“", "\"")
                .replace("”", "\"");
    }
}
