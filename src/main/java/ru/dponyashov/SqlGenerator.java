package ru.dponyashov;

public interface SqlGenerator {
    String selectText();
    String insertText();
    String updateText();
    String deleteText();

}
