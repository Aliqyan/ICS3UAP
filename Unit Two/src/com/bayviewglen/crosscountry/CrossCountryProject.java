package com.bayviewglen.crosscountry;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossCountryProject {

	public static void main(String[] args) {
		// Declare the scanner, formatter and constant
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("00.000");
		final int SEC_IN_MIN = 60;

		// ---------------------------------------------------------------------------------------------------//
		// Runner #1
		// Ask for name, and split into First and Last names
		System.out.print("Runner 1, \nPlease enter your first and last name: ");
		String name1 = keyboard.nextLine();
		String firstName1 = name1.split(" ")[0];
		String lastName1 = name1.split(" ")[1];

		// Ask for time values
		System.out.print(firstName1 + ", please enter your Mile One Time(mm:ss.sss): ");
		String runner1Mile1 = keyboard.nextLine();

		System.out.print(firstName1 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		String runner1Mile2 = keyboard.nextLine();

		System.out.print(firstName1 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		String runner1FiveKm = keyboard.nextLine();

		// Turn all input values(strings) to minutes (integers), seconds
		// (doubles), and total seconds (doubles)
		int runner1Mile1Min = Integer.parseInt(runner1Mile1.split(":")[0]);
		double runner1Mile1Sec = Double.parseDouble(runner1Mile1.split(":")[1]);
		double runner1Mile1Time = runner1Mile1Min * SEC_IN_MIN + runner1Mile1Sec;

		int runner1Mile2Min = Integer.parseInt(runner1Mile2.split(":")[0]);
		double runner1Mile2Sec = Double.parseDouble(runner1Mile2.split(":")[1]);
		double runner1Mile2Time = runner1Mile2Min * SEC_IN_MIN + runner1Mile2Sec;

		int runner1FiveKmMin = Integer.parseInt(runner1FiveKm.split(":")[0]);
		double runner1FiveKmSec = Double.parseDouble(runner1FiveKm.split(":")[1]);
		double runner1FiveKmTime = runner1FiveKmMin * SEC_IN_MIN + runner1FiveKmSec;

		// Calculate splits - turn split times to minutes and seconds
		// Split 1 is the same as Mile 1
		int runner1Split1Min = (int) (runner1Mile1Time / SEC_IN_MIN);
		double runner1Split1Sec = runner1Mile1Time % SEC_IN_MIN;

		double runner1Split2 = runner1Mile2Time - runner1Mile1Time;
		int runner1Split2Min = (int) (runner1Split2 / SEC_IN_MIN);
		double runner1Split2Sec = runner1Split2 % SEC_IN_MIN;

		double runner1Split3 = runner1FiveKmTime - runner1Mile2Time;
		int runner1Split3Min = (int) (runner1Split3 / SEC_IN_MIN);
		double runner1Split3Sec = runner1Split3 % SEC_IN_MIN;

		// Splits Seconds Formatted
		String runner1Split1SecFormatted = formatter.format(runner1Split1Sec);
		String runner1Split2SecFormatted = formatter.format(runner1Split2Sec);
		String runner1Split3SecFormatted = formatter.format(runner1Split3Sec);

		// Splits Formatted in mm:ss.sss notation
		String runner1Split1Formatted = runner1Split1Min + ":" + runner1Split1SecFormatted;
		String runner1Split2Formatted = runner1Split2Min + ":" + runner1Split2SecFormatted;
		String runner1Split3Formatted = runner1Split3Min + ":" + runner1Split3SecFormatted;

		// Total time - Split into seconds & minutes, then formatted to
		// mm:ss.sss notation
		int runner1FiveKmTimeMin = (int) (runner1FiveKmTime / SEC_IN_MIN);
		double runner1FiveKmTimeSec = runner1FiveKmTime % SEC_IN_MIN;
		String runner1FiveKmTimeSecFormatted = formatter.format(runner1FiveKmTimeSec);
		String runner1FiveKmTimeFormatted = runner1FiveKmTimeMin + ":" + runner1FiveKmTimeSecFormatted;

		// Runner Summary
		System.out.println("\nRunner One Summary");
		System.out.println("****************** \n");
		System.out.println("Runner: " + lastName1 + ", " + firstName1);
		System.out.println("Split One: " + runner1Split1Formatted);
		System.out.println("Split Two: " + runner1Split2Formatted);
		System.out.println("Split Three: " + runner1Split3Formatted);
		System.out.println("Total: " + runner1FiveKmTimeFormatted);

		// ---------------------------------------------------------------------------------------------------//
		// Runner #2
		// Ask for name, and split into First and Last names
		System.out.print("\n\nRunner 2, \nPlease enter your first and last name: ");
		String name2 = keyboard.nextLine();
		String firstName2 = name2.split(" ")[0];
		String lastName2 = name2.split(" ")[1];

		// Ask for time values
		System.out.print(firstName2 + ", please enter your Mile One Time(mm:ss.sss): ");
		String runner2Mile1 = keyboard.nextLine();

		System.out.print(firstName2 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		String runner2Mile2 = keyboard.nextLine();

		System.out.print(firstName2 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		String runner2FiveKm = keyboard.nextLine();

		// Turn all input values(strings) to minutes (integers), seconds
		// (doubles), and total seconds (doubles)
		int runner2Mile1Min = Integer.parseInt(runner2Mile1.split(":")[0]);
		double runner2Mile1Sec = Double.parseDouble(runner2Mile1.split(":")[1]);
		double runner2Mile1Time = runner2Mile1Min * SEC_IN_MIN + runner2Mile1Sec;

		int runner2Mile2Min = Integer.parseInt(runner2Mile2.split(":")[0]);
		double runner2Mile2Sec = Double.parseDouble(runner2Mile2.split(":")[1]);
		double runner2Mile2Time = runner2Mile2Min * SEC_IN_MIN + runner2Mile2Sec;

		int runner2FiveKmMin = Integer.parseInt(runner2FiveKm.split(":")[0]);
		double runner2FiveKmSec = Double.parseDouble(runner2FiveKm.split(":")[1]);
		double runner2FiveKmTime = runner2FiveKmMin * SEC_IN_MIN + runner2FiveKmSec;

		// Calculate splits - turn split times to minutes and seconds
		int runner2Split1Min = (int) (runner2Mile1Time / SEC_IN_MIN);
		double runner2Split1Sec = runner2Mile1Time % SEC_IN_MIN;

		double runner2Split2 = runner2Mile2Time - runner2Mile1Time;
		int runner2Split2Min = (int) (runner2Split2 / SEC_IN_MIN);
		double runner2Split2Sec = runner2Split2 % SEC_IN_MIN;

		double runner2Split3 = runner2FiveKmTime - runner2Mile2Time;
		int runner2Split3Min = (int) (runner2Split3 / SEC_IN_MIN);
		double runner2Split3Sec = runner2Split3 % SEC_IN_MIN;

		// Splits Seconds Formatted
		String runner2Split1SecFormatted = formatter.format(runner2Split1Sec);
		String runner2Split2SecFormatted = formatter.format(runner2Split2Sec);
		String runner2Split3SecFormatted = formatter.format(runner2Split3Sec);

		// Splits Formatted to mm:ss.sss notation
		String runner2Split1Formatted = runner2Split1Min + ":" + runner2Split1SecFormatted;
		String runner2Split2Formatted = runner2Split2Min + ":" + runner2Split2SecFormatted;
		String runner2Split3Formatted = runner2Split3Min + ":" + runner2Split3SecFormatted;

		// Total time - Split into seconds & minutes, then formatted to
		// mm:ss.sss notation
		int runner2FiveKmTimeMin = (int) (runner2FiveKmTime / SEC_IN_MIN);
		double runner2FiveKmTimeSec = runner2FiveKmTime % SEC_IN_MIN;
		String runner2FiveKmTimeSecFormatted = formatter.format(runner2FiveKmTimeSec);
		String runner2FiveKmTimeFormatted = runner2FiveKmTimeMin + ":" + runner2FiveKmTimeSecFormatted;

		// Runner Summary
		System.out.println("\nRunner Two Summary");
		System.out.println("****************** \n");
		System.out.println("Runner: " + lastName2 + ", " + firstName2);
		System.out.println("Split One: " + runner2Split1Formatted);
		System.out.println("Split Two: " + runner2Split2Formatted);
		System.out.println("Split Three: " + runner2Split3Formatted);
		System.out.println("Total: " + runner2FiveKmTimeFormatted);

		// ---------------------------------------------------------------------------------------------------//
		// Runner #3
		// Ask for name, and split into First and Last names
		System.out.print("\n\nRunner 3, \nPlease enter your first and last name: ");
		String name3 = keyboard.nextLine();
		String firstName3 = name3.split(" ")[0];
		String lastName3 = name3.split(" ")[1];

		// Ask for time values
		System.out.print(firstName3 + ", please enter your Mile One Time(mm:ss.sss): ");
		String runner3Mile1 = keyboard.nextLine();

		System.out.print(firstName3 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		String runner3Mile2 = keyboard.nextLine();

		System.out.print(firstName3 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		String runner3FiveKm = keyboard.nextLine();

		// Turn all input values(strings) to minutes (integers), seconds
		// (doubles), and total seconds (doubles)
		int runner3Mile1Min = Integer.parseInt(runner3Mile1.split(":")[0]);
		double runner3Mile1Sec = Double.parseDouble(runner3Mile1.split(":")[1]);
		double runner3Mile1Time = runner3Mile1Min * SEC_IN_MIN + runner3Mile1Sec;

		int runner3Mile2Min = Integer.parseInt(runner3Mile2.split(":")[0]);
		double runner3Mile2Sec = Double.parseDouble(runner3Mile2.split(":")[1]);
		double runner3Mile2Time = runner3Mile2Min * SEC_IN_MIN + runner3Mile2Sec;

		int runner3FiveKmMin = Integer.parseInt(runner3FiveKm.split(":")[0]);
		double runner3FiveKmSec = Double.parseDouble(runner3FiveKm.split(":")[1]);
		double runner3FiveKmTime = runner3FiveKmMin * SEC_IN_MIN + runner3FiveKmSec;

		// Calculate splits - turn split times to minutes and seconds
		int runner3Split1Min = (int) (runner3Mile1Time / SEC_IN_MIN);
		double runner3Split1Sec = runner3Mile1Time % SEC_IN_MIN;

		double runner3Split2 = runner3Mile2Time - runner3Mile1Time;
		int runner3Split2Min = (int) (runner3Split2 / SEC_IN_MIN);
		double runner3Split2Sec = runner3Split2 % SEC_IN_MIN;

		double runner3Split3 = runner3FiveKmTime - runner3Mile2Time;
		int runner3Split3Min = (int) (runner3Split3 / SEC_IN_MIN);
		double runner3Split3Sec = runner3Split3 % SEC_IN_MIN;

		// Splits Seconds Formatted
		String runner3Split1SecFormatted = formatter.format(runner3Split1Sec);
		String runner3Split2SecFormatted = formatter.format(runner3Split2Sec);
		String runner3Split3SecFormatted = formatter.format(runner3Split3Sec);

		// Splits Formatted to mm:ss.sss notation
		String runner3Split1Formatted = runner3Split1Min + ":" + runner3Split1SecFormatted;
		String runner3Split2Formatted = runner3Split2Min + ":" + runner3Split2SecFormatted;
		String runner3Split3Formatted = runner3Split3Min + ":" + runner3Split3SecFormatted;

		// Total time - Split into seconds & minutes, then formatted to
		// mm:ss.sss notation
		int runner3FiveKmTimeMin = (int) (runner3FiveKmTime / SEC_IN_MIN);
		double runner3FiveKmTimeSec = runner3FiveKmTime % SEC_IN_MIN;
		String runner3FiveKmTimeSecFormatted = formatter.format(runner3FiveKmTimeSec);
		String runner3FiveKmTimeFormatted = runner3FiveKmTimeMin + ":" + runner3FiveKmTimeSecFormatted;

		// Runner Summary
		System.out.println("\nRunner Three Summary");
		System.out.println("****************** \n");
		System.out.println("Runner: " + lastName3 + ", " + firstName3);
		System.out.println("Split One: " + runner3Split1Formatted);
		System.out.println("Split Two: " + runner3Split2Formatted);
		System.out.println("Split Three: " + runner3Split3Formatted);
		System.out.println("Total: " + runner3FiveKmTimeFormatted);

		// ---------------------------------------------------------------------------------------------------//
		// Runner #4
		// Ask for name, and split into First and Last names
		System.out.print("\n\nRunner 4, \nPlease enter your first and last name: ");
		String name4 = keyboard.nextLine();
		String firstName4 = name4.split(" ")[0];
		String lastName4 = name4.split(" ")[1];

		// Ask for time values
		System.out.print(firstName4 + ", please enter your Mile One Time(mm:ss.sss): ");
		String runner4Mile1 = keyboard.nextLine();

		System.out.print(firstName4 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		String runner4Mile2 = keyboard.nextLine();

		System.out.print(firstName4 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		String runner4FiveKm = keyboard.nextLine();

		// Turn all input values(strings) to minutes (integers), seconds
		// (doubles), and total seconds (doubles)
		int runner4Mile1Min = Integer.parseInt(runner4Mile1.split(":")[0]);
		double runner4Mile1Sec = Double.parseDouble(runner4Mile1.split(":")[1]);
		double runner4Mile1Time = runner4Mile1Min * SEC_IN_MIN + runner4Mile1Sec;

		int runner4Mile2Min = Integer.parseInt(runner4Mile2.split(":")[0]);
		double runner4Mile2Sec = Double.parseDouble(runner4Mile2.split(":")[1]);
		double runner4Mile2Time = runner4Mile2Min * SEC_IN_MIN + runner4Mile2Sec;

		int runner4FiveKmMin = Integer.parseInt(runner4FiveKm.split(":")[0]);
		double runner4FiveKmSec = Double.parseDouble(runner4FiveKm.split(":")[1]);
		double runner4FiveKmTime = runner4FiveKmMin * SEC_IN_MIN + runner4FiveKmSec;

		// Calculate splits - turn split times to minutes and seconds
		int runner4Split1Min = (int) (runner4Mile1Time / SEC_IN_MIN);
		double runner4Split1Sec = runner4Mile1Time % SEC_IN_MIN;

		double runner4Split2 = runner4Mile2Time - runner4Mile1Time;
		int runner4Split2Min = (int) (runner4Split2 / SEC_IN_MIN);
		double runner4Split2Sec = runner4Split2 % SEC_IN_MIN;

		double runner4Split3 = runner4FiveKmTime - runner4Mile2Time;
		int runner4Split3Min = (int) (runner4Split3 / SEC_IN_MIN);
		double runner4Split3Sec = runner4Split3 % SEC_IN_MIN;

		// Splits Seconds Formatted
		String runner4Split1SecFormatted = formatter.format(runner4Split1Sec);
		String runner4Split2SecFormatted = formatter.format(runner4Split2Sec);
		String runner4Split3SecFormatted = formatter.format(runner4Split3Sec);

		// Splits Formatted to mm:ss.sss notation
		String runner4Split1Formatted = runner4Split1Min + ":" + runner4Split1SecFormatted;
		String runner4Split2Formatted = runner4Split2Min + ":" + runner4Split2SecFormatted;
		String runner4Split3Formatted = runner4Split3Min + ":" + runner4Split3SecFormatted;

		// Total time - Split into seconds & minutes, then formatted to
		// mm:ss.sss notation
		int runner4FiveKmTimeMin = (int) (runner4FiveKmTime / SEC_IN_MIN);
		double runner4FiveKmTimeSec = runner4FiveKmTime % SEC_IN_MIN;
		String runner4FiveKmTimeSecFormatted = formatter.format(runner4FiveKmTimeSec);
		String runner4FiveKmTimeFormatted = runner4FiveKmTimeMin + ":" + runner4FiveKmTimeSecFormatted;

		// Runner Summary
		System.out.println("\nRunner Four Summary");
		System.out.println("****************** \n");
		System.out.println("Runner: " + lastName4 + ", " + firstName4);
		System.out.println("Split One: " + runner4Split1Formatted);
		System.out.println("Split Two: " + runner4Split2Formatted);
		System.out.println("Split Three: " + runner4Split3Formatted);
		System.out.println("Total: " + runner4FiveKmTimeFormatted);

		// ---------------------------------------------------------------------------------------------------//
		// Runner #5
		// Ask for name, and split into First and Last names
		System.out.print("\n\nRunner 5, \nPlease enter your first and last name: ");
		String name5 = keyboard.nextLine();
		String firstName5 = name5.split(" ")[0];
		String lastName5 = name5.split(" ")[1];

		// Ask for time values
		System.out.print(firstName5 + ", please enter your Mile One Time(mm:ss.sss): ");
		String runner5Mile1 = keyboard.nextLine();

		System.out.print(firstName5 + ", please enter your time to the end of the second mile (mm:ss.sss): ");
		String runner5Mile2 = keyboard.nextLine();

		System.out.print(firstName5 + ", please enter your time to the end of the 5 km (mm:ss.sss): ");
		String runner5FiveKm = keyboard.nextLine();

		// Turn all input values(strings) to minutes (integers), seconds
		// (doubles), and total seconds (doubles)
		int runner5Mile1Min = Integer.parseInt(runner5Mile1.split(":")[0]);
		double runner5Mile1Sec = Double.parseDouble(runner5Mile1.split(":")[1]);
		double runner5Mile1Time = runner5Mile1Min * SEC_IN_MIN + runner5Mile1Sec;

		int runner5Mile2Min = Integer.parseInt(runner5Mile2.split(":")[0]);
		double runner5Mile2Sec = Double.parseDouble(runner5Mile2.split(":")[1]);
		double runner5Mile2Time = runner5Mile2Min * SEC_IN_MIN + runner5Mile2Sec;

		int runner5FiveKmMin = Integer.parseInt(runner5FiveKm.split(":")[0]);
		double runner5FiveKmSec = Double.parseDouble(runner5FiveKm.split(":")[1]);
		double runner5FiveKmTime = runner5FiveKmMin * SEC_IN_MIN + runner5FiveKmSec;

		// Calculate splits - turn split times to minutes and seconds
		int runner5Split1Min = (int) (runner5Mile1Time / SEC_IN_MIN);
		double runner5Split1Sec = runner5Mile1Time % SEC_IN_MIN;

		double runner5Split2 = runner5Mile2Time - runner5Mile1Time;
		int runner5Split2Min = (int) (runner5Split2 / SEC_IN_MIN);
		double runner5Split2Sec = runner5Split2 % SEC_IN_MIN;

		double runner5Split3 = runner5FiveKmTime - runner5Mile2Time;
		int runner5Split3Min = (int) (runner5Split3 / SEC_IN_MIN);
		double runner5Split3Sec = runner5Split3 % SEC_IN_MIN;

		// Splits Seconds Formatted
		String runner5Split1SecFormatted = formatter.format(runner5Split1Sec);
		String runner5Split2SecFormatted = formatter.format(runner5Split2Sec);
		String runner5Split3SecFormatted = formatter.format(runner5Split3Sec);

		// Splits Formatted to mm:ss.sss notation
		String runner5Split1Formatted = runner5Split1Min + ":" + runner5Split1SecFormatted;
		String runner5Split2Formatted = runner5Split2Min + ":" + runner5Split2SecFormatted;
		String runner5Split3Formatted = runner5Split3Min + ":" + runner5Split3SecFormatted;

		// Total time - Split into seconds & minutes, then formatted to
		// mm:ss.sss notation
		int runner5FiveKmTimeMin = (int) (runner5FiveKmTime / SEC_IN_MIN);
		double runner5FiveKmTimeSec = runner5FiveKmTime % SEC_IN_MIN;
		String runner5FiveKmTimeSecFormatted = formatter.format(runner5FiveKmTimeSec);
		String runner5FiveKmTimeFormatted = runner5FiveKmTimeMin + ":" + runner5FiveKmTimeSecFormatted;

		// Runner Summary
		System.out.println("\nRunner Five Summary");
		System.out.println("****************** \n");
		System.out.println("Runner: " + lastName5 + ", " + firstName5);
		System.out.println("Split One: " + runner5Split1Formatted);
		System.out.println("Split Two: " + runner5Split2Formatted);
		System.out.println("Split Three: " + runner5Split3Formatted);
		System.out.println("Total: " + runner5FiveKmTimeFormatted);

		// ---------------------------------------------------------------------------------------------------//
		// Runner Table

		// Column indentation
		String format = "%n %15s %20s %20s %20s %20s %20s";

		System.out.println("\nFinal Summary:");
		System.out.printf(format, "Runner Number", "Runner Name", "Split One", "Split Two", "Split Three", "Total");
		System.out.printf(format, "1.", lastName1 + ", " + firstName1, runner1Split1Formatted, runner1Split2Formatted,
				runner1Split3Formatted, runner1FiveKmTimeFormatted);
		System.out.printf(format, "2.", lastName2 + ", " + firstName2, runner2Split1Formatted, runner2Split2Formatted,
				runner2Split3Formatted, runner2FiveKmTimeFormatted);
		System.out.printf(format, "3.", lastName3 + ", " + firstName3, runner3Split1Formatted, runner3Split2Formatted,
				runner3Split3Formatted, runner3FiveKmTimeFormatted);
		System.out.printf(format, "4.", lastName4 + ", " + firstName4, runner4Split1Formatted, runner4Split2Formatted,
				runner4Split3Formatted, runner4FiveKmTimeFormatted);
		System.out.printf(format, "5.", lastName5 + ", " + firstName5, runner5Split1Formatted, runner5Split2Formatted,
				runner5Split3Formatted, runner5FiveKmTimeFormatted);

		// Close the keyboard(Scanner)
		keyboard.close();

	}

}
