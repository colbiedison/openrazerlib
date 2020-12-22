package co.k42.openrazerlib;

public enum Effect {
    SOLID_COLOR ("0"),
    BLINK       ("1"),
    BREATHE     ("2"),
    FREEZE      ("3"),
    SPECTRUM    ("4")
    ;

    public final String code;

    Effect(String mode) {
        this.code = mode;
    }
}
