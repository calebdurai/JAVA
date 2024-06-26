//server
#include <stdio.h> 
#include <netdb.h> 
#include <netinet/in.h> 
#include <stdlib.h> 
#include <string.h> 
#include <sys/socket.h> 
#include <sys/types.h> 
#include <unistd.h> 
#define MAX 80 
#define PORT 8080 
#define SA struct sockaddr 
   
void func(int connfd) 
{ 
    char buff[MAX]; 
    int n; 
    for (;;) { 
        bzero(buff, MAX); 
    
        read(connfd, buff, sizeof(buff)); 
        printf("From client: %s\t To client : ", buff); 
        bzero(buff, MAX); 
        n = 0; 
        // copy server message in the buffer 
        while ((buff[n++] = getchar()) != '\n') 
            ; 
   
        // and send that buffer to client 
        write(connfd, buff, sizeof(buff)); 
   
        // if msg contains "Exit" then server exit and chat ended. 
        if (strncmp("exit", buff, 4) == 0) { 
            printf("Server Exit...\n"); 
            break; 
        } 
    } 
} 
   
// Driver function 
int main() 
{ 
    int sockfd, connfd, len; 
    struct sockaddr_in servaddr, cli; 
   
    // socket create and verification 
    sockfd = socket(AF_INET, SOCK_STREAM, 0); 
    if (sockfd == -1) { 
        printf("socket creation failed...\n"); 
        exit(0); 
    } 
    else
        printf("Socket successfully created..\n"); 
    bzero(&servaddr, sizeof(servaddr)); 
   
    // assign IP, PORT 
    servaddr.sin_family = AF_INET; 
    servaddr.sin_addr.s_addr = htonl(INADDR_ANY); 
    servaddr.sin_port = htons(PORT); 
   
    // Binding newly created socket to given IP and verification 
    if ((bind(sockfd, (SA*)&servaddr, sizeof(servaddr))) != 0) { 
        printf("socket bind failed...\n"); 
        exit(0); 
    } 
    else
        printf("Socket successfully binded..\n"); 
   
    // Now server is ready to listen and verification 
    if ((listen(sockfd, 5)) != 0) { 
        printf("Listen failed...\n"); 
        exit(0); 
    } 
    else
        printf("Server listening..\n"); 
    len = sizeof(cli); 
   
    // Accept the data packet from client and verification 
    connfd = accept(sockfd, (SA*)&cli, &len); 
    if (connfd < 0) { 
        printf("server accept failed...\n"); 
        exit(0); 
    } 
    else
        printf("server accept the client...\n"); 
   
    // Function for chatting between client and server 
    func(connfd); 
   
    // After chatting close the socket 
    close(sockfd); 
}

//client
#include <arpa/inet.h> // inet_addr()
#include <netdb.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h> // bzero()
#include <sys/socket.h>
#include <unistd.h> // read(), write(), close()
#define MAX 80
#define PORT 8080
#define SA struct sockaddr
void func(int sockfd)
{
    char buff[MAX];
    int n;
    for (;;) {
        bzero(buff, sizeof(buff));
        printf("Enter the string : ");
        n = 0;
        while ((buff[n++] = getchar()) != '\n')
            ;
        write(sockfd, buff, sizeof(buff));
        bzero(buff, sizeof(buff));
        read(sockfd, buff, sizeof(buff));
        printf("From Server : %s", buff);
        if ((strncmp(buff, "exit", 4)) == 0) {
            printf("Client Exit...\n");
            break;
        }
    }
}
 
int main()
{
    int sockfd, connfd;
    struct sockaddr_in servaddr, cli;
 
    // socket create and verification
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd == -1) {
        printf("socket creation failed...\n");
        exit(0);
    }
    else
        printf("Socket successfully created..\n");
    bzero(&servaddr, sizeof(servaddr));
 
    // assign IP, PORT
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = inet_addr("127.0.0.1");
    servaddr.sin_port = htons(PORT);
 
    // connect the client socket to server socket
    if (connect(sockfd, (SA*)&servaddr, sizeof(servaddr))
        != 0) {
        printf("connection with the server failed...\n");
        exit(0);
    }
    else
        printf("connected to the server..\n");
 
    // function for chat
    func(sockfd);
 
    // close the socket
    close(sockfd);
}


import java.util.Scanner;

public class palin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int reverse = 0;
        int original = number;

        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }

        System.out.println("Reversed number: " + reverse);

        if (original == reverse) {
            System.out.println(original + " is a palindrome number.");
        } else {
            System.out.println(original + " is not a palindrome number.");
        }
    }
}


public class 2waymultable {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base number:");
        double base = scanner.nextDouble();

        System.out.println("Enter the power:");
        int power = scanner.nextInt();

        double result = 1;
        int count = 0;
        while (count < power) {
            result *= base;
            count++;
        }

        System.out.println(base + " raised to the power of " + power + " is: " + result);
    }
}

import java.util.Scanner;

public class KrishnamoorthyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        if (isKrishnamoorthy(number)) {
            System.out.println(number + " is a Krishnamoorthy number.");
        } else {
            System.out.println(number + " is not a Krishnamoorthy number.");
        }
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static boolean isKrishnamoorthy(int num) {
        int originalNumber = num;
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }

        return sum == originalNumber;
    }
}



import java.util.Scanner;

public class KrishnamoorthyNumbersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the starting number of the range:");
        int start = scanner.nextInt();

        System.out.println("Enter the ending number of the range:");
        int end = scanner.nextInt();

        System.out.println("Krishnamoorthy numbers within the range:");
        for (int i = start; i <= end; i++) {
            if (isKrishnamoorthy(i)) {
                System.out.println(i);
            }
        }
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static boolean isKrishnamoorthy(int num) {
        int originalNumber = num;
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }

        return sum == originalNumber;
    }
}



import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of terms:");
        int n = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }

        System.out.println("Sum of the series (1+3+5+...+" + n + " terms) is: " + sum);
    }
}


import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of terms:");
        int n = scanner.nextInt();

        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (double) i / (2 * i + 1);
        }

        System.out.println("Sum of the series (1/3 + 2/5 + 3/7 + ... +" + n + " terms) is: " + sum);
    }
}


import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of x:");
        double x = scanner.nextDouble();

        System.out.println("Enter the number of terms:");
        int n = scanner.nextInt();

        double sum = 0;
        for (int i = 0; i < n; i++) {
            int power = 2 * i + 1;
            double term = Math.pow(x, power) * (i % 2 == 0 ? 1 : -1);
            sum += term;
        }

        System.out.println("Sum of the series (x - x^3 + x^5 - x^7 + ... +" + n + " terms) is: " + sum);
    }
}


import java.util.Scanner;

public class SineSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the value of x in radians:");
        double x = scanner.nextDouble();

        System.out.println("Enter the number of terms:");
        int n = scanner.nextInt();

        double sum = 0;
        int sign = 1;
        for (int i = 0; i < n; i++) {
            int power = 2 * i + 1;
            double term = Math.pow(x, power) / factorial(power) * sign;
            sum += term;
            sign *= -1;
        }

        System.out.println("Sine series value for x = " + x + " with " + n + " terms is: " + sum);
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            int fact = 1;
            for (int i = 2; i <= num; i++) {
                fact *= i;
            }
            return fact;
        }
    }
}


import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        boolean isPrime = isPrime(number);

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the lower limit:");
        int lowerLimit = scanner.nextInt();

        System.out.println("Enter the upper limit:");
        int upperLimit = scanner.nextInt();

        System.out.println("Prime numbers within the range " + lowerLimit + " to " + upperLimit + ":");
        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


import java.util.Scanner;

public class HollowSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the square:");
        int size = scanner.nextInt();

        for (int i = 1; i <= size; i++) {
            System.out.print("* ");
        }
        System.out.println();

        for (int i = 2; i <= size - 1; i++) {
            System.out.print("* ");
            for (int j = 2; j <= size - 1; j++) {
                System.out.print("  ");
            }
            System.out.println("*");
        }

        if (size > 1) {
            for (int i = 1; i <= size; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class RightHalfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class LeftHalfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  "); // Print spaces
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* "); // Print asterisks
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class FullPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            for (int l = i - 1; l >= 1; l--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class InvertedRightHalfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  "); // Print spaces
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* "); // Print asterisks
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class InvertedLeftHalfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        for (int i = rows; i >= 1; i--) {
            for (int j = i; j < rows; j++) {
                System.out.print("  "); // Print spaces
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("* "); // Print asterisks
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class InvertedPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        for (int i = rows; i >= 1; i--) {
            for (int j = i; j < rows; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class FloydsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        int number = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();

        System.out.println("Enter the operation (+, -, *, /):");
        char operator = scanner.next().charAt(0);

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
        }
    }
}


import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of the day (1 for Monday, 2 for Tuesday, ..., 7 for Sunday):");
        int dayNumber = scanner.nextInt();

        String day;
        switch (dayNumber) {
            case 1:
                day = "Monday";
                break;
            case 2:
                day = "Tuesday";
                break;
            case 3:
                day = "Wednesday";
                break;
            case 4:
                day = "Thursday";
                break;
            case 5:
                day = "Friday";
                break;
            case 6:
                day = "Saturday";
                break;
            case 7:
                day = "Sunday";
                break;
            default:
                day = "Invalid day number";
        }

        System.out.println("Day of the week: " + day);
    }
}


import java.util.Scanner;

public class ArmstrongNumberSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to check if it's Armstrong:");
        int number = scanner.nextInt();
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        switch (sum == originalNumber ? 1 : 0) {
            case 1:
                System.out.println(originalNumber + " is an Armstrong number.");
                break;
            case 0:
                System.out.println(originalNumber + " is not an Armstrong number.");
                break;
        }
    }
}


import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to calculate its factorial:");
        int number = scanner.nextInt();
        int factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}


import java.util.Scanner;

public class TwoNumEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        switch (num1 == num2 ? 1 : 0) {
            case 1:
                System.out.println("The two numbers are equal.");
                break;
            case 0:
                System.out.println("The two numbers are not equal.");
                break;
        }
    }
}

import java.util.Scanner;

public class CheckPrimeSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number to check if it's prime:");
        int number = scanner.nextInt();
        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        switch (isPrime ? 1 : 0) {
            case 1:
                System.out.println(number + " is a prime number.");
                break;
            case 0:
                System.out.println(number + " is not a prime number.");
                break;
        }
    }
}


import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of the matrices:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sum = new int[rows][cols];

        System.out.println("Enter the elements of first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Adding matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Sum of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class MatrixSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of the matrices:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] difference = new int[rows][cols];

        System.out.println("Enter the elements of first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Subtracting matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                difference[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        System.out.println("Difference of matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(difference[i][j] + " ");
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of the first matrix:");
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();

        System.out.println("Enter the number of rows and columns of the second matrix:");
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();

        if (cols1 != rows2) {
            System.out.println("Multiplication not possible!");
            return;
        }

        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] product = new int[rows1][cols2];

        System.out.println("Enter the elements of first matrix:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of second matrix:");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Multiplying matrices
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Product of matrices:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class MatrixTranspose {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns of the matrix:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        int[][] transpose = new int[cols][rows];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Transposing the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose of the matrix:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }
    }
}


import java.sql.*;

public class DatabaseConnectivity {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Establish connection to the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            System.out.println("Connected to the database.");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query
            String sqlQuery = "SELECT * FROM mytable";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Process the result set
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Display the data
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


import java.sql.*;

public class MultipleQueriesExample {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Establish connection to the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            System.out.println("Connected to the database.");

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute multiple queries
            String[] queries = {
                "SELECT * FROM employees", // Select all records from employees table
                "INSERT INTO employees (name, age) VALUES ('John', 30)", // Insert a new employee
                "UPDATE employees SET age = 31 WHERE name = 'John'", // Update John's age
                "DELETE FROM employees WHERE name = 'John'" // Delete John's record
            };

            for (String query : queries) {
                boolean isResultSet = statement.execute(query);

                if (isResultSet) {
                    // If the result is a ResultSet, process it
                    ResultSet resultSet = statement.getResultSet();
                    while (resultSet.next()) {
                        // Process the result set
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                    }
                } else {
                    // If the result is not a ResultSet, print the update count
                    int updateCount = statement.getUpdateCount();
                    System.out.println("Query executed, update count: " + updateCount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package project1;
import java.sql.*;
import java.util.*;

public class sui {
	public static void main(String[] args) {
		final String URL="jdbc:mysql://localhost:3306/msc";
		final String US="root";
		final String PS="";
		try(Connection conn= DriverManager.getConnection(URL,US,PS);Scanner scan=new Scanner(System.in);){
			while(true) {
			System.out.println("MENU");
			System.out.println("insert");
			System.out.println("update");
			System.out.println("delete");
			System.out.println("select");
			System.out.println("exit");
			System.out.println("option:");
			int opt=scan.nextInt();
			scan.nextLine();
			
				switch(opt) {
				case 1:
					insert(conn,scan);
					break;
				case 2:
					update(conn,scan);
					break;
				case 3:
					delete(conn,scan);
					break;
				case 4:
					select(conn);
					break;
				case 5:
					System.out.println("exited!");
					return;
				default:
					System.out.println("invalid");
				}
			}
		}
		catch(SQLException e) {
		e.printStackTrace();
		}
	}
		
			private static void insert(Connection conn,Scanner scan) throws SQLException {
				

		        System.out.println("Enter gname:");
		        String name = scan.nextLine();
		        System.out.println("Enter gid:");
		        int id = scan.nextInt();

		        String sql = "INSERT INTO genres (Genre_ID,Genre_Name) VALUES (?, ?)";
		        try (PreparedStatement statement = conn.prepareStatement(sql)) {
		            statement.setInt(1, id);
		            statement.setString(2, name);
		            int rowsInserted = statement.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("Record inserted successfully.");
		            } else {
		                System.out.println("Failed to insert record.");
		            }
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			private static void update(Connection conn,Scanner scan) throws SQLException{
				
				System.out.println("gname");
				String name=scan.nextLine();
				System.out.println("gid:");
				int id=scan.nextInt();
				String sql="UPDATE genres SET Genre_ID=? WHERE Genre_Name=?";
				try(PreparedStatement stmt=conn.prepareStatement(sql);){
					stmt.setInt(1, id);
					stmt.setString(2, name);
					int rowsUpdated=stmt.executeUpdate();
					if(rowsUpdated>0) {
						System.out.println("succes");
					}
					else {
						System.out.println("fail");
					}
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			private static void delete(Connection conn,Scanner scan) throws SQLException{
				System.out.println("regno:");
				int id=scan.nextInt();
				String sql="DELETE from genres WHERE Genre_ID=?";
				try(PreparedStatement stmt=conn.prepareStatement(sql);){
					stmt.setInt(1, id);
					int rowdel=stmt.executeUpdate();
					if(rowdel>0) {
						System.out.println("succes");
					}
					else {
						System.out.println("fail");
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			private static void select(Connection conn) throws SQLException {
				String sql="SELECT * FROM genres";
				try(Statement stmt=conn.createStatement(); ResultSet rs=stmt.executeQuery(sql);){
					while(rs.next()) {
						int id=rs.getInt("Genre_ID");
						String name=rs.getString("Genre_Name");
						System.out.println("id: "+id+"name :"+name);
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " sorted integers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search for: ");
        int target = scanner.nextInt();

        int result = binarySearch(array, target);
        if (result == -1) {
            System.out.println("Number not found.");
        } else {
            System.out.println("Number found at index: " + result);
        }
    }

    public static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}



import java.util.*;
public class bublesort {
	
	public static void main(String [] args) {
		Scanner scan=new Scanner(System.in);
		int [] arr=new int[10];
		System.out.println("enter array:");
		for(int i=0;i<10;i++) {
			arr[i]=scan.nextInt();
		}
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				int temp;
				if(arr[j]>arr[j+1]) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i=0;i<10;i++) {
			System.out.println(arr[i]);
		}
	}
}

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search for: ");
        int target = scanner.nextInt();

        int index = linearSearch(array, target);
        if (index != -1) {
            System.out.println("Number found at index: " + index);
        } else {
            System.out.println("Number not found.");
        }
    }

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; 
            }
        }
        return -1; 
    }
}


