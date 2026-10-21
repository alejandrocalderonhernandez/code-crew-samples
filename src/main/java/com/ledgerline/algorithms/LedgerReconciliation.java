package com.ledgerline.algorithms;

public final class LedgerReconciliation {

    private static final long CENTS_PER_UNIT = 100L;

    private static final long MAX_ABS_CENTS = 100_000_000_000_000L;

    private static final String ACCOUNT_PREFIX = "ACC-";

    private static final int ACCOUNT_DIGITS = 6;

    public static boolean isValidAmount(long cents) {
        return cents >= -MAX_ABS_CENTS && cents <= MAX_ABS_CENTS;
    }

    public static long requireValidAmount(long cents) {
        if (!isValidAmount(cents)) {
            throw new IllegalArgumentException("amount out of range: " + cents);
        }
        return cents;
    }

    public static long sumAmounts(long[] amounts) {
        if (amounts == null) {
            throw new IllegalArgumentException("amounts must not be null");
        }
        long total = 0L;
        for (int i = 0; i < amounts.length; i++) {
            total = Math.addExact(total, requireValidAmount(amounts[i]));
        }
        return total;
    }

    public static boolean isBalanced(long[] amounts) {
        return sumAmounts(amounts) == 0L;
    }

    public static long differenceCents(long expectedCents, long actualCents) {
        return Math.subtractExact(requireValidAmount(actualCents),
                requireValidAmount(expectedCents));
    }

    public static boolean isWithinTolerance(long expectedCents, long actualCents,
            long toleranceCents) {
        if (toleranceCents < 0) {
            throw new IllegalArgumentException("tolerance must not be negative");
        }
        return Math.abs(differenceCents(expectedCents, actualCents)) <= toleranceCents;
    }

    public static boolean isDigitsOnly(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (current < '0' || current > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCurrencyCode(String code) {
        if (code == null || code.length() != 3) {
            return false;
        }
        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            if (current < 'A' || current > 'Z') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidAccountId(String accountId) {
        if (accountId == null || !accountId.startsWith(ACCOUNT_PREFIX)) {
            return false;
        }
        String digits = accountId.substring(ACCOUNT_PREFIX.length());
        return digits.length() == ACCOUNT_DIGITS && isDigitsOnly(digits);
    }

    public static String formatAmount(long cents) {
        long absolute = Math.abs(requireValidAmount(cents));
        String units = Long.toString(absolute / CENTS_PER_UNIT);
        long fraction = absolute % CENTS_PER_UNIT;
        StringBuilder builder = new StringBuilder();
        if (cents < 0) {
            builder.append('-');
        }
        for (int i = 0; i < units.length(); i++) {
            if (i > 0 && (units.length() - i) % 3 == 0) {
                builder.append(',');
            }
            builder.append(units.charAt(i));
        }
        builder.append('.');
        if (fraction < 10) {
            builder.append('0');
        }
        builder.append(fraction);
        return builder.toString();
    }

    public static String formatWithCurrency(long cents, String currencyCode) {
        if (!isValidCurrencyCode(currencyCode)) {
            throw new IllegalArgumentException("invalid currency code: " + currencyCode);
        }
        return currencyCode + " " + formatAmount(cents);
    }

    public static long parseAmount(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("amount text must not be empty");
        }
        boolean negative = text.charAt(0) == '-';
        String body = negative ? text.substring(1) : text;
        int dot = body.indexOf('.');
        String unitsPart = dot < 0 ? body : body.substring(0, dot);
        String fractionPart = dot < 0 ? "00" : body.substring(dot + 1);
        if (!isDigitsOnly(unitsPart) || !isDigitsOnly(fractionPart)
                || fractionPart.length() != 2 || unitsPart.length() > 13) {
            throw new IllegalArgumentException("invalid amount text: " + text);
        }
        long cents = Long.parseLong(unitsPart) * CENTS_PER_UNIT + Long.parseLong(fractionPart);
        return requireValidAmount(negative ? -cents : cents);
    }
}
