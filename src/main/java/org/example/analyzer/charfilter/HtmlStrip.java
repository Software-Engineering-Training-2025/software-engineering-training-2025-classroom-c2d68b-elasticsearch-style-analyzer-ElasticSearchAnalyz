package org.example.analyzer.charfilter;

public class HtmlStrip implements CharFilter{
    @Override
    public String filter(String text) {
        return text.replaceAll("<[^>]*>", "");
    }
}
