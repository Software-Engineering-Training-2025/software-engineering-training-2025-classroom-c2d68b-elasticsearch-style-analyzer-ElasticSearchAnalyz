package org.example.analyzer.registry;

import org.example.analyzer.Analyzer;
import org.example.analyzer.builder.AnalyzerBuilder;
import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.enums.TokenizerType;

import java.util.Map;

public class AnalyzerRegistry {
    // TODO: simple map<String, Analyzer> with register/get
    private static final Map<String, Analyzer> analyzerMap = Map.of(
            "standard", getStandardAnalyzer(),
            "english",getEgnlishdAnalyzer());

    public static Analyzer get(String name) {
        return analyzerMap.getOrDefault(name, null);
    }
    public static Analyzer getStandardAnalyzer() {
        return AnalyzerBuilder.create()
                .addCharFilter(CharFilterType.HTML_STRIP)
                .tokenizer(TokenizerType.STANDARD)
                .addTokenFilter(TokenFilterType.LOWERCASE)
                .addTokenFilter(TokenFilterType.ASCII_FOLD)
                .build();
    }

    public static Analyzer getEgnlishdAnalyzer() {
        return AnalyzerBuilder.create()
                .addCharFilter(CharFilterType.HTML_STRIP)
                .addCharFilter(CharFilterType.MAPPING_SMART_QUOTES)
                .tokenizer(TokenizerType.STANDARD)
                .addTokenFilter(TokenFilterType.LOWERCASE)
                .addTokenFilter(TokenFilterType.ASCII_FOLD)
                .addTokenFilter(TokenFilterType.STOP_EN)
                .addTokenFilter(TokenFilterType.PORTER_LITE)
                .build();
    }

}
