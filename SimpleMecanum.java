package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp
public class SimpleMecanum extends OpMode {
    
    public DcMotorEx topLeft;
    public DcMotorEx botLeft;
    public DcMotorEx topRight;
    public DcMotorEx botRight;
    
    @Override
    public void init(){
        topLeft = hardwareMap.get(DcMotorEx.class, "topLeft");
        botLeft = hardwareMap.get(DcMotorEx.class, "botLeft");
        topRight = hardwareMap.get(DcMotorEx.class, "topRight");
        botRight = hardwareMap.get(DcMotorEx.class, "botRight");
        
        topRight.setDirection(DcMotor.Direction.REVERSE);
        botRight.setDirection(DcMotor.Direction.REVERSE);
    }
    
    @Override
    public void loop(){
        double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
        double x = gamepad1.left_stick_x;
        double rot = gamepad1.right_stick_x;
        
        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rot), 1);
        double topLeftPower = (y + x + rot) / denominator;
        double botLeftPower = (y - x + rot) / denominator;
        double topRightPower = (y - x - rot) / denominator;
        double botRightPower = (y + x - rot) / denominator;
        
        double slow = 0.5;
        
        topLeft.setPower(topLeftPower * slow);
        botLeft.setPower(botLeftPower * slow);
        topRight.setPower(topRightPower * slow);
        botRight.setPower(botRightPower * slow);
        
        telemetry.addData("left-x: ", gamepad1.left_stick_x);
        telemetry.addData("left-y: ", -gamepad1.left_stick_y);
        telemetry.addData("right-x: ", gamepad1.right_stick_x);
        
        telemetry.addData("t-l: ", topLeftPower);
        telemetry.addData("t-r: ", topRightPower);
        telemetry.addData("b-l: ", botLeftPower);
        telemetry.addData("b-r: ", botRightPower);
    }
}
