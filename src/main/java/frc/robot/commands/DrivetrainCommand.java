// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DrivetrainCommand extends CommandBase {
  /** Creates a new DrivetrainCommand. */

  DrivetrainSubsystem drivetrain;

  public DrivetrainCommand(DrivetrainSubsystem drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // drivetrain.stopMotor(drivetrain.motorLeft1);
    // drivetrain.stopMotor(drivetrain.motorLeft2);
    // drivetrain.stopMotor(drivetrain.motorRight1);
    // drivetrain.stopMotor(drivetrain.motorRight2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


    if(RobotContainer.getDrive()!=0){
      double speed = 0.2;
      drivetrain.setSpeed(drivetrain.motorLeft1, speed);
      drivetrain.setSpeed(drivetrain.motorLeft2, speed);
      drivetrain.setSpeed(drivetrain.motorRight1, speed);
      drivetrain.setSpeed(drivetrain.motorRight2, speed);
    }
    else
    {
      drivetrain.stopMotor(drivetrain.motorLeft1);
      drivetrain.stopMotor(drivetrain.motorLeft2);
      drivetrain.stopMotor(drivetrain.motorRight1);
      drivetrain.stopMotor(drivetrain.motorRight2);
    }

    
    if(RobotContainer.getTurn()>0){
      double speed = 0.2;
      drivetrain.setSpeed(drivetrain.motorLeft1, speed);
      drivetrain.setSpeed(drivetrain.motorLeft2, speed);
      drivetrain.setSpeed(drivetrain.motorRight1, -speed);
      drivetrain.setSpeed(drivetrain.motorRight2, -speed);
    }
    else if(RobotContainer.getTurn()<0){
      double speed = 0.2;
      drivetrain.setSpeed(drivetrain.motorLeft1, -speed);
      drivetrain.setSpeed(drivetrain.motorLeft2, -speed);
      drivetrain.setSpeed(drivetrain.motorRight1, speed);
      drivetrain.setSpeed(drivetrain.motorRight2, speed);
    }
    else
    {
      drivetrain.stopMotor(drivetrain.motorLeft1);
      drivetrain.stopMotor(drivetrain.motorLeft2);
      drivetrain.stopMotor(drivetrain.motorRight1);
      drivetrain.stopMotor(drivetrain.motorRight2);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
