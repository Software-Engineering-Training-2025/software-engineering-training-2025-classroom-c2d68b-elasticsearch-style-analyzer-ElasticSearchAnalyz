package org.example.analyzer.tokenfilter;

import org.example.analyzer.Token;

import java.util.ArrayList;
import java.util.List;

public class Lowercase implements TokenFilter{
    @Override
    public List<Token> filter(Token token) {
        return List.of(token.getTerm()).stream()
                .map(String::toLowerCase)
                .map(Token::new)
                .toList();
    }
}
