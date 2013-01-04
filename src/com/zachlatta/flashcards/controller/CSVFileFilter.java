package com.zachlatta.flashcards.controller;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * File filter which filters CSV files.
 *
 * @author Zachary Latta
 */
public class CSVFileFilter extends FileFilter
{
    @Override
    public boolean accept(File file)
    {
        return file.isDirectory() || file.isFile() && file.getName().toLowerCase().endsWith(".csv");

    }

    @Override
    public String getDescription()
    {
        return "*.csv";
    }
}
