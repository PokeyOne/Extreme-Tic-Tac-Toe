package ca.pokeyone.tictactoe;

/**
 * A simple container for all constants on the game
 */
public class Constants {
    //General information about the program
    /**
     * The version, in String form, of the program. Incremented with major changes
     */
    public static final String VERSION = "ALPHA 3";
    /**
     * The build number of the program. Should be incremented every build.
     */
    public static final long BUILD = 14L;

    //Window size
    /**
     * The width of the window
     */
    public static final int WIDTH = 800;
    /**
     * The height of the window
     */
    public static final int HEIGHT = 600;

    //State UIDs
    /**
     * Normal exit state UID
     */
    public static final long STATE_UID_EXIT = 1000L;
    /**
     * Abnormal exit state UID
     */
    public static final long STATE_UID_EXIT_ERROR = 1001L;
    /**
     * Loading state UID
     */
    public static final long STATE_UID_LOADING = 0L;
    /**
     * Menu state UID
     */
    public static final long STATE_UID_MENU = 1L;
    /**
     * Play menu state UID
     */
    public static final long STATE_UID_MENU_MODE = 2L;
    /**
     * UID for menu to choose online or AI for 3x3 play
     */
    public static final long STATE_UID_3X3_MENU = 3L;
    /**
     * UID for menu to choose online or AI for 9x9 play
     */
    public static final long STATE_UID_9X9_MENU = 4L;
    /**
     * UID for state to play a 3x3 game against AI
     */
    public static final long STATE_UID_PLAY_AI_3X3 = 5L;
    /**
     * UID for state to play a 3x3 game against AI
     */
    public static final long STATE_UID_PLAY_AI_9X9 = 6L;

    //Image IDs
    /**
     * PokeyOne logo image UID
     */
    public static final String IMAGE_LOGO = "logo";
    /**
     * Game title/logo image UID
     */
    public static final String IMAGE_TITLE = "title";
}
