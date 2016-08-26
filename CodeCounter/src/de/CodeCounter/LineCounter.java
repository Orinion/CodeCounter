/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.CodeCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Jakob
 */
public class LineCounter {
    private File rootFile;
    private FileFilter fileFilter;
    
    private int lines=0;
    private int directories=0;
    private int sourceFiles=0;
    public LineCounter(File file,SourceFileFilter filter) {
        this.rootFile = file;        
        this.fileFilter = filter;
        
        this.calc();
    }
    private void getLines(File file)
    {
        if(!file.exists())
            return;
        if(!fileFilter.accept(file))
            return;
        if(file.isDirectory()){
            directories++;
            for(File child: file.listFiles())
                getLines(child);
        }
        else
        {
            
            sourceFiles++;
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while(reader.readLine()!=null)
                    lines++;
            } catch (IOException ex) {}
        }
    }
    private void calc()
    {
        getLines(rootFile);
    }
  
    public String getFilePath() {
        return rootFile.getPath();
    }

    public int getLines() {
        return lines;
    }

    public int getDirectories() {
        return directories;
    }

    public int getSourceFiles() {
        return sourceFiles;
    }
    
}
