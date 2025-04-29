# Horse Racing Simulator

This is a simple Java program that simulates a horse race in the terminal. You can set up your own race, give horses names and symbols, and watch them compete.

## How to Run

1. First, clone the repository (or download the files).
2. Make sure you have Java installed.
3. Open a terminal in the folder where the files are saved.

To compile everything, use this command:

    javac *.java

Then to run the program:

    java Main

## What You Need

This program doesn't use any special libraries, just standard Java. So you don't need to install anything extra.

## How It Works

Once you run the program, it will ask you some questions:

- How long the race track should be (just a number usually between 10 and 40 for short to long races)
- How many lanes there should be
- For each lane, you can give the horse a name, a symbol, and a confidence level between 0 and 1

If you leave the name blank, no horse will be placed in that lane.

The horses will move forward or fall depending on their confidence. If a horse wins, its confidence goes up a bit. If it falls, it goes down slightly.

## Files in the Project

- Main.java - This is where the program starts and where you set up the race.
- Race.java - This handles how the race works, like moving horses and checking who won.
- Horse.java - This defines what a horse is and how it behaves.

That's pretty much it. You can play around with it and change how the race works if you want.
