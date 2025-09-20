package org.example.analyzer.tokenizer;

import org.example.analyzer.Token;

import java.util.Arrays;
import java.util.List;

public class StandardTokenizer implements Tokenizer{

    @Override
    public List<Token> tokenize(String text) {
        return Arrays.stream(text.split("\\p{L}[\\p{L}\\p{Mn}\\p{Nd}_']*"))
                .map(Token::new)
                .toList();
    }
}
