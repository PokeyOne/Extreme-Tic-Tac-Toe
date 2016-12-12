package ca.pokeyone.tictactoe;

/**
 * A simple container for all constants on the game
 */
public class Constants {
    //General information about the program
    public static final String VERSION = "ALPHA 2";
    public static final long BUILD = 9L;

    //Window size
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    //State UIDs
    public static final long STATE_UID_EXIT = 1000L;
    public static final long STATE_UID_EXIT_ERROR = 1001L;
    public static final long STATE_UID_LOADING = 0L;
    public static final long STATE_UID_MENU = 1L;
    public static final long STATE_UID_MENU_PLAY = 2L;

    //Image IDs
    public static final String IMAGE_LOGO = "logo";
    public static final String IMAGE_TITLE = "title";
}
