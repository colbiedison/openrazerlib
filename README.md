### openrazerlib<br>

A java library for controlling Razer mice on Linux, built around the [OpenRazer](https://openrazer.github.io/) driver.
<br>
This library has only been tested with my own mouse, a Razer Deathadder Chroma. However, it should work with any Razer mouse suported by OpenRazer.
<br>
<br>
It communicates with OpenRazer by reading from and writing to the device files in `/sys/bus/hid/drivers/razermouse/*:*:*.*`
#### Example usage

![Imgur](https://i.imgur.com/VSSLUyO.png)
<br>
<br>
<br>
The `ColorCycle` class will attempt to cycle the LEDs on the first mouse it finds through red, green, and blue.
```
$ java -cp openrazerlib.jar co.k42.openrazerlib.test.ColorCycle
```