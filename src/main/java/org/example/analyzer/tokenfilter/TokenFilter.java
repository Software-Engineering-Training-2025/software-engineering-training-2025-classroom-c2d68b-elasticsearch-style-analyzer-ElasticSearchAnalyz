package org.example.analyzer.tokenfilter;

import org.example.analyzer.Token;

import java.util.List;

public interface TokenFilter {
    List<Token> filter(Token token);
}
