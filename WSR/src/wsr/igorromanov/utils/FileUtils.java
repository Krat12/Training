package wsr.igorromanov.utils;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;


public class FileUtils {
    
    // получить расширение файла
    public static String getFileExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    // удалить текущий файл-фильтр и установить новый переданный    
    public static void addFileFilter(JFileChooser jfc, FileFilter ff) {
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.setFileFilter(ff);
        jfc.setSelectedFile(new File(""));// удалить последнее имя открываемого/сохраняемого файла
    }

}
