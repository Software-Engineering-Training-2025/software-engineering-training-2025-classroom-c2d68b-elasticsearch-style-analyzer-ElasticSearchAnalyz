package org.example.analyzer.builder;

import org.example.analyzer.Analyzer;
import org.example.analyzer.AnalyzerImpl;
import org.example.analyzer.charfilter.CharFilter;
import org.example.analyzer.charfilter.CharFilterFactory;
import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.enums.TokenizerType;
import org.example.analyzer.tokenfilter.TokenFilter;
import org.example.analyzer.tokenfilter.TokenFilterFactory;
import org.example.analyzer.tokenizer.Tokenizer;
import org.example.analyzer.tokenizer.TokenizerFactory;

import java.util.ArrayList;
import java.util.List;

public class AnalyzerBuilder {
    private List<CharFilter> charFilters = new ArrayList<>();
    private Tokenizer tokenizer = null;
    private List<TokenFilter> tokenFilters = new ArrayList<>();

    public static AnalyzerBuilder create() {
        return new AnalyzerBuilder();
    }

    public AnalyzerBuilder addCharFilter(CharFilterType type) {
        CharFilter charFilter = CharFilterFactory.getCharFilterType(type);
        charFilters.add(charFilter);
        return this;
    }

    public AnalyzerBuilder tokenizer(TokenizerType type) {
        tokenizer = TokenizerFactory.getTokenizer(type);
        return this;
    }

    public AnalyzerBuilder addTokenFilter(TokenFilterType type) {

        TokenFilter tokenFilter = TokenFilterFactory.getTokenFilter(type);
        tokenFilters.add(tokenFilter);
        return this;
    }

    /** Build an Analyzer that executes: charFilters -> tokenizer -> tokenFilters */
    public Analyzer build() {
        if(tokenizer == null){
            throw new RuntimeException("tokenizer should not be null");
        }
        return new AnalyzerImpl(charFilters, tokenizer, tokenFilters);
    }
}

