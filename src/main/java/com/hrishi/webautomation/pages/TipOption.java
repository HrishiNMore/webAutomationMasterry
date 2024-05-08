package com.hrishi.webautomation.pages;

public enum TipOption {
    NONE("None", 0),
    FIVE_PERCENT("5%", 5),
    TEN_PERCENT("10%", 10),
    FIFTEEN_PERCENT("15%", 15);

    private final String text;
    private final double percentage;

    TipOption(String text, double percentage) {
        this.text = text;
        this.percentage = percentage;
    }

    public String getText() {
        return text;
    }

    public double getPercentage() {
        return percentage;
    }

    public static TipOption getByText(String text) {
        for (TipOption option : TipOption.values()) {
            if (option.text.equalsIgnoreCase(text)) {
                return option;
            }
        }
        return null;
    }
}
