package ca.pokeyone.tictactoe;

/**
 * A simple container for all constants on the game
 */
public class Constants {
    //General information about the program
    /**
     * The version, in String form, of the program.
     */
    public static final String VERSION = "ALPHA 2";
    /**
     * The build number of the program. Should be incremented every build.
     */
    public static final long BUILD = 11L;

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
    public static final long STATE_UID_MENU_PLAY = 2L;

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
