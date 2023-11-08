package utils;

import java.util.Scanner;

public class CarRentalProject {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Введите сумму автомобиля");
        int totalAmount = scanner.nextInt();
        System.out.println("Введите сумму депозита");
        int downPayment = scanner.nextInt();
        int leftAmount = totalAmount-downPayment;
        int totalSpent = 0;
        int months=0;
        for (int x=1; leftAmount>0 ; x++){

            System.out.println("Месяц "+ x + ". \nВаш аренда состовляет: " + leftAmount/10 +"\nВаш остаток: "+leftAmount);
            totalSpent+=leftAmount/10;
            System.out.println("Введите сумму погашения:");
            int step = scanner.nextInt();
            leftAmount=leftAmount-step;
            months++;
        }
        System.out.println(totalSpent+" Переплата");
        System.out.println(months+" месяцев оплачивал");







    }
}
