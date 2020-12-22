package co.k42.openrazerlib;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class MouseManager {
    Collection<RazerMouse> mice;
    File razerMouseDir;
    File[] razerMouseDirFolders;

    public MouseManager() {
        mice = new ArrayList<RazerMouse>() {
            {
                add(new RazerMouse(new File("")));
            }
        };
//        System.out.println(mice);
        razerMouseDir = new File("/sys/bus/hid/drivers/razermouse/");
//        System.out.println(razerMouseDir);
        razerMouseDirFolders = razerMouseDir.listFiles();
//        System.out.println(razerMouseDirFolders.length);
    }

    public Collection<RazerMouse> getMice() {
        mice.clear();
        for (int i=0; i < razerMouseDirFolders.length; i++) {
            File file = razerMouseDirFolders[i];
            if (file.isDirectory() &&
                    file.getName().matches("[a-fA-F\\d]{4}:[a-fA-F\\d]{4}:[a-fA-F\\d]{4}\\.[a-fA-F\\d]{4}") &&
                    (new File(file, "device_type")).exists()
            ) {
                mice.add(new RazerMouse(file));
            }
        }
        return mice;
    }

}
