package org.example.analyzer.tokenfilter;

import org.example.analyzer.Token;

import java.util.List;
import java.util.Set;

public class StopEnglish implements TokenFilter {
    private static Set<String> stopWords = Set.of("the","and","of"
            ,"to","in","a","an","is","it","for","on");
    @Override
    public List<Token> filter(Token token) {
        if(stopWords.contains(token.getTerm())) {
            return List.of();
        }
        return List.of(token);
    }
}
