import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        String input = "int main() {int x;\n" +
                "    int y;\n" +
                "    x = 10;\n" +
                "    y = 20;\n" +
                "    if (x > y) {\n" +
                "        x = x + 1;\n" +
                "    } else {\n" +
                "        y = y - 1;\n" +
                "    }\n" +
                "    for (int i = 0; i < 5; i++) {\n" +
                "        x = x + i;\n" +
                "        y = y + i;\n" +
                "    }\n" +
                "    while (x > 0) {\n" +
                "        x = x - 1;\n" +
                "    }\n" +
                "    return x;\n" +
                "}";
        try {
            Lexer lexer = new Lexer(input);
            List<Token> tokens = lexer.tokenize();
            System.out.println("--------------------------------------------ANALYSEUR LEXICALE--------------------------------------------");
            printTokens(tokens);

        } catch (LexerException e) {
            System.err.println("Lexer error: " + e.getMessage());
        }
    }

 private static void printTokens(List<Token> tokens) {
        Map<String, Integer> identifierMap = new HashMap<>();
        System.out.println("Table de Symboles:");
        System.out.println("+---+------------------+-------------------------------+");
        System.out.println("| # |      Value       |           Type                |");
        System.out.println("+---+------------------+-------------------------------+");
        int identifierCount = 1;
        for (Token token : tokens) {
            if (token.getType() == TokenType.IDENTIFIER) {
                String value = token.getValue();
                if (!identifierMap.containsKey(value)) {
                    identifierMap.put(value, identifierCount);
                    identifierCount++;
                }
                System.out.printf("| %d | %-17s| %-30s|%n", identifierMap.get(value), value, token.getType());
            } else {
                System.out.printf("|   | %-17s| %-30s|%n", token.getValue(), token.getType());
            }
        }
        System.out.println("+---+------------------+-------------------------------+");
    }
}

class Lexer {
    private String input;
    private int position;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
    }

    public List<Token> tokenize() throws LexerException {
        List<Token> tokens = new ArrayList<>();
        while (position < input.length()) {
            char currentChar = input.charAt(position);
            if (Character.isWhitespace(currentChar)) {
                position++;
            } else if (Character.isDigit(currentChar)) {
                tokens.add(readNumber());
            } else if (Character.isLetter(currentChar)) {
                tokens.add(readIdentifierOrKeyword());
            } else if (currentChar == '=') {
                tokens.add(new Token(TokenType.ASSIGNMENT_OPERATOR, "="));
                position++;
            } else if (currentChar == ';') {
                tokens.add(new Token(TokenType.SEMICOLON, ";"));
                position++;
            } else if (currentChar == '(') {
                tokens.add(new Token(TokenType.LEFT_PAREN, "("));
                position++;
            } else if (currentChar == ')') {
                tokens.add(new Token(TokenType.RIGHT_PAREN, ")"));
                position++;
            } else if (currentChar == '{') {
                tokens.add(new Token(TokenType.LEFT_BRACE, "{"));
                position++;
            } else if (currentChar == '}') {
                tokens.add(new Token(TokenType.RIGHT_BRACE, "}"));
                position++;
            } else if (currentChar == '+') {
    tokens.add(new Token(TokenType.ADDITIVE_OPERATOR, "+"));
    position++;
} else if (currentChar == '>') {
    tokens.add(new Token(TokenType.RELATIONAL_OPERATOR, ">"));
    position++;
} else if (currentChar == '-') {
    tokens.add(new Token(TokenType.SUBTRACTIVE_OPERATOR, "-"));
    position++;
}else if (currentChar == '<') {
    tokens.add(new Token(TokenType.RELATIONAL_OPERATOR, "<"));
    position++;
}


            else {
                throw new LexerException("Unexpected character: " + currentChar);
            }
        }
        return tokens;
    }

    private Token readNumber() {
        StringBuilder sb = new StringBuilder();
        while (position < input.length() && Character.isDigit(input.charAt(position))) {
            sb.append(input.charAt(position));
            position++;
        }
        return new Token(TokenType.NUMBER, sb.toString());
    }

    private Token readIdentifierOrKeyword() {
        StringBuilder sb = new StringBuilder();
        while (position < input.length() && (Character.isLetterOrDigit(input.charAt(position)) || input.charAt(position) == '_')) {
            sb.append(input.charAt(position));
            position++;
        }
        String identifier = sb.toString();
        // Check if the identifier is a keyword
        if (identifier.equals("int") || identifier.equals("void") || identifier.equals("main") ||
            identifier.equals("if") || identifier.equals("else") || identifier.equals("for") ||
            identifier.equals("return") ||identifier.equals("while"))
            {
            return new Token(TokenType.KEYWORD, identifier);
        }
        return new Token(TokenType.IDENTIFIER, identifier);
    }
}

class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}

class LexerException extends Exception {
    public LexerException(String message) {
        super(message);
    }
}

enum TokenType {
    NUMBER,
    KEYWORD,
    IDENTIFIER,
    ASSIGNMENT_OPERATOR,
    RELATIONAL_OPERATOR,
    SEMICOLON,
    LEFT_PAREN,
    RIGHT_PAREN,
    LEFT_BRACE,
    RIGHT_BRACE,
    SUBTRACTIVE_OPERATOR,
    ADDITIVE_OPERATOR
}