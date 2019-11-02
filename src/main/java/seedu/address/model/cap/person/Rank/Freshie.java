package seedu.address.model.cap.person.Rank;

import seedu.address.model.cap.person.DegreeClassification;

public class Freshie extends Rank {

    private static final String TITLE = "FRESHIE";
    private static final double MAXIMUM_CAP = 0.0;
    private static final double MINIMUM_CAP = 0.0;
    private static final String imageFilePath = "/images/freshie.png";

    public Freshie() {
        super(DegreeClassification.FRESHIE, TITLE);
    }

    public static double getMaximumCap() {
        return MAXIMUM_CAP;
    }

    public static double getMinimumCap() {
        return MINIMUM_CAP;
    }

    @Override
    public String getRankImageFilePath() {
        return imageFilePath;
    }

    public static boolean isWithinRange(double cap) {
        if (cap > MAXIMUM_CAP && cap < MINIMUM_CAP) {
            return true;
        } else {
            return false;
        }
    }
}