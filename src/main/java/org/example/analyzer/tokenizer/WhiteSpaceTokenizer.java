package org.example.analyzer.tokenizer;

import org.example.analyzer.Token;

import java.util.Arrays;
import java.util.List;

public class WhiteSpaceTokenizer implements Tokenizer{
    @Override
    public List<Token> tokenize(String text) {
        return Arrays.stream(text.split("\\s+"))
                .map(Token::new)
                .toList();
    }
}
