package org.example.analyzer.tokenfilter;

import org.example.analyzer.Token;

import java.util.List;

public class EdgeNgram13 implements TokenFilter{
    @Override
    public List<Token> filter(Token token) {
        return List.of(new Token(token.getTerm().substring(0, 1)),
                new Token(token.getTerm().substring(0, 2)),
                new Token(token.getTerm().substring(0, 3)));
    }
}
