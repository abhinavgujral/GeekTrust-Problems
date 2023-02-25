package org.example;

import org.example.Exception.InputFileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Geektrust {
    public static void main ( String[] args ) {
       //Path inputFilePath = Path.of ( "sample_input" , "input3.txt" );
        Path inputFilePath=Path.of(args[0]);
        try {
            Stream <String> lines = Files.lines ( inputFilePath );
            List <String> getAllLines = lines.map(String::trim)
                    .filter(string -> !string.matches(" "))
                    .collect( Collectors.toList());
            readAllCommands(getAllLines);

        } catch ( IOException e ) {
            throw new InputFileException ("file not readable");
        }
    }

    private static void readAllCommands ( List< String> getAllLines ) {

        for (String eachLine : getAllLines) {
            String[] commands = eachLine.trim().split(" ");
            if(commands[0].equals(Commands.FASTAG.toString())){
                Fastag.addFastagBalance (commands[1],Integer.parseInt ( commands[2] ));
            }
            else if(commands[0].equals(Commands.COLLECT_TOLL.toString())){
                TollCalculator tollCalculator= new TollCalculator ();
                  tollCalculator.collectToll(commands[1],commands[2]);
            }
            else if(commands[0].equals ( Commands.PRINT_COLLECTION.toString () )){
                TollCollectionSummary.printCollection();
            }
        }
    }
}