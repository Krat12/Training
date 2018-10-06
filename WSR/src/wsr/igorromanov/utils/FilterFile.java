package wsr.igorromanov.utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;


public class FilterFile extends  FileFilter{
    
    private String fileExtension;
    private String fileDiscription;

    public FilterFile(String fileExtension, String fileDiscription) {
        this.fileExtension = fileExtension;
        this.fileDiscription = fileDiscription;
    }

    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getAbsolutePath().endsWith(fileExtension);
    }

    @Override
    public String getDescription() {
        return fileDiscription + " (.*"+fileExtension+")";
    }
    
    
    

}
