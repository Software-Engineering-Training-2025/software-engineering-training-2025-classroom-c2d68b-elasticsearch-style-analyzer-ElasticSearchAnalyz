package org.example.analyzer.charfilter;

public class NormalizeDash implements CharFilter{
    @Override
    public String filter(String text) {
        return text.replace("—", "-")
                .replace("–", "-");
    }
}
