package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Arm {
    private final int MOTOR_1_DEVICE_ID = 5;
    private final int MOTOR_2_DEVICE_ID = 6;
    private final double GEAR_RATIO = 10;

    // PID constants can be set to appropriate values
    private double kP = 0.0;
    private double kI = 0.0;
    private double kD = 0.0;
    private double kG = 0.0;

    private TalonFX motor1;
    private TalonFX motor2;

    // These could change according to hardweare design
    private final int MIN_ANGLE = 0;
    private final int MAX_ANGLE = 180;

    public Arm() {
        motor1 = new TalonFX(MOTOR_1_DEVICE_ID);
        motor2 = new TalonFX(MOTOR_2_DEVICE_ID);

        setMotorConfigs();

        motor1.setPosition(0);
        motor2.setPosition(0);
    }

    private void setMotorConfigs() {
        TalonFXConfiguration motorConfig = new TalonFXConfiguration();
        
        motorConfig.Slot0.kP = kP;
        motorConfig.Slot0.kI = kI;
        motorConfig.Slot0.kD = kD;
        motorConfig.Slot0.kG = kG;
        
        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        
        motor1.getConfigurator().apply(motorConfig);
        motor2.getConfigurator().apply(motorConfig);
    }

    // How these two motors are attached to the arm is unknown, 
    // so this is a simple implementation that gets the position for the first motor only.
    public double getAngle() {
        double angle = rotationToDegree(motor1.getPosition().getValueAsDouble());
        return angle;
    }

    // How these two motors are attached to the arm is unknown, 
    // so this is a simple implementation that sets the position for the first motor only.
    public void setAngle(double angle) {
        if (angle > MAX_ANGLE) angle = MAX_ANGLE;
        if (angle < MIN_ANGLE) angle = MIN_ANGLE;

        double rotations = degreeToRotation(angle);
        motor1.setControl(new PositionVoltage(rotations));
    }

    private double degreeToRotation(double angle) {
        double rotations = (angle / 360) * GEAR_RATIO;
        return rotations;
    }

    private double rotationToDegree(double rotations) {
        double angle = (rotations / GEAR_RATIO) * 360;
        return angle;
    }
}