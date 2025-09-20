package org.example.analyzer.enums;

import org.example.analyzer.Analyzer;
import org.example.analyzer.tokenizer.StandardTokenizer;
import org.example.analyzer.tokenizer.Tokenizer;
import org.example.analyzer.tokenizer.WhiteSpaceTokenizer;

public enum TokenizerType {
    WHITESPACE,             // split on \\s+
    STANDARD;// regex words: \\p{L}[\\p{L}\\p{Mn}\\p{Nd}_']*

}
