package org.example.analyzer.tokenfilter;

import org.example.analyzer.Token;

import java.text.Normalizer;
import java.util.List;

public class AscIIFold implements TokenFilter{

    @Override
    public List<Token> filter(Token token) {
        String norm = Normalizer.normalize(token.getTerm(), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return List.of(new Token(norm));
    }
}
