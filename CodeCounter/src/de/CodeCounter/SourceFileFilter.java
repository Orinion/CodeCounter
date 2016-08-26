/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.CodeCounter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Jakob
 */
public class SourceFileFilter extends FileFilter{
    public String[] allowed;
    public SourceFileFilter( String[] fileEndings) {
        this.allowed = fileEndings;
    }

    
    @Override
    public boolean accept(File f) {
        String fileName = f.getName();
      
        if(f.isDirectory())
            return true;
        String fileEnding;
        int i = fileName.lastIndexOf('.');
        if (i > 0)
            fileEnding = fileName.substring(i+1);
        else
            return false;
        for(String ending:allowed)
            if(ending.equals(fileEnding))
                return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "Sourcecode Files";
    }
    
}
