package co.k42.openrazerlib.test;


import co.k42.openrazerlib.Effect;
import co.k42.openrazerlib.MouseManager;
import co.k42.openrazerlib.RazerMouse;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class ColorCycle {

    public static void main(String[] args) {
        MouseManager mouseManager = new MouseManager();
        Collection<RazerMouse> mice = mouseManager.getMice();
        Iterator<RazerMouse> mouseIterator = mice.iterator();
        RazerMouse mouse = mouseIterator.next();

        mouse.setScrollEffect(Effect.SOLID_COLOR);

        try {
            mouse.setLogoRGB(new int[] {255,0,0});
            mouse.setScrollRGB(new int[] {255,0,0});
            Thread.sleep(2000);
            mouse.setLogoRGB(new int[] {0,255,0});
            mouse.setScrollRGB(new int[] {0,255,0});
            Thread.sleep(2000);
            mouse.setLogoRGB(new int[] {0,0,255});
            mouse.setScrollRGB(new int[] {0,0,255});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
