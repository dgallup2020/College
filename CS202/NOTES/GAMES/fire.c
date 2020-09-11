#include <curses.h>
#include <stdlib.h>

void fire();

int width, height;
WINDOW *wnd;

int main() {

	// main initialization (FIRST LINE!)
	wnd = initscr();

	// do not echo text back when a key is typed
	noecho();

	// getch() times out after 150ms
	timeout(150);

	// turn off cursor display
	curs_set(0);

	// enable CTRL + C
	cbreak();

	// turn on colors
	start_color();

	// init color pairs (cannot change 0)
	init_pair(1, COLOR_BLACK, COLOR_WHITE);
	init_pair(2, COLOR_BLACK, COLOR_YELLOW);
	init_pair(3, COLOR_BLACK, COLOR_RED);

	char keyboard = 0;

	// loop until ESC (ASCII 27) is pressed
	while (keyboard != 27) {

		// grab window width and height as it is changed
		getmaxyx(wnd, height, width);

		// clear screen should be BEFORE drawing
		clear();

		// draw fire at col 0, row height-1 width, at 15 characters high
		fire(0, height - 1, width, 15);

		// grab the user input
		// should be BELOW drawing otherwise there will be a flicker!
		keyboard = getch();

		// refresh the screen, should be last line in loop
		refresh();
	}

	// ALWAYS INCLUDE
	endwin();

	return 0;
}

void fire(int x, int y, int w, int h) {

	int i, j, rn;

	// draw fire base
	for (i = 0; i < w; i++) {
	
		// determine a random height for flame column
		rn = (rand() % h) + 3;

		// draw column
		for (j = 0; j < rn; j++) {

			// bottom of the flame should be all 3 colors
			// middle of flame should be yellow and red
			// top should be red
			if (j > rn * 0.5)
				attron(COLOR_PAIR(3));	// draw red if 50% up column
			else if (j > rn * 0.2)
				attron(COLOR_PAIR(2));	// draw yellow at 20%
			else
				attron(COLOR_PAIR(1));	// else draw white

			// embers, draw gaps in flame
			if (rand() % (j + 1) < h * 0.4)	// if the column is 40% up, small chance
							// to disconnect flame
				mvprintw(y - j, x + i, " ");
		}

	}

	return;
}
