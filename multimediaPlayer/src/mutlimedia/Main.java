package mutlimedia;

import mutlimedia.elements.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MultimediaElement[] elements = new MultimediaElement[5];
        int currentIndex = 0;

        while (true) {
            System.out.println("\n=============================");
            System.out.println("What would you like to do?");
            System.out.println("=============================");
            System.out.println("1: Add a new element");
            System.out.println("2: Play/Show an existing element");
            System.out.println("3: Modify an existing element");
            System.out.println("0: Exit");
            int action = in.nextInt();
            in.nextLine();

            if (action == 0) {
                System.out.println("Exiting...");
                break;
            } else if (action == 1) {
                if (currentIndex >= elements.length) {
                    System.out.println("******************************************************");
                    System.out.println("You have already added the maximum number of elements.");
                    System.out.println("******************************************************");
                    continue;
                }

                System.out.println("Enter details for element " + (currentIndex + 1) + " :\n");
                System.out.print("Title of the element: \n");
                String title = in.nextLine();

                System.out.print("Element type (1 for video, 2 for image, 3 for audio recording): \n");
                int type = in.nextInt();
                in.nextLine();

                switch (type) {
                    case 1: {
                        System.out.print("Enter the duration of the video: \n");
                        int duration = in.nextInt();
                        System.out.print("Enter the volume of the video: \n");
                        int volume = in.nextInt();
                        System.out.print("Enter the brightness of the video: \n");
                        int brightness = in.nextInt();
                        in.nextLine();
                        elements[currentIndex++] = new Video(title, duration, volume, brightness);
                        break;
                    }
                    case 2: {
                        System.out.print("Enter the brightness of the image: \n");
                        int brightness = in.nextInt();
                        in.nextLine();
                        elements[currentIndex++] = new Image(title, brightness);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter the duration of the audio recording: \n");
                        int duration = in.nextInt();
                        System.out.print("Enter the volume of the audio recording: \n");
                        int volume = in.nextInt();
                        in.nextLine();
                        elements[currentIndex++] = new AudioRecording(title, duration, volume);
                        break;
                    }
                    default: {
                        System.out.println("Invalid type. No element added.");
                    }
                }

            } else if (action == 2) {
                if (currentIndex == 0) {
                    System.out.println("No elements have been added yet.");
                    continue;
                }
                System.out.println("\n========================");
                System.out.println("Available elements:");
                System.out.println("========================");

                for (int i = 0; i < currentIndex; i++) {
                    System.out.println(
                            (i + 1) + ": " + elements[i].getTitle() + " (" + elements[i].getClass().getSimpleName()
                                    + ")");
                }

                System.out.print("Choose an element to play/show (1 to " + currentIndex + "): \n");
                int choice = in.nextInt();

                if (choice < 1 || choice > currentIndex) {
                    System.out.println("Invalid choice. Try again.");
                } else {
                    MultimediaElement element = elements[choice - 1];
                    if (element != null) {
                        element.execute();
                    } else {
                        System.out.println("Element not found.");
                    }
                }

            } else if (action == 3) {
                if (currentIndex == 0) {
                    System.out.println("No elements have been added yet.");
                    continue;
                }
                System.out.println("\n========================");
                System.out.println("Available elements:");
                System.out.println("========================");

                for (int i = 0; i < currentIndex; i++) {
                    System.out.println(
                            (i + 1) + ": " + elements[i].getTitle() + " (" + elements[i].getClass().getSimpleName()
                                    + ")");
                }

                System.out.print("Choose an element to modify (1 to " + currentIndex + "): \n");
                int choice = in.nextInt();

                if (choice < 1 || choice > currentIndex) {
                    System.out.println("Invalid choice. Try again.");
                } else {
                    MultimediaElement element = elements[choice - 1];
                    if (element instanceof AudioRecording audio) {
                        System.out.println("1: Increase volume\n2: Decrease volume");
                        int modifyChoice = in.nextInt();
                        if (modifyChoice == 1) {
                            audio.increaseVolume();
                            System.out.println("========================");
                            System.out.println("Volume increased.");
                            System.out.println("========================");

                        } else if (modifyChoice == 2) {
                            audio.lowerVolume();
                            System.out.println("========================");
                            System.out.println("Volume decreased.");
                            System.out.println("========================");

                        } else {
                            System.out.println("Invalid modification option.");
                        }
                    } else if (element instanceof Video video) {
                        System.out.println(
                                "1: Increase volume\n2: Decrease volume\n3: Increase brightness\n4: Decrease brightness");
                        int modifyChoice = in.nextInt();
                        if (modifyChoice == 1) {
                            video.increaseVolume();
                            System.out.println("========================");
                            System.out.println("Volume increased.");
                            System.out.println("========================");

                        } else if (modifyChoice == 2) {
                            video.lowerVolume();
                            System.out.println("========================");
                            System.out.println("Volume decreased.");
                            System.out.println("========================");

                        } else if (modifyChoice == 3) {
                            video.increaseBrightness();
                            System.out.println("========================");
                            System.out.println("Brightness increased.");
                            System.out.println("========================");

                        } else if (modifyChoice == 4) {
                            video.lowerBrightness();
                            System.out.println("========================");
                            System.out.println("Brightness decreased.");
                            System.out.println("========================");

                        } else {
                            System.out.println("Invalid modification option.");
                        }
                    } else if (element instanceof Image image) {
                        System.out.println("1: Increase brightness\n2: Decrease brightness");
                        int modifyChoice = in.nextInt();
                        if (modifyChoice == 1) {
                            image.increaseBrightness();
                            System.out.println("========================");
                            System.out.println("Brightness increased.");
                            System.out.println("========================");

                        } else if (modifyChoice == 2) {
                            image.lowerBrightness();
                            System.out.println("========================");
                            System.out.println("Brightness decreased.");
                            System.out.println("========================");

                        } else {
                            System.out.println("Invalid modification option.");
                        }
                    } else {
                        System.out.println("Element type not supported for modification.");
                    }
                }

            } else {
                System.out.println("Invalid action. Try again.");
            }
        }

        in.close();
    }
}
