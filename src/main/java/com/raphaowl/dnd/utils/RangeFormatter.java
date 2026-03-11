package com.raphaowl.dnd.utils;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RangeFormatter {

    private static final Pattern DISTANCE_PATTERN =
            Pattern.compile("(\\d+)\\s+(feet|mile|miles)");

    public static String format(String range, Locale locale) {

        boolean pt = locale.getLanguage().equals("pt_br");

        if (range == null) return "";

        range = range.trim();

        switch (range.toLowerCase()) {
            case "self":
                return pt ? "Pessoal" : "Self";
            case "touch":
                return pt ? "Toque" : "Touch";
            case "sight":
                return pt ? "À vista" : "Sight";
            case "special":
                return pt ? "Especial" : "Special";
            case "unlimited":
                return pt ? "Ilimitado" : "Unlimited";
        }

        Matcher matcher = DISTANCE_PATTERN.matcher(range);

        if (matcher.matches()) {

            int value = Integer.parseInt(matcher.group(1));
            String unit = matcher.group(2);

            if (!pt) {
                return range;
            }

            if (unit.startsWith("feet")) {
                double meters = value * 0.3048;
                return Math.round(meters) + " m";
            }

            if (unit.startsWith("mile")) {
                double km = value * 1.60934;
                return String.format("%.1f km", km);
            }
        }

        return range;
    }
}
