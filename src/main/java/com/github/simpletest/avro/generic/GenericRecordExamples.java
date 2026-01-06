package com.github.simpletest.avro.generic;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.avro.io.DatumWriter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class GenericRecordExamples {
    public static void main(String[] args) {
        // step 0: define schema
        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse("{\n" +
                "  \"type\": \"record\",\n" +
                "  \"namespace\": \"com.example\",\n" +
                "  \"name\": \"Customer\",\n" +
                "  \"fields\": [\n" +
                "    {\"name\": \"first_name\", \"type\": \"string\"},\n" +
                "    {\"name\": \"middle_name\", \"type\": [\"null\", \"string\"], \"default\": null},\n" +
                "    {\"name\": \"last_name\", \"type\": \"string\"},\n" +
                "    {\"name\": \"age\", \"type\": \"float\"},\n" +
                "    {\"name\": \"weight\", \"type\": \"float\"},\n" +
                "    {\"name\": \"customer_emails\", \"type\": {\"type\": \"array\", \"items\": \"string\"}}\n" +
                "  ]\n" +
                "}");
        // step 1: create a generic Record
        GenericRecordBuilder customerBuilder = new GenericRecordBuilder(schema);
        customerBuilder.set("first_name", "Jonh");
        customerBuilder.set("middle_name", "Jonh");
        customerBuilder.set("last_name", "Jonh");
        customerBuilder.set("age", 5f);
        customerBuilder.set("weight", 70f);
        customerBuilder.set("customer_emails", Arrays.asList("jonh1@example.com", "jonh2@example.com"));
        GenericRecord customer1 = customerBuilder.build();
        System.out.println(customer1);

        // ------------------------------
        // EXTRA STEPS
        // Step 2: Write to a file
        /*File file = new File("customer.avro");
        DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>(schema);
        try (DataFileWriter<GenericRecord> dataFileWriter = new DataFileWriter<>(datumWriter)) {
            dataFileWriter.create(schema, file);
            dataFileWriter.append(customer1);
            System.out.println("Successfully wrote customer.avro");
        } catch (IOException e) {
            System.out.println("Unsuccessful: file save");
            e.printStackTrace();
        }*/

        // Step 2: Write to a file

    }    
}
