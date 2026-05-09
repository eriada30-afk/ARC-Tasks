package task1;

import java.util.ArrayList;


public class BatteryManager {
    private ArrayList<Battery> batteryList = new ArrayList<>();
    private Battery bestBattery;

    public void addBattery() {
        int batteryNum = 0;
        while (batteryNum < 2) {
            System.out.println("\nThe number of batteries must be minimum 2. ");
            System.out.print("How many battaries do you have?: ");
            if (InputScanner.scanner.hasNextInt()) {
                batteryNum = InputScanner.scanner.nextInt();
                InputScanner.scanner.nextLine();
            } else {
                System.out.println("Please enter a valid number.");
                InputScanner.scanner.nextLine();
            }
        }
        System.out.println("Now enter every battery's status and voltage.");
        for(int i = 1 ; i <= batteryNum ; i++){
            System.out.println("\nEnter the details for battery number " + i);
            String status = getStatusFromUser();
            double voltage = getVoltageFromUser();
            Battery battery = new Battery(status, voltage);
            batteryList.add(battery);
        }
    }

    private String getStatusFromUser() {
        String status = "";
        while(true) {
            System.out.print("The status of the battery (good/fair): ");
            status = InputScanner.scanner.nextLine().strip();
            if(status.equals("good") || status.equals("fair")) {
                break;
            } else {
                System.out.println(status);
                System.out.println("You must enter 'good' or 'fair' as an answer.");
            }
        }
        return status;
    }

    private double getVoltageFromUser() {
        double voltage = 0;
        while(true) {
            System.out.print("The voltage of the battery: ");
            if (InputScanner.scanner.hasNextDouble()) {
                voltage = InputScanner.scanner.nextDouble();
                InputScanner.scanner.nextLine();
                break;
            } else {
                System.out.println("Please enter a valid number.");
                InputScanner.scanner.nextLine();
            }
        }
        return voltage;
    }

    // 
    public void printBatteries() {
        System.out.println("\nBatteries:");
        for(int i = 0 ; i < batteryList.size() ; i++) {
            System.out.println("Battery " + (i + 1) + ": " + batteryList.get(i).toString());
        }
    }

    // Finds the best battery by checking the batteries voltage and picks the one that is closer to 13
    // if both are equal it checks their status and picks the better one
    public void findBestBattery() {
        int bestIndex = 0;
        for (int i = 0 ; i < batteryList.size() ; i++) {
            double voltage = batteryList.get(i).getVoltage();
            double bestVoltage = batteryList.get(bestIndex).getVoltage();
            if ((Math.abs(voltage-13)) < (Math.abs(bestVoltage-13))) {
                bestIndex = i;
            } else if (voltage == bestVoltage && batteryList.get(i).getStatus().equals("good")) {
                bestIndex = i;
            }
        }
        Battery bestBattery = batteryList.get(bestIndex);
        System.out.println("\nBest Battery(" + (bestIndex + 1) + "): " + bestBattery.toString());
        this.bestBattery = bestBattery;
        // return bestBattery;
    }

    // Returns the best battery
    public Battery getBestBattery() {
        return this.bestBattery;
    }
}

