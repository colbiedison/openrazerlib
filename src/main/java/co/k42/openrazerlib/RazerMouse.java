package co.k42.openrazerlib;

import java.io.File;
import java.io.IOException;

public class RazerMouse {
    public File path;
//    public String device_mode;
//    public String device_serial;
//    public String device_type;
//    public String dpi;
//    public String firmware_version;
//    public String logo_led_brightness;
//    public String logo_led_effect;
//    public String logo_led_rgb;
//    public String logo_led_state;
//    public String modalias;
//    public String poll_rate;
//    public String report_descriptor;
//    public String scroll_led_brightness;
//    public String scroll_led_effect;
//    public String scroll_led_rgb;
//    public String scroll_led_state;
//    public String uevent;
//    public String version;


    public RazerMouse(File _path) {
        path = _path;
    }


    public byte[] getDeviceMode() {
        try {
            return IO.readFile(new File(path, "device_mode"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public String getDeviceSerial() {
        try {
            return new String(IO.readFile(new File(path, "device_serial")));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getDeviceType() {
        try {
            return (new String(IO.readFile(new File(path, "device_type")))).trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public byte[] getDPI() {
        try {
            return IO.readFile(new File(path, "dpi"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public String getFirmwareVersion() {
        try {
            return new String(IO.readFile(new File(path, "firmware_version")));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public byte[] getLogoBrightness() {
        try {
            return IO.readFile(new File(path, "logo_led_brightness"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getLogoEffect() {
        try {
            return IO.readFile(new File(path, "logo_led_effect"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getLogoRGB() {
        try {
            return IO.readFile(new File(path, "logo_led_rgb"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getLogoState() {
        try {
            return IO.readFile(new File(path, "logo_led_state"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public String getModAlias() {
        try {
            return new String(IO.readFile(new File(path, "modalias")));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public byte[] getPollRate() {
        try {
            return IO.readFile(new File(path, "poll_rate"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getReportDescriptor() {
        try {
            return IO.readFile(new File(path, "report_descriptor"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getScrollBrightness() {
        try {
            return IO.readFile(new File(path, "scroll_led_brightness"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getScrollEffect() {
        try {
            return IO.readFile(new File(path, "scroll_led_effect"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getScrollRGB() {
        try {
            return IO.readFile(new File(path, "scroll_led_rgb"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getScrollState() {
        try {
            return IO.readFile(new File(path, "scroll_led_state"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getUEvent() {
        try {
            return IO.readFile(new File(path, "uevent"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public byte[] getVersion() {
        try {
            return IO.readFile(new File(path, "version"));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }



    public void setDeviceMode(String device_mode) {
        try {
            IO.writeFile(new File(path, "device_mode"), device_mode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDpi(int x, int y) {
        try {

            int[] data = {
                    (x & 0xff00) >> 8,
                    (x & 0x00ff),

                    (y & 0xff00) >> 8,
                    (y & 0x00ff)
            };

            IO.writeFile(new File(path, "dpi"), data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogoBrightness(int brightness) {
        if (brightness < 0 || brightness > 255) {
            throw new IllegalArgumentException("value must be in range 0-255");
        }

        try {
            IO.writeFile(new File(path, "logo_led_brightness"), Integer.toString(brightness));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogoEffect(Effect effect) {
        try {
            IO.writeFile(new File(path, "logo_led_effect"), effect.code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogoRGB(int[] rgb) {
        String data = "";
        for (int i = 0; i < rgb.length; i++) {
            data = data+ rgb[i];
        }

        try {
            IO.writeFile(new File(path, "logo_led_rgb"), rgb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogoState(boolean state) {
        try {
            IO.writeFile(new File(path, "logo_led_state"), state ? "1" : "0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setLogoState(int state) {
        try {
            IO.writeFile(new File(path, "logo_led_state"), (state != 0) ? "1" : "0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPollRate(String poll_rate) {

    }

    public void setScrollBrightness(int brightness) {
        if (brightness < 0 || brightness > 255) {
            throw new IllegalArgumentException("value must be in range 0-255");
        }

        try {
            IO.writeFile(new File(path, "scroll_led_brightness"), Integer.toString(brightness));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScrollEffect(Effect effect) {
        try {
            IO.writeFile(new File(path, "scroll_led_effect"), effect.code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScrollRGB(int[] rgb) {
        String data = "";
        for (int i = 0; i < rgb.length; i++) {
            data = data+ rgb[i];
        }

        try {
            IO.writeFile(new File(path, "scroll_led_rgb"), rgb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScrollState(boolean state) {
        try {
            IO.writeFile(new File(path, "scroll_led_state"), state ? "1" : "0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setScrollState(int state) {
        try {
            IO.writeFile(new File(path, "scroll_led_state"), (state != 0) ? "1" : "0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
