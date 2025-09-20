package org.example.analyzer.tokenfilter;

import org.example.analyzer.enums.TokenFilterType;

public class TokenFilterFactory {
    public static TokenFilter getTokenFilter(TokenFilterType type) {
        if(type == TokenFilterType.LOWERCASE) {
            return new Lowercase();
        }
        if(type == TokenFilterType.ASCII_FOLD) {
            return new AscIIFold();
        }
        if(type == TokenFilterType.EDGE_NGRAM_1_3) {
            return new EdgeNgram13();
        }
        if(type == TokenFilterType.STOP_EN) {
            return new StopEnglish();
        }
        if(type == TokenFilterType.PORTER_LITE) {
            return new PorterLite();
        }
        throw new RuntimeException("Not supported");
    }
}
