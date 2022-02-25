// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */

  public TalonSRX motorLeft1;
  public TalonSRX motorLeft2; 
  public TalonSRX motorRight1;
  public TalonSRX motorRight2;

  public DrivetrainSubsystem() {
    motorLeft1 = new TalonSRX(19);
    motorLeft2 = new TalonSRX(7);
    motorRight1 = new TalonSRX(16);
    motorRight2 = new TalonSRX(61);

    motorRight1.setInverted(true);
    motorRight2.setInverted(true);
    motorRight2.follow(motorRight1);
    motorLeft1.setInverted(false);
    motorLeft2.setInverted(false);
    motorLeft2.follow(motorLeft1);
  }

  public void setSpeed(TalonSRX motor, double speed){
    motor.set(ControlMode.PercentOutput, speed);
  }

  public void stopMotor(TalonSRX motor){
    setSpeed(motor, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
