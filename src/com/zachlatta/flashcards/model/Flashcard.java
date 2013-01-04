package com.zachlatta.flashcards.model;

/**
 * A flashcard.
 *
 * @author Zachary Latta
 */
public class Flashcard
{
    private String term;
    private String definition;
    private boolean correct;

    /**
     * Creates a new flashcard.
     *
     * @param term The term of the flashcard.
     * @param definition The definition of the flashcard.
     */
    public Flashcard(String term, String definition)
    {
        this.term = term;
        this.definition = definition;
        this.correct = false;
    }

    public void setCorrect(boolean correct)
    {
        this.correct = correct;
    }

    public String getTerm()
    {
        return term;
    }

    public String getDefinition()
    {
        return definition;
    }

    public boolean isCorrect()
    {
        return correct;
    }
}
