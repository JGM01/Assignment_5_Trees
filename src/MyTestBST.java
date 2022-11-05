// Name: Jacob Germana-McCray
// Class: CS 3305/Section#04
// Term: Fall 2022
// Instructor: Dr. Majeed
// Assignment: 5

import java.util.Scanner;

public class MyTestBST {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        menu(buildBST());
    }

    /* Input(String msg)
    *  Allows me to get inputs without rewriting parses.
    *
    *  @param - String msg: The input prompt to be displayed.
    *  @return - Object: If the input is numeric, it will be turned to an Integer,
    *            if not, it will return as a String Object.
     */
    static Object input (String msg) {
        System.out.print(msg);
        var data = scan.next();
        if (data.chars().allMatch(Character::isDigit))
            return Integer.parseInt(data);
        else
            return data;
    }

    /* buildBST()
    *  Assigns a data-type to the generic BST, decided via user input.
    *
    *  @param - None.
    *  @return - A new instance of a BST. Either Integer or String.
     */
    static BST buildBST() {
        if ((int)input("What data type would you like for your tree? (0 - Int | 1 - String): ") == 0) {
            return new BST<Integer>();
        }
        return new BST<String>();
    }

    /* Menu(BST bst)
    *  Standard menu prompt, keeps you in loop until you exit. This is where the user can
    *  use the implementations of the BST.
    *
    *  @param - BST bst: The BST generated from the buildBST() method, called from main().
    *  @return - void.
     */
    static void menu(BST bst) {
        while (true) {
            System.out.print(
                    "\n---------MAIN MENU---------\n" +
                            "1. Insert Data Element\n" +
                            "2. Delete Data Element\n" +
                            "3. Search for Data Element\n" +
                            "4. Print Tree Size\n" +
                            "5. Path from Root to Data Element\n" +
                            "6. Check if Empty Tree\n" +
                            "7. Print Preorder Traversal\n" +
                            "8. Print Inorder Traversal\n" +
                            "9. Print Postorder Traversal\n" +
                            "10. Exit Program\n\n"
            );
            Object data;
            var choice = (int)input("Enter Option Number: ");
            switch (choice) {
                case 1:
                    data = input("Input data to insert into the tree: ");
                    System.out.print("BST before adding " + (Comparable) data + ": ");
                    bst.inorder();
                    System.out.println();
                    bst.insert((Comparable) data);
                    System.out.print("BST after adding " + (Comparable) data + ": ");
                    bst.inorder();
                    System.out.println();
                    break;
                case 2:
                    data = input("Input data to delete from the tree: ");
                    System.out.print("BST before removing " + (Comparable) data + ": ");
                    bst.inorder();
                    System.out.println();
                    bst.delete((Comparable) data);
                    System.out.print("BST after deleting " + (Comparable) data + ": ");
                    bst.inorder();
                    System.out.println();
                    break;
                case 3:
                    data = input("Item to search for: ");
                    System.out.println(bst.search((Comparable) data));
                    break;
                case 4:
                    System.out.println("BST is " + bst.size);
                    break;
                case 5:
                    data = input("Item to create path to: ");
                    for(var x : bst.path((Comparable) data))
                        System.out.print(x.toString() + " ");
                    System.out.println();
                    break;
                case 6:
                    System.out.println(bst.isEmpty()? "BST is Empty." : "BST is not Empty.");
                    break;
                case 7:
                    bst.preorder();
                    break;
                case 8:
                    bst.inorder();
                    break;
                case 9:
                    bst.postorder();
                    break;
                case 10:
                    System.out.println("Exiting Program.");
                    return;
                default:
                    break;
            }
        }
    }

}