package org.example.analyzer.tokenizer;

import org.example.analyzer.enums.TokenizerType;

public class TokenizerFactory {
    public static Tokenizer getTokenizer(TokenizerType type) {
        if (type == TokenizerType.WHITESPACE) {
            return new WhiteSpaceTokenizer();
        }
        if (type == TokenizerType.STANDARD) {
            return new StandardTokenizer();
        }
        throw new RuntimeException("Not supported");
    }
}
