package org.example.analyzer.tokenfilter;

import org.example.analyzer.Token;
import org.tartarus.snowball.ext.EnglishStemmer;

import java.util.List;

public class PorterLite implements TokenFilter{
    @Override
    public List<Token> filter(Token token) {
        EnglishStemmer stemmer = new EnglishStemmer();
        stemmer.setCurrent(token.getTerm());
        stemmer.stem();
        return List.of(new Token(stemmer.getCurrent()));
    }
}
