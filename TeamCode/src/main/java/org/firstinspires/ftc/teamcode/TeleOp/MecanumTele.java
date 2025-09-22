package org.firstinspires.ftc.teamcode.TeleOp;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Config
@TeleOp
public class MecanumTele extends OpMode {

/// Making names for the variables
    MecanumDrive drive;
    DcMotor rightFront;
    DcMotor rightBack;
    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor slide;
    Servo Claw;
    Servo Arm;

    int maxPosition = 3050;
    int target = 1000;
    int counter = -1;
    int slow = 1;
    boolean pressed = false;

///  Making variables that hold numbers i can call and edit later
    public static double ClawOpen = 1, ClawClose = 0;
    public static double ArmUp = .3, ArmDown = 0.75;
    public static double speed=2;








/// Defining what port the mmotors/servos are plugged into
    @Override
    public void init() {
        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
          rightFront = hardwareMap.get(DcMotor.class, "rightFront");
          rightBack = hardwareMap.get(DcMotor.class, "rightRear");
          leftFront = hardwareMap.get(DcMotor.class, "leftFront");
          leftBack = hardwareMap.get(DcMotor.class, "leftRear");
//        slide = hardwareMap.get(DcMotor.class, "slide");
//        slide.setDirection(DcMotorSimple.Direction.REVERSE);
//        Arm = hardwareMap.get(Servo.class, "arm");
//        Claw = hardwareMap.get(Servo.class, "claw");
    }

    @Override
    public void loop() {
/// Making the movement of the bt connected to the joysticks (Y an X of left stick for going straight and strafing, right stick for turning)
        drive.setDrivePowers(new PoseVelocity2d(
                new Vector2d(
                        -gamepad1.left_stick_y/speed,
                        -gamepad1.left_stick_x/speed
                ),
                -gamepad1.right_stick_x/speed));

///Make bot slow when triangle is pressed
        if(gamepad1.triangle && !pressed) {
            speed = 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            speed=2;
}
///Make slow/fast (depends on what it is) when cross is pressed
        if(gamepad1.cross && !pressed) {
            slow= slow*-1;

            if(slow == -1){
                speed=3;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } ;
            }

}
///Make bot turn 360 degrees to the left when circle is pressed
        if(gamepad1.dpad_right && !pressed) {
            leftFront.setPower(1);
            leftBack.setPower(1);
            rightBack.setPower(-1);
            rightFront.setPower(-1);
                try {
                    Thread.sleep(336);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightBack.setPower(0);
            rightFront.setPower(0);
}
///Make bot turn 180 degrees to the left when left dpad is pressed
        if(gamepad1.dpad_down && !pressed) {
            leftFront.setPower(1);
            leftBack.setPower(1);
            rightBack.setPower(-1);
            rightFront.setPower(-1);
                try {
                    Thread.sleep(167);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            leftFront.setPower(0);
            leftBack.setPower(0);
            rightBack.setPower(0);
            rightFront.setPower(0);
}

/// make bot turn 360 degrees to the right when dpad up is pressed
            if(gamepad1.dpad_left && !pressed) {
                rightBack.setPower(1);
                rightFront.setPower(1);
                leftFront.setPower(-1);
                leftBack.setPower(-1);
                try {
                    Thread.sleep(334);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
        }

///Make bot turn 180 degrees to the right when left dpad is pressed
            if(gamepad1.dpad_up && !pressed) {
                leftFront.setPower(-1);
                leftBack.setPower(-1);
                rightBack.setPower(1);
                rightFront.setPower(1);
                try {
                    Thread.sleep(167);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightBack.setPower(0);
                rightFront.setPower(0);
        }



//        telemetry.addData("Slide Position", slide.getCurrentPosition());
//        telemetry.addData("Claw Position", Claw.getPosition());
//        telemetry.addData("Arm Position", Arm.getPosition());
//
//        slide.setPower(-gamepad2.left_stick_y+holdPow);


//        if (gamepad2.a && !pressed) {
//            counter++;
//        }
//        pressed = gamepad2.a;
//
//        if (counter % 4 == 0) {
//            Arm.setPosition(ArmDown);
//        }
//        else if (counter % 4 == 1){
//            Claw.setPosition(ClawClose);
//        }
//        else if (counter % 4 == 2){
//            Arm.setPosition(ArmUp);
//        }
//        else if(counter % 4 == 3) {
//            Claw.setPosition(ClawOpen);
//        }
//
//
//        if(gamepad2.left_bumper) {
//            Claw.setPosition(ClawOpen);
//        }
//
//        if(gamepad2.right_bumper){
//            Claw.setPosition(ClawClose);}
//
//        if(gamepad2.left_trigger>0.2){
//         Arm.setPosition(ArmUp);
//        }
//
//        if(gamepad2.right_trigger>0.2){
//         Arm.setPosition(ArmDown);
//        }


//        if (gamepad1.left_stick_y > 0.05 || gamepad1.left_stick_y < -0.05 || gamepad1.right_stick_x > 0.05 || gamepad1.right_stick_x < -0.05) {
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 2,
//                            -gamepad1.left_stick_x / 2
//                    ),
//                    -gamepad1.right_stick_x / 2));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 2,
//                            -gamepad1.left_stick_x / 2
//                    ),
//                    -gamepad1.right_stick_x / 2));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y /2,
//                            -gamepad1.left_stick_x / 2
//                    ),
//                    -gamepad1.right_stick_x / 2));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 2,
//                            -gamepad1.left_stick_x / 2
//                    ),
//                    -gamepad1.right_stick_x / 2));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 1.5,
//                            -gamepad1.left_stick_x / 1.5
//                    ),
//                    -gamepad1.right_stick_x / 1.5));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 1.5,
//                            -gamepad1.left_stick_x / 1.5
//                    ),
//                    -gamepad1.right_stick_x / 1.5));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 1.5,
//                            -gamepad1.left_stick_x / 1.5
//                    ),
//                    -gamepad1.right_stick_x / 1.5));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 1.5,
//                            -gamepad1.left_stick_x / 1.5
//                    ),
//                    -gamepad1.right_stick_x / 1.5));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 1.5,
//                            -gamepad1.left_stick_x / 1.5
//                    ),
//                    -gamepad1.right_stick_x / 1.5));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            drive.setDrivePowers(new PoseVelocity2d(
//                    new Vector2d(
//                            -gamepad1.left_stick_y / 1.5,
//                            -gamepad1.left_stick_x / 1.5
//                    ),
//                    -gamepad1.right_stick_x / 1.5));
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }


//            if (gamepad1.left_stick_y < 0.05 && gamepad1.left_stick_y >= 0.0 || gamepad1.left_stick_y > -0.05 && gamepad1.left_stick_y <= 0.0 || gamepad1.right_stick_x < 0.05 && gamepad1.left_stick_y >= 0.0 || gamepad1.right_stick_x > -0.05 && gamepad1.right_stick_x <= 0.0) {
//                drive.setDrivePowers(new PoseVelocity2d(
//                        new Vector2d(
//                                -gamepad1.left_stick_y * 0,
//                                -gamepad1.left_stick_x * 0
//                        ),
//                        -gamepad1.right_stick_x * 0));
//
//
//                telemetry.update();
            }
        }


