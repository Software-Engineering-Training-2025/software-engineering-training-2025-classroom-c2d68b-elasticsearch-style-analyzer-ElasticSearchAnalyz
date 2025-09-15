package org.example.analyzer.builder;

import org.example.analyzer.Analyzer;
import org.example.analyzer.enums.CharFilterType;
import org.example.analyzer.enums.TokenFilterType;
import org.example.analyzer.enums.TokenizerType;

public class AnalyzerBuilder {
    // TODO: keep internal ordered lists of charFilters and tokenFilters, and a tokenizer
    public static AnalyzerBuilder create() {
        // TODO
        throw new UnsupportedOperationException("impl me");
    }

    public AnalyzerBuilder addCharFilter(CharFilterType type) {
        // TODO (append in order)
        throw new UnsupportedOperationException("impl me");
    }

    public AnalyzerBuilder tokenizer(TokenizerType type) {
        // TODO (set tokenizer)
        throw new UnsupportedOperationException("impl me");
    }

    public AnalyzerBuilder addTokenFilter(TokenFilterType type) {
        // TODO (append in order)
        throw new UnsupportedOperationException("impl me");
    }

    /** Build an Analyzer that executes: charFilters -> tokenizer -> tokenFilters */
    public Analyzer build() {
        // TODO (validate tokenizer set; return AnalyzerImpl with resolved components)
        throw new UnsupportedOperationException("impl me");
    }
}

