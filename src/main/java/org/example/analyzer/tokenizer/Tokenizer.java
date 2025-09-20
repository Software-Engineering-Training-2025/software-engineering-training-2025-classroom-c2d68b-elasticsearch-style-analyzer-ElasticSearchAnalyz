package org.example.analyzer.tokenizer;

import org.example.analyzer.Token;

import java.util.List;

public interface Tokenizer {
    List<Token> tokenize(String text);
}
