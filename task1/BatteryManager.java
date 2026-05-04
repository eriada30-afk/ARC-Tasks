package task1;

import java.util.ArrayList;


public class BatteryManager {
    private ArrayList<Battery> batteryList = new ArrayList<>();
    private Battery bestBattery;

    public void addBattery() {
        System.out.print("How many battaries do you have?: ");
        int batteryNum = InputScanner.scanner.nextInt();
        InputScanner.scanner.nextLine();
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

    public void printBatteries() {
        System.out.println("\nBatteries:");
        for(int i = 0 ; i < batteryList.size() ; i++) {
            System.out.println("Battery " + (i + 1) + ": " + batteryList.get(i).toString());
        }
    }

    public void findBestBattery() {
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
        System.out.println("\nBest Battery(" + (maxIndex + 1) + "): " + bestBattery.toString());
        this.bestBattery = bestBattery;
        // return bestBattery;
    }

    public Battery getBestBattery() {
        return this.bestBattery;
    }
}

