package com.zachlatta.flashcards.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A set of flashcards.
 *
 * @author Zachary Latta
 */
public class FlashcardSet
{
    /**
     * Flashcards in the set.
     */
    private List<Flashcard> flashcards;

    /**
     * Creates a new flashcard set.
     */
    public FlashcardSet()
    {
        this.flashcards = new ArrayList<Flashcard>();
    }

    /**
     * Adds a flashcard to the flashcard set.
     *
     * @param flashcard The flashcard to add.
     */
    public void addFlashcard(Flashcard flashcard)
    {
        flashcards.add(flashcard);
    }

    /**
     * Returns the flashcard at the specified index in the set.
     *
     * @param index The index of the flashcard to return.
     * @return The flashcard at the specified index in the set.
     */
    public Flashcard getFlashcard(int index)
    {
        return flashcards.get(index);
    }

    /**
     * Returns the size of the flashcard set.
     */
    public int size()
    {
        return flashcards.size();
    }
}
