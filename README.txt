Overview
	This is an Android application that processes video game statistics, which was developed for an Object Oriented Design (OOD) graduate class. 
	Users will be able to add and delete video game entries, and view the games in the list, game statistics, and a sorted bar graph of the main time and 100% time of
	the games in the list.

	**Note that this Android application has only been tested on an Android emulator running on Windows 10 and has not been tested on real hardware.**

	Developers: cclay6 and aprey8

Main Menu
	The main menu has the following options: VIEW GAME LIST, ADD A GAME, DELETE A GAME, VIEW
	STATS, and VIEW GRAPH. This is where the user selects most of the different states of the application.
	The options are detailed as follows:
	
	VIEW GAME LIST: The user can view a games list with game names they have added to the list, or an empty list if no
	games have been added.

	ADD A GAME: The user can add a new entry to their games list by entering the following data fields: Name,
	Console, Completed, In Progress, Main Story Time (in hours, minutes, seconds), 100% Time (in Hours,
	Minutes, Seconds), and Year. There is error handling for incomplete data fields.

	Delete a Game: The user can delete an entry from the list by typing in a game name. There is error handling
	for when the user tries to delete from an empty list, as well as if the game name entered is not in the list.
	
	VIEW STATS: The user can view statistics about the games in their list.
	The following statistics are presented to the user: percentage of games completed, percentage of
	games in progress, average main game time, average 100% time, total time main game time, and total 100%
	time.

	VIEW GRAPH: The user can view a graph detailing the time length of the games on the list from shortest to longest. The graph of the
	time length (main or 100%) that is shown to the user is selected in the View Graph menu.

Setup (for emulator)

This is the setup we used when developing the app. It may or may not work with other configurations.

1) Download the IDE 

	Go to https://developer.android.com/studio and download
	Android Studio. When developing this app, we used version 3.3.2 for Windows (64 bit).

2) Configuration settings (could be Windows specific configuration settings)
	These settings can be found by going to the Welcome Menu and left clicking on 
	Configure, and then SDK Manager. Be sure to check the Show Package Details box
	in the SDK Manager menu.
	- SDK Platforms
		- Android 9.0 Pie
		- Android SDK Platform 28
		- Google APIs Intel x86 Atom System Image 
		- Google Play Intel x86 Atom System Image
		
	- SDK Tools
		- Android SDK Build- Tools 29-rc2 version 28.0.3
		- Android Emulator version 28.0.25
		- Android SDK Platform-Tools version 28.0.2
		- Android SDK Tools version 26.1.1
		- Documentation for Android SDK version 1
		- Google Play Services version 49
		- Google USB Driver version 11
		- Intel x86 Emulator Accelerator (HAXM installer) version 7.3.2
		- Constraint Layout for Android version 1.0.2
		- Solver for ConstraintLayout version 1.0.2
		- Android Support Repository version 47.0.0
		- Google Repository version 58

	The emulator settings can be found by going to the Welcome Menu and left clicking on
	Configure, and then AVD Manager. To create a virtual device, click on + Create Virtual
	Device...

	Select Nexus 5X size 5.2 inches, and then next. Select Android Pie API 28 on the recommended
	system image, and then next. Finally, select a name for the device and select finish.

Running the App
	To run the app, select Profile or debug APK from the Welcome Menu.
	Select the file apk-debug from OOD_project folder
	
	In the next screen, select the green play button in the right hand corner next to
	where it says app-debug to run the APK. Then, in the Select Deployment Target Menu,
	select the virtual device you created before and click Ok. Then, the app will run in
	the emulator.

	Hardware testing has not been done. Presumably, you can select an Android device that is
	connected via USB instead of the emulator in the Select Deployment Target Menu.

File Locations
	Some of the deliverable items that were generated for the class are in the OOD_Project folder. 
	This includes the app demonstration video, app-debug apk file, java code (in the java code folder), javadocs (in the gamestats folder; 
	because of the way that Android Studio generates javadocs, the folder can not be renamed or 
	used in a zip folder), and junit tests (in the Junit tests folder). Note that high level design (e.g., UML diagrams, report, and other documentation)
	are not included. Many of these are copies of files that exist elsewhere throughout the directory and have just been stored into a single folder
	for convenience.

	The actual app files in their respective file paths are located at the following directory:
	Video-Game-Statistics > GameStats> app> src

	The main java files are located here: 
	Video-Game-Statistics > GameStats> app>src> main> java> OOD_project> gamestats

	The Junit tests are located here:
	Video-Game-Statistics > GameStats> app>src> test> java> OOD_project> gamestats