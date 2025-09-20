package org.example.analyzer;

import org.example.analyzer.charfilter.CharFilter;
import org.example.analyzer.tokenfilter.PorterLite;
import org.example.analyzer.tokenfilter.TokenFilter;
import org.example.analyzer.tokenizer.Tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AnalyzerImpl implements Analyzer{
    private List<CharFilter> charFilters = new ArrayList<>();
    private Tokenizer tokenizer = null;
    private List<TokenFilter> tokenFilters = new ArrayList<>();

    public AnalyzerImpl(List<CharFilter> charFilters, Tokenizer tokenizer, List<TokenFilter> tokenFilters) {
        this.charFilters = charFilters;
        this.tokenizer = tokenizer;
        this.tokenFilters = tokenFilters;
    }

    @Override
    public List<Token> analyze(String text) {
        // char filters
        String filterText = runCharFilters(text);
        // tokenization
        List<Token> tokens = tokenizer.tokenize(filterText);
        // tokenFilter
        return runTokenFilters(tokens);
    }

    private List<Token> runTokenFilters(List<Token> tokens) {
        for(TokenFilter tokenFilter: tokenFilters) {
            List<Token> list = new ArrayList<>();
            for(Token token: tokens) {
                list.addAll(tokenFilter.filter(token));
            }
            tokens = list;
        }
//        Stream<Token> stream = tokens.stream();
//        for(TokenFilter tokenFilter: tokenFilters){
//            stream.flatMap(token -> tokenFilter.filter());
//        }
        return tokens;
    }

    private String runCharFilters(String text) {
        for(CharFilter charFilter: charFilters) {
            text = charFilter.filter(text);
        }
        return text;
    }
}
