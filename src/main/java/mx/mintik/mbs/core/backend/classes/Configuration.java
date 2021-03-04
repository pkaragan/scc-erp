package mx.mintik.mbs.core.backend.classes;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Configuration {

    private static String ROOT_DIRECTORY = "C:\\mintik\\mbs";
    public static String COMPANY_NAME = "COMPANY NAME";

    public enum Directory {
        ROOT,
        BOM_ITEM_DRAWINGS
    }

    public static String getDirectory(Directory directory) {

        String path;

        switch(directory) {
            case ROOT:
                path = ROOT_DIRECTORY;
                break;

            case BOM_ITEM_DRAWINGS:
                path =  ROOT_DIRECTORY + File.separator + "boms" + File.separator + "drawings";
                break;

            default:
                path = "";
        }

        if(path != "") {
            try {
                File file = new File(path);

                if( !Files.exists(Paths.get(path)) ) {
                    file.mkdirs();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return path;
    }

}


