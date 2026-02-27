package com.chavvicalc;

import java.util.Scanner;


public class ChavviCalcExampleApp {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    char command = '_';

    // initial stored values
    float valA = 0.0f;
    float valB = 0.0f;

    // keep running until user chooses quit
    while (command != 'q') {
      printMenu(valA, valB);

      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);

      // user enters value for A
      if (command == 'a') {
        System.out.print("Enter a value for A: ");
        try {
          valA = Float.parseFloat(scan.nextLine().trim());
        } catch (NumberFormatException e) {
          System.out.println("ERROR: Entering a non-numerical value is invalid.");
        }
      }

      // user enters value for B
      else if (command == 'b') {
        System.out.print("Enter a value for B: ");
        try {
          valB = Float.parseFloat(scan.nextLine().trim());
        } catch (NumberFormatException e) {
          System.out.println("ERROR: Entering a non-numerical value is invalid.");
        }
      }

      // execute calculator commands (+ - * / c q)
      else {
        valA = executeCommand(command, valA, valB);

        // clear resets both stored values
        if (command == 'c') {
          valB = 0.0f;
        }
      }
    }

    scan.close();
  }

  // prints separator line
  private static void printMenuLine() {
    System.out.println("----------------------------------------------------------");
  }

  // prints one command entry
  private static void printMenuCommand(char command, String text) {
    System.out.printf("%s\t%s\n", command, text);
  }

  // displays calculator menu with current values
  public static void printMenu(float a, float b) {
    printMenuLine();
    System.out.println("Chavvi Calc");
    printMenuLine();

    // show stored values formatted
    System.out.printf("A = %.3f      B = %.3f\n", a, b);

    printMenuLine();
    printMenuCommand('a', "Enter a value for A");
    printMenuCommand('b', "Enter a value for B");
    printMenuCommand('+', "Add");
    printMenuCommand('-', "Subtract");
    printMenuCommand('*', "Multiply");
    printMenuCommand('/', "Divide");
    printMenuCommand('c', "Clear");
    printMenuCommand('q', "Quit");
    printMenuLine();
  }

  // reads first character from user input
  private static char menuGetCommand(Scanner scan) {
    String input = scan.nextLine().toLowerCase();

    if (input.length() > 0) {
      return input.charAt(0);
    }

    return '_';
  }

  // performs selected calculator operation
  private static float executeCommand(char command, float a, float b) {
    float result = a;

    switch (command) {
      case '+':
        result = a + b;
        break;

      case '-':
        result = a - b;
        break;

      case '*':
        result = a * b;
        break;

      case '/':
        if (b == 0) {
          System.out.println("ERROR: Dividing by zero is invalid user input.");
        } else {
          result = a / b;
        }
        break;

      case 'c':
        result = 0.0f;
        break;

      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;

      default:
        System.out.println("ERROR: Unknown command");
    }

    return result;
  }
}