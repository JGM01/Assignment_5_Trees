// Name: Jacob Germana-McCray
// Class: CS 3305/Section#04
// Term: Fall 2022
// Instructor: Dr. Majeed
// Assignment: 5

import java.util.Scanner;


/// REMOVE DUPLICATES
///
/// Split a string by spaces, and then input the individual words into a BST. From there,
/// read the BST inOrder to display all words in the input without any duplicates.
public class RemoveDuplicates {
    static BST<String> bst = new BST<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    /* menu()
    *  Standard menu which loops until you exit.
    *  @param - None.
    *  @return - Void.
     */
    static void menu() {
        while (true) {
            System.out.print(
                    "\n---------MAIN MENU---------\n" +
                            "1. Read Input String\n" +
                            "2. Remove Duplicates & Display Outputs\n" +
                            "3. Exit Program\n\n"
            );
            System.out.print("Option: ");
            var choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    bst.clear();
                    System.out.println("Original Text:");
                    var str = sc.nextLine().split(" ");
                    for(var i : (String[]) str)
                        bst.insert(i);
                    break;
                case 2:
                    System.out.println("Processed Text:");
                    bst.inorder();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Exiting Program.");
                    return;
                default:
                    break;
            }
        }
    }
}
