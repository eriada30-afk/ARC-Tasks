package task1;

import java.util.ArrayList;
import java.util.Scanner;

public class BatteryManager {
    private ArrayList<Battery> batteryList = new ArrayList<>();

    public void addBattery() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many battaries do you have?: ");
        int batteryNum = input.nextInt();
        input.nextLine();
        System.out.println("Now enter every battery's status and voltage.");
        for(int i = 1 ; i <= batteryNum ; i++){
            System.out.println("\nEnter the details for battery number " + i);
            String status = getStatusFromUser(input);
            double voltage = getVoltageFromUser(input);
            Battery battery = new Battery(status, voltage);
            batteryList.add(battery);
        }
        input.close();
    }

    private String getStatusFromUser(Scanner input) {
        String status = "";
        while(true) {
            System.out.print("The status of the battery (good/fair): ");
            status = input.nextLine().strip();
            if(status.equals("good") || status.equals("fair")) {
                break;
            } else {
                System.out.println(status);
                System.out.println("You must enter 'good' or 'fair' as an answer.");
            }
        }
        return status;
    }

    private double getVoltageFromUser(Scanner input) {
        double voltage = 0;
        while(true) {
            System.out.print("The voltage of the battery: ");
            if (input.hasNextDouble()) {
                voltage = input.nextDouble();
                input.nextLine();
                break;
            } else {
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        }
        return voltage;
    }

    public void printBatteries() {
        System.out.println("\nBatteries:");
        for(int i = 0 ; i < batteryList.size() ; i++) {
            System.out.println("Battery " + (i + 1) + ": " + batteryList.get(i).toString());
        }
    }

    public Battery getBestBattery() {
        int maxIndex = 0;
        for (int i = 0 ; i < batteryList.size() ; i++) {
            double voltage = batteryList.get(i).getVoltage();
            double maxVoltage = batteryList.get(maxIndex).getVoltage();
            if (voltage > maxVoltage) {
                maxIndex = i;
            } else if (voltage == maxVoltage && batteryList.get(i).getStatus().equals("good")) {
                maxIndex = i;
            }
        }
        Battery bestBattery = batteryList.get(maxIndex);
        System.out.println("\nBest Battery: " + bestBattery.toString());
        return bestBattery;
    }
}

